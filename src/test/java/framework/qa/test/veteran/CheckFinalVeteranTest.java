package framework.qa.test.veteran;

import framework.qa.consts.ChannelEnum;
import framework.qa.consts.Params;
import framework.qa.consts.ScenarioCodeEnum;
import framework.qa.consts.UiFieldsNames;
import framework.qa.jupiter.annotations.CheckRequest;
import framework.qa.jupiter.annotations.Mock;
import framework.qa.models.requestData.*;
import framework.qa.test.BaseTest;
import framework.qa.utils.Wiremock;
import framework.qa.values.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("Ветераны")
public class CheckFinalVeteranTest extends BaseVeteranTest {


    @DisplayName("Получение успешного экрана при запросе на check final c минимальным набором параметров")
    @Test
    public void baseCheckTestUfocheckLocation(@CheckRequest OmniRequestItem check,
                                              @Mock Wiremock issuCheckMock) {
        String gpbRequestId = UUID.randomUUID().toString();
        step("Конфигурация мок issuCheckMock", () -> {
            issuCheckMock.wiremockSend("wiremock/issue-check/card-issue-check-isMobilePinTrue.json",
                    "/omni-information-card/api/v3/client/product/card/issue/check",
                    "actualTimestamp",
                    "1234",
                    gpbRequestId);
        });

        step("Отправка запроса на check", () -> {
            List<ScreenValueBack> operation = new ArrayList<>();
            List<ScreenValueBack> verifyDataValues = new ArrayList<>();
            verifyDataValues.add(new ScreenValueBack(UiFieldsNames.UI_CARD_NUMBER_FIELD_ID, CardNumber));
            verifyDataValues.add(new ScreenValueBack(UiFieldsNames.UI_DATE_EXPIRATION, dateExpiration));
            verifyDataValues.add(new ScreenValueBack(Params.BRANCH_UNIT_CODE, TestDataValues.branchUnitCode));
            verifyDataValues.add(new ScreenValueBack(UiFieldsNames.UI_IS_OTP, "true"));

            check.getData().getOperation().setOrder4client(UUID.randomUUID().toString());
            check.getData().getScenario().setId(veteranScenarioId);
            check.getData().getScenario().setCode(veteranScenarioCode);
            check.getData().getVerifyData().setValues(verifyDataValues);
            check.getData().getVerifyData().setCommand(new ScreenCommandFront("check", "checkLocation"));
            check.getData().getVerifyData().setScreenStage("final");

            check.getData().getOperation().setValues(operationFinalMinParam());
            Response response = given().header("gpb-requestId", gpbRequestId)
                    .body(check)
                    .post("api/v1/metadata/check")
                    .then().extract().response();
            step("Проверка получения экрана успеха");
            assertAll(
                    () -> assertEquals("CARD_APPLICATION_STATUS", response.path("screen.load.id")),
                    () -> assertEquals("draft", response.path("screen.stage")),
                    () -> assertEquals(true, response.path("screen.success"))
            );
        });
        step("Очистка мок", () -> {
            issuCheckMock.wiremockRemove();
        });

    }


}

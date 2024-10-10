package framework.qa.test.veteran;

import framework.qa.api.OmniApiClient;
import framework.qa.consts.ChannelEnum;
import framework.qa.consts.Params;
import framework.qa.consts.ScenarioCodeEnum;
import framework.qa.consts.UiFieldsNames;
import framework.qa.jupiter.annotations.CheckRequest;
import framework.qa.jupiter.annotations.Wmock;
import framework.qa.jupiter.annotations.Wmocks;
import framework.qa.models.omniresponseitem.ResponseItem;
import framework.qa.models.omniresponseitem.ValuesItem;
import framework.qa.models.requestData.*;
import framework.qa.models.wiremock.response.RootWiremockResponse;
import framework.qa.test.BaseTest;
import framework.qa.utils.JsonLoader;
import framework.qa.values.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@Tag("Ветераны")
public class CheckFinalVeteranTest extends BaseVeteranTest {
    private final OmniApiClient checkApi = new OmniApiClient();

    @Test
    @DisplayName("Получение успешного экрана при запросе на check final c минимальным набором параметров")
    @Wmocks({
            @Wmock(
                    enpointMapping = "/omni-information/api/v2/client/search",
                    mockFile = "wiremock/client-search/default.json",
                    pathToField = "data.clients.[?(@.base.guid==\"6F57A2C3507C4D6AA1A70E9C8C8CF919\")].base.hid",
                    value = ""
            ),
            @Wmock(
                    enpointMapping = "/omni-information-card/api/v3/client/product/card/issue/check",
                    mockFile = "wiremock/issue-check/card-issue-check-isMobilePinTrue.json",
                    pathToField = "actualTimestamp",
                    value = "1234")}

    )
    public void veteranCheckFinalShouldReturnSuccessScreenWithMinParams(RootWiremockResponse rwr, @CheckRequest OmniRequestItem check) {
        String gpbrequestId = rwr.getRequest().getHeaders().getGpbrequestId().getEqualTo();
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

            ResponseItem response = checkApi.checkRequest(gpbrequestId, check);
            assertAll(
                    () -> assertEquals("CARD_APPLICATION_STATUS", response.getScreen().getLoad().getId()),
                    () -> assertEquals("draft", response.getScreen().getStage()),
                    () -> assertEquals(true, response.getScreen().isSuccess()),
                    () -> assertTrue(response.getData().getOperation().getOrder4client().matches("^[{(]?[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}[)}]?$")));
        });
    }


}

package framework.qa.test.veteran;

import framework.qa.consts.ChannelEnum;
import framework.qa.consts.Params;
import framework.qa.consts.ScenarioCodeEnum;
import framework.qa.consts.UiFieldsNames;
import framework.qa.jupiter.annotations.CheckRequest;
import framework.qa.models.requestData.*;
import framework.qa.test.BaseTest;
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
public class CheckInitialVeteranTest extends BaseVeteranTest {


    @DisplayName("Получение успешного экрана при запросе на check initial c минимальным набором параметров")
    @Test
    public void baseCheckTestUfocheckSmartCardParams(@CheckRequest OmniRequestItem check) {
        String gpbRequestId = UUID.randomUUID().toString();

        step("Отправка запроса на check", () -> {
            check.getData().getScenario().setId(veteranScenarioId);
            check.getData().getScenario().setCode(veteranScenarioCode);
            Response response = given().header("gpb-requestId", gpbRequestId)
                    .body(check)
                    .post("api/v1/metadata/check")
                    .then().extract().response();
            step("Проверка получения экрана успеха");
            assertAll(
                    () -> assertEquals("5NT_BORROWER_EXT_OFFICE", response.path("screen.load.id")),
                    () -> assertEquals("final", response.path("screen.stage")),
                    () -> assertEquals(true, response.path("screen.success")),
                    () -> assertEquals("false", response.jsonPath().getString("data.operation.values.find{it.id==\"##isSecretWord\"}.value")),
                    () -> assertEquals(productOfferShortName, response.jsonPath().getString("data.operation.values.find{it.id==\"productOfferShortName\"}.value")),
                    () -> assertEquals(servicePackage, response.jsonPath().getString("data.operation.values.find{it.id==\"##servicePackage\"}.value")),
                    () -> assertEquals(TypeCreation, response.jsonPath().getString("data.operation.values.find{it.id==\"TypeCreation\"}.value")),
                    () -> assertEquals("false", response.jsonPath().getString("data.operation.values.find{it.id==\"##delivery.dsa\"}.value")),
                    () -> assertEquals(paySystemCode, response.jsonPath().getString("data.operation.values.find{it.id==\"##paySystemCode\"}.value")),
                    () -> assertEquals(cardCurrency, response.jsonPath().getString("data.operation.values.find{it.id==\"##cardCurrency\"}.value")),
                    () -> assertEquals("false", response.jsonPath().getString("data.operation.values.find{it.id==\"##delivery.courier\"}.value")),
                    () -> assertEquals(IsUnembossed, response.jsonPath().getString("data.operation.values.find{it.id==\"IsUnembossed\"}.value")),
                    () -> assertEquals(printCardName, response.jsonPath().getString("data.operation.values.find{it.id==\"##printCardName\"}.value")),
                    () -> assertEquals(branchCode, response.jsonPath().getString("data.operation.values.find{it.id==\"branchCode\"}.value")),
                    () -> assertEquals("1", response.jsonPath().getString("data.operation.values.find{it.id==\"##currencyId\"}.value")),
                    () -> assertEquals("true", response.jsonPath().getString("data.operation.values.find{it.id==\"##delivery.office\"}.value")),
                    () -> assertEquals(subProgramCode, response.jsonPath().getString("data.operation.values.find{it.id==\"subProgramCode\"}.value")),
                    () -> assertEquals("false", response.jsonPath().getString("data.operation.values.find{it.id==\"##expiredPassport\"}.value")),
                    () -> assertEquals(currencyCode, response.jsonPath().getString("data.operation.values.find{it.id==\"currencyCode\"}.value")),
                    () -> assertEquals(paymentSystemCode, response.jsonPath().getString("data.operation.values.find{it.id==\"paymentSystemCode\"}.value"))
            );
        });

    }


}

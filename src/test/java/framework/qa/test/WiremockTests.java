package framework.qa.test;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import framework.qa.models.init.InitRoot;
import framework.qa.jupiter.parameters.Init;
import framework.qa.jupiter.parameters.Mock;
import framework.qa.utils.Wiremock;

import java.util.UUID;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WiremockTests extends BaseTest {

    @DisplayName("Пробрасываем мок cs1")
    @Test
    public void initTestWithWiremockExtension(@Init InitRoot initRootBody,
                                              @Mock Wiremock clientSearchMock,
                                              @Mock Wiremock productCardsMock) {
        String gpbRequestId = UUID.randomUUID().toString();
        step("конфигурируем мок client-search", () -> {
            clientSearchMock.wiremockSend("wiremock/client-search/default.json",
                    "base.guid",
                    "false",
                    "client-search",
                    gpbRequestId);
        });
        step("конфигурируем мок product-cards", () -> {
            productCardsMock.wiremockSend("wiremock/product-cards/product-cards-ok.json",
                    "actualTimestamp",
                    "1234",
                    "product-cards",
                    gpbRequestId);
        });
        step("отправляем запрос на init", () -> {
            initRootBody.getMeta().setChannel("mb");
            Response response = given().header("gpb-requestId", gpbRequestId).body(initRootBody).post("api/v1/metadata/init")
                    .then().log().all().extract().response();
            assertAll(
                    () -> assertEquals(200, response.getStatusCode()));
        });
    }


    @DisplayName("Пробрасываем мок cs2")
    @Test
    public void initTestWithWiremockExtension2(@Mock Wiremock wiremock) {
        wiremock.wiremockSend("wiremock/client-search/default.json",
                "base.guid",
                "1234",
                "1234",
                "1234");
    }

}

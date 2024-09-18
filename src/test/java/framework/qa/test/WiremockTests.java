package framework.qa.test;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import framework.qa.models.init.InitRoot;
import framework.qa.jupiter.annotations.Init;
import framework.qa.jupiter.annotations.Mock;
import framework.qa.utils.Wiremock;

import java.util.UUID;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WiremockTests extends BaseTest {

    @DisplayName("Получение экрана успеха1")
    @Test
    public void initTestWithWiremockExtension1(@Init InitRoot initRootBody,
                                               @Mock Wiremock clientSearchMock,
                                               @Mock Wiremock productCardsMock) {
        String gpbRequestId = UUID.randomUUID().toString();
        step("конфигурируем мок client-search", () -> {
            clientSearchMock.wiremockSend("wiremock/client-search/default.json",
                    "/omni-information/api/v2/client/search",
                    "data.clients.[?(@.base.guid==\"6F57A2C3507C4D6AA1A70E9C8C8CF919\")].base.hid",
                    "1111",
                    gpbRequestId);
        });
        step("конфигурируем мок product-cards", () -> {
            productCardsMock.wiremockSend("wiremock/product-cards/product-cards-ok.json",
                    "/omni-information-card/api/v3/client/product/cards",
                    "actualTimestamp",
                    "1234",
                    gpbRequestId);
        });
        step("отправляем запрос на init", () -> {
            initRootBody.getMeta().setChannel("ufo");
            Response response = given().header("gpb-requestId", gpbRequestId)
                    .body(initRootBody)
                    .post("api/v1/metadata/init")
                    .then().extract().response();
            assertAll(
                    () -> assertEquals("5NT_CARD_PARAMS", response.path("screen.load.id")));
        });
        clientSearchMock.wiremockRemove();
        productCardsMock.wiremockRemove();
    }

    @DisplayName("Получение экрана успеха2")
    @Test
    public void initTestWithWiremockExtension2(@Init InitRoot initRootBody,
                                               @Mock Wiremock clientSearchMock,
                                               @Mock Wiremock productCardsMock) {
        String gpbRequestId = UUID.randomUUID().toString();
        step("конфигурируем мок client-search", () -> {
            clientSearchMock.wiremockSend("wiremock/client-search/default.json",
                    "/omni-information/api/v2/client/search",
                    "data.clients.[?(@.base.guid==\"6F57A2C3507C4D6AA1A70E9C8C8CF919\")].base.guid",
                    "6F57A2C3507C4D6AA1A70E9C8C8CF911",
                    gpbRequestId);
        });
        step("конфигурируем мок product-cards", () -> {
            productCardsMock.wiremockSend("wiremock/product-cards/product-cards-ok.json",
                    "/omni-information-card/api/v3/client/product/cards",
                    "actualTimestamp",
                    "1234",
                    gpbRequestId);
        });
        step("отправляем запрос на init", () -> {
            initRootBody.getMeta().setChannel("ufo");
            Response response = given().header("gpb-requestId", gpbRequestId)
                    .body(initRootBody)
                    .post("api/v1/metadata/init")
                    .then().extract().response();
            assertAll(
                    () -> assertEquals("OMNI_CARD_ERROR_STATUS", response.path("screen.load.id")));
        });
        clientSearchMock.wiremockRemove();
        productCardsMock.wiremockRemove();
    }


    @DisplayName("Получение экрана успеха3")
    @Test
    public void initTestWithWiremockExtension3(@Init InitRoot initRootBody,
                                               @Mock Wiremock clientSearchMock,
                                               @Mock Wiremock productCardsMock) {
        String gpbRequestId = UUID.randomUUID().toString();
        step("конфигурируем мок client-search", () -> {
            clientSearchMock.wiremockSend("wiremock/client-search/default.json",
                    "/omni-information/api/v2/client/search",
                    "data.clients.[?(@.base.guid==\"6F57A2C3507C4D6AA1A70E9C8C8CF919\")].base.hid",
                    "1111",
                    gpbRequestId);
        });
        step("конфигурируем мок product-cards", () -> {
            productCardsMock.wiremockSend("wiremock/product-cards/product-cards-ok.json",
                    "/omni-information-card/api/v3/client/product/cards",
                    "actualTimestamp",
                    "1234",
                    gpbRequestId);
        });
        step("отправляем запрос на init", () -> {
            initRootBody.getMeta().setChannel("ufo");
            Response response = given().header("gpb-requestId", gpbRequestId)
                    .body(initRootBody)
                    .post("api/v1/metadata/init")
                    .then().extract().response();
            assertAll(
                    () -> assertEquals("5NT_CARD_PARAMS", response.path("screen.load.id")));
        });
        clientSearchMock.wiremockRemove();
        productCardsMock.wiremockRemove();
    }

    @DisplayName("Получение экрана успеха4")
    @Test
    public void initTestWithWiremockExtension4(@Init InitRoot initRootBody,
                                               @Mock Wiremock clientSearchMock,
                                               @Mock Wiremock productCardsMock) {
        String gpbRequestId = UUID.randomUUID().toString();
        step("конфигурируем мок client-search", () -> {
            clientSearchMock.wiremockSend("wiremock/client-search/default.json",
                    "/omni-information/api/v2/client/search",
                    "data.clients.[?(@.base.guid==\"6F57A2C3507C4D6AA1A70E9C8C8CF919\")].base.guid",
                    "6F57A2C3507C4D6AA1A70E9C8C8CF911",
                    gpbRequestId);
        });
        step("конфигурируем мок product-cards", () -> {
            productCardsMock.wiremockSend("wiremock/product-cards/product-cards-ok.json",
                    "/omni-information-card/api/v3/client/product/cards",
                    "actualTimestamp",
                    "1234",
                    gpbRequestId);
        });
        step("отправляем запрос на init", () -> {
            initRootBody.getMeta().setChannel("ufo");
            Response response = given().header("gpb-requestId", gpbRequestId)
                    .body(initRootBody)
                    .post("api/v1/metadata/init")
                    .then().extract().response();
            assertAll(
                    () -> assertEquals("OMNI_CARD_ERROR_STATUS", response.path("screen.load.id")));
        });
        clientSearchMock.wiremockRemove();
        productCardsMock.wiremockRemove();
    }

    @DisplayName("Получение экрана успеха1")
    @Test
    public void initTestWithWiremockExtension5(@Init InitRoot initRootBody,
                                               @Mock Wiremock clientSearchMock,
                                               @Mock Wiremock productCardsMock) {
        String gpbRequestId = UUID.randomUUID().toString();
        step("конфигурируем мок client-search", () -> {
            clientSearchMock.wiremockSend("wiremock/client-search/default.json",
                    "/omni-information/api/v2/client/search",
                    "data.clients.[?(@.base.guid==\"6F57A2C3507C4D6AA1A70E9C8C8CF919\")].base.hid",
                    "1111",
                    gpbRequestId);
        });
        step("конфигурируем мок product-cards", () -> {
            productCardsMock.wiremockSend("wiremock/product-cards/product-cards-ok.json",
                    "/omni-information-card/api/v3/client/product/cards",
                    "actualTimestamp",
                    "1234",
                    gpbRequestId);
        });
        step("отправляем запрос на init", () -> {
            initRootBody.getMeta().setChannel("ufo");
            Response response = given().header("gpb-requestId", gpbRequestId)
                    .body(initRootBody)
                    .post("api/v1/metadata/init")
                    .then().extract().response();
            assertAll(
                    () -> assertEquals("5NT_CARD_PARAMS", response.path("screen.load.id")));
        });
        clientSearchMock.wiremockRemove();
        productCardsMock.wiremockRemove();
    }

    @DisplayName("Получение экрана успеха2")
    @Test
    public void initTestWithWiremockExtension6(@Init InitRoot initRootBody,
                                               @Mock Wiremock clientSearchMock,
                                               @Mock Wiremock productCardsMock) {
        String gpbRequestId = UUID.randomUUID().toString();
        step("конфигурируем мок client-search", () -> {
            clientSearchMock.wiremockSend("wiremock/client-search/default.json",
                    "/omni-information/api/v2/client/search",
                    "data.clients.[?(@.base.guid==\"6F57A2C3507C4D6AA1A70E9C8C8CF919\")].base.guid",
                    "6F57A2C3507C4D6AA1A70E9C8C8CF911",
                    gpbRequestId);
        });
        step("конфигурируем мок product-cards", () -> {
            productCardsMock.wiremockSend("wiremock/product-cards/product-cards-ok.json",
                    "/omni-information-card/api/v3/client/product/cards",
                    "actualTimestamp",
                    "1234",
                    gpbRequestId);
        });
        step("отправляем запрос на init", () -> {
            initRootBody.getMeta().setChannel("ufo");
            Response response = given().header("gpb-requestId", gpbRequestId)
                    .body(initRootBody)
                    .post("api/v1/metadata/init")
                    .then().extract().response();
            assertAll(
                    () -> assertEquals("OMNI_CARD_ERROR_STATUS", response.path("screen.load.id")));
        });
        clientSearchMock.wiremockRemove();
        productCardsMock.wiremockRemove();
    }


    @DisplayName("Получение экрана успеха3")
    @Test
    public void initTestWithWiremockExtension7(@Init InitRoot initRootBody,
                                               @Mock Wiremock clientSearchMock,
                                               @Mock Wiremock productCardsMock) {
        String gpbRequestId = UUID.randomUUID().toString();
        step("конфигурируем мок client-search", () -> {
            clientSearchMock.wiremockSend("wiremock/client-search/default.json",
                    "/omni-information/api/v2/client/search",
                    "data.clients.[?(@.base.guid==\"6F57A2C3507C4D6AA1A70E9C8C8CF919\")].base.hid",
                    "1111",
                    gpbRequestId);
        });
        step("конфигурируем мок product-cards", () -> {
            productCardsMock.wiremockSend("wiremock/product-cards/product-cards-ok.json",
                    "/omni-information-card/api/v3/client/product/cards",
                    "actualTimestamp",
                    "1234",
                    gpbRequestId);
        });
        step("отправляем запрос на init", () -> {
            initRootBody.getMeta().setChannel("ufo");
            Response response = given().header("gpb-requestId", gpbRequestId)
                    .body(initRootBody)
                    .post("api/v1/metadata/init")
                    .then().extract().response();
            assertAll(
                    () -> assertEquals("5NT_CARD_PARAMS", response.path("screen.load.id")));
        });
        clientSearchMock.wiremockRemove();
        productCardsMock.wiremockRemove();
    }

    @DisplayName("Получение экрана успеха4")
    @Test
    public void initTestWithWiremockExtension8(@Init InitRoot initRootBody,
                                               @Mock Wiremock clientSearchMock,
                                               @Mock Wiremock productCardsMock) {
        String gpbRequestId = UUID.randomUUID().toString();
        step("конфигурируем мок client-search", () -> {
            clientSearchMock.wiremockSend("wiremock/client-search/default.json",
                    "/omni-information/api/v2/client/search",
                    "data.clients.[?(@.base.guid==\"6F57A2C3507C4D6AA1A70E9C8C8CF919\")].base.guid",
                    "6F57A2C3507C4D6AA1A70E9C8C8CF911",
                    gpbRequestId);
        });
        step("конфигурируем мок product-cards", () -> {
            productCardsMock.wiremockSend("wiremock/product-cards/product-cards-ok.json",
                    "/omni-information-card/api/v3/client/product/cards",
                    "actualTimestamp",
                    "1234",
                    gpbRequestId);
        });
        step("отправляем запрос на init", () -> {
            initRootBody.getMeta().setChannel("ufo");
            Response response = given().header("gpb-requestId", gpbRequestId)
                    .body(initRootBody)
                    .post("api/v1/metadata/init")
                    .then().extract().response();
            assertAll(
                    () -> assertEquals("OMNI_CARD_ERROR_STATUS", response.path("screen.load.id")));
        });
        clientSearchMock.wiremockRemove();
        productCardsMock.wiremockRemove();
    }

}

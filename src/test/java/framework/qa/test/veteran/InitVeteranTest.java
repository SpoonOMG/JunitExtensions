package framework.qa.test.veteran;

import framework.qa.jupiter.annotations.InitRequest;
import framework.qa.jupiter.annotations.Mock;
import framework.qa.models.requestData.*;
import framework.qa.test.BaseTest;
import framework.qa.utils.Wiremock;
import framework.qa.consts.ScenarioCodeEnum;
import framework.qa.values.TestDataValues;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.UUID;
import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("Ветераны")
@Tag("init")
public class InitVeteranTest extends BaseVeteranTest {

    @DisplayName("Получение успешного экрана при запросе на init с обязательными параметрами")
    @Test
    public void initTestRequredParams(@InitRequest OmniRequestItem init,
                                      @Mock Wiremock clientSearchMock,
                                      @Mock Wiremock productCardsMock) {
        String gpbRequestId = UUID.randomUUID().toString();

        step("Конфигурация мок client-search", () -> {
            clientSearchMock.wiremockSend("wiremock/client-search/default.json",
                    "/omni-information/api/v2/client/search",
                    "data.clients.[?(@.base.guid==\"6F57A2C3507C4D6AA1A70E9C8C8CF919\")].base.hid",
                    "",
                    gpbRequestId);
        });
        step("Конфигурация мок product-cards", () -> {
            productCardsMock.wiremockSend("wiremock/product-cards/default.json",
                    "/omni-information-card/api/v3/client/product/cards",
                    "actualTimestamp",
                    "1234",
                    gpbRequestId);
        });

        step("Отправка запроса на init", () -> {
            init.getData().getScenario().setId(veteranScenarioId);
            init.getData().getScenario().setCode(veteranScenarioCode);
            Response response = given().header("gpb-requestId", gpbRequestId)
                    .body(init)
                    .post("api/v1/metadata/init")
                    .then().extract().response();
            step("Проверка статуса экрана");
            assertAll(
                    () -> assertEquals("5NT_ARMY_PARAMS_DO", response.path("screen.load.id")),
                    () -> assertEquals("initial", response.path("screen.stage")),
                    () -> assertEquals(true, response.path("screen.success"))
            );
        });

        step("Очистка мок", () -> {
            clientSearchMock.wiremockRemove();
            productCardsMock.wiremockRemove();
        });
    }

    @DisplayName("Получение успешного экрана при запросе на init с проверкой заполнения параметров из client-search")
    @Test
    public void initTestCheckClientSearchParams(@InitRequest OmniRequestItem init,
                                                @Mock Wiremock clientSearchMock,
                                                @Mock Wiremock productCardsMock) {
        String gpbRequestId = UUID.randomUUID().toString();

        step("Конфигурация мок client-search", () -> {
            clientSearchMock.wiremockSend("wiremock/client-search/default.json",
                    "/omni-information/api/v2/client/search",
                    "data.clients.[?(@.base.guid==\"6F57A2C3507C4D6AA1A70E9C8C8CF919\")].base.hid",
                    "",
                    gpbRequestId);
        });
        step("Конфигурация мок product-cards", () -> {
            productCardsMock.wiremockSend("wiremock/product-cards/default.json",
                    "/omni-information-card/api/v3/client/product/cards",
                    "actualTimestamp",
                    "1234",
                    gpbRequestId);
        });

        step("Отправка запроса на init", () -> {
            init.getData().getScenario().setId(veteranScenarioId);
            init.getData().getScenario().setCode(veteranScenarioCode);
            Response response = given().header("gpb-requestId", gpbRequestId)
                    .body(init)
                    .post("api/v1/metadata/init")
                    .then().extract().response();
            step("Проверка параметров client-search в operation");
            assertAll(
                    () -> assertEquals(TestDataValues.cellPhone, response.jsonPath().getString("data.operation.values.find{it.id==\"CELLPHONE\"}.value")),
                    () -> assertEquals(TestDataValues.docSeries, response.jsonPath().getString("data.operation.values.find{it.id==\"docSeries\"}.value")),
                    () -> assertEquals(TestDataValues.clientPhone, response.jsonPath().getString("data.operation.values.find{it.id==\"##clientPhone\"}.value")),
                    () -> assertEquals(TestDataValues.latinClientName, response.jsonPath().getString("data.operation.values.find{it.id==\"latinClientName\"}.value")),
                    () -> assertEquals(TestDataValues.areEmbossedCardsAvailable, response.jsonPath().getString("data.operation.values.find{it.id==\"##areEmbossedCardsAvailable\"}.value")),
                    () -> assertEquals(TestDataValues.countryISOCODE, response.jsonPath().getString("data.operation.values.find{it.id==\"countryISOCODE\"}.value")),
                    () -> assertEquals(TestDataValues.areInstantCardsAvailable, response.jsonPath().getString("data.operation.values.find{it.id==\"##areInstantCardsAvailable\"}.value")),
                    () -> assertEquals(TestDataValues.full_name, response.jsonPath().getString("data.operation.values.find{it.id==\"##full_name\"}.value")),
                    () -> assertEquals(TestDataValues.EMAIL, response.jsonPath().getString("data.operation.values.find{it.id==\"EMAIL\"}.value")),
                    () -> assertEquals(TestDataValues.rgCity, response.jsonPath().getString("data.operation.values.find{it.id==\"rgCity\"}.value")),
                    () -> assertEquals(TestDataValues.rgFlat, response.jsonPath().getString("data.operation.values.find{it.id==\"rgFlat\"}.value")),
                    () -> assertEquals(TestDataValues.isResident, response.jsonPath().getString("data.operation.values.find{it.id==\"isResident\"}.value")),
                    () -> assertEquals(TestDataValues.ftRegionName, response.jsonPath().getString("data.operation.values.find{it.id==\"ftRegionName\"}.value")),
                    () -> assertEquals(TestDataValues.rgCountryCode, response.jsonPath().getString("data.operation.values.find{it.id==\"rgCountryCode\"}.value")),
                    () -> assertEquals(TestDataValues.rgHouse, response.jsonPath().getString("data.operation.values.find{it.id==\"rgHouse\"}.value")),
                    () -> assertEquals(TestDataValues.location, response.jsonPath().getString("data.operation.values.find{it.id==\"##location\"}.value")),
                    () -> assertEquals(TestDataValues.aflt_surname, response.jsonPath().getString("data.operation.values.find{it.id==\"partnerdevParam.aflt_surname\"}.value")),
                    () -> assertEquals(TestDataValues.registration_address, response.jsonPath().getString("data.operation.values.find{it.id==\"##registration_address\"}.value")),
                    () -> assertEquals(TestDataValues.ftHouse, response.jsonPath().getString("data.operation.values.find{it.id==\"ftHouse\"}.value")),
                    () -> assertEquals(TestDataValues.cellPhoneWithSep, response.jsonPath().getString("data.operation.values.find{it.id==\"##CELLPHONE\"}.value")),
                    () -> assertEquals(TestDataValues.secondName, response.jsonPath().getString("data.operation.values.find{it.id==\"##secondName\"}.value")),
                    () -> assertEquals(TestDataValues.patronymic, response.jsonPath().getString("data.operation.values.find{it.id==\"patronymic\"}.value")),
                    () -> assertEquals(TestDataValues.expiredPassport, response.jsonPath().getString("data.operation.values.find{it.id==\"##expiredPassport\"}.value")),
                    () -> assertEquals(TestDataValues.name, response.jsonPath().getString("data.operation.values.find{it.id==\"name\"}.value")),
                    () -> assertEquals(TestDataValues.docTypeCode, response.jsonPath().getString("data.operation.values.find{it.id==\"docTypeCode\"}.value")),
                    () -> assertEquals(TestDataValues.document, response.jsonPath().getString("data.operation.values.find{it.id==\"##document\"}.value")),
                    () -> assertEquals(TestDataValues.birth_date, response.jsonPath().getString("data.operation.values.find{it.id==\"##birth_date\"}.value")),
                    () -> assertEquals(TestDataValues.guidOperation, response.jsonPath().getString("data.operation.values.find{it.id==\"guid\"}.value")),
                    () -> assertEquals(TestDataValues.rgPostalCode, response.jsonPath().getString("data.operation.values.find{it.id==\"rgPostalCode\"}.value")),
                    () -> assertEquals(TestDataValues.fact_address, response.jsonPath().getString("data.operation.values.find{it.id==\"##fact_address\"}.value")),
                    () -> assertEquals(TestDataValues.embossing_client_name, response.jsonPath().getString("data.operation.values.find{it.id==\"##embossing_client_name\"}.value")),
                    () -> assertEquals(TestDataValues.docNum, response.jsonPath().getString("data.operation.values.find{it.id==\"docNum\"}.value")),
                    () -> assertEquals(TestDataValues.firstName, response.jsonPath().getString("data.operation.values.find{it.id==\"##firstName\"}.value")),
                    () -> assertEquals(TestDataValues.lastName, response.jsonPath().getString("data.operation.values.find{it.id==\"##lastName\"}.value")),
                    () -> assertEquals(TestDataValues.CRSCountryCode, response.jsonPath().getString("data.operation.values.find{it.id==\"CRSCountryCode\"}.value")),
                    () -> assertEquals(TestDataValues.issuedBy, response.jsonPath().getString("data.operation.values.find{it.id==\"issuedBy\"}.value")),
                    () -> assertEquals(TestDataValues.ftCity, response.jsonPath().getString("data.operation.values.find{it.id==\"ftCity\"}.value")),
                    () -> assertEquals(TestDataValues.EMAIL, response.jsonPath().getString("data.operation.values.find{it.id==\"##email\"}.value")),
                    () -> assertEquals(TestDataValues.rgRegionCode, response.jsonPath().getString("data.operation.values.find{it.id==\"rgRegionCode\"}.value")),
                    () -> assertEquals(TestDataValues.surname, response.jsonPath().getString("data.operation.values.find{it.id==\"surname\"}.value")),
                    () -> assertEquals(TestDataValues.PDL, response.jsonPath().getString("data.operation.values.find{it.id==\"PDL\"}.value")),
                    () -> assertEquals(TestDataValues.issueDate, response.jsonPath().getString("data.operation.values.find{it.id==\"issueDate\"}.value")),
                    () -> assertEquals(TestDataValues.ftPostalCode, response.jsonPath().getString("data.operation.values.find{it.id==\"ftPostalCode\"}.value")),
                    () -> assertEquals(TestDataValues.ftRegionCode, response.jsonPath().getString("data.operation.values.find{it.id==\"ftRegionCode\"}.value")),
                    () -> assertEquals(TestDataValues.birthCountryCode, response.jsonPath().getString("data.operation.values.find{it.id==\"birthCountryCode\"}.value")),
                    () -> assertEquals(TestDataValues.ftCountryCode, response.jsonPath().getString("data.operation.values.find{it.id==\"ftCountryCode\"}.value")),
                    () -> assertEquals(TestDataValues.birthDate, response.jsonPath().getString("data.operation.values.find{it.id==\"birthDate\"}.value")),
                    () -> assertEquals(TestDataValues.sexCode, response.jsonPath().getString("data.operation.values.find{it.id==\"sexCode\"}.value")),
                    () -> assertEquals(TestDataValues.ftFlat, response.jsonPath().getString("data.operation.values.find{it.id==\"ftFlat\"}.value")),
                    () -> assertEquals(TestDataValues.departCode, response.jsonPath().getString("data.operation.values.find{it.id==\"departCode\"}.value")),
                    () -> assertEquals(TestDataValues.aflt_name, response.jsonPath().getString("data.operation.values.find{it.id==\"partnerdevParam.aflt_name\"}.value")),
                    () -> assertEquals(TestDataValues.ftBuilding, response.jsonPath().getString("data.operation.values.find{it.id==\"ftBuilding\"}.value")),
                    () -> assertEquals(TestDataValues.rgRegionName, response.jsonPath().getString("data.operation.values.find{it.id==\"rgRegionName\"}.value")),
                    () -> assertEquals(TestDataValues.isDkbo, response.jsonPath().getString("data.operation.values.find{it.id==\"isDkbo\"}.value")),
                    () -> assertEquals("initial", response.path("screen.stage"))
            );
        });

        step("Очистка мок", () -> {
            clientSearchMock.wiremockRemove();
            productCardsMock.wiremockRemove();
        });
    }

    @DisplayName("Получение успешного экрана при запросе на init с валидацией параметров из client-search")
    @ParameterizedTest
    @MethodSource("provideForinitTestCheckClientSearchValidationParams")
    public void initTestCheckClientSearchValidationParams(String att,
                                                          String val,
                                                          String incorrectDataMessage,
                                                          @InitRequest OmniRequestItem init,
                                                          @Mock Wiremock clientSearchMock,
                                                          @Mock Wiremock productCardsMock) {
        String gpbRequestId = UUID.randomUUID().toString();

        step("Конфигурация мок client-search", () -> {
            clientSearchMock.wiremockSend("wiremock/client-search/default.json",
                    "/omni-information/api/v2/client/search",
                    att,
                    val,
                    gpbRequestId);
        });
        step("Конфигурация мок product-cards", () -> {
            productCardsMock.wiremockSend("wiremock/product-cards/default.json",
                    "/omni-information-card/api/v3/client/product/cards",
                    "actualTimestamp",
                    "1234",
                    gpbRequestId);
        });

        step("Отправка запроса на init", () -> {
            init.getData().getScenario().setId(veteranScenarioId);
            init.getData().getScenario().setCode(veteranScenarioCode);
            Response response = given().header("gpb-requestId", gpbRequestId)
                    .body(init)
                    .post("api/v1/metadata/init")
                    .then().extract().response();
            step("Проверка параметров client-search в operation");
            assertAll(
                    () -> assertEquals("Клиентские данные некорректны", response.jsonPath().getString("data.operation.values.find{it.id==\"incorrectDataError\"}.value")),
                    () -> assertEquals(incorrectDataMessage, response.jsonPath().getString("data.operation.values.find{it.id==\"incorrectDataMessage\"}.value"))
            );
        });

        step("Очистка мок", () -> {
            clientSearchMock.wiremockRemove();
            productCardsMock.wiremockRemove();
        });
    }

    private static Stream<Arguments> provideForinitTestCheckClientSearchValidationParams() {
        return Stream.of(
                Arguments.of("data.clients.[?(@.base.guid==\"6F57A2C3507C4D6AA1A70E9C8C8CF919\")].base.surname", "", "Некорректное или отсутствующее имя клиента."),
                Arguments.of("data.clients.[?(@.base.guid==\"6F57A2C3507C4D6AA1A70E9C8C8CF919\")].base.name", "", "Некорректное или отсутствующее имя клиента."),
                Arguments.of("data.clients.[?(@.base.guid==\"6F57A2C3507C4D6AA1A70E9C8C8CF919\")].base.birthdate", "", "Дата рождения клиента  в системе банка отсутствует или заполнена некорректно.")

        );
    }

    @DisplayName("Получение успешного экрана при запросе на init с проверкой заполнения параметров из client-search")
    @Test
    public void initTestCheckStopListParams(@InitRequest OmniRequestItem init,
                                            @Mock Wiremock clientSearchMock,
                                            @Mock Wiremock productCardsMock) {
        String gpbRequestId = UUID.randomUUID().toString();

        step("Конфигурация мок client-search", () -> {
            clientSearchMock.wiremockSend("wiremock/client-search/default.json",
                    "/omni-information/api/v2/client/search",
                    "data.clients.[?(@.base.guid==\"6F57A2C3507C4D6AA1A70E9C8C8CF919\")].base.hid",
                    "",
                    gpbRequestId);
        });
        step("Конфигурация мок product-cards", () -> {
            productCardsMock.wiremockSend("wiremock/product-cards/default.json",
                    "/omni-information-card/api/v3/client/product/cards",
                    "actualTimestamp",
                    "1234",
                    gpbRequestId);
        });

        step("Отправка запроса на init", () -> {
            init.getData().getScenario().setId(veteranScenarioId);
            init.getData().getScenario().setCode(veteranScenarioCode);
            Response response = given().header("gpb-requestId", gpbRequestId)
                    .body(init)
                    .post("api/v1/metadata/init")
                    .then().extract().response();
            step("Проверка параметров client-search в operation");
            assertAll(
                    () -> assertEquals(TestDataValues.cellPhone, response.jsonPath().getString("data.operation.values.find{it.id==\"CELLPHONE\"}.value")),
                    () -> assertEquals(TestDataValues.docSeries, response.jsonPath().getString("data.operation.values.find{it.id==\"docSeries\"}.value")),
                    () -> assertEquals(TestDataValues.clientPhone, response.jsonPath().getString("data.operation.values.find{it.id==\"##clientPhone\"}.value")),
                    () -> assertEquals(TestDataValues.latinClientName, response.jsonPath().getString("data.operation.values.find{it.id==\"latinClientName\"}.value")),
                    () -> assertEquals(TestDataValues.areEmbossedCardsAvailable, response.jsonPath().getString("data.operation.values.find{it.id==\"##areEmbossedCardsAvailable\"}.value")),
                    () -> assertEquals(TestDataValues.countryISOCODE, response.jsonPath().getString("data.operation.values.find{it.id==\"countryISOCODE\"}.value")),
                    () -> assertEquals(TestDataValues.areInstantCardsAvailable, response.jsonPath().getString("data.operation.values.find{it.id==\"##areInstantCardsAvailable\"}.value")),
                    () -> assertEquals(TestDataValues.full_name, response.jsonPath().getString("data.operation.values.find{it.id==\"##full_name\"}.value")),
                    () -> assertEquals(TestDataValues.EMAIL, response.jsonPath().getString("data.operation.values.find{it.id==\"EMAIL\"}.value")),
                    () -> assertEquals(TestDataValues.rgCity, response.jsonPath().getString("data.operation.values.find{it.id==\"rgCity\"}.value")),
                    () -> assertEquals(TestDataValues.rgFlat, response.jsonPath().getString("data.operation.values.find{it.id==\"rgFlat\"}.value")),
                    () -> assertEquals(TestDataValues.isResident, response.jsonPath().getString("data.operation.values.find{it.id==\"isResident\"}.value")),
                    () -> assertEquals(TestDataValues.ftRegionName, response.jsonPath().getString("data.operation.values.find{it.id==\"ftRegionName\"}.value")),
                    () -> assertEquals(TestDataValues.rgCountryCode, response.jsonPath().getString("data.operation.values.find{it.id==\"rgCountryCode\"}.value")),
                    () -> assertEquals(TestDataValues.rgHouse, response.jsonPath().getString("data.operation.values.find{it.id==\"rgHouse\"}.value")),
                    () -> assertEquals(TestDataValues.location, response.jsonPath().getString("data.operation.values.find{it.id==\"##location\"}.value")),
                    () -> assertEquals(TestDataValues.aflt_surname, response.jsonPath().getString("data.operation.values.find{it.id==\"partnerdevParam.aflt_surname\"}.value")),
                    () -> assertEquals(TestDataValues.registration_address, response.jsonPath().getString("data.operation.values.find{it.id==\"##registration_address\"}.value")),
                    () -> assertEquals(TestDataValues.ftHouse, response.jsonPath().getString("data.operation.values.find{it.id==\"ftHouse\"}.value")),
                    () -> assertEquals(TestDataValues.cellPhoneWithSep, response.jsonPath().getString("data.operation.values.find{it.id==\"##CELLPHONE\"}.value")),
                    () -> assertEquals(TestDataValues.secondName, response.jsonPath().getString("data.operation.values.find{it.id==\"##secondName\"}.value")),
                    () -> assertEquals(TestDataValues.patronymic, response.jsonPath().getString("data.operation.values.find{it.id==\"patronymic\"}.value")),
                    () -> assertEquals(TestDataValues.expiredPassport, response.jsonPath().getString("data.operation.values.find{it.id==\"##expiredPassport\"}.value")),
                    () -> assertEquals(TestDataValues.name, response.jsonPath().getString("data.operation.values.find{it.id==\"name\"}.value")),
                    () -> assertEquals(TestDataValues.docTypeCode, response.jsonPath().getString("data.operation.values.find{it.id==\"docTypeCode\"}.value")),
                    () -> assertEquals(TestDataValues.document, response.jsonPath().getString("data.operation.values.find{it.id==\"##document\"}.value")),
                    () -> assertEquals(TestDataValues.birth_date, response.jsonPath().getString("data.operation.values.find{it.id==\"##birth_date\"}.value")),
                    () -> assertEquals(TestDataValues.guidOperation, response.jsonPath().getString("data.operation.values.find{it.id==\"guid\"}.value")),
                    () -> assertEquals(TestDataValues.rgPostalCode, response.jsonPath().getString("data.operation.values.find{it.id==\"rgPostalCode\"}.value")),
                    () -> assertEquals(TestDataValues.fact_address, response.jsonPath().getString("data.operation.values.find{it.id==\"##fact_address\"}.value")),
                    () -> assertEquals(TestDataValues.embossing_client_name, response.jsonPath().getString("data.operation.values.find{it.id==\"##embossing_client_name\"}.value")),
                    () -> assertEquals(TestDataValues.docNum, response.jsonPath().getString("data.operation.values.find{it.id==\"docNum\"}.value")),
                    () -> assertEquals(TestDataValues.firstName, response.jsonPath().getString("data.operation.values.find{it.id==\"##firstName\"}.value")),
                    () -> assertEquals(TestDataValues.lastName, response.jsonPath().getString("data.operation.values.find{it.id==\"##lastName\"}.value")),
                    () -> assertEquals(TestDataValues.CRSCountryCode, response.jsonPath().getString("data.operation.values.find{it.id==\"CRSCountryCode\"}.value")),
                    () -> assertEquals(TestDataValues.issuedBy, response.jsonPath().getString("data.operation.values.find{it.id==\"issuedBy\"}.value")),
                    () -> assertEquals(TestDataValues.ftCity, response.jsonPath().getString("data.operation.values.find{it.id==\"ftCity\"}.value")),
                    () -> assertEquals(TestDataValues.EMAIL, response.jsonPath().getString("data.operation.values.find{it.id==\"##email\"}.value")),
                    () -> assertEquals(TestDataValues.rgRegionCode, response.jsonPath().getString("data.operation.values.find{it.id==\"rgRegionCode\"}.value")),
                    () -> assertEquals(TestDataValues.surname, response.jsonPath().getString("data.operation.values.find{it.id==\"surname\"}.value")),
                    () -> assertEquals(TestDataValues.PDL, response.jsonPath().getString("data.operation.values.find{it.id==\"PDL\"}.value")),
                    () -> assertEquals(TestDataValues.issueDate, response.jsonPath().getString("data.operation.values.find{it.id==\"issueDate\"}.value")),
                    () -> assertEquals(TestDataValues.ftPostalCode, response.jsonPath().getString("data.operation.values.find{it.id==\"ftPostalCode\"}.value")),
                    () -> assertEquals(TestDataValues.ftRegionCode, response.jsonPath().getString("data.operation.values.find{it.id==\"ftRegionCode\"}.value")),
                    () -> assertEquals(TestDataValues.birthCountryCode, response.jsonPath().getString("data.operation.values.find{it.id==\"birthCountryCode\"}.value")),
                    () -> assertEquals(TestDataValues.ftCountryCode, response.jsonPath().getString("data.operation.values.find{it.id==\"ftCountryCode\"}.value")),
                    () -> assertEquals(TestDataValues.birthDate, response.jsonPath().getString("data.operation.values.find{it.id==\"birthDate\"}.value")),
                    () -> assertEquals(TestDataValues.sexCode, response.jsonPath().getString("data.operation.values.find{it.id==\"sexCode\"}.value")),
                    () -> assertEquals(TestDataValues.ftFlat, response.jsonPath().getString("data.operation.values.find{it.id==\"ftFlat\"}.value")),
                    () -> assertEquals(TestDataValues.departCode, response.jsonPath().getString("data.operation.values.find{it.id==\"departCode\"}.value")),
                    () -> assertEquals(TestDataValues.aflt_name, response.jsonPath().getString("data.operation.values.find{it.id==\"partnerdevParam.aflt_name\"}.value")),
                    () -> assertEquals(TestDataValues.ftBuilding, response.jsonPath().getString("data.operation.values.find{it.id==\"ftBuilding\"}.value")),
                    () -> assertEquals(TestDataValues.rgRegionName, response.jsonPath().getString("data.operation.values.find{it.id==\"rgRegionName\"}.value")),
                    () -> assertEquals(TestDataValues.isDkbo, response.jsonPath().getString("data.operation.values.find{it.id==\"isDkbo\"}.value")),
                    () -> assertEquals("initial", response.path("screen.stage"))
            );
        });

        step("Очистка мок", () -> {
            clientSearchMock.wiremockRemove();
            productCardsMock.wiremockRemove();
        });
    }

}





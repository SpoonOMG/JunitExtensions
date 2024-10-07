//package framework.qa.test.veteran;
//
//import framework.qa.consts.ChannelEnum;
//import framework.qa.consts.Params;
//import framework.qa.consts.UiFieldsNames;
//import framework.qa.jupiter.annotations.CheckRequest;
//import framework.qa.jupiter.annotations.InitRequest;
//import framework.qa.jupiter.annotations.LoadRequest;
//import framework.qa.jupiter.annotations.Mock;
//import framework.qa.models.requestData.OmniRequestItem;
//import framework.qa.models.requestData.ScreenCommandFront;
//import framework.qa.models.requestData.ScreenValueBack;
//import framework.qa.utils.Wiremock;
//import framework.qa.values.TestDataValues;
//import io.restassured.response.Response;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.MethodSource;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//import java.util.stream.Stream;
//
//import static framework.qa.values.TestDataValues.title;
//import static framework.qa.values.TestDataValues.userFullName;
//import static io.qameta.allure.Allure.step;
//import static io.restassured.RestAssured.given;
//import static org.junit.jupiter.api.Assertions.assertAll;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class ExampleTest extends BaseVeteranTest {
//
//
//    @DisplayName("Получение успешного экрана при запросе на init с обязательными параметрами")
//    @Test
//    public void veteranInitShouldReturnSuccessWithRequiredParams(@InitRequest OmniRequestItem init,
//                                                                 @Mock Wiremock clientSearchMock,
//                                                                 @Mock Wiremock productCardsMock) {
//        String gpbRequestId = UUID.randomUUID().toString();
//
//        step("Конфигурация мок client-search", () -> {
//            clientSearchMock.wiremockSend("wiremock/client-search/default.json",
//                    "/omni-information/api/v2/client/search",
//                    "data.clients.[?(@.base.guid==\"6F57A2C3507C4D6AA1A70E9C8C8CF919\")].base.hid",
//                    "",
//                    gpbRequestId);
//        });
//        step("Конфигурация мок product-cards", () -> {
//            productCardsMock.wiremockSend("wiremock/product-cards/default.json",
//                    "/omni-information-card/api/v3/client/product/cards",
//                    "actualTimestamp",
//                    "1234",
//                    gpbRequestId);
//        });
//
//        step("Отправка запроса на init", () -> {
//            init.getData().getScenario().setId(veteranScenarioId);
//            init.getData().getScenario().setCode(veteranScenarioCode);
//            Response response = given().header("gpb-requestId", gpbRequestId)
//                    .body(init)
//                    .post("omni-oks-cards/api/v1/metadata/init")
//                    .then().extract().response();
//            step("Проверка статуса экрана");
//            assertAll(
//                    () -> assertEquals("5NT_ARMY_PARAMS_DO", response.path("screen.load.id")),
//                    () -> assertEquals("initial", response.path("screen.stage")),
//                    () -> assertEquals(true, response.path("screen.success"))
//            );
//        });
//
//        step("Очистка мок", () -> {
//            clientSearchMock.wiremockRemove();
//            productCardsMock.wiremockRemove();
//        });
//    }
//
//    @DisplayName("Получение успешного экрана при запросе на init с проверкой заполнения параметров из client-search")
//    @Test
//    public void veteranInitCheckClientSearchReturnedParams(@InitRequest OmniRequestItem init,
//                                                           @Mock Wiremock clientSearchMock,
//                                                           @Mock Wiremock productCardsMock) {
//        String gpbRequestId = UUID.randomUUID().toString();
//
//        step("Конфигурация мок client-search", () -> {
//            clientSearchMock.wiremockSend("wiremock/client-search/default.json",
//                    "/omni-information/api/v2/client/search",
//                    "data.clients.[?(@.base.guid==\"6F57A2C3507C4D6AA1A70E9C8C8CF919\")].base.hid",
//                    "",
//                    gpbRequestId);
//        });
//        step("Конфигурация мок product-cards", () -> {
//            productCardsMock.wiremockSend("wiremock/product-cards/default.json",
//                    "/omni-information-card/api/v3/client/product/cards",
//                    "actualTimestamp",
//                    "1234",
//                    gpbRequestId);
//        });
//
//        step("Отправка запроса на init", () -> {
//            init.getData().getScenario().setId(veteranScenarioId);
//            init.getData().getScenario().setCode(veteranScenarioCode);
//            Response response = given().header("gpb-requestId", gpbRequestId)
//                    .body(init)
//                    .post("omni-oks-cards/api/v1/metadata/init")
//                    .then().extract().response();
//            step("Проверка параметров client-search в operation");
//            assertAll(
//                    () -> assertEquals(TestDataValues.cellPhone, response.jsonPath().getString("data.operation.values.find{it.id==\"CELLPHONE\"}.value")),
//                    () -> assertEquals(TestDataValues.docSeries, response.jsonPath().getString("data.operation.values.find{it.id==\"docSeries\"}.value")),
//                    () -> assertEquals(TestDataValues.clientPhone, response.jsonPath().getString("data.operation.values.find{it.id==\"##clientPhone\"}.value")),
//                    () -> assertEquals(TestDataValues.latinClientName, response.jsonPath().getString("data.operation.values.find{it.id==\"latinClientName\"}.value")),
//                    () -> assertEquals(TestDataValues.areEmbossedCardsAvailable, response.jsonPath().getString("data.operation.values.find{it.id==\"##areEmbossedCardsAvailable\"}.value")),
//                    () -> assertEquals(TestDataValues.countryISOCODE, response.jsonPath().getString("data.operation.values.find{it.id==\"countryISOCODE\"}.value")),
//                    () -> assertEquals(TestDataValues.areInstantCardsAvailable, response.jsonPath().getString("data.operation.values.find{it.id==\"##areInstantCardsAvailable\"}.value")),
//                    () -> assertEquals(TestDataValues.full_name, response.jsonPath().getString("data.operation.values.find{it.id==\"##full_name\"}.value")),
//                    () -> assertEquals(TestDataValues.EMAIL, response.jsonPath().getString("data.operation.values.find{it.id==\"EMAIL\"}.value")),
//                    () -> assertEquals(TestDataValues.rgCity, response.jsonPath().getString("data.operation.values.find{it.id==\"rgCity\"}.value")),
//                    () -> assertEquals(TestDataValues.rgFlat, response.jsonPath().getString("data.operation.values.find{it.id==\"rgFlat\"}.value")),
//                    () -> assertEquals(TestDataValues.isResident, response.jsonPath().getString("data.operation.values.find{it.id==\"isResident\"}.value")),
//                    () -> assertEquals(TestDataValues.ftRegionName, response.jsonPath().getString("data.operation.values.find{it.id==\"ftRegionName\"}.value")),
//                    () -> assertEquals(TestDataValues.rgCountryCode, response.jsonPath().getString("data.operation.values.find{it.id==\"rgCountryCode\"}.value")),
//                    () -> assertEquals(TestDataValues.rgHouse, response.jsonPath().getString("data.operation.values.find{it.id==\"rgHouse\"}.value")),
//                    () -> assertEquals(TestDataValues.location, response.jsonPath().getString("data.operation.values.find{it.id==\"##location\"}.value")),
//                    () -> assertEquals(TestDataValues.aflt_surname, response.jsonPath().getString("data.operation.values.find{it.id==\"partnerdevParam.aflt_surname\"}.value")),
//                    () -> assertEquals(TestDataValues.registration_address, response.jsonPath().getString("data.operation.values.find{it.id==\"##registration_address\"}.value")),
//                    () -> assertEquals(TestDataValues.ftHouse, response.jsonPath().getString("data.operation.values.find{it.id==\"ftHouse\"}.value")),
//                    () -> assertEquals(TestDataValues.cellPhoneWithSep, response.jsonPath().getString("data.operation.values.find{it.id==\"##CELLPHONE\"}.value")),
//                    () -> assertEquals(TestDataValues.secondName, response.jsonPath().getString("data.operation.values.find{it.id==\"##secondName\"}.value")),
//                    () -> assertEquals(TestDataValues.patronymic, response.jsonPath().getString("data.operation.values.find{it.id==\"patronymic\"}.value")),
//                    () -> assertEquals(TestDataValues.expiredPassport, response.jsonPath().getString("data.operation.values.find{it.id==\"##expiredPassport\"}.value")),
//                    () -> assertEquals(TestDataValues.name, response.jsonPath().getString("data.operation.values.find{it.id==\"name\"}.value")),
//                    () -> assertEquals(TestDataValues.docTypeCode, response.jsonPath().getString("data.operation.values.find{it.id==\"docTypeCode\"}.value")),
//                    () -> assertEquals(TestDataValues.document, response.jsonPath().getString("data.operation.values.find{it.id==\"##document\"}.value")),
//                    () -> assertEquals(TestDataValues.birth_date, response.jsonPath().getString("data.operation.values.find{it.id==\"##birth_date\"}.value")),
//                    () -> assertEquals(TestDataValues.guidOperation, response.jsonPath().getString("data.operation.values.find{it.id==\"guid\"}.value")),
//                    () -> assertEquals(TestDataValues.rgPostalCode, response.jsonPath().getString("data.operation.values.find{it.id==\"rgPostalCode\"}.value")),
//                    () -> assertEquals(TestDataValues.fact_address, response.jsonPath().getString("data.operation.values.find{it.id==\"##fact_address\"}.value")),
//                    () -> assertEquals(TestDataValues.embossing_client_name, response.jsonPath().getString("data.operation.values.find{it.id==\"##embossing_client_name\"}.value")),
//                    () -> assertEquals(TestDataValues.docNum, response.jsonPath().getString("data.operation.values.find{it.id==\"docNum\"}.value")),
//                    () -> assertEquals(TestDataValues.firstName, response.jsonPath().getString("data.operation.values.find{it.id==\"##firstName\"}.value")),
//                    () -> assertEquals(TestDataValues.lastName, response.jsonPath().getString("data.operation.values.find{it.id==\"##lastName\"}.value")),
//                    () -> assertEquals(TestDataValues.CRSCountryCode, response.jsonPath().getString("data.operation.values.find{it.id==\"CRSCountryCode\"}.value")),
//                    () -> assertEquals(TestDataValues.issuedBy, response.jsonPath().getString("data.operation.values.find{it.id==\"issuedBy\"}.value")),
//                    () -> assertEquals(TestDataValues.ftCity, response.jsonPath().getString("data.operation.values.find{it.id==\"ftCity\"}.value")),
//                    () -> assertEquals(TestDataValues.EMAIL, response.jsonPath().getString("data.operation.values.find{it.id==\"##email\"}.value")),
//                    () -> assertEquals(TestDataValues.rgRegionCode, response.jsonPath().getString("data.operation.values.find{it.id==\"rgRegionCode\"}.value")),
//                    () -> assertEquals(TestDataValues.surname, response.jsonPath().getString("data.operation.values.find{it.id==\"surname\"}.value")),
//                    () -> assertEquals(TestDataValues.PDL, response.jsonPath().getString("data.operation.values.find{it.id==\"PDL\"}.value")),
//                    () -> assertEquals(TestDataValues.issueDate, response.jsonPath().getString("data.operation.values.find{it.id==\"issueDate\"}.value")),
//                    () -> assertEquals(TestDataValues.ftPostalCode, response.jsonPath().getString("data.operation.values.find{it.id==\"ftPostalCode\"}.value")),
//                    () -> assertEquals(TestDataValues.ftRegionCode, response.jsonPath().getString("data.operation.values.find{it.id==\"ftRegionCode\"}.value")),
//                    () -> assertEquals(TestDataValues.birthCountryCode, response.jsonPath().getString("data.operation.values.find{it.id==\"birthCountryCode\"}.value")),
//                    () -> assertEquals(TestDataValues.ftCountryCode, response.jsonPath().getString("data.operation.values.find{it.id==\"ftCountryCode\"}.value")),
//                    () -> assertEquals(TestDataValues.birthDate, response.jsonPath().getString("data.operation.values.find{it.id==\"birthDate\"}.value")),
//                    () -> assertEquals(TestDataValues.sexCode, response.jsonPath().getString("data.operation.values.find{it.id==\"sexCode\"}.value")),
//                    () -> assertEquals(TestDataValues.ftFlat, response.jsonPath().getString("data.operation.values.find{it.id==\"ftFlat\"}.value")),
//                    () -> assertEquals(TestDataValues.departCode, response.jsonPath().getString("data.operation.values.find{it.id==\"departCode\"}.value")),
//                    () -> assertEquals(TestDataValues.aflt_name, response.jsonPath().getString("data.operation.values.find{it.id==\"partnerdevParam.aflt_name\"}.value")),
//                    () -> assertEquals(TestDataValues.ftBuilding, response.jsonPath().getString("data.operation.values.find{it.id==\"ftBuilding\"}.value")),
//                    () -> assertEquals(TestDataValues.rgRegionName, response.jsonPath().getString("data.operation.values.find{it.id==\"rgRegionName\"}.value")),
//                    () -> assertEquals(TestDataValues.isDkbo, response.jsonPath().getString("data.operation.values.find{it.id==\"isDkbo\"}.value")),
//                    () -> assertEquals("initial", response.path("screen.stage"))
//            );
//        });
//
//        step("Очистка мок", () -> {
//            clientSearchMock.wiremockRemove();
//            productCardsMock.wiremockRemove();
//        });
//    }
//
//    @DisplayName("Получение успешного экрана при запросе на init с валидацией параметров из client-search")
//    @ParameterizedTest
//    @MethodSource("provideForinitTestCheckClientSearchValidationParams")
//    public void veteranInitCheckClientSearchValidationParams(String att,
//                                                             String val,
//                                                             String incorrectDataMessage,
//                                                             @InitRequest OmniRequestItem init,
//                                                             @Mock Wiremock clientSearchMock,
//                                                             @Mock Wiremock productCardsMock) {
//        String gpbRequestId = UUID.randomUUID().toString();
//
//        step("Конфигурация мок client-search", () -> {
//            clientSearchMock.wiremockSend("wiremock/client-search/default.json",
//                    "/omni-information/api/v2/client/search",
//                    att,
//                    val,
//                    gpbRequestId);
//        });
//        step("Конфигурация мок product-cards", () -> {
//            productCardsMock.wiremockSend("wiremock/product-cards/default.json",
//                    "/omni-information-card/api/v3/client/product/cards",
//                    "actualTimestamp",
//                    "1234",
//                    gpbRequestId);
//        });
//
//        step("Отправка запроса на init", () -> {
//            init.getData().getScenario().setId(veteranScenarioId);
//            init.getData().getScenario().setCode(veteranScenarioCode);
//            Response response = given().header("gpb-requestId", gpbRequestId)
//                    .body(init)
//                    .post("omni-oks-cards/api/v1/metadata/init")
//                    .then().extract().response();
//            step("Проверка параметров client-search в operation");
//            assertAll(
//                    () -> assertEquals("Клиентские данные некорректны", response.jsonPath().getString("data.operation.values.find{it.id==\"incorrectDataError\"}.value")),
//                    () -> assertEquals(incorrectDataMessage, response.jsonPath().getString("data.operation.values.find{it.id==\"incorrectDataMessage\"}.value"))
//            );
//        });
//
//        step("Очистка мок", () -> {
//            clientSearchMock.wiremockRemove();
//            productCardsMock.wiremockRemove();
//        });
//    }
//
//    private static Stream<Arguments> provideForinitTestCheckClientSearchValidationParams() {
//        return Stream.of(
//                Arguments.of("data.clients.[?(@.base.guid==\"6F57A2C3507C4D6AA1A70E9C8C8CF919\")].base.surname", "", "Некорректное или отсутствующее имя клиента."),
//                Arguments.of("data.clients.[?(@.base.guid==\"6F57A2C3507C4D6AA1A70E9C8C8CF919\")].base.name", "", "Некорректное или отсутствующее имя клиента.")
////                Arguments.of("data.clients.[?(@.base.guid==\"6F57A2C3507C4D6AA1A70E9C8C8CF919\")].base.birthdate", "2010-10-17", "Дата рождения клиента  в системе банка отсутствует или заполнена некорректно.")
//
//        );
//    }
//
//    @DisplayName("Получение успешного экрана при запросе на check initial c минимальным набором параметров")
//    @Test
//    public void veteranCheckInitialShouldReturnSuccessScreenWithMinParams(@CheckRequest OmniRequestItem check) {
//        String gpbRequestId = UUID.randomUUID().toString();
//
//        step("Отправка запроса на check", () -> {
//            check.getData().getScenario().setId(veteranScenarioId);
//            check.getData().getScenario().setCode(veteranScenarioCode);
//            Response response = given().header("gpb-requestId", gpbRequestId)
//                    .body(check)
//                    .post("omni-oks-cards/api/v1/metadata/check")
//                    .then().extract().response();
//            step("Проверка получения экрана успеха");
//            assertAll(
//                    () -> assertEquals("5NT_BORROWER_EXT_OFFICE", response.path("screen.load.id")),
//                    () -> assertEquals("final", response.path("screen.stage")),
//                    () -> assertEquals(true, response.path("screen.success")),
//                    () -> assertEquals("false", response.jsonPath().getString("data.operation.values.find{it.id==\"##isSecretWord\"}.value")),
//                    () -> assertEquals(productOfferShortName, response.jsonPath().getString("data.operation.values.find{it.id==\"productOfferShortName\"}.value")),
//                    () -> assertEquals(servicePackage, response.jsonPath().getString("data.operation.values.find{it.id==\"##servicePackage\"}.value")),
//                    () -> assertEquals(TypeCreation, response.jsonPath().getString("data.operation.values.find{it.id==\"TypeCreation\"}.value")),
//                    () -> assertEquals("false", response.jsonPath().getString("data.operation.values.find{it.id==\"##delivery.dsa\"}.value")),
//                    () -> assertEquals(paySystemCode, response.jsonPath().getString("data.operation.values.find{it.id==\"##paySystemCode\"}.value")),
//                    () -> assertEquals(cardCurrency, response.jsonPath().getString("data.operation.values.find{it.id==\"##cardCurrency\"}.value")),
//                    () -> assertEquals("false", response.jsonPath().getString("data.operation.values.find{it.id==\"##delivery.courier\"}.value")),
//                    () -> assertEquals(IsUnembossed, response.jsonPath().getString("data.operation.values.find{it.id==\"IsUnembossed\"}.value")),
//                    () -> assertEquals(printCardName, response.jsonPath().getString("data.operation.values.find{it.id==\"##printCardName\"}.value")),
//                    () -> assertEquals(branchCode, response.jsonPath().getString("data.operation.values.find{it.id==\"branchCode\"}.value")),
//                    () -> assertEquals("1", response.jsonPath().getString("data.operation.values.find{it.id==\"##currencyId\"}.value")),
//                    () -> assertEquals("true", response.jsonPath().getString("data.operation.values.find{it.id==\"##delivery.office\"}.value")),
//                    () -> assertEquals(subProgramCode, response.jsonPath().getString("data.operation.values.find{it.id==\"subProgramCode\"}.value")),
//                    () -> assertEquals("false", response.jsonPath().getString("data.operation.values.find{it.id==\"##expiredPassport\"}.value")),
//                    () -> assertEquals(currencyCode, response.jsonPath().getString("data.operation.values.find{it.id==\"currencyCode\"}.value")),
//                    () -> assertEquals(paymentSystemCode, response.jsonPath().getString("data.operation.values.find{it.id==\"paymentSystemCode\"}.value"))
//            );
//        });
//
//    }
//
//    @DisplayName("Получение успешного экрана при запросе на check final c минимальным набором параметров")
//    @Test
//    public void veteranCheckFinalShouldReturnSuccessScreenWithMinParams(@CheckRequest OmniRequestItem check,
//                                                                        @Mock Wiremock issuCheckMock) {
//        String gpbRequestId = UUID.randomUUID().toString();
//        step("Конфигурация мок issuCheckMock", () -> {
//            issuCheckMock.wiremockSend("wiremock/issue-check/card-issue-check-isMobilePinTrue.json",
//                    "/omni-information-card/api/v3/client/product/card/issue/check",
//                    "actualTimestamp",
//                    "1234",
//                    gpbRequestId);
//        });
//
//        step("Отправка запроса на check", () -> {
//            List<ScreenValueBack> operation = new ArrayList<>();
//            List<ScreenValueBack> verifyDataValues = new ArrayList<>();
//            verifyDataValues.add(new ScreenValueBack(UiFieldsNames.UI_CARD_NUMBER_FIELD_ID, CardNumber));
//            verifyDataValues.add(new ScreenValueBack(UiFieldsNames.UI_DATE_EXPIRATION, dateExpiration));
//            verifyDataValues.add(new ScreenValueBack(Params.BRANCH_UNIT_CODE, TestDataValues.branchUnitCode));
//            verifyDataValues.add(new ScreenValueBack(UiFieldsNames.UI_IS_OTP, "true"));
//
//            check.getData().getOperation().setOrder4client(UUID.randomUUID().toString());
//            check.getData().getScenario().setId(veteranScenarioId);
//            check.getData().getScenario().setCode(veteranScenarioCode);
//            check.getData().getVerifyData().setValues(verifyDataValues);
//            check.getData().getVerifyData().setCommand(new ScreenCommandFront("check", "checkLocation"));
//            check.getData().getVerifyData().setScreenStage("final");
//
//            check.getData().getOperation().setValues(operationFinalMinParam());
//            Response response = given().header("gpb-requestId", gpbRequestId)
//                    .body(check)
//                    .post("omni-oks-cards/api/v1/metadata/check")
//                    .then().extract().response();
//            step("Проверка получения экрана успеха");
//            assertAll(
//                    () -> assertEquals("CARD_APPLICATION_STATUS", response.path("screen.load.id")),
//                    () -> assertEquals("draft", response.path("screen.stage")),
//                    () -> assertEquals(true, response.path("screen.success"))
//            );
//        });
//        step("Очистка мок", () -> {
//            issuCheckMock.wiremockRemove();
//        });
//
//    }
//
//    @DisplayName("Получение успешного экрана при запросе на check final c минимальным набором параметров")
//    @Test
//    public void veteranCheckExecuteShouldReturnSuccessScreenWithMinParams(@Mock Wiremock clientSearchMock,
//                                                                          @CheckRequest OmniRequestItem check) {
//        String gpbRequestId = UUID.randomUUID().toString();
//        step("Конфигурация мок client-search", () -> {
//            clientSearchMock.wiremockSend("wiremock/client-search/default.json",
//                    "/omni-information/api/v2/client/search",
//                    "data.clients.[?(@.base.guid==\"6F57A2C3507C4D6AA1A70E9C8C8CF919\")].base.hid",
//                    "",
//                    gpbRequestId);
//        });
//
//
//        step("Отправка запроса на check", () -> {
//            List<ScreenValueBack> verifyDataValues = new ArrayList<>();
//            List<ScreenValueBack> operationValues = operationFinalMaxParam();
//            operationValues.add(new ScreenValueBack(Params.IS_UNEMBOSSED, "1"));
//            operationValues.add(new ScreenValueBack(UiFieldsNames.UI_EMBOSSING_CLIENT_NAME, TestDataValues.embossing_client_name));
//            operationValues.add(new ScreenValueBack(Params.CHANNEL, ChannelEnum.UFO.getName()));
//
//            verifyDataValues.add(new ScreenValueBack(UiFieldsNames.UI_CODEWORD, "Рига"));
//            verifyDataValues.add(new ScreenValueBack(UiFieldsNames.UI_CLIENT_CONSENTS, "true"));
//
//            check.getMeta().setChannel(ChannelEnum.WEB.getName());
//            check.getData().getOperation().setOrder4client(UUID.randomUUID().toString());
//            check.getData().getScenario().setId(veteranScenarioId);
//            check.getData().getScenario().setCode(veteranScenarioCode);
//            check.getData().getVerifyData().setCommand(new ScreenCommandFront("execute", "confirmCardApplication"));
//            check.getData().getVerifyData().setScreenStage("after_draft");
//            check.getData().getVerifyData().setScreenId("5NT_AFTER_DRAFT_ALL");
//
//            check.getData().getVerifyData().setValues(verifyDataValues);
//            check.getData().getOperation().setValues(operationValues);
//            Response response = given().header("gpb-requestId", gpbRequestId)
//                    .body(check)
//                    .post("omni-oks-cards/api/v1/metadata/check")
//                    .then().extract().response();
//            step("Проверка получения экрана успеха");
//
//            assertAll(
//                    () -> assertEquals("success", response.path("status")),
//                    () -> assertEquals(check.getData().getOperation().getOrderId(), response.path("data.operation.orderId")),
//                    () -> assertEquals("high", response.path("data.serverActions.find{it.action=\"signature\"}.criticality")),
//                    () -> assertEquals("after", response.path("data.serverActions.find{it.action=\"signature\"}.startPoint")),
//                    () -> assertEquals("Вы оформляете заявку на дебетовую карту", response.path("data.serverActions.find{it.action=\"signature\"}.parameters.find{it.key=\"textSms\"}.value")),
//                    () -> assertEquals("string", response.path("data.serverActions.find{it.action=\"signature\"}.parameters.find{it.key=\"clientPhone\"}.type")));
//
//        });
//        step("Очистка мок", () -> {
//            clientSearchMock.wiremockRemove();
//        });
//
//    }
//
//    @DisplayName("Получение успешного экрана при запросе на load c минимальным набором параметров")
//    @Test
//    public void veteranLoadShouldReturnSuccessScreenWithMinParams(@LoadRequest OmniRequestItem load) {
//        String gpbRequestId = UUID.randomUUID().toString();
//        step("Отправка запроса на load", () -> {
//            Response response = given().header("gpb-requestId", gpbRequestId)
//                    .body(load)
//                    .post("omni-oks-cards/api/v1/metadata/load")
//                    .then().extract().response();
//            step("Проверка получения экрана успеха");
//            assertAll(
//                    () -> assertEquals("5NT_AFTER_DRAFT_ALL", response.path("screen.load.id")),
//                    () -> assertEquals("after_draft", response.path("screen.stage")),
//                    () -> assertEquals(true, response.path("screen.success"))
//            );
//        });
//    }
//
//
//    @DisplayName("Проверка получения параметров в ответе, переданных в verifyData при запросе на load c максимальным набором параметров")
//    @Test
//    public void veteranLoadShouldReturnSuccessScreenWithProvidedParams(@LoadRequest OmniRequestItem load) {
//        String gpbRequestId = UUID.randomUUID().toString();
//        step("Отправка запроса на load", () -> {
//
//            load.getData().getVerifyData().setValues(operationFinalMaxParam());
//            Response response = given().header("gpb-requestId", gpbRequestId)
//                    .body(load)
//                    .post("omni-oks-cards/api/v1/metadata/load")
//                    .then().extract().response();
//            step("Проверка получения экрана успеха");
//            assertAll(
//                    () -> assertEquals(TestDataValues.login, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.LOGIN + "\"}.value")),
//                    () -> assertEquals(TestDataValues.sourceChannel, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.SOURCE_CHANNEL + "\"}.value")),
//                    () -> assertEquals(TestDataValues.isDkbo, response.jsonPath().getString("data.operation.values.find{it.id==\"isDkbo\"}.value")),
//                    () -> assertEquals(TestDataValues.PDL, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.PDL + "\"}.value")),
//                    () -> assertEquals(branchCode, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.BRANCH_CODE + "\"}.value")),
//                    () -> assertEquals(currencyCode, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.CURRENCY_CODE + "\"}.value")),
//                    () -> assertEquals(subProgramCode, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.SUB_PROGRAM_CODE + "\"}.value")),
//                    () -> assertEquals(productOfferShortName, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.PRODUCT_OFFER_SHORT_NAME + "\"}.value")),
//                    () -> assertEquals("7", response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.CARD_CATEGORY_CODE + "\"}.value")),
//                    () -> assertEquals(paymentSystemCode, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.PAY_SYSTEM_CODE + "\"}.value")),
//                    () -> assertEquals(TypeCreation, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.TYPE_CREATION + "\"}.value")),
//                    () -> assertEquals(userFullName, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.USER_FULL_NAME + "\"}.value")),
//                    () -> assertEquals(TestDataValues.full_name, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.EMPLOYEE_FULL_NAME + "\"}.value")),
//                    () -> assertEquals(TestDataValues.latinClientName, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.LATIN_CLIENT_NAME + "\"}.value")),
//                    () -> assertEquals(title, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.TITLE + "\"}.value")),
//                    () -> assertEquals(title, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.EMPLOYEE_POSITION + "\"}.value")),
//                    () -> assertEquals(ChannelEnum.UFO.getName(), response.jsonPath().getString("data.operation.values.find{it.id==\"" + UiFieldsNames.UI_SOURCE_CHANNEL + "\"}.value")),
//                    () -> assertEquals(TestDataValues.surname, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.SURNAME + "\"}.value")),
//                    () -> assertEquals(TestDataValues.name, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.NAME + "\"}.value")),
//                    () -> assertEquals(TestDataValues.sexCode, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.SEX_CODE + "\"}.value")),
//                    () -> assertEquals(TestDataValues.isResident, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.IS_RESIDENT + "\"}.value")),
//                    () -> assertEquals(TestDataValues.birth_date, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.BIRTH_DATE + "\"}.value")),
//                    () -> assertEquals(TestDataValues.birthPlace, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.BIRTH_PLACE + "\"}.value")),
//                    () -> assertEquals(TestDataValues.birthCountryCode, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.BIRTH_COUNTRY_CODE + "\"}.value")),
//                    () -> assertEquals(TestDataValues.docTypeCode, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.DOC_TYPE_CODE + "\"}.value")),
//                    () -> assertEquals(TestDataValues.docSeries, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.DOC_SERIES + "\"}.value")),
//                    () -> assertEquals(TestDataValues.docNum, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.DOC_NUM + "\"}.value")),
//                    () -> assertEquals(TestDataValues.issueDate, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.ISSUE_DATE + "\"}.value")),
//                    () -> assertEquals(TestDataValues.issuedBy, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.ISSUED_BY + "\"}.value")),
//                    () -> assertEquals(TestDataValues.departCode, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.DEPART_CODE + "\"}.value")),
//                    () -> assertEquals(TestDataValues.rgCountryCode, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.RG_COUNTRY_CODE + "\"}.value")),
//                    () -> assertEquals(TestDataValues.rgPostalCode, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.RG_POSTAL_CODE + "\"}.value")),
//                    () -> assertEquals(TestDataValues.rgRegionCode, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.RG_REGION_CODE + "\"}.value")),
//                    () -> assertEquals(TestDataValues.ftCountryCode, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.FT_COUNTRY_CODE + "\"}.value")),
//                    () -> assertEquals(TestDataValues.ftPostalCode, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.FT_POSTAL_CODE + "\"}.value")),
//                    () -> assertEquals(TestDataValues.ftRegionCode, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.FT_REGION_CODE + "\"}.value")),
//                    () -> assertEquals(TestDataValues.cellPhone, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.CELL_PHONE + "\"}.value")),
//                    () -> assertEquals(TestDataValues.EMAIL, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.EMAIL + "\"}.value")),
//                    () -> assertEquals(currencyCode, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.CURRENCY_CODE + "\"}.value"))
//            );
//        });
//    }
//
//
//
//    }

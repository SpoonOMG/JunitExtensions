//package framework.qa.test.common;
//
//import framework.qa.consts.ChannelEnum;
//import framework.qa.consts.Params;
//import framework.qa.consts.ScenarioCodeEnum;
//import framework.qa.consts.UiFieldsNames;
//import framework.qa.jupiter.annotations.CheckRequest;
//import framework.qa.jupiter.annotations.Mock;
//import framework.qa.models.requestData.OmniRequestItem;
//import framework.qa.models.requestData.ScreenCommandFront;
//import framework.qa.models.requestData.ScreenValueBack;
//import framework.qa.test.BaseTest;
//import framework.qa.test.veteran.BaseVeteranTest;
//import framework.qa.utils.WiremockRetrofit;
//import framework.qa.values.TestDataValues;
//import io.restassured.response.Response;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Tag;
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
//import static framework.qa.values.TestDataValues.*;
//import static framework.qa.values.TestDataValues.title;
//import static io.qameta.allure.Allure.step;
//import static io.restassured.RestAssured.given;
//import static org.junit.jupiter.api.Assertions.assertAll;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@Tag("Отказ от подписания")
//public class CheckExecuteSignRefuse extends BaseTest {
//
//
//    @DisplayName("Проверка обязательных параметров в operation для сценариев с отказом от подписания")
//    @ParameterizedTest
//    @MethodSource("provideForCheckFinalPlannedClosureInUFO")
//    public void refuseCheckExecuteShouldReturnRequiredParams(String scenarioId,
//                                                             String scenarioCode,
//                                                             @Mock WiremockRetrofit clientSearchMock,
//                                                             @CheckRequest OmniRequestItem check) {
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
//            List<ScreenValueBack> operationValues = operationParam();
//            String order4client = UUID.randomUUID().toString();
//
//
//            verifyDataValues.add(new ScreenValueBack(UiFieldsNames.UI_CODEWORD, "Рига"));
//            verifyDataValues.add(new ScreenValueBack(UiFieldsNames.UI_CLIENT_CONSENTS, "true"));
//
//            check.getMeta().setChannel(ChannelEnum.WEB.getName());
//            check.getData().getOperation().setOrder4client(order4client);
//            check.getData().getScenario().setId(scenarioId);
//            check.getData().getScenario().setCode(scenarioCode);
//            check.getData().getVerifyData().setCommand(new ScreenCommandFront("execute", "refuseCardApplication"));
//            check.getData().getVerifyData().setScreenStage("after_draft");
//            check.getData().getVerifyData().setScreenId("5NT_AFTER_DRAFT_ALL");
//
//            check.getData().getVerifyData().setValues(verifyDataValues);
//            check.getData().getOperation().setValues(operationValues);
//            Response response = given().header("gpb-requestId", gpbRequestId)
//                    .body(check)
//                    .post("api/v1/metadata/check")
//                    .then().extract().response();
//            step("Проверка получения экрана успеха");
//
//            assertAll(
//                    () -> assertEquals("success", response.path("status")),
//                    () -> assertEquals(check.getData().getOperation().getOrderId(), response.path("data.operation.orderId")),
//                    () -> assertEquals(TestDataValues.branchCode, response.path("data.operation.values.find{it.id==\"branchCode\"}.value")),
//                    () -> assertEquals(TestDataValues.branchUnitCode, response.path("data.operation.values.find{it.id==\"branchUnitCode\"}.value")),
//                    () -> assertEquals("1", response.path("data.operation.values.find{it.id==\"kindGet\"}.value")),
//                    () -> assertEquals(TestDataValues.subProgramCode, response.path("data.operation.values.find{it.id==\"subProgramCode\"}.value")),
//                    () -> assertEquals(TestDataValues.sourceChannel, response.path("data.operation.values.find{it.id==\"channel\"}.value")),
//                    () -> assertEquals(order4client, response.path("data.operation.values.find{it.id==\"order4client\"}.value")),
//                    () -> assertEquals("0", response.path("data.operation.values.find{it.id==\"TypeSign\"}.value")),
//                    () -> assertEquals("false", response.path("data.operation.values.find{it.id==\"agreeOtpSign\"}.value")),
//                    () -> assertEquals(TestDataValues.login, response.path("data.operation.values.find{it.id==\"RealUser\"}.value")),
//                    () -> assertEquals(name, response.path("data.operation.values.find{it.id==\"name\"}.value")),
//                    () -> assertEquals(surname, response.path("data.operation.values.find{it.id==\"surname\"}.value")),
//                    () -> assertEquals(patronymic, response.path("data.operation.values.find{it.id==\"patronymic\"}.value")),
//                    () -> assertEquals(sexCode, response.path("data.operation.values.find{it.id==\"sexCode\"}.value")),
//                    () -> assertEquals(isResident, response.path("data.operation.values.find{it.id==\"isResident\"}.value")),
//                    () -> assertEquals(countryISOCODE, response.path("data.operation.values.find{it.id==\"countryISOCODE\"}.value")),
//                    () -> assertEquals(birth_date, response.path("data.operation.values.find{it.id==\"birthDate\"}.value")),
//                    () -> assertEquals(birthPlace, response.path("data.operation.values.find{it.id==\"birthPlace\"}.value")),
//                    () -> assertEquals(birthCountryCode, response.path("data.operation.values.find{it.id==\"birthCountryCode\"}.value")),
//                    () -> assertEquals(EMAIL, response.path("data.operation.values.find{it.id==\"EMAIL\"}.value")),
//                    () -> assertEquals(cellPhone, response.path("data.operation.values.find{it.id==\"CELLPHONE\"}.value")),
//                    () -> assertEquals(rgCountryCode, response.path("data.operation.values.find{it.id==\"rgCountryCode\"}.value")),
//                    () -> assertEquals(rgPostalCode, response.path("data.operation.values.find{it.id==\"rgPostalCode\"}.value")),
//                    () -> assertEquals(ftCountryCode, response.path("data.operation.values.find{it.id==\"ftCountryCode\"}.value")),
//                    () -> assertEquals("1", response.path("data.operation.values.find{it.id==\"IsUnembossed\"}.value")),
//                    () -> assertEquals(latinClientName, response.path("data.operation.values.find{it.id==\"latinClientName\"}.value")));
//
//        });
//        step("Очистка мок", () -> {
//            clientSearchMock.wiremockRemove();
//        });
//
//    }
//
//    private static Stream<Arguments> provideForCheckFinalPlannedClosureInUFO() {
//        return Stream.of(
//                Arguments.of(ScenarioCodeEnum.sc_57eb451bc6aa383.getId(), ScenarioCodeEnum.sc_57eb451bc6aa383.getCode()),
//                Arguments.of(ScenarioCodeEnum.sc_beece2b6ae57866.getId(), ScenarioCodeEnum.sc_beece2b6ae57866.getCode()),
//                Arguments.of(ScenarioCodeEnum.sc_268e095e417227a.getId(), ScenarioCodeEnum.sc_268e095e417227a.getCode()),
//                Arguments.of(ScenarioCodeEnum.sc_2bd290ce18e7c38.getId(), ScenarioCodeEnum.sc_2bd290ce18e7c38.getCode()),
//                Arguments.of(ScenarioCodeEnum.sc_28fe75e70f491af.getId(), ScenarioCodeEnum.sc_28fe75e70f491af.getCode()),
//                Arguments.of(ScenarioCodeEnum.sc_a962ae4856b4934.getId(), ScenarioCodeEnum.sc_a962ae4856b4934.getCode()),
//                Arguments.of(ScenarioCodeEnum.sc_aaa069108374373.getId(), ScenarioCodeEnum.sc_aaa069108374373.getCode()),
//                Arguments.of(ScenarioCodeEnum.sc_050bf0e46183924.getId(), ScenarioCodeEnum.sc_050bf0e46183924.getCode()),
//                Arguments.of(ScenarioCodeEnum.sc_71b501548473525.getId(), ScenarioCodeEnum.sc_71b501548473525.getCode()),
//                Arguments.of(ScenarioCodeEnum.sc_04b1b0cbf1754c9.getId(), ScenarioCodeEnum.sc_04b1b0cbf1754c9.getCode()),
//                Arguments.of(ScenarioCodeEnum.sc_d4f3b8b82abe703.getId(), ScenarioCodeEnum.sc_d4f3b8b82abe703.getCode()),
//                Arguments.of(ScenarioCodeEnum.sc_952dc9ede3b89c0.getId(), ScenarioCodeEnum.sc_952dc9ede3b89c0.getCode()),
//                Arguments.of(ScenarioCodeEnum.sc_4262aa8ccd8ada7.getId(), ScenarioCodeEnum.sc_4262aa8ccd8ada7.getCode())
//
//        );
//    }
//
//    List<ScreenValueBack> operationParam() {
//        List<ScreenValueBack> operationFinals = new ArrayList<>();
//        operationFinals.add(new ScreenValueBack(Params.LOGIN, TestDataValues.login));
//        operationFinals.add(new ScreenValueBack(Params.SOURCE_CHANNEL, TestDataValues.sourceChannel));
//        operationFinals.add(new ScreenValueBack(Params.IS_DKBO, TestDataValues.isDkbo));
//        operationFinals.add(new ScreenValueBack(Params.PDL, TestDataValues.PDL));
//        operationFinals.add(new ScreenValueBack(Params.BRANCH_CODE, branchCode));
//        operationFinals.add(new ScreenValueBack(Params.CURRENCY_CODE, "810"));
//        operationFinals.add(new ScreenValueBack(Params.SUB_PROGRAM_CODE, subProgramCode));
//        operationFinals.add(new ScreenValueBack(Params.CARD_CATEGORY_CODE, "7"));
//        operationFinals.add(new ScreenValueBack(Params.PAY_SYSTEM_CODE, "3"));
//        operationFinals.add(new ScreenValueBack(Params.USER_FULL_NAME, userFullName));
//        operationFinals.add(new ScreenValueBack(Params.EMPLOYEE_FULL_NAME, TestDataValues.full_name));
//        operationFinals.add(new ScreenValueBack(Params.LATIN_CLIENT_NAME, TestDataValues.latinClientName));
//        operationFinals.add(new ScreenValueBack(Params.TITLE, title));
//        operationFinals.add(new ScreenValueBack(Params.EMPLOYEE_POSITION, title));
//        operationFinals.add(new ScreenValueBack(UiFieldsNames.UI_SOURCE_CHANNEL, ChannelEnum.UFO.getName()));
//        operationFinals.add(new ScreenValueBack(Params.SURNAME, TestDataValues.surname));
//        operationFinals.add(new ScreenValueBack(Params.NAME, TestDataValues.name));
//        operationFinals.add(new ScreenValueBack(Params.PATRONYMIC, patronymic));
//        operationFinals.add(new ScreenValueBack(Params.SEX_CODE, TestDataValues.sexCode));
//        operationFinals.add(new ScreenValueBack(Params.IS_RESIDENT, TestDataValues.isResident));
//        operationFinals.add(new ScreenValueBack(Params.BIRTH_DATE, TestDataValues.birth_date));
//        operationFinals.add(new ScreenValueBack(Params.BIRTH_PLACE, TestDataValues.birthPlace));
//        operationFinals.add(new ScreenValueBack(Params.BIRTH_COUNTRY_CODE, TestDataValues.birthCountryCode));
//        operationFinals.add(new ScreenValueBack(Params.DOC_TYPE_CODE, TestDataValues.docTypeCode));
//        operationFinals.add(new ScreenValueBack(Params.DOC_SERIES, TestDataValues.docSeries));
//        operationFinals.add(new ScreenValueBack(Params.DOC_NUM, TestDataValues.docNum));
//        operationFinals.add(new ScreenValueBack(Params.ISSUE_DATE, TestDataValues.issueDate));
//        operationFinals.add(new ScreenValueBack(Params.ISSUED_BY, TestDataValues.issuedBy));
//        operationFinals.add(new ScreenValueBack(Params.DEPART_CODE, TestDataValues.departCode));
//        operationFinals.add(new ScreenValueBack(Params.RG_COUNTRY_CODE, TestDataValues.rgCountryCode));
//        operationFinals.add(new ScreenValueBack(Params.RG_POSTAL_CODE, TestDataValues.rgPostalCode));
//        operationFinals.add(new ScreenValueBack(Params.RG_REGION_CODE, TestDataValues.rgRegionCode));
//        operationFinals.add(new ScreenValueBack(Params.FT_COUNTRY_CODE, TestDataValues.ftCountryCode));
//        operationFinals.add(new ScreenValueBack(Params.FT_POSTAL_CODE, TestDataValues.ftPostalCode));
//        operationFinals.add(new ScreenValueBack(Params.FT_REGION_CODE, TestDataValues.ftRegionCode));
//        operationFinals.add(new ScreenValueBack(Params.CELL_PHONE, TestDataValues.cellPhone));
//        operationFinals.add(new ScreenValueBack(Params.EMAIL, TestDataValues.EMAIL));
//        operationFinals.add(new ScreenValueBack(Params.IS_UNEMBOSSED, "1"));
//        operationFinals.add(new ScreenValueBack(UiFieldsNames.UI_EMBOSSING_CLIENT_NAME, TestDataValues.embossing_client_name));
//        operationFinals.add(new ScreenValueBack(Params.CHANNEL, ChannelEnum.UFO.getName()));
//        operationFinals.add(new ScreenValueBack(Params.KIND_GET, "1"));
//        operationFinals.add(new ScreenValueBack(Params.BRANCH_UNIT_CODE, branchUnitCode));
//        operationFinals.add(new ScreenValueBack(Params.REAL_USER, login));
//        operationFinals.add(new ScreenValueBack(Params.COUNTRY_ISO_CODE, countryISOCODE));
//        return operationFinals;
//    }
//}

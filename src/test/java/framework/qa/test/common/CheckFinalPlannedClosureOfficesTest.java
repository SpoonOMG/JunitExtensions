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
//import framework.qa.utils.WiremockRetrofit;
//import framework.qa.values.TestDataValues;
//import io.restassured.http.ContentType;
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
//import static io.qameta.allure.Allure.step;
//import static io.restassured.RestAssured.given;
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertAll;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//
//// Проверка TEAMDB-33389 Оповещение сотрудника о плановом закрытии офиса
//
//
//@Tag("TEAMDB-33389")
//public class CheckFinalPlannedClosureOfficesTest extends BaseTest {
//
//
//    @DisplayName("Получение экрана ошибки при запросе на check final когда office-list не вернул запрашиваемый офис")
//    @Test
//    public void checkFinalShouldReturnErrorWhenBranchUnitCodeNotInOfficeListAnswerUFO(@CheckRequest OmniRequestItem check,
//                                                                                   @Mock WiremockRetrofit issuCheckMock) {
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
//            verifyDataValues.add(new ScreenValueBack(UiFieldsNames.UI_CARD_NUMBER_FIELD_ID, TestDataValues.CardNumber));
//            verifyDataValues.add(new ScreenValueBack(UiFieldsNames.UI_DATE_EXPIRATION, TestDataValues.dateExpiration));
//            verifyDataValues.add(new ScreenValueBack(Params.BRANCH_UNIT_CODE, TestDataValues.branchUnitCode));
//            verifyDataValues.add(new ScreenValueBack(UiFieldsNames.UI_IS_OTP, "true"));
//            operation.add(new ScreenValueBack(Params.LOGIN, TestDataValues.login));
//            operation.add(new ScreenValueBack(Params.BRANCH_CODE, TestDataValues.branchCode));
//            operation.add(new ScreenValueBack(Params.CURRENCY_CODE, "810"));
//            operation.add(new ScreenValueBack(Params.SUB_PROGRAM_CODE, TestDataValues.subProgramCode));
//            operation.add(new ScreenValueBack(Params.CARD_CATEGORY_CODE, "7"));
//            operation.add(new ScreenValueBack(Params.LATIN_CLIENT_NAME, TestDataValues.latinClientName));
//            operation.add(new ScreenValueBack(UiFieldsNames.UI_SOURCE_CHANNEL, ChannelEnum.UFO.getName()));
//
//            check.getData().getOperation().setOrder4client(UUID.randomUUID().toString());
//            check.getData().getScenario().setId(ScenarioCodeEnum.sc_57eb451bc6aa383.getId());
//            check.getData().getScenario().setCode(ScenarioCodeEnum.sc_57eb451bc6aa383.getCode());
//            check.getData().getVerifyData().setValues(verifyDataValues);
//            check.getData().getVerifyData().setCommand(new ScreenCommandFront("check", "checkLocation"));
//            check.getData().getVerifyData().setScreenStage("final");
//
//
//            check.getData().getOperation().setValues(operation);
//            Response response = given().header("gpb-requestId", gpbRequestId)
//                    .header("Authorization", CFG.token())
//                    .header("GPB-guid", guid).contentType(ContentType.JSON)
//                    .body(check)
//                    .post("api/v1/metadata/check")
//                    .then().extract().response();
//            step("Проверка получения экрана успеха");
//            assertAll(
//                    () -> assertEquals(response.path("screen.message.elements.find{it.id=='branchUnitCode'}.error.message"), "ДО в состоянии, отличном от \"Открыт\" или информация о состоянии ДО отсутствует.  Для завершения оформления выберите другой ДО")
//            );
//        });
//        step("Очистка мок", () -> {
//            issuCheckMock.wiremockRemove();
//        });
//
//    }
//
//
//    @DisplayName("Получение экрана ошибки при запросе на check final когда office-list stateId=3")
//    @ParameterizedTest
//    @MethodSource("provideForCheckFinalPlannedClosureInUFO")
//    public void checkFinalShouldReturnErrorWhenStateIdIs3(
//            String scenarioId,
//            String scenarioCode, @CheckRequest OmniRequestItem check,
//            @Mock WiremockRetrofit issuCheckMock,
//            @Mock WiremockRetrofit officeListMock
//
//    ) {
//        String gpbRequestId = UUID.randomUUID().toString();
//        step("Конфигурация мок issuCheckMock", () -> {
//            issuCheckMock.wiremockSend("wiremock/issue-check/card-issue-check-isMobilePinTrue.json",
//                    "/omni-information-card/api/v3/client/product/card/issue/check",
//                    "actualTimestamp",
//                    "1234",
//                    gpbRequestId);
//        });
//        step("Конфигурация мок officeListMock", () -> {
//            officeListMock.wiremockSend("wiremock/office-list/office-list.json",
//                    "/omni-glossary/api/v2/office/list",
//                    "data.offices.[?(@.vspCode==\"2099ДО2016042001\")].stateId",
//                    "3",
//                    gpbRequestId);
//        });
//
//        step("Отправка запроса на check", () -> {
//            List<ScreenValueBack> operation = new ArrayList<>();
//            List<ScreenValueBack> verifyDataValues = new ArrayList<>();
//            verifyDataValues.add(new ScreenValueBack(UiFieldsNames.UI_CARD_NUMBER_FIELD_ID, TestDataValues.CardNumber));
//            verifyDataValues.add(new ScreenValueBack(UiFieldsNames.UI_DATE_EXPIRATION, TestDataValues.dateExpiration));
//            verifyDataValues.add(new ScreenValueBack(Params.BRANCH_UNIT_CODE, TestDataValues.branchUnitCode));
//            verifyDataValues.add(new ScreenValueBack(UiFieldsNames.UI_IS_OTP, "true"));
//            operation.add(new ScreenValueBack(Params.LOGIN, TestDataValues.login));
//            operation.add(new ScreenValueBack(Params.BRANCH_CODE, TestDataValues.branchCode));
//            operation.add(new ScreenValueBack(Params.CURRENCY_CODE, "810"));
//            operation.add(new ScreenValueBack(Params.SUB_PROGRAM_CODE, TestDataValues.subProgramCode));
//            operation.add(new ScreenValueBack(Params.CARD_CATEGORY_CODE, "7"));
//            operation.add(new ScreenValueBack(Params.LATIN_CLIENT_NAME, TestDataValues.latinClientName));
//            operation.add(new ScreenValueBack(UiFieldsNames.UI_SOURCE_CHANNEL, ChannelEnum.UFO.getName()));
//
//            check.getData().getOperation().setOrder4client(UUID.randomUUID().toString());
//            check.getData().getScenario().setId(scenarioId);
//            check.getData().getScenario().setCode(scenarioCode);
//            check.getData().getVerifyData().setValues(verifyDataValues);
//            check.getData().getVerifyData().setCommand(new ScreenCommandFront("check", "checkLocation"));
//            check.getData().getVerifyData().setScreenStage("final");
//
//            check.getData().getOperation().setValues(operation);
//            Response response = given().header("gpb-requestId", gpbRequestId)
//                    .header("Authorization", CFG.token())
//                    .header("GPB-guid", guid).contentType(ContentType.JSON)
//                    .body(check)
//                    .post("api/v1/metadata/check")
//                    .then().extract().response();
//            step("Проверка получения экрана успеха");
//            assertAll(
//                    () -> assertEquals(response.path("screen.message.elements.find{it.id=='branchUnitCode'}.error.message"), "Запланировано закрытие выбранного ДО банка. Для завершения оформления выберите другой ДО")
//            );
//        });
//        step("Очистка мок", () -> {
//            issuCheckMock.wiremockRemove();
//            officeListMock.wiremockRemove();
//        });
//
//    }
//
//    @DisplayName("Получение экрана ошибки при запросе на check final когда office-list stateId=3")
//    @ParameterizedTest
//    @MethodSource("provideForCheckFinalPlannedClosureInUFO")
//    public void checkFinalShouldReturnSuccessWhenStateIdIs1(
//            String scenarioId,
//            String scenarioCode, @CheckRequest OmniRequestItem check,
//            @Mock WiremockRetrofit issuCheckMock,
//            @Mock WiremockRetrofit officeListMock
//
//    ) {
//        String gpbRequestId = UUID.randomUUID().toString();
//        step("Конфигурация мок issuCheckMock", () -> {
//            issuCheckMock.wiremockSend("wiremock/issue-check/card-issue-check-isMobilePinTrue.json",
//                    "/omni-information-card/api/v3/client/product/card/issue/check",
//                    "actualTimestamp",
//                    "1234",
//                    gpbRequestId);
//        });
//        step("Конфигурация мок officeListMock", () -> {
//            officeListMock.wiremockSend("wiremock/office-list/office-list.json",
//                    "/omni-glossary/api/v2/office/list",
//                    "data.offices.[?(@.vspCode==\"2099ДО2016042001\")].stateId",
//                    "1",
//                    gpbRequestId);
//        });
//
//        step("Отправка запроса на check", () -> {
//            List<ScreenValueBack> operation = new ArrayList<>();
//            List<ScreenValueBack> verifyDataValues = new ArrayList<>();
//            verifyDataValues.add(new ScreenValueBack(UiFieldsNames.UI_CARD_NUMBER_FIELD_ID, TestDataValues.CardNumber));
//            verifyDataValues.add(new ScreenValueBack(UiFieldsNames.UI_DATE_EXPIRATION, TestDataValues.dateExpiration));
//            verifyDataValues.add(new ScreenValueBack(Params.BRANCH_UNIT_CODE, TestDataValues.branchUnitCode));
//            verifyDataValues.add(new ScreenValueBack(UiFieldsNames.UI_IS_OTP, "true"));
//            operation.add(new ScreenValueBack(Params.LOGIN, TestDataValues.login));
//            operation.add(new ScreenValueBack(Params.BRANCH_CODE, "000"));
//            operation.add(new ScreenValueBack(Params.CURRENCY_CODE, "810"));
//            operation.add(new ScreenValueBack(Params.SUB_PROGRAM_CODE, TestDataValues.subProgramCode));
//            operation.add(new ScreenValueBack(Params.CARD_CATEGORY_CODE, "7"));
//            operation.add(new ScreenValueBack(Params.LATIN_CLIENT_NAME, TestDataValues.latinClientName));
//            operation.add(new ScreenValueBack(UiFieldsNames.UI_SOURCE_CHANNEL, ChannelEnum.UFO.getName()));
//
//            check.getData().getOperation().setOrder4client(UUID.randomUUID().toString());
//            check.getData().getScenario().setId(scenarioId);
//            check.getData().getScenario().setCode(scenarioCode);
//            check.getData().getVerifyData().setValues(verifyDataValues);
//            check.getData().getVerifyData().setCommand(new ScreenCommandFront("check", "checkLocation"));
//            check.getData().getVerifyData().setScreenStage("final");
//
//            check.getData().getOperation().setValues(operation);
//            Response response = given().header("gpb-requestId", gpbRequestId)
//                    .header("Authorization", CFG.token())
//                    .header("GPB-guid", guid).contentType(ContentType.JSON)
//                    .body(check)
//                    .post("api/v1/metadata/check")
//                    .then().extract().response();
//            step("Проверка получения экрана успеха");
//            assertAll(
//                    () -> assertEquals(response.path("screen.stage"), "draft"),
//                    () -> assertEquals(response.path("screen.success"), true)
//            );
//        });
//        step("Очистка мок", () -> {
//            issuCheckMock.wiremockRemove();
//            officeListMock.wiremockRemove();
//        });
//    }
//    @DisplayName("Получение экрана ошибки при запросе на check final когда office-list stateId=3")
//    @ParameterizedTest
//    @MethodSource("provideForCheckFinalPlannedClosureInUFO_DSA")
//    public void checkFinalShouldReturnSuccessWhenStateIdIs3ForUfoDSA(
//            String scenarioId,
//            String scenarioCode, @CheckRequest OmniRequestItem check,
//            @Mock WiremockRetrofit issuCheckMock,
//            @Mock WiremockRetrofit officeListMock
//
//    ) {
//        String gpbRequestId = UUID.randomUUID().toString();
//        step("Конфигурация мок issuCheckMock", () -> {
//            issuCheckMock.wiremockSend("wiremock/issue-check/card-issue-check-isMobilePinTrue.json",
//                    "/omni-information-card/api/v3/client/product/card/issue/check",
//                    "actualTimestamp",
//                    "1234",
//                    gpbRequestId);
//        });
//        step("Конфигурация мок officeListMock", () -> {
//            officeListMock.wiremockSend("wiremock/office-list/office-list.json",
//                    "/omni-glossary/api/v2/office/list",
//                    "data.offices.[?(@.vspCode==\"2099ДО2016042001\")].stateId",
//                    "3",
//                    gpbRequestId);
//        });
//
//        step("Отправка запроса на check", () -> {
//            List<ScreenValueBack> operation = new ArrayList<>();
//            List<ScreenValueBack> verifyDataValues = new ArrayList<>();
//            verifyDataValues.add(new ScreenValueBack(UiFieldsNames.UI_CARD_NUMBER_FIELD_ID, TestDataValues.CardNumber));
//            verifyDataValues.add(new ScreenValueBack(UiFieldsNames.UI_DATE_EXPIRATION, TestDataValues.dateExpiration));
//            verifyDataValues.add(new ScreenValueBack(Params.BRANCH_UNIT_CODE, TestDataValues.branchUnitCode));
//            verifyDataValues.add(new ScreenValueBack(UiFieldsNames.UI_IS_OTP, "true"));
//            operation.add(new ScreenValueBack(Params.LOGIN, TestDataValues.login));
//            operation.add(new ScreenValueBack(Params.BRANCH_CODE, "000"));
//            operation.add(new ScreenValueBack(Params.CURRENCY_CODE, "810"));
//            operation.add(new ScreenValueBack(Params.SUB_PROGRAM_CODE, TestDataValues.subProgramCode));
//            operation.add(new ScreenValueBack(Params.CARD_CATEGORY_CODE, "7"));
//            operation.add(new ScreenValueBack(Params.LATIN_CLIENT_NAME, TestDataValues.latinClientName));
//            operation.add(new ScreenValueBack(UiFieldsNames.UI_SOURCE_CHANNEL, ChannelEnum.UFO.getName()));
//
//            check.getData().getOperation().setOrder4client(UUID.randomUUID().toString());
//            check.getData().getScenario().setId(scenarioId);
//            check.getData().getScenario().setCode(scenarioCode);
//            check.getData().getVerifyData().setValues(verifyDataValues);
//            check.getData().getVerifyData().setCommand(new ScreenCommandFront("check", "checkLocation"));
//            check.getData().getVerifyData().setScreenStage("final");
//
//            check.getData().getOperation().setValues(operation);
//            check.getMeta().setChannel(ChannelEnum.UFO_DSA.getName());
//            Response response = given().header("gpb-requestId", gpbRequestId)
//                    .header("Authorization", CFG.token())
//                    .header("GPB-guid", guid).contentType(ContentType.JSON)
//                    .body(check)
//                    .post("api/v1/metadata/check")
//                    .then().extract().response();
//            step("Проверка получения экрана успеха");
//            assertAll(
//                    () -> assertEquals(response.path("screen.stage"), "draft"),
//                    () -> assertEquals(response.path("screen.success"), true)
//            );
//        });
//        step("Очистка мок", () -> {
//            issuCheckMock.wiremockRemove();
//            officeListMock.wiremockRemove();
//        });
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
//    private static Stream<Arguments> provideForCheckFinalPlannedClosureInUFO_DSA() {
//        return Stream.of(
//                Arguments.of(ScenarioCodeEnum.sc_57eb451bc6aa383.getId(), ScenarioCodeEnum.sc_57eb451bc6aa383.getCode()),
//                Arguments.of(ScenarioCodeEnum.sc_beece2b6ae57866.getId(), ScenarioCodeEnum.sc_beece2b6ae57866.getCode()),
//                Arguments.of(ScenarioCodeEnum.sc_268e095e417227a.getId(), ScenarioCodeEnum.sc_268e095e417227a.getCode()),
//                Arguments.of(ScenarioCodeEnum.sc_2bd290ce18e7c38.getId(), ScenarioCodeEnum.sc_2bd290ce18e7c38.getCode()),
//                Arguments.of(ScenarioCodeEnum.sc_28fe75e70f491af.getId(), ScenarioCodeEnum.sc_28fe75e70f491af.getCode()),
//                Arguments.of(ScenarioCodeEnum.sc_a962ae4856b4934.getId(), ScenarioCodeEnum.sc_a962ae4856b4934.getCode()),
//                Arguments.of(ScenarioCodeEnum.sc_aaa069108374373.getId(), ScenarioCodeEnum.sc_aaa069108374373.getCode()),
//                Arguments.of(ScenarioCodeEnum.sc_050bf0e46183924.getId(), ScenarioCodeEnum.sc_050bf0e46183924.getCode()),
//                Arguments.of(ScenarioCodeEnum.sc_04b1b0cbf1754c9.getId(), ScenarioCodeEnum.sc_04b1b0cbf1754c9.getCode()),
//                Arguments.of(ScenarioCodeEnum.sc_4262aa8ccd8ada7.getId(), ScenarioCodeEnum.sc_4262aa8ccd8ada7.getCode())
//
//        );
//    }
//
//
//}

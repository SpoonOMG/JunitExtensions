package framework.qa.test.common;

import framework.qa.api.OmniApiClient;
import framework.qa.consts.ChannelEnum;
import framework.qa.consts.Params;
import framework.qa.consts.ScenarioCodeEnum;
import framework.qa.consts.UiFieldsNames;
import framework.qa.jupiter.annotations.CheckRequest;
import framework.qa.jupiter.annotations.Wmock;
import framework.qa.jupiter.annotations.Wmocks;
import framework.qa.models.omniresponseitem.ElementsItem;
import framework.qa.models.omniresponseitem.Error;
import framework.qa.models.omniresponseitem.ResponseItem;
import framework.qa.models.omniresponseitem.ValuesItem;
import framework.qa.models.requestData.OmniRequestItem;
import framework.qa.models.requestData.ScreenCommandFront;
import framework.qa.models.requestData.ScreenValueBack;
import framework.qa.models.wiremock.response.RootWiremockResponse;
import framework.qa.test.BaseTest;
import framework.qa.values.TestDataValues;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


// Проверка TEAMDB-33389 Оповещение сотрудника о плановом закрытии офиса


@Tag("TEAMDB-33389")
public class CheckFinalPlannedClosureOfficesTest extends BaseTest {
    private final OmniApiClient checkApi = new OmniApiClient();

    @Test
    @DisplayName("Получение экрана ошибки при запросе на check final когда office-list не вернул запрашиваемый офис")
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
                    value = "1234"),
            @Wmock(
                    enpointMapping = "/omni-glossary/api/v2/office/list",
                    mockFile = "wiremock/office-list/office-list.json",
                    pathToField = "data.offices.[?(@.vspCode==\"2099ДО2016042001\")].stateId",
                    value = ""
            )}

    )
    public void checkFinalShouldReturnErrorWhenBranchUnitCodeNotInOfficeListAnswerUFO(
            RootWiremockResponse rwr,
            @CheckRequest OmniRequestItem check
    ) {
        String gpbrequestId = rwr.getRequest().getHeaders().getGpbrequestId().getEqualTo();

        step("Отправка запроса на check", () -> {
            List<ScreenValueBack> operation = new ArrayList<>();
            List<ScreenValueBack> verifyDataValues = new ArrayList<>();
            verifyDataValues.add(new ScreenValueBack(UiFieldsNames.UI_CARD_NUMBER_FIELD_ID, TestDataValues.CardNumber));
            verifyDataValues.add(new ScreenValueBack(UiFieldsNames.UI_DATE_EXPIRATION, TestDataValues.dateExpiration));
            verifyDataValues.add(new ScreenValueBack(Params.BRANCH_UNIT_CODE, TestDataValues.branchUnitCode));
            verifyDataValues.add(new ScreenValueBack(UiFieldsNames.UI_IS_OTP, "true"));
            operation.add(new ScreenValueBack(Params.LOGIN, TestDataValues.login));
            operation.add(new ScreenValueBack(Params.BRANCH_CODE, "000"));
            operation.add(new ScreenValueBack(Params.BRANCH_CODE_5NT, "000"));
            operation.add(new ScreenValueBack(Params.CURRENCY_CODE, "810"));
            operation.add(new ScreenValueBack(Params.SUB_PROGRAM_CODE, TestDataValues.subProgramCode));
            operation.add(new ScreenValueBack(Params.CARD_CATEGORY_CODE, "7"));
            operation.add(new ScreenValueBack(Params.LATIN_CLIENT_NAME, TestDataValues.latinClientName));
            operation.add(new ScreenValueBack(UiFieldsNames.UI_SOURCE_CHANNEL, ChannelEnum.UFO.getName()));

            check.getData().getOperation().setOrder4client(UUID.randomUUID().toString());
            check.getData().getScenario().setId(ScenarioCodeEnum.sc_57eb451bc6aa383.getId());
            check.getData().getScenario().setCode(ScenarioCodeEnum.sc_57eb451bc6aa383.getCode());
            check.getData().getVerifyData().setValues(verifyDataValues);
            check.getData().getVerifyData().setCommand(new ScreenCommandFront("check", "checkLocation"));
            check.getData().getVerifyData().setScreenStage("final");


            check.getData().getOperation().setValues(operation);

            ResponseItem response = checkApi.checkRequest(gpbrequestId, check);
            Map<String, Error> collect = response.getScreen().getMessage().getElements().stream().collect(Collectors.toMap(ElementsItem::getId, ElementsItem::getError));

            step("Проверка получения экрана успеха");
            assertAll(
                    () -> assertEquals("ДО в состоянии, отличном от \"Открыт\" или информация о состоянии ДО отсутствует.  Для завершения оформления выберите другой ДО", collect.get(Params.BRANCH_UNIT_CODE).getMessage()));
        });


    }


    @DisplayName("Получение экрана ошибки при запросе на check final когда office-list stateId=3")
    @ParameterizedTest
    @MethodSource("provideForCheckFinalPlannedClosureInUFO")
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
                    value = "1234"),
            @Wmock(
                    enpointMapping = "/omni-glossary/api/v2/office/list",
                    mockFile = "wiremock/office-list/office-list.json",
                    pathToField = "data.offices.[?(@.vspCode==\"2099ДО2016042001\")].stateId",
                    value = "3"
            )}

    )
    public void checkFinalShouldReturnErrorWhenStateIdIs3(
            String scenarioId,
            String scenarioCode,
            RootWiremockResponse rwr,
            @CheckRequest OmniRequestItem check
    ) {
        String gpbrequestId = rwr.getRequest().getHeaders().getGpbrequestId().getEqualTo();

        step("Отправка запроса на check", () -> {
            List<ScreenValueBack> operation = new ArrayList<>();
            List<ScreenValueBack> verifyDataValues = new ArrayList<>();
            verifyDataValues.add(new ScreenValueBack(UiFieldsNames.UI_CARD_NUMBER_FIELD_ID, TestDataValues.CardNumber));
            verifyDataValues.add(new ScreenValueBack(UiFieldsNames.UI_DATE_EXPIRATION, TestDataValues.dateExpiration));
            verifyDataValues.add(new ScreenValueBack(Params.BRANCH_UNIT_CODE, TestDataValues.branchUnitCode));
            verifyDataValues.add(new ScreenValueBack(UiFieldsNames.UI_IS_OTP, "true"));
            operation.add(new ScreenValueBack(Params.LOGIN, TestDataValues.login));
            operation.add(new ScreenValueBack(Params.BRANCH_CODE, "000"));
            operation.add(new ScreenValueBack(Params.BRANCH_CODE_5NT, "000"));
            operation.add(new ScreenValueBack(Params.CURRENCY_CODE, "810"));
            operation.add(new ScreenValueBack(Params.SUB_PROGRAM_CODE, TestDataValues.subProgramCode));
            operation.add(new ScreenValueBack(Params.CARD_CATEGORY_CODE, "7"));
            operation.add(new ScreenValueBack(Params.LATIN_CLIENT_NAME, TestDataValues.latinClientName));
            operation.add(new ScreenValueBack(UiFieldsNames.UI_SOURCE_CHANNEL, ChannelEnum.UFO.getName()));

            check.getData().getOperation().setOrder4client(UUID.randomUUID().toString());
            check.getData().getScenario().setId(scenarioId);
            check.getData().getScenario().setCode(scenarioCode);
            check.getData().getVerifyData().setValues(verifyDataValues);
            check.getData().getVerifyData().setCommand(new ScreenCommandFront("check", "checkLocation"));
            check.getData().getVerifyData().setScreenStage("final");


            check.getData().getOperation().setValues(operation);

            ResponseItem response = checkApi.checkRequest(gpbrequestId, check);
            Map<String, Error> collect = response.getScreen().getMessage().getElements().stream().collect(Collectors.toMap(ElementsItem::getId, ElementsItem::getError));

            step("Проверка получения экрана успеха");
            assertAll(
                    () -> assertEquals("Запланировано закрытие выбранного ДО банка. Для завершения оформления выберите другой ДО", collect.get(Params.BRANCH_UNIT_CODE).getMessage()));
        });
    }


    @DisplayName("Получение успешного экрана при запросе на check final когда office-list stateId=1")
    @ParameterizedTest
    @MethodSource("provideForCheckFinalPlannedClosureInUFO")
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
                    value = "1234"),
            @Wmock(
                    enpointMapping = "/omni-glossary/api/v2/office/list",
                    mockFile = "wiremock/office-list/office-list.json",
                    pathToField = "data.offices.[?(@.vspCode==\"2099ДО2016042001\")].stateId",
                    value = "1"
            )}

    )
    public void checkFinalShouldReturnSuccessWhenStateIdIs1(
            String scenarioId,
            String scenarioCode,
            RootWiremockResponse rwr,
            @CheckRequest OmniRequestItem check
    ) {
        String gpbrequestId = rwr.getRequest().getHeaders().getGpbrequestId().getEqualTo();

        step("Отправка запроса на check", () -> {
            List<ScreenValueBack> operation = new ArrayList<>();
            List<ScreenValueBack> verifyDataValues = new ArrayList<>();
            verifyDataValues.add(new ScreenValueBack(UiFieldsNames.UI_CARD_NUMBER_FIELD_ID, TestDataValues.CardNumber));
            verifyDataValues.add(new ScreenValueBack(UiFieldsNames.UI_DATE_EXPIRATION, TestDataValues.dateExpiration));
            verifyDataValues.add(new ScreenValueBack(Params.BRANCH_UNIT_CODE, TestDataValues.branchUnitCode));
            verifyDataValues.add(new ScreenValueBack(UiFieldsNames.UI_IS_OTP, "true"));
            operation.add(new ScreenValueBack(Params.LOGIN, TestDataValues.login));
            operation.add(new ScreenValueBack(Params.BRANCH_CODE, "000"));
            operation.add(new ScreenValueBack(Params.BRANCH_CODE_5NT, "000"));
            operation.add(new ScreenValueBack(Params.CURRENCY_CODE, "810"));
            operation.add(new ScreenValueBack(Params.SUB_PROGRAM_CODE, TestDataValues.subProgramCode));
            operation.add(new ScreenValueBack(Params.CARD_CATEGORY_CODE, "7"));
            operation.add(new ScreenValueBack(Params.LATIN_CLIENT_NAME, TestDataValues.latinClientName));
            operation.add(new ScreenValueBack(UiFieldsNames.UI_SOURCE_CHANNEL, ChannelEnum.UFO.getName()));

            check.getData().getOperation().setOrder4client(UUID.randomUUID().toString());
            check.getData().getScenario().setId(scenarioId);
            check.getData().getScenario().setCode(scenarioCode);
            check.getData().getVerifyData().setValues(verifyDataValues);
            check.getData().getVerifyData().setCommand(new ScreenCommandFront("check", "checkLocation"));
            check.getData().getVerifyData().setScreenStage("final");
            check.getData().getOperation().setValues(operation);
            ResponseItem response = checkApi.checkRequest(gpbrequestId, check);

            step("Проверка получения экрана успеха");
            assertAll(
                    () -> assertEquals(response.getScreen().getStage(), "draft"),
                    () -> assertEquals(response.getScreen().isSuccess(), true));
        });
    }


    @DisplayName("Получение экрана ошибки при запросе на check final когда office-list stateId=3")
    @ParameterizedTest
    @MethodSource("provideForCheckFinalPlannedClosureInUFO_DSA")
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
                    value = "1234"),
            @Wmock(
                    enpointMapping = "/omni-glossary/api/v2/office/list",
                    mockFile = "wiremock/office-list/office-list.json",
                    pathToField = "data.offices.[?(@.vspCode==\"2099ДО2016042001\")].stateId",
                    value = "3"
            )}

    )
    public void checkFinalShouldReturnSuccessWhenStateIdIs3ForUfoDSA(
            String scenarioId,
            String scenarioCode,
            RootWiremockResponse rwr,
            @CheckRequest OmniRequestItem check
    ) {
        String gpbrequestId = rwr.getRequest().getHeaders().getGpbrequestId().getEqualTo();

        step("Отправка запроса на check", () -> {
            List<ScreenValueBack> operation = new ArrayList<>();
            List<ScreenValueBack> verifyDataValues = new ArrayList<>();
            verifyDataValues.add(new ScreenValueBack(UiFieldsNames.UI_CARD_NUMBER_FIELD_ID, TestDataValues.CardNumber));
            verifyDataValues.add(new ScreenValueBack(UiFieldsNames.UI_DATE_EXPIRATION, TestDataValues.dateExpiration));
            verifyDataValues.add(new ScreenValueBack(Params.BRANCH_UNIT_CODE, TestDataValues.branchUnitCode));
            verifyDataValues.add(new ScreenValueBack(UiFieldsNames.UI_IS_OTP, "true"));
            operation.add(new ScreenValueBack(Params.LOGIN, TestDataValues.login));
            operation.add(new ScreenValueBack(Params.BRANCH_CODE, "000"));
            operation.add(new ScreenValueBack(Params.BRANCH_CODE_5NT, "000"));
            operation.add(new ScreenValueBack(Params.CURRENCY_CODE, "810"));
            operation.add(new ScreenValueBack(Params.SUB_PROGRAM_CODE, TestDataValues.subProgramCode));
            operation.add(new ScreenValueBack(Params.CARD_CATEGORY_CODE, "7"));
            operation.add(new ScreenValueBack(Params.LATIN_CLIENT_NAME, TestDataValues.latinClientName));
            operation.add(new ScreenValueBack(UiFieldsNames.UI_SOURCE_CHANNEL, ChannelEnum.UFO.getName()));

            check.getMeta().setChannel(ChannelEnum.UFO_DSA.getName());
            check.getData().getOperation().setOrder4client(UUID.randomUUID().toString());
            check.getData().getScenario().setId(scenarioId);
            check.getData().getScenario().setCode(scenarioCode);
            check.getData().getVerifyData().setValues(verifyDataValues);
            check.getData().getVerifyData().setCommand(new ScreenCommandFront("check", "checkLocation"));
            check.getData().getVerifyData().setScreenStage("final");


            check.getData().getOperation().setValues(operation);

            ResponseItem response = checkApi.checkRequest(gpbrequestId, check);

            step("Проверка получения экрана успеха");
            assertAll(
                    () -> assertEquals(response.getScreen().getStage(), "draft"),
                    () -> assertEquals(response.getScreen().isSuccess(), true));
        });
    }


    private static Stream<Arguments> provideForCheckFinalPlannedClosureInUFO() {
        return Stream.of(
                Arguments.of(ScenarioCodeEnum.sc_57eb451bc6aa383.getId(), ScenarioCodeEnum.sc_57eb451bc6aa383.getCode()),
                Arguments.of(ScenarioCodeEnum.sc_beece2b6ae57866.getId(), ScenarioCodeEnum.sc_beece2b6ae57866.getCode()),
                Arguments.of(ScenarioCodeEnum.sc_268e095e417227a.getId(), ScenarioCodeEnum.sc_268e095e417227a.getCode()),
                Arguments.of(ScenarioCodeEnum.sc_2bd290ce18e7c38.getId(), ScenarioCodeEnum.sc_2bd290ce18e7c38.getCode()),
                Arguments.of(ScenarioCodeEnum.sc_28fe75e70f491af.getId(), ScenarioCodeEnum.sc_28fe75e70f491af.getCode()),
                Arguments.of(ScenarioCodeEnum.sc_a962ae4856b4934.getId(), ScenarioCodeEnum.sc_a962ae4856b4934.getCode()),
                Arguments.of(ScenarioCodeEnum.sc_aaa069108374373.getId(), ScenarioCodeEnum.sc_aaa069108374373.getCode()),
                Arguments.of(ScenarioCodeEnum.sc_050bf0e46183924.getId(), ScenarioCodeEnum.sc_050bf0e46183924.getCode()),
                Arguments.of(ScenarioCodeEnum.sc_71b501548473525.getId(), ScenarioCodeEnum.sc_71b501548473525.getCode()),
                Arguments.of(ScenarioCodeEnum.sc_04b1b0cbf1754c9.getId(), ScenarioCodeEnum.sc_04b1b0cbf1754c9.getCode()),
                Arguments.of(ScenarioCodeEnum.sc_d4f3b8b82abe703.getId(), ScenarioCodeEnum.sc_d4f3b8b82abe703.getCode()),
                Arguments.of(ScenarioCodeEnum.sc_952dc9ede3b89c0.getId(), ScenarioCodeEnum.sc_952dc9ede3b89c0.getCode()),
                Arguments.of(ScenarioCodeEnum.sc_4262aa8ccd8ada7.getId(), ScenarioCodeEnum.sc_4262aa8ccd8ada7.getCode())

        );
    }

    private static Stream<Arguments> provideForCheckFinalPlannedClosureInUFO_DSA() {
        return Stream.of(
                Arguments.of(ScenarioCodeEnum.sc_57eb451bc6aa383.getId(), ScenarioCodeEnum.sc_57eb451bc6aa383.getCode()),
                Arguments.of(ScenarioCodeEnum.sc_beece2b6ae57866.getId(), ScenarioCodeEnum.sc_beece2b6ae57866.getCode()),
                Arguments.of(ScenarioCodeEnum.sc_268e095e417227a.getId(), ScenarioCodeEnum.sc_268e095e417227a.getCode()),
                Arguments.of(ScenarioCodeEnum.sc_2bd290ce18e7c38.getId(), ScenarioCodeEnum.sc_2bd290ce18e7c38.getCode()),
                Arguments.of(ScenarioCodeEnum.sc_28fe75e70f491af.getId(), ScenarioCodeEnum.sc_28fe75e70f491af.getCode()),
                Arguments.of(ScenarioCodeEnum.sc_a962ae4856b4934.getId(), ScenarioCodeEnum.sc_a962ae4856b4934.getCode()),
                Arguments.of(ScenarioCodeEnum.sc_aaa069108374373.getId(), ScenarioCodeEnum.sc_aaa069108374373.getCode()),
                Arguments.of(ScenarioCodeEnum.sc_050bf0e46183924.getId(), ScenarioCodeEnum.sc_050bf0e46183924.getCode()),
                Arguments.of(ScenarioCodeEnum.sc_04b1b0cbf1754c9.getId(), ScenarioCodeEnum.sc_04b1b0cbf1754c9.getCode()),
                Arguments.of(ScenarioCodeEnum.sc_4262aa8ccd8ada7.getId(), ScenarioCodeEnum.sc_4262aa8ccd8ada7.getCode())

        );
    }


}

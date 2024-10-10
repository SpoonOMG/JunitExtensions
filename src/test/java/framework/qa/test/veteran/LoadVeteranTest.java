package framework.qa.test.veteran;

import framework.qa.api.OmniApiClient;
import framework.qa.consts.ChannelEnum;
import framework.qa.consts.Params;
import framework.qa.consts.UiFieldsNames;
import framework.qa.jupiter.annotations.CheckRequest;
import framework.qa.jupiter.annotations.LoadRequest;
import framework.qa.models.omniresponseitem.ResponseItem;
import framework.qa.models.omniresponseitem.ValuesItem;
import framework.qa.models.requestData.OmniRequestItem;
import framework.qa.models.requestData.ScreenCommandFront;
import framework.qa.models.requestData.ScreenValueBack;
import framework.qa.values.TestDataValues;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import static framework.qa.values.TestDataValues.title;
import static framework.qa.values.TestDataValues.userFullName;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("Ветераны")
public class LoadVeteranTest extends BaseVeteranTest {
    private final OmniApiClient loadApi = new OmniApiClient();

    @DisplayName("Получение успешного экрана при запросе на load c минимальным набором параметров")
    @Test
    public void veteranLoadShouldReturnSuccessScreenWithMinParams(@LoadRequest OmniRequestItem load) {
        String gpbRequestId = UUID.randomUUID().toString();
        step("Отправка запроса на load", () -> {
            ResponseItem response = loadApi.loadRequest(gpbRequestId, load);
            assertAll(
                    () -> assertEquals("5NT_AFTER_DRAFT_ALL", response.getScreen().getLoad().getId()),
                    () -> assertEquals("after_draft", response.getScreen().getStage()),
                    () -> assertEquals(true, response.getScreen().isSuccess())
            );
        });
    }


    @DisplayName("Проверка получения параметров в ответе, переданных в verifyData при запросе на load c максимальным набором параметров")
    @Test
    public void veteranLoadShouldReturnSuccessScreenWithProvidedParams(@LoadRequest OmniRequestItem load) {
        String gpbRequestId = UUID.randomUUID().toString();
        step("Отправка запроса на load", () -> {
            load.getData().getScenario().setId(veteranScenarioId);
            load.getData().getScenario().setCode(veteranScenarioCode);
            load.getData().getVerifyData().setValues(operationFinalMaxParam());
            ResponseItem response = loadApi.loadRequest(gpbRequestId, load);
            Map<String, String> collect = response.getData().getOperation().getValues().stream().collect(Collectors.toMap(ValuesItem::getId, ValuesItem::getValue));

            assertAll(
                    () -> assertEquals(TestDataValues.login, collect.get(Params.LOGIN)),
                    () -> assertEquals(TestDataValues.sourceChannel, collect.get(Params.SOURCE_CHANNEL)),
                    () -> assertEquals(TestDataValues.isDkbo, collect.get(Params.IS_DKBO)),
                    () -> assertEquals(TestDataValues.PDL, collect.get(Params.PDL)),
                    () -> assertEquals(branchCode, collect.get(Params.BRANCH_CODE)),
                    () -> assertEquals(currencyCode, collect.get(Params.CURRENCY_CODE)),
                    () -> assertEquals(subProgramCode, collect.get(Params.SUB_PROGRAM_CODE)),
                    () -> assertEquals(productOfferShortName, collect.get(Params.PRODUCT_OFFER_SHORT_NAME)),
                    () -> assertEquals("7", collect.get(Params.CARD_CATEGORY_CODE)),
                    () -> assertEquals(paymentSystemCode, collect.get(Params.PAY_SYSTEM_CODE)),
                    () -> assertEquals(TypeCreation, collect.get(Params.TYPE_CREATION)),
                    () -> assertEquals(userFullName, collect.get(Params.USER_FULL_NAME)),
                    () -> assertEquals(TestDataValues.full_name, collect.get(Params.EMPLOYEE_FULL_NAME)),
                    () -> assertEquals(TestDataValues.latinClientName, collect.get(Params.LATIN_CLIENT_NAME)),
                    () -> assertEquals(title, collect.get(Params.TITLE)),
                    () -> assertEquals(title, collect.get(Params.EMPLOYEE_POSITION)),
                    () -> assertEquals(ChannelEnum.UFO.getName(), collect.get(UiFieldsNames.UI_SOURCE_CHANNEL)),
                    () -> assertEquals(TestDataValues.surname, collect.get(Params.SURNAME)),
                    () -> assertEquals(TestDataValues.name, collect.get(Params.NAME)),
                    () -> assertEquals(TestDataValues.sexCode, collect.get(Params.SEX_CODE)),
                    () -> assertEquals(TestDataValues.isResident, collect.get(Params.IS_RESIDENT)),
                    () -> assertEquals(TestDataValues.birth_date, collect.get(Params.BIRTH_DATE)),
                    () -> assertEquals(TestDataValues.birthPlace, collect.get(Params.BIRTH_PLACE)),
                    () -> assertEquals(TestDataValues.birthCountryCode, collect.get(Params.BIRTH_COUNTRY_CODE)),
                    () -> assertEquals(TestDataValues.docTypeCode, collect.get(Params.DOC_TYPE_CODE)),
                    () -> assertEquals(TestDataValues.docSeries, collect.get(Params.DOC_SERIES)),
                    () -> assertEquals(TestDataValues.docNum, collect.get(Params.DOC_NUM)),
                    () -> assertEquals(TestDataValues.issueDate, collect.get(Params.ISSUE_DATE)),
                    () -> assertEquals(TestDataValues.issuedBy, collect.get(Params.ISSUED_BY)),
                    () -> assertEquals(TestDataValues.departCode, collect.get(Params.DEPART_CODE)),
                    () -> assertEquals(TestDataValues.rgCountryCode, collect.get(Params.RG_COUNTRY_CODE)),
                    () -> assertEquals(TestDataValues.rgPostalCode, collect.get(Params.RG_POSTAL_CODE)),
                    () -> assertEquals(TestDataValues.rgRegionCode, collect.get(Params.RG_REGION_CODE)),
                    () -> assertEquals(TestDataValues.ftCountryCode, collect.get(Params.FT_COUNTRY_CODE)),
                    () -> assertEquals(TestDataValues.ftPostalCode, collect.get(Params.FT_POSTAL_CODE)),
                    () -> assertEquals(TestDataValues.ftRegionCode, collect.get(Params.FT_REGION_CODE)),
                    () -> assertEquals(TestDataValues.cellPhone, collect.get(Params.CELL_PHONE)),
                    () -> assertEquals(TestDataValues.EMAIL, collect.get(Params.EMAIL)),
                    () -> assertEquals(currencyCode, collect.get(Params.CURRENCY_CODE))
            );
        });
    }
}

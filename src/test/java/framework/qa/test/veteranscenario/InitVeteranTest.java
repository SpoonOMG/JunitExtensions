package framework.qa.test.veteranscenario;

import framework.qa.api.OmniApiClient;
import framework.qa.consts.Params;
import framework.qa.consts.UiFieldsNames;
import framework.qa.jupiter.annotations.InitRequest;
import framework.qa.jupiter.annotations.Wmock;
import framework.qa.jupiter.annotations.Wmocks;
import framework.qa.models.omniresponseitem.ResponseItem;
import framework.qa.models.omniresponseitem.ValuesItem;
import framework.qa.models.requestData.*;
import framework.qa.models.wiremock.response.RootWiremockResponse;
import framework.qa.values.TestDataValues;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("Ветераны")
@Tag("init")
public class InitVeteranTest extends BaseVeteranTest {
    private final OmniApiClient initApi = new OmniApiClient();

    @Test
    @DisplayName("Получение успешного экрана при запросе на init с обязательными параметрами")
    @Wmocks({
            @Wmock(
                    enpointMapping = "/omni-information/api/v2/client/search",
                    mockFile = "wiremock/client-search/default.json",
                    pathToField = "data.clients.[?(@.base.guid==\"6F57A2C3507C4D6AA1A70E9C8C8CF919\")].base.hid",
                    value = ""
            ),
            @Wmock(
                    enpointMapping = "/omni-information-card/api/v3/client/product/cards",
                    mockFile = "wiremock/product-cards/default.json",
                    pathToField = "actualTimestamp",
                    value = "1234"
            )})
    public void veteranInitShouldReturnSuccessWithRequiredParams(
            RootWiremockResponse rwr,
            @InitRequest OmniRequestItem init
    ) throws IOException {
        String gpbrequestId = rwr.getRequest().getHeaders().getGpbrequestId().getEqualTo();
        init.getData().getScenario().setId(veteranScenarioId);
        init.getData().getScenario().setCode(veteranScenarioCode);
        ResponseItem response = initApi.initRequest(gpbrequestId, init);
        assertAll(
                () -> assertEquals("5NT_ARMY_PARAMS_DO", response.getScreen().getLoad().getId()),
                () -> assertEquals("initial", response.getScreen().getStage()),
                () -> assertEquals(true, response.getScreen().isSuccess())
        );
    }

    @Test
    @DisplayName("Получение успешного экрана при запросе на init с проверкой заполнения параметров из client-search")
    @Wmocks({
            @Wmock(
                    enpointMapping = "/omni-information/api/v2/client/search",
                    mockFile = "wiremock/client-search/default.json",
                    pathToField = "data.clients.[?(@.base.guid==\"6F57A2C3507C4D6AA1A70E9C8C8CF919\")].base.hid",
                    value = ""
            ),
            @Wmock(
                    enpointMapping = "/omni-information-card/api/v3/client/product/cards",
                    mockFile = "wiremock/product-cards/default.json",
                    pathToField = "actualTimestamp",
                    value = "1234"
            )})
    public void veteranInitCheckClientSearchReturnedParams(RootWiremockResponse rwr,
                                                           @InitRequest OmniRequestItem init) throws IOException {
        String gpbrequestId = rwr.getRequest().getHeaders().getGpbrequestId().getEqualTo();
        init.getData().getScenario().setId(veteranScenarioId);
        init.getData().getScenario().setCode(veteranScenarioCode);
        ResponseItem response = initApi.initRequest(gpbrequestId, init);

        step("Проверка параметров client-search в operation");

        Map<String, String> collect = response.getData().getOperation().getValues().stream().collect(Collectors.toMap(ValuesItem::getId, ValuesItem::getValue));

        assertAll(
                () -> assertEquals(TestDataValues.cellPhone, collect.get(Params.CELL_PHONE)),
                () -> assertEquals(TestDataValues.docSeries, collect.get(Params.DOC_SERIES)),
                () -> assertEquals(TestDataValues.clientPhone, collect.get(UiFieldsNames.UI_CLIENT_PHONE)),
                () -> assertEquals(TestDataValues.latinClientName, collect.get(Params.LATIN_CLIENT_NAME)),
                () -> assertEquals(TestDataValues.areEmbossedCardsAvailable, collect.get(UiFieldsNames.ARE_EMBOSSED_CARDS_AVAILABLE)),
                () -> assertEquals(TestDataValues.countryISOCODE, collect.get(Params.COUNTRY_ISO_CODE)),
                () -> assertEquals(TestDataValues.areInstantCardsAvailable, collect.get(UiFieldsNames.ARE_INSTANT_CARDS_AVAILABLE)),
                () -> assertEquals(TestDataValues.full_name, collect.get(UiFieldsNames.UI_FULL_NAME)),
                () -> assertEquals(TestDataValues.EMAIL, collect.get(Params.EMAIL)),
                () -> assertEquals(TestDataValues.rgCity, collect.get(Params.RG_CITY)),
                () -> assertEquals(TestDataValues.rgFlat, collect.get(Params.RG_FLAT)),
                () -> assertEquals(TestDataValues.isResident, collect.get(Params.IS_RESIDENT)),
                () -> assertEquals(TestDataValues.ftRegionName, collect.get(Params.FT_REGION_NAME)),
                () -> assertEquals(TestDataValues.rgCountryCode, collect.get(Params.RG_COUNTRY_CODE)),
                () -> assertEquals(TestDataValues.rgHouse, collect.get(Params.RG_HOUSE)),
                () -> assertEquals(TestDataValues.location, collect.get(UiFieldsNames.UI_LOCATION)),
                () -> assertEquals(TestDataValues.aflt_surname, collect.get(Params.PARTNERDEV_PARAM_SURNAME)),
                () -> assertEquals(TestDataValues.registration_address, collect.get(UiFieldsNames.UI_REGISTRATION_ADDRESS)),
                () -> assertEquals(TestDataValues.ftHouse, collect.get(Params.FT_HOUSE)),
                () -> assertEquals(TestDataValues.cellPhoneWithSep, collect.get(UiFieldsNames.UI_CELLPHONE)),
                () -> assertEquals(TestDataValues.secondName, collect.get(UiFieldsNames.UI_SECOND_NAME)),
                () -> assertEquals(TestDataValues.patronymic, collect.get(Params.PATRONYMIC)),
                () -> assertEquals(TestDataValues.expiredPassport, collect.get(UiFieldsNames.UI_EXPIRED_PASSPORT)),
                () -> assertEquals(TestDataValues.name, collect.get(Params.NAME)),
                () -> assertEquals(TestDataValues.docTypeCode, collect.get(Params.DOC_TYPE_CODE)),
                () -> assertEquals(TestDataValues.document, collect.get(UiFieldsNames.UI_DOCUMENT)),
                () -> assertEquals(TestDataValues.birth_date, collect.get(UiFieldsNames.UI_BIRTH_DATE)),
                () -> assertEquals(TestDataValues.guidOperation, collect.get(Params.GUID)),
                () -> assertEquals(TestDataValues.rgPostalCode, collect.get(Params.RG_POSTAL_CODE)),
                () -> assertEquals(TestDataValues.fact_address, collect.get(UiFieldsNames.UI_FACT_ADDRESS)),
                () -> assertEquals(TestDataValues.embossing_client_name, collect.get(UiFieldsNames.UI_EMBOSSING_CLIENT_NAME)),
                () -> assertEquals(TestDataValues.docNum, collect.get(Params.DOC_NUM)),
                () -> assertEquals(TestDataValues.firstName, collect.get(UiFieldsNames.UI_FIRST_NAME)),
                () -> assertEquals(TestDataValues.lastName, collect.get(UiFieldsNames.UI_LAST_NAME)),
                () -> assertEquals(TestDataValues.CRSCountryCode, collect.get(Params.CRS_COUNTRY_CODE)),
                () -> assertEquals(TestDataValues.issuedBy, collect.get(Params.ISSUED_BY)),
                () -> assertEquals(TestDataValues.ftCity, collect.get(Params.FT_CITY)),
                () -> assertEquals(TestDataValues.EMAIL, collect.get(UiFieldsNames.UI_EMAIL)),
                () -> assertEquals(TestDataValues.rgRegionCode, collect.get(Params.RG_REGION_CODE)),
                () -> assertEquals(TestDataValues.surname, collect.get(Params.SURNAME)),
                () -> assertEquals(TestDataValues.PDL, collect.get(Params.PDL)),
                () -> assertEquals(TestDataValues.issueDate, collect.get(Params.ISSUE_DATE)),
                () -> assertEquals(TestDataValues.ftPostalCode, collect.get(Params.FT_POSTAL_CODE)),
                () -> assertEquals(TestDataValues.ftRegionCode, collect.get(Params.FT_REGION_CODE)),
                () -> assertEquals(TestDataValues.birthCountryCode, collect.get(Params.BIRTH_COUNTRY_CODE)),
                () -> assertEquals(TestDataValues.ftCountryCode, collect.get(Params.FT_COUNTRY_CODE)),
                () -> assertEquals(TestDataValues.birthDate, collect.get(Params.BIRTH_DATE)),
                () -> assertEquals(TestDataValues.sexCode, collect.get(Params.SEX_CODE)),
                () -> assertEquals(TestDataValues.ftFlat, collect.get(Params.FT_FLAT)),
                () -> assertEquals(TestDataValues.departCode, collect.get(Params.DEPART_CODE)),
                () -> assertEquals(TestDataValues.aflt_name, collect.get(Params.PARTNERDEV_PARAM_NAME)),
                () -> assertEquals(TestDataValues.ftBuilding, collect.get(Params.FT_BUILDING)),
                () -> assertEquals(TestDataValues.rgRegionName, collect.get(Params.RG_REGION_NAME)),
                () -> assertEquals(TestDataValues.isDkbo, collect.get(Params.IS_DKBO)),
                () -> assertEquals("initial", response.getScreen().getStage())
        );
    }


    @Test
    @DisplayName("Получение экрана ошибки 'Некорректное или отсутствующее имя клиента' когда clientSearch не вернул фамилию")
    @Wmocks({
            @Wmock(
                    enpointMapping = "/omni-information/api/v2/client/search",
                    mockFile = "wiremock/client-search/default.json",
                    pathToField = "data.clients.[?(@.base.guid==\"6F57A2C3507C4D6AA1A70E9C8C8CF919\")].base.surname",
                    value = ""
            ),
            @Wmock(
                    enpointMapping = "/omni-information-card/api/v3/client/product/cards",
                    mockFile = "wiremock/product-cards/default.json",
                    pathToField = "actualTimestamp",
                    value = "1234"
            )})
    public void veteranInitCheckClientSearchValidationParamsIncorrectClientSurName(RootWiremockResponse rwr,
                                                                                   @InitRequest OmniRequestItem init) throws IOException {
        String gpbrequestId = rwr.getRequest().getHeaders().getGpbrequestId().getEqualTo();
        init.getData().getScenario().setId(veteranScenarioId);
        init.getData().getScenario().setCode(veteranScenarioCode);
        ResponseItem response = initApi.initRequest(gpbrequestId, init);
        List<ValuesItem> operationValues = response.getData().getOperation().getValues();

        step("Проверка параметров client-search в operation");

        Map<String, String> collect = response.getData().getOperation().getValues().stream().collect(Collectors.toMap(ValuesItem::getId, ValuesItem::getValue));
        collect.get(Params.CELL_PHONE);

        assertAll(
                () -> assertEquals("Клиентские данные некорректны", collect.get("incorrectDataError")),
                () -> assertEquals("Некорректное или отсутствующее имя клиента.", collect.get("incorrectDataMessage"))
        );
    }

    @Test
    @DisplayName("Получение экрана ошибки 'Некорректное или отсутствующее имя клиента' когда clientSearch не вернул имя клиента")
    @Wmocks({
            @Wmock(
                    enpointMapping = "/omni-information/api/v2/client/search",
                    mockFile = "wiremock/client-search/default.json",
                    pathToField = "data.clients.[?(@.base.guid==\"6F57A2C3507C4D6AA1A70E9C8C8CF919\")].base.name",
                    value = ""
            ),
            @Wmock(
                    enpointMapping = "/omni-information-card/api/v3/client/product/cards",
                    mockFile = "wiremock/product-cards/default.json",
                    pathToField = "actualTimestamp",
                    value = "1234"
            )})
    public void veteranInitCheckClientSearchValidationParamsIncorrectClientName(RootWiremockResponse rwr,
                                                                                @InitRequest OmniRequestItem init) throws IOException {
        String gpbrequestId = rwr.getRequest().getHeaders().getGpbrequestId().getEqualTo();
        init.getData().getScenario().setId(veteranScenarioId);
        init.getData().getScenario().setCode(veteranScenarioCode);
        ResponseItem response = initApi.initRequest(gpbrequestId, init);
        List<ValuesItem> operationValues = response.getData().getOperation().getValues();

        step("Проверка параметров client-search в operation");

        Map<String, String> collect = response.getData().getOperation().getValues().stream().collect(Collectors.toMap(ValuesItem::getId, ValuesItem::getValue));
        collect.get(Params.CELL_PHONE);

        assertAll(
                () -> assertEquals("Клиентские данные некорректны", collect.get("incorrectDataError")),
                () -> assertEquals("Некорректное или отсутствующее имя клиента.", collect.get("incorrectDataMessage"))
        );
    }

    @Test
    @DisplayName("Получение экрана ошибки 'Некорректное или отсутствующее имя клиента' когда clientSearch не вернул дату рождения")
    @Wmocks({
            @Wmock(
                    enpointMapping = "/omni-information/api/v2/client/search",
                    mockFile = "wiremock/client-search/default.json",
                    pathToField = "data.clients.[?(@.base.guid==\"6F57A2C3507C4D6AA1A70E9C8C8CF919\")].base.birthdate",
                    value = ""
            ),
            @Wmock(
                    enpointMapping = "/omni-information-card/api/v3/client/product/cards",
                    mockFile = "wiremock/product-cards/default.json",
                    pathToField = "actualTimestamp",
                    value = "1234"
            )})
    public void veteranInitCheckClientSearchValidationParamsIncorrectBirthDate(RootWiremockResponse rwr,
                                                                               @InitRequest OmniRequestItem init) throws IOException {
        String gpbrequestId = rwr.getRequest().getHeaders().getGpbrequestId().getEqualTo();
        init.getData().getScenario().setId(veteranScenarioId);
        init.getData().getScenario().setCode(veteranScenarioCode);
        ResponseItem response = initApi.initRequest(gpbrequestId, init);
        List<ValuesItem> operationValues = response.getData().getOperation().getValues();

        step("Проверка параметров client-search в operation");

        Map<String, String> collect = response.getData().getOperation().getValues().stream().collect(Collectors.toMap(ValuesItem::getId, ValuesItem::getValue));
        collect.get(Params.CELL_PHONE);

        assertAll(
                () -> assertEquals("Ограничения на обслуживание", collect.get("incorrectDataError")),
                () -> assertEquals("Минимальный возраст для подачи заявки на дебетовую карту - 14 лет.", collect.get("incorrectDataMessage"))
        );
    }

}








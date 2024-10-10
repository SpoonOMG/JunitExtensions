package framework.qa.test.veteranscenario;

import framework.qa.consts.ChannelEnum;
import framework.qa.consts.Params;
import framework.qa.consts.ScenarioCodeEnum;
import framework.qa.consts.UiFieldsNames;
import framework.qa.models.requestData.ScreenValueBack;
import framework.qa.test.BaseTest;
import framework.qa.values.TestDataValues;

import java.util.ArrayList;
import java.util.List;

import static framework.qa.values.TestDataValues.title;
import static framework.qa.values.TestDataValues.userFullName;

public abstract class BaseVeteranTest extends BaseTest {

    protected String veteranScenarioCode = ScenarioCodeEnum.sc_421e8df062b2939.getCode();
    protected String veteranScenarioId = ScenarioCodeEnum.sc_421e8df062b2939.getId();

    protected String productOfferShortName = "МИР Advanced Instant Армия Ветеран";
    protected String servicePackage = "Зарплатный Мир. Силовые структуры";
    protected String TypeCreation = "0";
    protected String paySystemCode = "mir";
    protected String cardCurrency = "RUR";
    protected String IsUnembossed = "1";
    protected String printCardName = "МИР Advanced Instant Армия Ветеран";
    protected String branchCode = "000";
    protected String subProgramCode = "261";
    protected String currencyCode = "810";
    protected String paymentSystemCode = "3";
    protected String CardNumber = "4041369648900142";
    protected String dateExpiration = "0427";


    protected List<ScreenValueBack> operationFinalMaxParam() {
        List<ScreenValueBack> operationFinals = new ArrayList<>();
        operationFinals.add(new ScreenValueBack(Params.LOGIN,                       TestDataValues.login));
        operationFinals.add(new ScreenValueBack(Params.SOURCE_CHANNEL,              TestDataValues.sourceChannel));
        operationFinals.add(new ScreenValueBack(Params.IS_DKBO,                     TestDataValues.isDkbo));
        operationFinals.add(new ScreenValueBack(Params.PDL,                         TestDataValues.PDL));
        operationFinals.add(new ScreenValueBack(Params.BRANCH_CODE,                 branchCode));
        operationFinals.add(new ScreenValueBack(Params.CURRENCY_CODE,               currencyCode));
        operationFinals.add(new ScreenValueBack(Params.SUB_PROGRAM_CODE,            subProgramCode));
        operationFinals.add(new ScreenValueBack(Params.PRODUCT_OFFER_SHORT_NAME,    productOfferShortName));
        operationFinals.add(new ScreenValueBack(Params.CARD_CATEGORY_CODE,           "7"));
        operationFinals.add(new ScreenValueBack(Params.PAY_SYSTEM_CODE,             paymentSystemCode));
        operationFinals.add(new ScreenValueBack(Params.TYPE_CREATION,               TypeCreation));
        operationFinals.add(new ScreenValueBack(Params.USER_FULL_NAME,              userFullName));
        operationFinals.add(new ScreenValueBack(Params.EMPLOYEE_FULL_NAME,          TestDataValues.full_name));
        operationFinals.add(new ScreenValueBack(Params.LATIN_CLIENT_NAME,            TestDataValues.latinClientName));
        operationFinals.add(new ScreenValueBack(Params.TITLE,                       title));
        operationFinals.add(new ScreenValueBack(Params.EMPLOYEE_POSITION,           title));
        operationFinals.add(new ScreenValueBack(UiFieldsNames.UI_SOURCE_CHANNEL,    ChannelEnum.UFO.getName()));
        operationFinals.add(new ScreenValueBack(Params.SURNAME,                     TestDataValues.surname));
        operationFinals.add(new ScreenValueBack(Params.NAME,                        TestDataValues.name));
        operationFinals.add(new ScreenValueBack(Params.SEX_CODE,                    TestDataValues.sexCode));
        operationFinals.add(new ScreenValueBack(Params.IS_RESIDENT,                 TestDataValues.isResident));
        operationFinals.add(new ScreenValueBack(Params.BIRTH_DATE,                  TestDataValues.birth_date));
        operationFinals.add(new ScreenValueBack(Params.BIRTH_PLACE,                 TestDataValues.birthPlace));
        operationFinals.add(new ScreenValueBack(Params.BIRTH_COUNTRY_CODE,          TestDataValues.birthCountryCode));
        operationFinals.add(new ScreenValueBack(Params.DOC_TYPE_CODE,               TestDataValues.docTypeCode));
        operationFinals.add(new ScreenValueBack(Params.DOC_SERIES,                  TestDataValues.docSeries));
        operationFinals.add(new ScreenValueBack(Params.DOC_NUM,                     TestDataValues.docNum));
        operationFinals.add(new ScreenValueBack(Params.ISSUE_DATE,                  TestDataValues.issueDate));
        operationFinals.add(new ScreenValueBack(Params.ISSUED_BY,                   TestDataValues.issuedBy));
        operationFinals.add(new ScreenValueBack(Params.DEPART_CODE,                 TestDataValues.departCode));
        operationFinals.add(new ScreenValueBack(Params.RG_COUNTRY_CODE,             TestDataValues.rgCountryCode));
        operationFinals.add(new ScreenValueBack(Params.RG_POSTAL_CODE,              TestDataValues.rgPostalCode));
        operationFinals.add(new ScreenValueBack(Params.RG_REGION_CODE,              TestDataValues.rgRegionCode));
        operationFinals.add(new ScreenValueBack(Params.FT_COUNTRY_CODE,             TestDataValues.ftCountryCode));
        operationFinals.add(new ScreenValueBack(Params.FT_POSTAL_CODE,              TestDataValues.ftPostalCode));
        operationFinals.add(new ScreenValueBack(Params.FT_REGION_CODE,              TestDataValues.ftRegionCode));
        operationFinals.add(new ScreenValueBack(Params.CELL_PHONE,                  TestDataValues.cellPhone));
        operationFinals.add(new ScreenValueBack(Params.EMAIL,                       TestDataValues.EMAIL));
        return operationFinals;
    }

    protected List<ScreenValueBack> operationFinalMinParam() {
        List<ScreenValueBack> operation = new ArrayList<>();
        operation.add(new ScreenValueBack(Params.LOGIN, TestDataValues.login));
        operation.add(new ScreenValueBack(Params.BRANCH_CODE, branchCode));
        operation.add(new ScreenValueBack(Params.CURRENCY_CODE, currencyCode));
        operation.add(new ScreenValueBack(Params.SUB_PROGRAM_CODE, subProgramCode));
        operation.add(new ScreenValueBack(Params.CARD_CATEGORY_CODE, "7"));
        operation.add(new ScreenValueBack(Params.LATIN_CLIENT_NAME, TestDataValues.latinClientName));
        operation.add(new ScreenValueBack(UiFieldsNames.UI_SOURCE_CHANNEL, ChannelEnum.UFO.getName()));
        return operation;
    }
}

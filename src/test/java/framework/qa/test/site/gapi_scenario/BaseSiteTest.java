package framework.qa.test.site.gapi_scenario;

import com.fasterxml.jackson.databind.ObjectMapper;
import framework.qa.api.OmniApiClient;
import framework.qa.consts.Params;
import framework.qa.models.requestData.ScreenValueBack;
import framework.qa.test.BaseTest;
import framework.qa.values.TestDataValues;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseSiteTest extends BaseTest {

    OmniApiClient initApi = new OmniApiClient();
    OmniApiClient checkApi = new OmniApiClient();
    ObjectMapper om = new ObjectMapper();


    protected List<ScreenValueBack> siteVerifyDataRequiredParams() {
        List<ScreenValueBack> siteVerifyData = new ArrayList<>();
        siteVerifyData.add(new ScreenValueBack(Params.SITE_TYPE_CARD, "0"));
        siteVerifyData.add(new ScreenValueBack(Params.BRANCH_CODE, TestDataValues.branchCode));
        siteVerifyData.add(new ScreenValueBack(Params.SURNAME,TestDataValues.surname));
        siteVerifyData.add(new ScreenValueBack(Params.NAME,TestDataValues.name));
        siteVerifyData.add(new ScreenValueBack(Params.SEX_CODE,TestDataValues.sexCode));
        siteVerifyData.add(new ScreenValueBack(Params.BIRTH_DATE,"1993-07-02"));
        siteVerifyData.add(new ScreenValueBack(Params.BIRTH_PLACE,TestDataValues.birthPlace));
        siteVerifyData.add(new ScreenValueBack(Params.BIRTH_COUNTRY_CODE,TestDataValues.birthCountryCode));
        siteVerifyData.add(new ScreenValueBack(Params.DOC_TYPE_CODE,TestDataValues.docTypeCode));
        siteVerifyData.add(new ScreenValueBack(Params.DOC_SERIES,TestDataValues.docSeries));
        siteVerifyData.add(new ScreenValueBack(Params.DOC_NUM,TestDataValues.docNum));
        siteVerifyData.add(new ScreenValueBack(Params.ISSUE_DATE,TestDataValues.issueDate));
        siteVerifyData.add(new ScreenValueBack(Params.ISSUED_BY,TestDataValues.issuedBy));
        siteVerifyData.add(new ScreenValueBack(Params.DEPART_CODE,TestDataValues.departCode));
        siteVerifyData.add(new ScreenValueBack(Params.RG_COUNTRY_CODE,"RU"));
        siteVerifyData.add(new ScreenValueBack(Params.RG_POSTAL_CODE,TestDataValues.rgPostalCode));
        siteVerifyData.add(new ScreenValueBack(Params.RG_REGION_CODE,TestDataValues.rgRegionCode));
        siteVerifyData.add(new ScreenValueBack(Params.FT_COUNTRY_CODE,"RU"));
        siteVerifyData.add(new ScreenValueBack(Params.FT_POSTAL_CODE,TestDataValues.ftPostalCode));
        siteVerifyData.add(new ScreenValueBack(Params.FT_REGION_CODE,TestDataValues.rgRegionCode));
        siteVerifyData.add(new ScreenValueBack(Params.SITE_MOBILE_NUMBER,TestDataValues.cellPhone));
        siteVerifyData.add(new ScreenValueBack(Params.CONSENT_PERSONAL_DATA,TestDataValues.consentPersonalData));
        siteVerifyData.add(new ScreenValueBack(Params.CONSENT_PERSONAL_DATA_SHARING,TestDataValues.consentPersonalDataSharing));
        siteVerifyData.add(new ScreenValueBack(Params.CONSENT_CH_CHECK,TestDataValues.consentChCheck));
        siteVerifyData.add(new ScreenValueBack(Params.CONSENT_ADV_SUBSCRIPTION,TestDataValues.consentAdvSubscription));
        siteVerifyData.add(new ScreenValueBack(Params.CURRENCY_CODE,TestDataValues.currencyCode));
        siteVerifyData.add(new ScreenValueBack(Params.BRANCH_UNIT_CODE,TestDataValues.branchUnitCode));
        siteVerifyData.add(new ScreenValueBack(Params.KIND_GET,TestDataValues.kindGet));
        siteVerifyData.add(new ScreenValueBack(Params.SUB_PROGRAM_CODE,"083"));

        return siteVerifyData;
    }

}

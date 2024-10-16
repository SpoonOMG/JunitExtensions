package framework.qa.test.site.gapi_scenario;

import com.fasterxml.jackson.databind.ObjectMapper;
import framework.qa.api.OmniApiClient;
import framework.qa.consts.ScenarioCodeEnum;
import framework.qa.jupiter.annotations.InitRequest;
import framework.qa.models.omniresponseitem.ResponseItem;
import framework.qa.models.omniresponseitem.ValuesItem;
import framework.qa.models.requestData.OmniRequestItem;
import framework.qa.models.requestData.Scenario;
import framework.qa.models.requestData.ScreenValueBack;
import framework.qa.models.requestData.VerifyData;
import framework.qa.test.BaseTest;
import framework.qa.utils.JsonLoader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InitSiteGapiTest extends BaseSiteTest {
    ObjectMapper om = new ObjectMapper();

    @DisplayName("Прием заявки с сайта на ДК. Получение успешного ответа")
    @Test
    public void siteInitRequestShouldReturnSuccess(@InitRequest OmniRequestItem init) throws IOException {
        String gpbRequestId = UUID.randomUUID().toString();
        init.getMeta().setChannel("WEB");
        init.getMeta().setSystemId("GAPI");
        init.getData().setScenario(new Scenario(ScenarioCodeEnum.sc_13cc01653561c2c.getId(),ScenarioCodeEnum.sc_13cc01653561c2c.getCode(),"RMI"));
        init.getData().setVerifyData(new VerifyData(new ArrayList<>()));
        ResponseItem response = initApi.initRequest(gpbRequestId,init);
        assertAll(
                () -> assertEquals("SITE_CARD_PARAMS", response.getScreen().getLoad().getId()),
                () -> assertEquals("initial", response.getScreen().getStage()),
                () -> assertEquals(true, response.getScreen().isSuccess())
        );
    }


}

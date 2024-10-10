package framework.qa.test.veteranscenario;

import framework.qa.api.OmniApiClient;
import framework.qa.consts.ChannelEnum;
import framework.qa.consts.Params;
import framework.qa.consts.UiFieldsNames;
import framework.qa.jupiter.annotations.CheckRequest;
import framework.qa.jupiter.annotations.Wmock;
import framework.qa.jupiter.annotations.Wmocks;
import framework.qa.models.omniresponseitem.*;
import framework.qa.models.requestData.OmniRequestItem;
import framework.qa.models.requestData.ScreenCommandFront;
import framework.qa.models.requestData.ScreenValueBack;
import framework.qa.models.wiremock.response.RootWiremockResponse;
import framework.qa.values.TestDataValues;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


import java.util.*;


import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("Ветераны")
public class CheckExecuteVeteranTest extends BaseVeteranTest {
    private final OmniApiClient checkApi = new OmniApiClient();

    @Test
    @DisplayName("Получение успешного экрана при запросе на check final c минимальным набором параметров")
    @Wmocks({
            @Wmock(
                    enpointMapping = "/omni-information/api/v2/client/search",
                    mockFile = "wiremock/client-search/default.json",
                    pathToField = "data.clients.[?(@.base.guid==\"6F57A2C3507C4D6AA1A70E9C8C8CF919\")].base.hid",
                    value = ""
            )})

    public void veteranCheckExecuteShouldReturnSuccessScreenWithMinParams(
            RootWiremockResponse rwr,
            @CheckRequest OmniRequestItem check) {
        String gpbrequestId = rwr.getRequest().getHeaders().getGpbrequestId().getEqualTo();

        step("Отправка запроса на check", () -> {
            List<ScreenValueBack> verifyDataValues = new ArrayList<>();
            List<ScreenValueBack> operationValues = operationFinalMaxParam();
            operationValues.add(new ScreenValueBack(Params.IS_UNEMBOSSED, "1"));
            operationValues.add(new ScreenValueBack(UiFieldsNames.UI_EMBOSSING_CLIENT_NAME, TestDataValues.embossing_client_name));
            operationValues.add(new ScreenValueBack(Params.CHANNEL, ChannelEnum.UFO.getName()));

            verifyDataValues.add(new ScreenValueBack(UiFieldsNames.UI_CODEWORD, "Рига"));
            verifyDataValues.add(new ScreenValueBack(UiFieldsNames.UI_CLIENT_CONSENTS, "true"));

            check.getMeta().setChannel(ChannelEnum.WEB.getName());
            check.getData().getOperation().setOrder4client(UUID.randomUUID().toString());
            check.getData().getScenario().setId(veteranScenarioId);
            check.getData().getScenario().setCode(veteranScenarioCode);
            check.getData().getVerifyData().setCommand(new ScreenCommandFront("execute", "confirmCardApplication"));
            check.getData().getVerifyData().setScreenStage("after_draft");
            check.getData().getVerifyData().setScreenId("5NT_AFTER_DRAFT_ALL");

            check.getData().getVerifyData().setValues(verifyDataValues);
            check.getData().getOperation().setValues(operationValues);
            ResponseItem response = checkApi.checkRequest(gpbrequestId, check);

            step("Проверка получения экрана успеха");

            assertAll(
                    () -> assertEquals("success", response.getStatus()),
                    () -> assertEquals(check.getData().getOperation().getOrderId(), response.getData().getOperation().getOrderId()),
                    () -> assertEquals(ServerActionEnum.SIGNATURE.getValue(), response.getData().getServerActions().stream().map(ServerAction::getAction).map(ServerActionEnum::getValue).findAny().orElse(null))
            );
        });

    }
}

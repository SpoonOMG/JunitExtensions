package framework.qa.test.veteran;

import framework.qa.api.OmniApiClient;
import framework.qa.consts.ChannelEnum;
import framework.qa.consts.Params;
import framework.qa.consts.ScenarioCodeEnum;
import framework.qa.consts.UiFieldsNames;
import framework.qa.jupiter.annotations.CheckRequest;
import framework.qa.jupiter.annotations.Wmock;
import framework.qa.jupiter.annotations.Wmocks;
import framework.qa.models.omniresponseitem.ResponseItem;
import framework.qa.models.omniresponseitem.ValuesItem;
import framework.qa.models.requestData.*;
import framework.qa.models.wiremock.response.RootWiremockResponse;
import framework.qa.test.BaseTest;
import framework.qa.values.*;
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

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("Ветераны")
public class CheckInitialVeteranTest extends BaseVeteranTest {
    private final OmniApiClient checkApi = new OmniApiClient();

    @Test
    @Wmocks
    (@Wmock(
            enpointMapping = "/omni-information/api/v2/client/search",
            mockFile = "wiremock/client-search/default.json",
            pathToField = "data.clients.[?(@.base.guid==\"6F57A2C3507C4D6AA1A70E9C8C8CF919\")].base.hid",
            value = ""
    ))
    @DisplayName("Получение успешного экрана при запросе на check initial c минимальным набором параметров")
    public void veteranCheckInitialShouldReturnSuccessScreenWithMinParams(
            RootWiremockResponse rwr,
            @CheckRequest OmniRequestItem check) {
        String gpbrequestId = rwr.getRequest().getHeaders().getGpbrequestId().getEqualTo();

        step("Отправка запроса на check", () -> {
            List<ScreenValueBack> operationValueBackList = new ArrayList<>();
            operationValueBackList.add(new ScreenValueBack(Params.CARD_CATEGORY_CODE,"7"));
            check.getData().getScenario().setId(veteranScenarioId);
            check.getData().getScenario().setCode(veteranScenarioCode);
            check.getData().getOperation().setValues(operationValueBackList);
            check.getData().getVerifyData().setCommand(new ScreenCommandFront("check","checkSmartCardParams"));

            ResponseItem response = checkApi.checkRequest(gpbrequestId, check);
            Map<String, String> collect = response.getData().getOperation().getValues().stream().collect(Collectors.toMap(ValuesItem::getId, ValuesItem::getValue));
            collect.get(Params.CELL_PHONE);

            step("Проверка получения экрана успеха");
            assertAll(
                    () -> assertEquals("5NT_BORROWER_EXT_OFFICE", response.getScreen().getLoad().getId()),
                    () -> assertEquals("final", response.getScreen().getStage()),
                    () -> assertEquals(true, response.getScreen().isSuccess()),
                    () -> assertEquals("false", collect.get("##isSecretWord")),
                    () -> assertEquals(productOfferShortName, collect.get(Params.PRODUCT_OFFER_SHORT_NAME)),
                    () -> assertEquals(servicePackage, collect.get("##servicePackage")),
                    () -> assertEquals(TypeCreation, collect.get(Params.TYPE_CREATION)),
                    () -> assertEquals("false", collect.get(UiFieldsNames.UI_DELIVERY_DSA)),
                    () -> assertEquals(paySystemCode, collect.get("##paySystemCode")),
                    () -> assertEquals(cardCurrency, collect.get("##cardCurrency")),
                    () -> assertEquals("false", collect.get(UiFieldsNames.UI_DELIVERY_COURIER)),
                    () -> assertEquals(IsUnembossed, collect.get(Params.IS_UNEMBOSSED)),
                    () -> assertEquals(printCardName, collect.get(UiFieldsNames.UI_PRINT_CARD_NAME)),
                    () -> assertEquals(branchCode, collect.get(Params.BRANCH_CODE)),
                    () -> assertEquals("1", collect.get(UiFieldsNames.UI_CURRENCY)),
                    () -> assertEquals("true", collect.get(UiFieldsNames.UI_DELIVERY_OFFICE)),
                    () -> assertEquals(subProgramCode, collect.get(Params.SUB_PROGRAM_CODE)),
                    () -> assertEquals("false", collect.get(UiFieldsNames.UI_EXPIRED_PASSPORT)),
                    () -> assertEquals(currencyCode, collect.get(Params.CURRENCY_CODE)),
                    () -> assertEquals(paymentSystemCode, collect.get(Params.PAYMENT_SYSTEM_CODE))
            );
        });
    }
}

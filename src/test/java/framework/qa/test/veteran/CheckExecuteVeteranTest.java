//package framework.qa.test.veteran;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import framework.qa.consts.ChannelEnum;
//import framework.qa.consts.Params;
//import framework.qa.consts.UiFieldsNames;
//import framework.qa.jupiter.annotations.CheckRequest;
//import framework.qa.jupiter.annotations.Mock;
//import framework.qa.models.requestData.OmniRequestItem;
//import framework.qa.models.requestData.ScreenCommandFront;
//import framework.qa.models.requestData.ScreenValueBack;
//import framework.qa.utils.JsonLoader;
//import framework.qa.utils.WiremockRetrofit;
//import framework.qa.values.TestDataValues;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//import org.apache.commons.lang3.StringEscapeUtils;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Tag;
//import org.junit.jupiter.api.Test;
//
//import java.io.File;
//import java.nio.charset.StandardCharsets;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//import java.util.UUID;
//
//import static io.qameta.allure.Allure.step;
//import static io.restassured.RestAssured.given;
//import static org.junit.jupiter.api.Assertions.assertAll;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@Tag("Ветераны")
//public class CheckExecuteVeteranTest extends BaseVeteranTest {
//
//
//    @DisplayName("Получение успешного экрана при запросе на check final c минимальным набором параметров")
//    @Test
//    public void veteranCheckExecuteShouldReturnSuccessScreenWithMinParams(@Mock WiremockRetrofit clientSearchMock,
//                                                                          @CheckRequest OmniRequestItem check) {
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
//            List<ScreenValueBack> operationValues = operationFinalMaxParam();
//            operationValues.add(new ScreenValueBack(Params.IS_UNEMBOSSED, "1"));
//            operationValues.add(new ScreenValueBack(UiFieldsNames.UI_EMBOSSING_CLIENT_NAME, TestDataValues.embossing_client_name));
//            operationValues.add(new ScreenValueBack(Params.CHANNEL, ChannelEnum.UFO.getName()));
//
//            verifyDataValues.add(new ScreenValueBack(UiFieldsNames.UI_CODEWORD, "Рига"));
//            verifyDataValues.add(new ScreenValueBack(UiFieldsNames.UI_CLIENT_CONSENTS, "true"));
//
//            check.getMeta().setChannel(ChannelEnum.WEB.getName());
//            check.getData().getOperation().setOrder4client(UUID.randomUUID().toString());
//            check.getData().getScenario().setId(veteranScenarioId);
//            check.getData().getScenario().setCode(veteranScenarioCode);
//            check.getData().getVerifyData().setCommand(new ScreenCommandFront("execute", "confirmCardApplication"));
//            check.getData().getVerifyData().setScreenStage("after_draft");
//            check.getData().getVerifyData().setScreenId("5NT_AFTER_DRAFT_ALL");
//
//            check.getData().getVerifyData().setValues(verifyDataValues);
//            check.getData().getOperation().setValues(operationValues);
//            Response response = given()                    .contentType(ContentType.JSON)
//                    .header("gpb-requestId", gpbRequestId)
//                    .header("Authorization", CFG.token()).header("GPB-guid", guid)
//                    .body(check)
//                    .post("api/v1/metadata/check")
//                    .then().extract().response();
//            step("Проверка получения экрана успеха");
//
//            assertAll(
//                    () -> assertEquals("success", response.path("status")),
//                    () -> assertEquals(check.getData().getOperation().getOrderId(), response.path("data.operation.orderId")),
//                    () -> assertEquals("high", response.path("data.serverActions.find{it.action=\"signature\"}.criticality")),
//                    () -> assertEquals("after", response.path("data.serverActions.find{it.action=\"signature\"}.startPoint")),
//                    () -> assertEquals("Вы оформляете заявку на дебетовую карту", response.path("data.serverActions.find{it.action=\"signature\"}.parameters.find{it.key=\"textSms\"}.value")),
//                    () -> assertEquals("string", response.path("data.serverActions.find{it.action=\"signature\"}.parameters.find{it.key=\"clientPhone\"}.type")));
//
//        });
//        step("Очистка мок", () -> {
//            clientSearchMock.wiremockRemove();
//        });
//
//    }
//}

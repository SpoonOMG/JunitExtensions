//package framework.qa.test.veteran;
//
//import framework.qa.consts.ChannelEnum;
//import framework.qa.consts.Params;
//import framework.qa.consts.UiFieldsNames;
//import framework.qa.jupiter.annotations.CheckRequest;
//import framework.qa.jupiter.annotations.LoadRequest;
//import framework.qa.jupiter.annotations.Mock;
//import framework.qa.models.requestData.OmniRequestItem;
//import framework.qa.models.requestData.ScreenCommandFront;
//import framework.qa.models.requestData.ScreenValueBack;
//import framework.qa.utils.Wiremock;
//import framework.qa.values.TestDataValues;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Tag;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//import static framework.qa.values.TestDataValues.title;
//import static framework.qa.values.TestDataValues.userFullName;
//import static io.qameta.allure.Allure.step;
//import static io.restassured.RestAssured.given;
//import static org.junit.jupiter.api.Assertions.assertAll;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@Tag("Ветераны")
//public class LoadVeteranTest extends BaseVeteranTest {
//
//    @DisplayName("Получение успешного экрана при запросе на load c минимальным набором параметров")
//    @Test
//    public void veteranLoadShouldReturnSuccessScreenWithMinParams(@LoadRequest OmniRequestItem load) {
//        String gpbRequestId = UUID.randomUUID().toString();
//        step("Отправка запроса на load", () -> {
//            Response response = given()                    .contentType(ContentType.JSON)
//                    .header("gpb-requestId", gpbRequestId)
//                    .header("Authorization", CFG.token()).header("GPB-guid", guid)
//                    .body(load)
//                    .post("api/v1/metadata/load")
//                    .then().extract().response();
//            step("Проверка получения экрана успеха");
//            assertAll(
//                    () -> assertEquals("5NT_AFTER_DRAFT_ALL", response.path("screen.load.id")),
//                    () -> assertEquals("after_draft", response.path("screen.stage")),
//                    () -> assertEquals(true, response.path("screen.success"))
//            );
//        });
//    }
//
//
//    @DisplayName("Проверка получения параметров в ответе, переданных в verifyData при запросе на load c максимальным набором параметров")
//    @Test
//    public void veteranLoadShouldReturnSuccessScreenWithProvidedParams(@LoadRequest OmniRequestItem load) {
//        String gpbRequestId = UUID.randomUUID().toString();
//        step("Отправка запроса на load", () -> {
//
//            load.getData().getVerifyData().setValues(operationFinalMaxParam());
//            Response response = given()                    .contentType(ContentType.JSON)
//                    .header("gpb-requestId", gpbRequestId)
//                    .header("Authorization", CFG.token()).header("GPB-guid", guid)
//                    .body(load)
//                    .post("api/v1/metadata/load")
//                    .then().extract().response();
//            step("Проверка получения экрана успеха");
//            assertAll(
//                    () -> assertEquals(TestDataValues.login, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.LOGIN + "\"}.value")),
//                    () -> assertEquals(TestDataValues.sourceChannel, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.SOURCE_CHANNEL + "\"}.value")),
//                    () -> assertEquals(TestDataValues.isDkbo, response.jsonPath().getString("data.operation.values.find{it.id==\"isDkbo\"}.value")),
//                    () -> assertEquals(TestDataValues.PDL, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.PDL + "\"}.value")),
//                    () -> assertEquals(branchCode, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.BRANCH_CODE + "\"}.value")),
//                    () -> assertEquals(currencyCode, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.CURRENCY_CODE + "\"}.value")),
//                    () -> assertEquals(subProgramCode, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.SUB_PROGRAM_CODE + "\"}.value")),
//                    () -> assertEquals(productOfferShortName, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.PRODUCT_OFFER_SHORT_NAME + "\"}.value")),
//                    () -> assertEquals("7", response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.CARD_CATEGORY_CODE + "\"}.value")),
//                    () -> assertEquals(paymentSystemCode, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.PAY_SYSTEM_CODE + "\"}.value")),
//                    () -> assertEquals(TypeCreation, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.TYPE_CREATION + "\"}.value")),
//                    () -> assertEquals(userFullName, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.USER_FULL_NAME + "\"}.value")),
//                    () -> assertEquals(TestDataValues.full_name, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.EMPLOYEE_FULL_NAME + "\"}.value")),
//                    () -> assertEquals(TestDataValues.latinClientName, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.LATIN_CLIENT_NAME + "\"}.value")),
//                    () -> assertEquals(title, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.TITLE + "\"}.value")),
//                    () -> assertEquals(title, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.EMPLOYEE_POSITION + "\"}.value")),
//                    () -> assertEquals(ChannelEnum.UFO.getName(), response.jsonPath().getString("data.operation.values.find{it.id==\"" + UiFieldsNames.UI_SOURCE_CHANNEL + "\"}.value")),
//                    () -> assertEquals(TestDataValues.surname, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.SURNAME + "\"}.value")),
//                    () -> assertEquals(TestDataValues.name, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.NAME + "\"}.value")),
//                    () -> assertEquals(TestDataValues.sexCode, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.SEX_CODE + "\"}.value")),
//                    () -> assertEquals(TestDataValues.isResident, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.IS_RESIDENT + "\"}.value")),
//                    () -> assertEquals(TestDataValues.birth_date, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.BIRTH_DATE + "\"}.value")),
//                    () -> assertEquals(TestDataValues.birthPlace, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.BIRTH_PLACE + "\"}.value")),
//                    () -> assertEquals(TestDataValues.birthCountryCode, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.BIRTH_COUNTRY_CODE + "\"}.value")),
//                    () -> assertEquals(TestDataValues.docTypeCode, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.DOC_TYPE_CODE + "\"}.value")),
//                    () -> assertEquals(TestDataValues.docSeries, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.DOC_SERIES + "\"}.value")),
//                    () -> assertEquals(TestDataValues.docNum, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.DOC_NUM + "\"}.value")),
//                    () -> assertEquals(TestDataValues.issueDate, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.ISSUE_DATE + "\"}.value")),
//                    () -> assertEquals(TestDataValues.issuedBy, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.ISSUED_BY + "\"}.value")),
//                    () -> assertEquals(TestDataValues.departCode, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.DEPART_CODE + "\"}.value")),
//                    () -> assertEquals(TestDataValues.rgCountryCode, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.RG_COUNTRY_CODE + "\"}.value")),
//                    () -> assertEquals(TestDataValues.rgPostalCode, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.RG_POSTAL_CODE + "\"}.value")),
//                    () -> assertEquals(TestDataValues.rgRegionCode, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.RG_REGION_CODE + "\"}.value")),
//                    () -> assertEquals(TestDataValues.ftCountryCode, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.FT_COUNTRY_CODE + "\"}.value")),
//                    () -> assertEquals(TestDataValues.ftPostalCode, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.FT_POSTAL_CODE + "\"}.value")),
//                    () -> assertEquals(TestDataValues.ftRegionCode, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.FT_REGION_CODE + "\"}.value")),
//                    () -> assertEquals(TestDataValues.cellPhone, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.CELL_PHONE + "\"}.value")),
//                    () -> assertEquals(TestDataValues.EMAIL, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.EMAIL + "\"}.value")),
//                    () -> assertEquals(currencyCode, response.jsonPath().getString("data.operation.values.find{it.id==\"" + Params.CURRENCY_CODE + "\"}.value"))
//            );
//        });
//    }
//}

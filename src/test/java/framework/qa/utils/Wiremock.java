package framework.qa.utils;

import com.github.jknack.handlebars.internal.text.translate.UnicodeUnescaper;
import framework.qa.config.Config;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;

public class Wiremock {
    protected static final Config CFG = Config.getInstance();
    protected String uuid;
    public String requestId;


    public void wiremockSend(String mockPath, String enpointMapping,  String att, String value, String gpbRequestIdMapping) {
        JsonAttChanger js = new JsonAttChanger();
        String jsonBody = js.apply(mockPath,att,value);

        //todo здесь нужно продумать как сделать преобразование jsonBody в запрос на генерацию мока (возможно через конкатенацию строк)

        String escapedJsonBody=StringEscapeUtils.escapeJson(jsonBody);
        String utfJsonBody = new UnicodeUnescaper().translate(escapedJsonBody);
        String request = "{\n" +
                "    \"request\": {\n" +
                "        \"method\": \"POST\",\n" +
                "        \"url\": \""+enpointMapping+"\",\n" +
                "        \"headers\": {\n" +
                "          \"gpb-requestId\": {\n" +
                "            \"equalTo\": \""+gpbRequestIdMapping+"\"\n" +
                "          }\n" +
                "        }\n" +
                "    },\n" +
                "    \"response\": {\n" +
                "        \"status\": 200,\n" +
                "        \"headers\": {\n" +
                "            \"Content-Type\": \"application/json\"\n" +
                "        },\n" +
                "        \"body\": \""+utfJsonBody+"}\"}}";

        Response response= given().header("Content-Type","application/json; charset=UTF-8")
                .baseUri(CFG.wiremockUrl())
                .body(request)
                .post("/__admin/mappings")
                .then().extract().response();

        uuid = response.body().path("uuid");

        System.out.println(uuid);
    }
    public void wiremockRemove(){
        given()
                .baseUri(CFG.wiremockUrl())
                .delete("/__admin/mappings/"+uuid)
                .then().extract().response();
    }


    @Test
    void test(){
        wiremockSend("wiremock/client-search/default.json",
                "/omni-information/api/v2/client/search",
                "data.clients.[?(@.base.guid==\"6F57A2C3507C4D6AA1A70E9C8C8CF919\")].base.hid",
                "",
                "gpbRequestId");
        wiremockRemove();
    }
}

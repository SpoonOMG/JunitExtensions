package framework.qa.utils;
import org.json.JSONException;
import org.json.JSONObject;


import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Predicate;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class JsonAttChanger {
    public String apply(String jsonString, String pathToField, String value) {
        DocumentContext ctx = JsonPath.parse(jsonString);
        ctx.set(pathToField, value, new Predicate[0]);
        FileContentReader.jsonBody=ctx.jsonString();
        return FileContentReader.jsonBody;
    }


    public String appli(String jsonString, String pathToField, String value) {
        String json=null;
        try {
            JsonLoader loader = new JsonLoader();
            String jsonContent = loader.getJsonFromResources(jsonString);
//            System.out.println(jsonContent);
            // Дальнейшая работа с полученной строкой JSON
            DocumentContext ctx = JsonPath.parse(jsonContent);
            ctx.set(pathToField, value, new Predicate[0]);
            json=ctx.jsonString();
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
        return json;
    }

//@Test
//    void tt(){
//    System.out.println(appli("wiremock/client-search/default.json","base.guid","1234"));
//}
//
//    @Test
//    void tt2(){
//        System.out.println(appli("base.guid","4321"));
//    }
//
//    @Test
//    void tt3(){
//        System.out.println(appli("base.guid","21234"));
//    }
//
//    @Test
//    void tt4(){
//        System.out.println(appli("base.guid","34321"));
//    }
}

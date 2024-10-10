package framework.qa.utils;

import org.json.JSONException;
import org.json.JSONObject;


import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Predicate;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class JsonAttChanger {

    //todo убрать метод из класса  - не используется
//    public String appli(String mockFile, String pathToField, String value) {
//        DocumentContext ctx = JsonPath.parse(mockFile);
//        ctx.set(pathToField, value, new Predicate[0]);
//        FileContentReader.jsonBody = ctx.mockFile();
//        return FileContentReader.jsonBody;
//    }


    public String apply(String jsonString, String pathToField, String value) {
        String json = null;
        try {
            JsonLoader loader = new JsonLoader();
            String jsonContent = loader.getJsonFromResources(jsonString);
            // Дальнейшая работа с полученной строкой JSON
            DocumentContext ctx = JsonPath.parse(jsonContent);
            ctx.set(pathToField, value, new Predicate[0]);
            json = ctx.jsonString();
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
        return json;
    }

}

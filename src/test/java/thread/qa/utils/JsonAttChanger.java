package thread.qa.utils;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Predicate;

import static thread.qa.utils.FileContentReader.jsonBody;

public class JsonAttChanger {
    public String apply(String jsonString, String pathToField, String value) {
        DocumentContext ctx = JsonPath.parse(jsonString);
        ctx.set(pathToField, value, new Predicate[0]);
        jsonBody=ctx.jsonString();
        return jsonBody;
    }
}

package framework.qa.utils;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Predicate;

public class JsonAttChanger {
    public String apply(String jsonString, String pathToField, String value) {
        DocumentContext ctx = JsonPath.parse(jsonString);
        ctx.set(pathToField, value, new Predicate[0]);
        FileContentReader.jsonBody=ctx.jsonString();
        return FileContentReader.jsonBody;
    }
}

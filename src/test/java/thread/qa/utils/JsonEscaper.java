package thread.qa.utils;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import java.io.IOException;


public class JsonEscaper {

        public static String escapeJson(String json){
            return Json.createObjectBuilder()
                    .add("originalJSON", json)
                    .build()
                    .toString();
        }
    }

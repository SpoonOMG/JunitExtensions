package framework.qa.models.omniresponseitem;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Angle {


    public String getType() {
        return type;
    }

    @JsonProperty("type")
    private String type;
}

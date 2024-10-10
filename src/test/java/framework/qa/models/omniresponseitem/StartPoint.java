package framework.qa.models.omniresponseitem;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

public enum StartPoint {
    BEFORE("before"),
    AFTER("after");

    private String value;

    StartPoint(String value) {
        this.value = value;
    }

    public static StartPoint getDefault() {
        return BEFORE;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}

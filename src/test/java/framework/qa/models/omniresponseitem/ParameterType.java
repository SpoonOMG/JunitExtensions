package framework.qa.models.omniresponseitem;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

public enum ParameterType {
    BOOLEAN("boolean"),
    STRING("string"),
    NUMBER("number");

    private String value;

    ParameterType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}

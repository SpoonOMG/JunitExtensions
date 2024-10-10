package framework.qa.models.omniresponseitem;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

public enum ParameterSourceType {
    REFERENCE("reference"),
    OPERATION("operation");

    private String value;

    ParameterSourceType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}

package framework.qa.models.omniresponseitem;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

public enum Criticality {
    HIGH("high"),
    MEDIUM("medium"),
    LOW("low");

    private String value;

    Criticality(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}

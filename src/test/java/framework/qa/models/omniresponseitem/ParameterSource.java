package framework.qa.models.omniresponseitem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ParameterSource {
    public ParameterSourceType getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public String getProperty() {
        return property;
    }

    private ParameterSourceType type;
    private String id;
    private String property;
}

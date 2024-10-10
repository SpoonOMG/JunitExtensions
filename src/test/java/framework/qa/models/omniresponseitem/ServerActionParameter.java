package framework.qa.models.omniresponseitem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ServerActionParameter {
    private String key;
    private ParameterType type;
    private String value;
    private ParameterSource source;

    public String getKey() {
        return key;
    }

    public ParameterType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public ParameterSource getSource() {
        return source;
    }

    @Override
    public String toString() {
        return "ServerActionParameter{" +
                "key='" + key + '\'' +
                ", type=" + type +
                ", value='" + value + '\'' +
                ", source=" + source +
                "}\n";
    }
}

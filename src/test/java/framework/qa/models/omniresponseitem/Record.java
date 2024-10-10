package framework.qa.models.omniresponseitem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Запись arbitrary
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Record {

    private String value;

    private String label;

    private String help;

    public String getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    public String getHelp() {
        return help;
    }
}

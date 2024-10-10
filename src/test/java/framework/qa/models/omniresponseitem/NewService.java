package framework.qa.models.omniresponseitem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class NewService {
    public String getExecute() {
        return execute;
    }

    private String execute;
}

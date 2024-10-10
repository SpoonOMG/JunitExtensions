package framework.qa.models.omniresponseitem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ServerActionConfiguration {

    private ServerActionSmftFile smft;
    private String print;
    private String mte;
}

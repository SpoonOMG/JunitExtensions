package framework.qa.models.requestData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@AllArgsConstructor
@Data
@Accessors(chain = true)
public class VerifyData {

    private List<ScreenValueBack> values;

    private String screenStage;

    private String screenId;

    private ScreenCommandFront command;

    public VerifyData(List<ScreenValueBack> values) {
        this.values = values;
    }

    public VerifyData() {
    }

    public ScreenCommandFront getCommand() {
        return command;
    }

    public void setCommand(ScreenCommandFront command) {
        this.command = command;
    }

    public List<ScreenValueBack> getValues() {
        return values;
    }

    public void setValues(List<ScreenValueBack> values) {
        this.values = values;
    }

    public String getScreenStage() {
        return screenStage;
    }

    public void setScreenStage(String screenStage) {
        this.screenStage = screenStage;
    }

    public String getScreenId() {
        return screenId;
    }

    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }
}

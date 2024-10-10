package framework.qa.models.requestData;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ScreenCommandFront {

    private String type;

    private String id;

    private String logInfo;

    private String techInfo;

    private Object specific;

    public ScreenCommandFront(String type, String id, String logInfo, String techInfo, Object specific) {
        this.type = type;
        this.id = id;
        this.logInfo = logInfo;
        this.techInfo = techInfo;
        this.specific = specific;
    }

    public ScreenCommandFront(String type, String id) {
        this.type = type;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogInfo() {
        return logInfo;
    }

    public void setLogInfo(String logInfo) {
        this.logInfo = logInfo;
    }

    public String getTechInfo() {
        return techInfo;
    }

    public void setTechInfo(String techInfo) {
        this.techInfo = techInfo;
    }

    public Object getSpecific() {
        return specific;
    }

    public void setSpecific(Object specific) {
        this.specific = specific;
    }
}

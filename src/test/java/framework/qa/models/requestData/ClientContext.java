package framework.qa.models.requestData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class ClientContext {

    private String version;

    private String sessionContextId;

    private String clientDateTime;

    private Employee employee;

    /**
     * Путь, по которому
     * волеизъявление оформляется example -  "oneStepWill"
     */
    private String way;

    private List<OmniParam> params = new ArrayList<>();

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSessionContextId() {
        return sessionContextId;
    }

    public void setSessionContextId(String sessionContextId) {
        this.sessionContextId = sessionContextId;
    }

    public String getClientDateTime() {
        return clientDateTime;
    }

    public void setClientDateTime(String clientDateTime) {
        this.clientDateTime = clientDateTime;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public List<OmniParam> getParams() {
        return params;
    }

    public void setParams(List<OmniParam> params) {
        this.params = params;
    }
}

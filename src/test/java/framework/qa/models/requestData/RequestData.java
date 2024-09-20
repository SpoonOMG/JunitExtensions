package framework.qa.models.requestData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class RequestData {

    private Scenario scenario;

    private Operation operation;

    private ClientContext clientContext;

    private VerifyData verifyData;


    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public ClientContext getClientContext() {
        return clientContext;
    }

    public void setClientContext(ClientContext clientContext) {
        this.clientContext = clientContext;
    }

    public VerifyData getVerifyData() {
        return verifyData;
    }

    public void setVerifyData(VerifyData verifyData) {
        this.verifyData = verifyData;
    }
}

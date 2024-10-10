package framework.qa.models.requestData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Operation {

    /**
     * идентификатор
     */
    private String orderId;

    /**
     * Номер заявки
     */
    private String order4client;

    /**
     * Момент времени UNIX (timestamp в мс), в которой волеизъявление было принято к исполнению.
     */
    private String acceptedTime;

    public Operation() {
    }

    public void setValues(List<ScreenValueBack> values) {
        this.values = values;
    }

    private List<ScreenValueBack> values;

    public Operation(String orderId, List<ScreenValueBack> values) {
        this.orderId = orderId;
        this.values = values;
    }

    public Operation(String orderId, String order4client, String acceptedTime, List<ScreenValueBack> values) {
        this.orderId = orderId;
        this.order4client = order4client;
        this.acceptedTime = acceptedTime;
        this.values = values;
    }

    public Operation(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrder4client() {
        return order4client;
    }

    public void setOrder4client(String order4client) {
        this.order4client = order4client;
    }

    public String getAcceptedTime() {
        return acceptedTime;
    }

    public void setAcceptedTime(String acceptedTime) {
        this.acceptedTime = acceptedTime;
    }

    public List<ScreenValueBack> getValues() {
        return values;
    }
}

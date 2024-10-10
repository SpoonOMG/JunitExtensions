package framework.qa.models.omniresponseitem;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Operation{

	public String getOrderId() {
		return orderId;
	}

	public String getOrder4client() {
		return order4client;
	}

	/**
	 * Номер заявки
	 */
	private String order4client;

	private String orderId;


	@JsonProperty("values")
	private List<ValuesItem> values;

	public List<ValuesItem> getValues(){
		return values;
	}
}
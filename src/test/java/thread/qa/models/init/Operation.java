package thread.qa.models.init;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Operation{

	@JsonProperty("orderId")
	private String orderId = UUID.randomUUID().toString();

	public void setOrderId(String orderId){
		this.orderId = orderId;
	}

	public String getOrderId(){
		return orderId;
	}
}
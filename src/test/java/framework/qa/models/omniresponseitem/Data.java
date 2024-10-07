package framework.qa.models.omniresponseitem;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data{

	@JsonProperty("operation")
	private Operation operation;

	public Operation getOperation(){
		return operation;
	}
}
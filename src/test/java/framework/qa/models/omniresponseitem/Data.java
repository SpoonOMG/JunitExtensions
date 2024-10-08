package framework.qa.models.omniresponseitem;

import com.fasterxml.jackson.annotation.JsonProperty;
import framework.qa.models.omniresponse.Arbitrary;

public class Data{
	@JsonProperty("arbitrary")
	private Arbitrary arbitrary;

	@JsonProperty("operation")
	private Operation operation;

	public Operation getOperation(){
		return operation;
	}
}
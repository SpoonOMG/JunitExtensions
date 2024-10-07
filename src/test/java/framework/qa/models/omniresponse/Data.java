package framework.qa.models.omniresponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data{

	@JsonProperty("arbitrary")
	private Arbitrary arbitrary;

	@JsonProperty("operation")
	private Operation operation;

	public Arbitrary getArbitrary(){
		return arbitrary;
	}

	public Operation getOperation(){
		return operation;
	}
}
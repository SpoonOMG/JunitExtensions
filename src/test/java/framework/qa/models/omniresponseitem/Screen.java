package framework.qa.models.omniresponseitem;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Screen{

	@JsonProperty("stage")
	private String stage;

	@JsonProperty("load")
	private Load load;

	@JsonProperty("success")
	private boolean success;

	public String getStage(){
		return stage;
	}

	public Load getLoad(){
		return load;
	}

	public boolean isSuccess(){
		return success;
	}
}
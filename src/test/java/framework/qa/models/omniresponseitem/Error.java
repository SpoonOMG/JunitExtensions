package framework.qa.models.omniresponseitem;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Error{

	@JsonProperty("type")
	private String type;

	@JsonProperty("message")
	private String message;

	public String getType(){
		return type;
	}

	public String getMessage(){
		return message;
	}
}
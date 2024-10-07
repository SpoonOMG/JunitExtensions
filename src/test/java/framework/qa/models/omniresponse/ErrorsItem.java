package framework.qa.models.omniresponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorsItem{

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
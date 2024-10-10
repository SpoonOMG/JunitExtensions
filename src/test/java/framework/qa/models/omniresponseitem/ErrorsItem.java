package framework.qa.models.omniresponseitem;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorsItem{

	@JsonProperty("type")
	private String type;

	public String getSeverity() {
		return severity;
	}

	@JsonProperty("severity")
	private String severity;

	@JsonProperty("message")
	private String message;

	public String getType(){
		return type;
	}

	public String getMessage(){
		return message;
	}
}
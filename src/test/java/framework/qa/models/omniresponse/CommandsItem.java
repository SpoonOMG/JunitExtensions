package framework.qa.models.omniresponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommandsItem{

	@JsonProperty("id")
	private String id;

	@JsonProperty("type")
	private String type;

	public String getId(){
		return id;
	}

	public String getType(){
		return type;
	}
}
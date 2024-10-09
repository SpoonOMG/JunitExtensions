package framework.qa.models.omniresponseitem;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommandsItem{

	@JsonProperty("id")
	private String id;

	@JsonProperty("type")
	private String type;

	@JsonProperty("logInfo")
	private String logInfo;

	public String getId(){
		return id;
	}

	public String getType(){
		return type;
	}

	public String getLogInfo(){
		return logInfo;
	}
}
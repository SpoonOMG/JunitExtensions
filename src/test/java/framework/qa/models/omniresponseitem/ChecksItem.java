package framework.qa.models.omniresponseitem;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChecksItem{

	@JsonProperty("logInfo")
	private String logInfo;

	@JsonProperty("type")
	private String type;

	@JsonProperty("error")
	private Error error;

	@JsonProperty("specific")
	private Specific specific;

	public String getLogInfo(){
		return logInfo;
	}

	public String getType(){
		return type;
	}

	public Error getError(){
		return error;
	}

	public Specific getSpecific(){
		return specific;
	}
}
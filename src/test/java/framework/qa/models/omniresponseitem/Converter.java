package framework.qa.models.omniresponseitem;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Converter{

	@JsonProperty("logInfo")
	private String logInfo;

	@JsonProperty("type")
	private String type;

	@JsonProperty("specific")
	private Specific specific;

	public String getLogInfo(){
		return logInfo;
	}

	public String getType(){
		return type;
	}

	public Specific getSpecific(){
		return specific;
	}
}
package framework.qa.models.omniresponseitem;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AndsItem{

	@JsonProperty("compare")
	private String compare;

	@JsonProperty("property")
	private String property;

	@JsonProperty("id")
	private String id;

	@JsonProperty("logInfo")
	private String logInfo;

	@JsonProperty("type")
	private String type;

	@JsonProperty("value")
	private String value;

	public String getCompare(){
		return compare;
	}

	public String getProperty(){
		return property;
	}

	public String getId(){
		return id;
	}

	public String getLogInfo(){
		return logInfo;
	}

	public String getType(){
		return type;
	}

	public String getValue(){
		return value;
	}
}
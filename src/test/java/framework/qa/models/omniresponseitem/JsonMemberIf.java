package framework.qa.models.omniresponseitem;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonMemberIf{

	@JsonProperty("compare")
	private String compare;

	@JsonProperty("property")
	private String property;

	@JsonProperty("id")
	private String id;

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

	public String getType(){
		return type;
	}

	public String getValue(){
		return value;
	}
}
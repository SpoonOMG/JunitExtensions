package framework.qa.models.omniresponseitem;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExternalPropertyValue{

	@JsonProperty("property")
	private String property;

	@JsonProperty("id")
	private String id;

	@JsonProperty("type")
	private String type;

	public String getProperty(){
		return property;
	}

	public String getId(){
		return id;
	}

	public String getType(){
		return type;
	}
}
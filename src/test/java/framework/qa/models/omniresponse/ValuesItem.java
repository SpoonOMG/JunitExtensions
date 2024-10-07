package framework.qa.models.omniresponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValuesItem{

	@JsonProperty("id")
	private String id;

	@JsonProperty("value")
	private String value;

	public String getId(){
		return id;
	}

	public String getValue(){
		return value;
	}
}
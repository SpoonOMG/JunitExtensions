package framework.qa.models.omniresponseitem;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Set{

	@JsonProperty("value")
	private String value;

	public String getValue(){
		return value;
	}
}
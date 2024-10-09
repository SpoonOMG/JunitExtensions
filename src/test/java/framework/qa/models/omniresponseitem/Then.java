package framework.qa.models.omniresponseitem;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Then{

	@JsonProperty("externalPropertyValue")
	private ExternalPropertyValue externalPropertyValue;

	@JsonProperty("value")
	private String value;

	public ExternalPropertyValue getExternalPropertyValue(){
		return externalPropertyValue;
	}

	public String getValue(){
		return value;
	}
}
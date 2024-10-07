package framework.qa.models.omniresponseitem;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Then{

	@JsonProperty("externalPropertyValue")
	private ExternalPropertyValue externalPropertyValue;

	public ExternalPropertyValue getExternalPropertyValue(){
		return externalPropertyValue;
	}
}
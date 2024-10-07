package framework.qa.models.omniresponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Style{

	@JsonProperty("width")
	private String width;

	public String getWidth(){
		return width;
	}
}
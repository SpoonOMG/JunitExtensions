package framework.qa.models.omniresponseitem;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Style{
	public String getAlign() {
		return align;
	}

	@JsonProperty("align")
	private String align;

	@JsonProperty("width")
	private String width;

	public String getDirection() {
		return direction;
	}

	@JsonProperty("direction")
	private String direction;

	public String getWidth(){
		return width;
	}
}
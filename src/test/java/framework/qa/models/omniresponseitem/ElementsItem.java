package framework.qa.models.omniresponseitem;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ElementsItem{

	@JsonProperty("component")
	private String component;

	@JsonProperty("visible")
	private boolean visible;

	@JsonProperty("serverFeature")
	private ServerFeature serverFeature;

	@JsonProperty("disabled")
	private boolean disabled;

	@JsonProperty("type")
	private String type;

	@JsonProperty("value")
	private String value;

	public String getComponent(){
		return component;
	}

	public boolean isVisible(){
		return visible;
	}

	public ServerFeature getServerFeature(){
		return serverFeature;
	}

	public boolean isDisabled(){
		return disabled;
	}

	public String getType(){
		return type;
	}

	public String getValue(){
		return value;
	}
}
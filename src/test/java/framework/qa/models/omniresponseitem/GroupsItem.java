package framework.qa.models.omniresponseitem;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import framework.qa.models.omniresponse.ElementsItem;
import framework.qa.models.omniresponse.ServerFeature;
import framework.qa.models.omniresponse.Style;

public class GroupsItem{

	@JsonProperty("excluded")
	private boolean excluded;

	@JsonProperty("component")
	private String component;

	@JsonProperty("elements")
	private List<framework.qa.models.omniresponse.ElementsItem> elements;

	@JsonProperty("logInfo")
	private String logInfo;

	@JsonProperty("visible")
	private boolean visible;

	@JsonProperty("serverFeature")
	private framework.qa.models.omniresponse.ServerFeature serverFeature;

	@JsonProperty("alias")
	private String alias;

	@JsonProperty("disabled")
	private boolean disabled;

	@JsonProperty("style")
	private Style style;

	public boolean isExcluded(){
		return excluded;
	}

	public String getComponent(){
		return component;
	}

	public List<ElementsItem> getElements(){
		return elements;
	}

	public String getLogInfo(){
		return logInfo;
	}

	public boolean isVisible(){
		return visible;
	}

	public ServerFeature getServerFeature(){
		return serverFeature;
	}

	public String getAlias(){
		return alias;
	}

	public boolean isDisabled(){
		return disabled;
	}

	public Style getStyle(){
		return style;
	}
}
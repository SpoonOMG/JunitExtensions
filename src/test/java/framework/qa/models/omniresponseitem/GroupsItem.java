package framework.qa.models.omniresponseitem;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GroupsItem{

	@JsonProperty("excluded")
	private boolean excluded;

	@JsonProperty("component")
	private String component;

	@JsonProperty("visible")
	private boolean visible;

	@JsonProperty("elements")
	private List<ElementsItem> elements;

	@JsonProperty("disabled")
	private boolean disabled;

	@JsonProperty("dependencies")
	private List<Object> dependencies;

	public boolean isExcluded(){
		return excluded;
	}

	public String getComponent(){
		return component;
	}

	public boolean isVisible(){
		return visible;
	}

	public List<ElementsItem> getElements(){
		return elements;
	}

	public boolean isDisabled(){
		return disabled;
	}

	public List<Object> getDependencies(){
		return dependencies;
	}
}
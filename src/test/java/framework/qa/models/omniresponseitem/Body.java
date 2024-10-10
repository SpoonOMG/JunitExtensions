package framework.qa.models.omniresponseitem;

import com.fasterxml.jackson.annotation.JsonProperty;
import framework.qa.models.omniresponse.GroupsItem;

import java.util.List;

public class Body {

	@JsonProperty("component")
	private String component;

	@JsonProperty("groups")
	private List<framework.qa.models.omniresponse.GroupsItem> groups;

	@JsonProperty("id")
	private String id;

	public String getComponent(){
		return component;
	}

	public List<GroupsItem> getGroups(){
		return groups;
	}

	public String getId(){
		return id;
	}
}
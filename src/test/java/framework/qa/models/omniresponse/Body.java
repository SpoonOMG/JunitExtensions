package framework.qa.models.omniresponse;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Body{

	@JsonProperty("component")
	private String component;

	@JsonProperty("groups")
	private List<GroupsItem> groups;

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
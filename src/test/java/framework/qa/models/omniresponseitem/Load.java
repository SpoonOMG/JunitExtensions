package framework.qa.models.omniresponseitem;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Load{

	@JsonProperty("component")
	private String component;

	@JsonProperty("groups")
	private List<GroupsItem> groups;

	@JsonProperty("cacheable")
	private boolean cacheable;

	@JsonProperty("id")
	private String id;

	@JsonProperty("commands")
	private List<Object> commands;

	public String getComponent(){
		return component;
	}

	public List<GroupsItem> getGroups(){
		return groups;
	}

	public boolean isCacheable(){
		return cacheable;
	}

	public String getId(){
		return id;
	}

	public List<Object> getCommands(){
		return commands;
	}
}
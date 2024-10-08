package framework.qa.models.omniresponseitem;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import framework.qa.models.omniresponse.CommandsItem;
import framework.qa.models.omniresponse.GroupsItem;
import framework.qa.models.omniresponse.ServerFeature;

public class Load{

	@JsonProperty("component")
	private String component;

	@JsonProperty("serverFeature")
	private framework.qa.models.omniresponse.ServerFeature serverFeature;

	@JsonProperty("header")
	private String header;

	@JsonProperty("groups")
	private List<framework.qa.models.omniresponse.GroupsItem> groups;

	@JsonProperty("cacheable")
	private boolean cacheable;

	@JsonProperty("id")
	private String id;

	@JsonProperty("logInfo")
	private String logInfo;

	@JsonProperty("defCommandId")
	private String defCommandId;

	@JsonProperty("commands")
	private List<CommandsItem> commands;

	public String getComponent(){
		return component;
	}

	public ServerFeature getServerFeature(){
		return serverFeature;
	}

	public String getHeader(){
		return header;
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

	public String getLogInfo(){
		return logInfo;
	}

	public String getDefCommandId(){
		return defCommandId;
	}

	public List<CommandsItem> getCommands(){
		return commands;
	}
}
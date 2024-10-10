package framework.qa.models.omniresponseitem;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DictionaryEntriesItem{

	@JsonProperty("icon")
	private String icon;

	@JsonProperty("label")
	private String label;

	@JsonProperty("value")
	private String value;

	@JsonProperty("help")
	private String help;

	public String getIcon(){
		return icon;
	}

	public String getLabel(){
		return label;
	}

	public String getValue(){
		return value;
	}

	public String getHelp(){
		return help;
	}
}
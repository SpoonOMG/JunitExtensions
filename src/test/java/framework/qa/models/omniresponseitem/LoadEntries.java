package framework.qa.models.omniresponseitem;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoadEntries{

	@JsonProperty("valueRef")
	private String valueRef;

	@JsonProperty("objectRef")
	private String objectRef;

	@JsonProperty("helpRef")
	private String helpRef;

	@JsonProperty("labelRef")
	private String labelRef;

	public String getValueRef(){
		return valueRef;
	}

	public String getObjectRef(){
		return objectRef;
	}

	public String getHelpRef(){
		return helpRef;
	}

	public String getLabelRef(){
		return labelRef;
	}
}
package framework.qa.models.omniresponseitem;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RulesItem{

	@JsonProperty("then")
	private Then then;

	@JsonProperty("if")
	private JsonMemberIf jsonMemberIf;

	public Then getThen(){
		return then;
	}

	public JsonMemberIf getJsonMemberIf(){
		return jsonMemberIf;
	}
}
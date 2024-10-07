package framework.qa.models.omniresponse;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RulesItem{

	@JsonProperty("then")
	private Then then;

	@JsonProperty("if")
	private JsonMemberIf jsonMemberIf;

	@JsonProperty("ands")
	private List<Object> ands;

	public Then getThen(){
		return then;
	}

	public JsonMemberIf getJsonMemberIf(){
		return jsonMemberIf;
	}

	public List<Object> getAnds(){
		return ands;
	}
}
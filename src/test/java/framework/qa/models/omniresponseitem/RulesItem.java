package framework.qa.models.omniresponseitem;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RulesItem{

	@JsonProperty("then")
	private Then then;

	public Set getSet() {
		return set;
	}

	@JsonProperty("set")
	private Set set;

	@JsonProperty("if")
	private JsonMemberIf jsonMemberIf;

	@JsonProperty("ands")
	private List<AndsItem> ands;

	public Then getThen(){
		return then;
	}

	public JsonMemberIf getJsonMemberIf(){
		return jsonMemberIf;
	}

	public List<AndsItem> getAnds(){
		return ands;
	}
}
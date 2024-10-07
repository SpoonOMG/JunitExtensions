package framework.qa.models.omniresponse;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DependenciesItem{

	@JsonProperty("property")
	private String property;

	@JsonProperty("rules")
	private List<RulesItem> rules;

	public String getProperty(){
		return property;
	}

	public List<RulesItem> getRules(){
		return rules;
	}
}
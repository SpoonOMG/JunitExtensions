package framework.qa.models.omniresponseitem;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Validator{

	@JsonProperty("condition")
	private String condition;

	@JsonProperty("checks")
	private List<ChecksItem> checks;

	@JsonProperty("visible")
	private boolean visible;

	public String getCondition(){
		return condition;
	}

	public List<ChecksItem> getChecks(){
		return checks;
	}

	public boolean isVisible(){
		return visible;
	}
}
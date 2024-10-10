package framework.qa.models.omniresponseitem;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ServerFeature{

	public DataCommand getDataCommand() {
		return dataCommand;
	}

	@JsonProperty("dataCommand")
	private DataCommand dataCommand;


	@JsonProperty("dependencies")
	private List<DependenciesItem> dependencies;

	public List<DependenciesItem> getDependencies(){
		return dependencies;
	}
}
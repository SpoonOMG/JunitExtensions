package framework.qa.models.omniresponseitem;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Data{

	@JsonProperty("arbitrary")
	private Arbitrary arbitrary;

	@JsonProperty("operation")
	private Operation operation;

	public List<ServerAction> getServerActions() {
		return serverActions;
	}

	private List<ServerAction> serverActions;


	public NewService getNewService() {
		return newService;
	}

	private NewService newService;

	public Arbitrary getArbitrary(){
		return arbitrary;
	}

	public Operation getOperation(){
		return operation;
	}
}
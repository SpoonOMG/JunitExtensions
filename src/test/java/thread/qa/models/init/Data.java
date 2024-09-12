package thread.qa.models.init;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data{

	@JsonProperty("clientContext")
	private ClientContext clientContext;

	@JsonProperty("scenario")
	private Scenario scenario;

	@JsonProperty("verifyData")
	private VerifyData verifyData;

	@JsonProperty("operation")
	private Operation operation;

	public void setClientContext(ClientContext clientContext){
		this.clientContext = clientContext;
	}

	public ClientContext getClientContext(){
		return clientContext;
	}

	public void setScenario(Scenario scenario){
		this.scenario = scenario;
	}

	public Scenario getScenario(){
		return scenario;
	}

	public void setVerifyData(VerifyData verifyData){
		this.verifyData = verifyData;
	}

	public VerifyData getVerifyData(){
		return verifyData;
	}

	public void setOperation(Operation operation){
		this.operation = operation;
	}

	public Operation getOperation(){
		return operation;
	}
}
package thread.qa.models.init;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientContext{

	@JsonProperty("employee")
	private Employee employee;

	@JsonProperty("version")
	private String version = "ufo_1.0";

	public void setEmployee(Employee employee){
		this.employee = employee;
	}

	public Employee getEmployee(){
		return employee;
	}

	public void setVersion(String version){
		this.version = version;
	}

	public String getVersion(){
		return version;
	}
}
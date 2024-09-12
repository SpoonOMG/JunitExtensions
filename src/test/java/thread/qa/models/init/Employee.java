package thread.qa.models.init;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee{

	@JsonProperty("fullName")
	private String fullName = "Федор Иванович";

	@JsonProperty("position")
	private String position = "Эксперт";

	@JsonProperty("department")
	private Department department;

	public void setFullName(String fullName){
		this.fullName = fullName;
	}

	public String getFullName(){
		return fullName;
	}

	public void setPosition(String position){
		this.position = position;
	}

	public String getPosition(){
		return position;
	}

	public void setDepartment(Department department){
		this.department = department;
	}

	public Department getDepartment(){
		return department;
	}
}
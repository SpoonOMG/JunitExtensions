package framework.qa.models.init;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Department{

	@JsonProperty("branchCode")
	private String branchCode = "099/1039";

	@JsonProperty("code")
	private String code = "000";

	@JsonProperty("address")
	private Address address;

	@JsonProperty("fullName")
	private String fullName = "099/1039 ДО Головной офис Цветной бульвар";

	public void setBranchCode(String branchCode){
		this.branchCode = branchCode;
	}

	public String getBranchCode(){
		return branchCode;
	}

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setAddress(Address address){
		this.address = address;
	}

	public Address getAddress(){
		return address;
	}

	public void setFullName(String fullName){
		this.fullName = fullName;
	}

	public String getFullName(){
		return fullName;
	}
}
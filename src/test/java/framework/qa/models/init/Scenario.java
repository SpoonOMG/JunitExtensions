package framework.qa.models.init;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Scenario{

	@JsonProperty("kindCode")
	private String kindCode= "CARD";

	@JsonProperty("code")
	private String code = "000";

	@JsonProperty("systemInit")
	private String systemInit = "OMNI-OKS-CARDS-CLOSE";

	@JsonProperty("systemCheck")
	private String systemCheck = "OMNI-OKS-CARDS-CLOSE";

	@JsonProperty("kindName")
	private String kindName = "OMNI-OKS-CARDS-CLOSE";

	@JsonProperty("name")
	private String name = "OMNI-OKS-CARDS-CLOSE";

	@JsonProperty("active")
	private boolean active = true;

	@JsonProperty("id")
	private String id = "sc_730e5106e58bc19";

	@JsonProperty("categoryCode")
	private String categoryCode = "CARDS";

	@JsonProperty("categoryName")
	private String categoryName = "CARDS";

	@JsonProperty("systemExecute")
	private String systemExecute = "OMNI-OKS-CARDS-CLOSE";

	@JsonProperty("typeCode")
	private String typeCode = "#EMPTY#";

	public void setKindCode(String kindCode){
		this.kindCode = kindCode;
	}

	public String getKindCode(){
		return kindCode;
	}

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setSystemInit(String systemInit){
		this.systemInit = systemInit;
	}

	public String getSystemInit(){
		return systemInit;
	}

	public void setSystemCheck(String systemCheck){
		this.systemCheck = systemCheck;
	}

	public String getSystemCheck(){
		return systemCheck;
	}

	public void setKindName(String kindName){
		this.kindName = kindName;
	}

	public String getKindName(){
		return kindName;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setActive(boolean active){
		this.active = active;
	}

	public boolean isActive(){
		return active;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setCategoryCode(String categoryCode){
		this.categoryCode = categoryCode;
	}

	public String getCategoryCode(){
		return categoryCode;
	}

	public void setCategoryName(String categoryName){
		this.categoryName = categoryName;
	}

	public String getCategoryName(){
		return categoryName;
	}

	public void setSystemExecute(String systemExecute){
		this.systemExecute = systemExecute;
	}

	public String getSystemExecute(){
		return systemExecute;
	}

	public void setTypeCode(String typeCode){
		this.typeCode = typeCode;
	}

	public String getTypeCode(){
		return typeCode;
	}
}
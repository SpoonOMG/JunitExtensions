package framework.qa.models.init;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address{

	@JsonProperty("city")
	private String city = "Москва";

	@JsonProperty("fullAddress")
	private String fullAddress = "КВ5";

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setFullAddress(String fullAddress){
		this.fullAddress = fullAddress;
	}

	public String getFullAddress(){
		return fullAddress;
	}
}
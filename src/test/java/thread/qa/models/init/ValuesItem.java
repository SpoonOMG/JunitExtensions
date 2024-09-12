package thread.qa.models.init;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValuesItem{

	@JsonProperty("id")
	private String id;

	@JsonProperty("value")
	private String value;

	public ValuesItem(String id, String value) {
		this.id = id;
		this.value = value;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setValue(String value){
		this.value = value;
	}

	public String getValue(){
		return value;
	}
}
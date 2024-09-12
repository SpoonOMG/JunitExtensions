package thread.qa.models.init;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class VerifyData{

	@JsonProperty("values")
	private List<ValuesItem> values;

	public void setValues(List<ValuesItem> values){
		this.values = values;
	}

	public List<ValuesItem> getValues(){
		return values;
	}
}
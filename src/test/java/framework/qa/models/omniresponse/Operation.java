package framework.qa.models.omniresponse;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Operation{

	@JsonProperty("values")
	private List<ValuesItem> values;

	public List<ValuesItem> getValues(){
		return values;
	}
}
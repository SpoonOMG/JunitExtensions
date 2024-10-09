package framework.qa.models.omniresponseitem;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MiddleOfficeDsa{

	@JsonProperty("records")
	private List<Object> records;

	public List<Object> getRecords(){
		return records;
	}
}
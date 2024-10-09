package framework.qa.models.omniresponseitem;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Specific{

	@JsonProperty("dictionaryEntries")
	private List<DictionaryEntriesItem> dictionaryEntries;

	@JsonProperty("pattern")
	private String pattern;

	public List<DictionaryEntriesItem> getDictionaryEntries(){
		return dictionaryEntries;
	}

	public String getPattern(){
		return pattern;
	}
}
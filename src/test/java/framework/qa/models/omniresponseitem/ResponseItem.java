package framework.qa.models.omniresponseitem;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseItem{

	@JsonProperty("data")
	private Data data;

	@JsonProperty("screen")
	private Screen screen;

	@JsonProperty("actualTimestamp")
	private long actualTimestamp;

	@JsonProperty("status")
	private String status;

	public Data getData(){
		return data;
	}

	public Screen getScreen(){
		return screen;
	}

	public long getActualTimestamp(){
		return actualTimestamp;
	}

	public String getStatus(){
		return status;
	}
}
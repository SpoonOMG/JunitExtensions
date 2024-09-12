package thread.qa.models.init;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Meta{

	@JsonProperty("channel")
	private String channel = "ufo";

	public void setChannel(String channel){
		this.channel = channel;
	}

	public String getChannel(){
		return channel;
	}
}
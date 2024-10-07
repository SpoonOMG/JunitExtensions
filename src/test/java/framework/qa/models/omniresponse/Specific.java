package framework.qa.models.omniresponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Specific{

	@JsonProperty("header")
	private String header;

	@JsonProperty("body")
	private Body body;

	@JsonProperty("fileName")
	private String fileName;

	@JsonProperty("url")
	private String url;

	public String getHeader(){
		return header;
	}

	public Body getBody(){
		return body;
	}

	public String getFileName(){
		return fileName;
	}

	public String getUrl(){
		return url;
	}
}
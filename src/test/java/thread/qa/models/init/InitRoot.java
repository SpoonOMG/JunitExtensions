package thread.qa.models.init;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InitRoot {

	@JsonProperty("data")
	private Data data;

	@JsonProperty("meta")
	private Meta meta;

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	public void setMeta(Meta meta){
		this.meta = meta;
	}

	public Meta getMeta(){
		return meta;
	}
}
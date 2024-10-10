package framework.qa.models.requestData;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import framework.qa.models.init.Data;
import framework.qa.models.init.Meta;

import java.io.Serializable;

public final class OmniRequestItem implements Serializable {
    @JsonProperty("meta")
    private OmniRequestMeta meta;
    @JsonProperty("data")
    private RequestData data;



    public OmniRequestItem(RequestData data, OmniRequestMeta meta) {
        this.meta = meta;
        this.data = data;
    }

    public OmniRequestItem(OmniRequestMeta meta, RequestData data) {
        this.meta = meta;
        this.data = data;
    }

    public OmniRequestItem() {
    }


    public RequestData getData() {
        return data;
    }

    public void setData(RequestData data) {
        this.data = data;
    }

    public OmniRequestMeta getMeta() {
        return meta;
    }

    public void setMeta(OmniRequestMeta meta) {
        this.meta = meta;
    }
}

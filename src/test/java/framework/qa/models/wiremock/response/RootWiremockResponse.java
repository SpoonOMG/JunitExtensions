package framework.qa.models.wiremock.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RootWiremockResponse {
    @JsonProperty("id")
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    String id;

    @JsonProperty("request")
    public Request getRequest() {
        return this.request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    Request request;

    @JsonProperty("response")
    public Response getResponse() {
        return this.response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    Response response;

    @JsonProperty("uuid")
    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    String uuid;
}
package framework.qa.models.wiremock.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseHeaders {
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @JsonProperty("Content-Type")
    public String contentType;
}

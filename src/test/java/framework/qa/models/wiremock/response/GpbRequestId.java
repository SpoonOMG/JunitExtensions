package framework.qa.models.wiremock.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GpbRequestId{
    @JsonProperty("equalTo")
    public String getEqualTo() {
        return this.equalTo; }
    public void setEqualTo(String equalTo) {
        this.equalTo = equalTo; }
    String equalTo;
}

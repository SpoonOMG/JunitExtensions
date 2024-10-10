package framework.qa.models.wiremock.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Headers{
    @JsonProperty("gpb-requestId")
    public GpbRequestId getGpbrequestId() {
        return this.gpbrequestId; }
    public void setGpbrequestId(GpbRequestId gpbrequestId) {
        this.gpbrequestId = gpbrequestId; }
    GpbRequestId gpbrequestId;
    @JsonProperty("Content-Type")
    public String getContentType() {
        return this.contentType; }
    public void setContentType(String contentType) {
        this.contentType = contentType; }
    String contentType;
}

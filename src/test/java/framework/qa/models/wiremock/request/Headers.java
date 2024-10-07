package framework.qa.models.wiremock.request;

import com.fasterxml.jackson.annotation.JsonProperty;
public class Headers {
    public GpbRequestId gpbrequestId;

    public Headers(GpbRequestId gpbrequestId) {
        this.gpbrequestId = gpbrequestId;
    }


    @JsonProperty("gpb-requestId")
    public GpbRequestId getGpbrequestId() {
        return gpbrequestId;
    }

    public void setGpbrequestId(GpbRequestId gpbrequestId) {
        this.gpbrequestId = gpbrequestId;
    }

}

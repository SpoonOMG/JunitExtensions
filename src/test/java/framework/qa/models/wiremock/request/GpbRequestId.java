package framework.qa.models.wiremock.request;

public class GpbRequestId {
    public String equalTo;

    public GpbRequestId(String equalTo) {
        this.equalTo = equalTo;
    }


    public String getEqualTo() {
        return equalTo;
    }

    public void setEqualTo(String equalTo) {
        this.equalTo = equalTo;
    }
}

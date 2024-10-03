package framework.qa.models.wiremock.request;

public class Response {
    public int status;
    public ResponseHeaders headers;
    public String body;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }



    public void setHeaders(ResponseHeaders headers) {
        this.headers = headers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

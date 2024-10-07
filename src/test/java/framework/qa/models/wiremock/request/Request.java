package framework.qa.models.wiremock.request;

public class Request {
    public String method;
    public String url;
    public Headers headers;

    public Request(String method, String url, Headers headers) {
        this.method = method;
        this.url = url;
        this.headers = headers;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Headers getHeaders() {
        return headers;
    }

    public void setHeaders(Headers headers) {
        this.headers = headers;
    }
}

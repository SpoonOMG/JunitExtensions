package framework.qa.models.wiremock.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Request{
    @JsonProperty("url")
    public String getUrl() {
        return this.url; }
    public void setUrl(String url) {
        this.url = url; }
    String url;
    @JsonProperty("method")
    public String getMethod() {
        return this.method; }
    public void setMethod(String method) {
        this.method = method; }
    String method;
    @JsonProperty("headers")
    public Headers getHeaders() {
        return this.headers; }
    public void setHeaders(Headers headers) {
        this.headers = headers; }
    Headers headers;
}

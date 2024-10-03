package framework.qa.models.wiremock.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response{
    @JsonProperty("status")
    public int getStatus() {
        return this.status; }
    public void setStatus(int status) {
        this.status = status; }
    int status;
    @JsonProperty("body")
    public String getBody() {
        return this.body; }
    public void setBody(String body) {
        this.body = body; }
    String body;
    @JsonProperty("headers")
    public Headers getHeaders() {
        return this.headers; }
    public void setHeaders(Headers headers) {
        this.headers = headers; }
    Headers headers;
}

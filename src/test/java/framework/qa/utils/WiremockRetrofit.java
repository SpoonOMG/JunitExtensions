package framework.qa.utils;

import framework.qa.config.Config;
import framework.qa.models.wiremock.request.*;
import framework.qa.models.wiremock.response.RootWiremockResponse;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.junit.jupiter.api.Test;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static okhttp3.logging.HttpLoggingInterceptor.*;

public class WiremockRetrofit {
    protected static final Config CFG = Config.getInstance();
    protected String uuid;
    OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder().addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(Level.BODY));

    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(CFG.wiremockUrl())
            .client(okHttpClientBuilder.build())
            .addConverterFactory(JacksonConverterFactory.create())
            .build();

    private final ExampleService mocks = retrofit.create(ExampleService.class);


    public void wiremockSend(String mockPath, String enpointMapping, String att, String value, String gpbRequestIdMapping) throws IOException {
        JsonAttChanger js = new JsonAttChanger();
        String jsonBody = js.apply(mockPath, att, value);

        WiremockRoot wiremockRoot = new WiremockRoot();
        Request request = new Request();

        Headers headersRequest = new Headers();
        GpbRequestId gpbRequestId = new GpbRequestId();
        gpbRequestId.setEqualTo(gpbRequestIdMapping);
        headersRequest.setGpbrequestId(gpbRequestId);
        request.setMethod("POST");
        request.setUrl(enpointMapping);
        request.setHeaders(headersRequest);
        Response response = new Response();
        ResponseHeaders responseHeaders = new ResponseHeaders();
        responseHeaders.setContentType("application/json");
        response.setHeaders(responseHeaders);
        response.setStatus(200);
        response.setBody(jsonBody);
        wiremockRoot.setRequest(request);
        wiremockRoot.setResponse(response);


        retrofit2.Response<RootWiremockResponse> wiremockResponse = mocks.makeMock(wiremockRoot).execute();
        RootWiremockResponse rootWiremockResponse = wiremockResponse.body();
        uuid = rootWiremockResponse.getUuid();

        System.out.println(uuid);
    }

    public void wiremockRemove() throws IOException {
        mocks.deleteMock(uuid).execute();

    }

    @Test
    void t() throws IOException {
        wiremockSend("wiremock/product-cards/default.json",
                "/omni-information-card/api/v3/client/product/cards",
                "actualTimestamp",
                "1234",
                "123234");
        wiremockRemove();
    }


}

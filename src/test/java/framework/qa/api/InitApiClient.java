package framework.qa.api;

import framework.qa.models.omniresponseitem.ResponseItem;
import framework.qa.models.requestData.OmniRequestItem;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

import java.io.IOException;

public class InitApiClient extends ApiClient{
    private String guid = "6F57A2C3507C4D6AA1A70E9C8C8CF919";
    private final InitApi initApi;


    public InitApiClient(OkHttpClient okHttpClient, Retrofit retrofit, InitApi initApi) {
        super(okHttpClient, retrofit);
        this.initApi = retrofit.create(InitApi.class);
    }

    public InitApiClient() {
        super(CFG.baseUrl());
        this.initApi = retrofit.create(InitApi.class);
    }

    public ResponseItem initRequest(String gpbRequestId, OmniRequestItem body) throws IOException {
        return initApi.initRequest(CFG.token(),gpbRequestId,guid,body).execute().body();

    }


}

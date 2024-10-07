package framework.qa.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import framework.qa.models.omniresponse.ResponseRoot;
import framework.qa.models.omniresponseitem.ResponseItem;
import framework.qa.models.requestData.OmniRequestItem;
import framework.qa.models.wiremock.request.WiremockRoot;
import framework.qa.models.wiremock.response.RootWiremockResponse;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface InitApi {

    @POST("api/v1/metadata/init")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Call<ResponseItem> initRequest(
            @Header("Authorization") String authorization,
            @Header("gpb-requestId") String gpbRequestId,
            @Header("gpb-guid") String gpbGuid,
            @Body OmniRequestItem body);
}

package framework.qa.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import framework.qa.models.omniresponseitem.ResponseItem;
import framework.qa.models.requestData.OmniRequestItem;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface OmniApi {

    @POST("api/v1/metadata/init")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Call<ResponseItem> initRequest(
            @Header("Authorization") String authorization,
            @Header("gpb-requestId") String gpbRequestId,
            @Header("gpb-guid") String gpbGuid,
            @Body OmniRequestItem body);


    @POST("api/v1/metadata/check")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Call<ResponseItem> checkRequest(
            @Header("Authorization") String authorization,
            @Header("gpb-requestId") String gpbRequestId,
            @Header("gpb-guid") String gpbGuid,
            @Body OmniRequestItem body);


    @POST("api/v1/metadata/load")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Call<ResponseItem> loadRequest(
            @Header("Authorization") String authorization,
            @Header("gpb-requestId") String gpbRequestId,
            @Header("gpb-guid") String gpbGuid,
            @Body OmniRequestItem body);


}

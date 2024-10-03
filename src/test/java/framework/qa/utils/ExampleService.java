package framework.qa.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import framework.qa.models.wiremock.request.WiremockRoot;
import framework.qa.models.wiremock.response.RootWiremockResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.POST;
import retrofit2.http.Path;

// Интерфейс для вашего RESTful сервиса
interface ExampleService {
    @POST("/__admin/mappings")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Call<RootWiremockResponse> makeMock(@Body WiremockRoot body);

    @DELETE("/__admin/mappings/{uuid}")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Call<Void> deleteMock(@Path("uuid")String uuid);
}
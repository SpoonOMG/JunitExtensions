package framework.qa.test.example;

import framework.qa.api.InitApi;
import framework.qa.api.InitApiClient;
import framework.qa.config.Config;
import framework.qa.consts.Params;
import framework.qa.jupiter.annotations.*;
import framework.qa.jupiter.callbacks.InitRqExtension;
import framework.qa.jupiter.callbacks.WmockExtension;
//import framework.qa.jupiter.parameters.InitApiResolver;
import framework.qa.jupiter.parameters.InitRequestResolver;
import framework.qa.models.omniresponseitem.Data;
import framework.qa.models.omniresponseitem.Operation;
import framework.qa.models.omniresponseitem.ResponseItem;
import framework.qa.models.omniresponseitem.ValuesItem;
import framework.qa.models.requestData.OmniRequestItem;
import framework.qa.models.requestData.ScreenValueBack;
import framework.qa.models.wiremock.response.RootWiremockResponse;
import framework.qa.utils.ServiceUtils;
import framework.qa.values.TestDataValues;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.*;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static java.util.stream.Collectors.joining;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith({WmockExtension.class, InitRequestResolver.class
})

public class InitVeteranTest {
    private final InitApiClient initApi = new InitApiClient();

//
//    @BeforeEach
//    void tt()
//    {
//        final List<ScreenValueBack> valueBackList = new ArrayList<>();
//        valueBackList.add(new ScreenValueBack(Params.LOGIN, TestDataValues.login));
//        valueBackList.add(new ScreenValueBack(Params.USER_FULL_NAME, TestDataValues.userFullName));
//        valueBackList.add(new ScreenValueBack(Params.TITLE, TestDataValues.title));
//        valueBackList.add(new ScreenValueBack(Params.BRANCH_CODE, TestDataValues.branchCode));
//        valueBackList.add(new ScreenValueBack(Params.BRANCH_UNIT_CODE, TestDataValues.branchUnitCode));
//        valueBackList.add(new ScreenValueBack(Params.VIRTUAL_NUM, TestDataValues.virtualNum));
//        valueBackList.add(new ScreenValueBack(Params.BRANCH_CODE_5NT, TestDataValues.branchCode5nt));
//        valueBackList.add(new ScreenValueBack(Params.ADDRESS_IS_INCORRECT, TestDataValues.addressIsIncorrect));
//    }


    @Wmocks({
            @Wmock(
                    enpointMapping = "/omni-information/api/v2/client/search",
                    mockFile = "wiremock/client-search/default.json",
                    pathToField = "data.clients.[?(@.base.guid==\"6F57A2C3507C4D6AA1A70E9C8C8CF919\")].base.hid",
                    value = "1234"
            ),
            @Wmock(
                    enpointMapping = "/omni-information-card/api/v3/client/product/cards",
                    mockFile = "wiremock/product-cards/default.json",
                    pathToField = "actualTimestamp",
                    value = "1234"
            )})
    @Test
    void exampleTest(
                     @InitRequest OmniRequestItem init
    ) throws IOException {
        String gpbrequestId = "gpbrequestIddd";
        String myFieldName = "##requestId";
        ResponseItem response = initApi.initRequest(gpbrequestId, init);

        List<ValuesItem> operationValues = response.getData().getOperation().getValues();
        String value = Optional.ofNullable(response.getData()).map(Data::getOperation).map(Operation::getValues)
                .flatMap(valuesItems -> ServiceUtils.extractValue(operationValues, myFieldName))
                .map(ValuesItem::getValue).orElse(null);

        System.out.println(value);
        Assertions.assertEquals(gpbrequestId, value);

    }

}





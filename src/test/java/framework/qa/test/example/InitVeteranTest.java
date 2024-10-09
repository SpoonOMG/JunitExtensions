package framework.qa.test.example;

import framework.qa.api.OmniApiClient;
import framework.qa.jupiter.annotations.*;
import framework.qa.jupiter.callbacks.WmockExtension;
//import framework.qa.jupiter.parameters.InitApiResolver;
import framework.qa.jupiter.parameters.InitRequestResolver;
import framework.qa.models.omniresponseitem.Data;
import framework.qa.models.omniresponseitem.Operation;
import framework.qa.models.omniresponseitem.ResponseItem;
import framework.qa.models.omniresponseitem.ValuesItem;
import framework.qa.models.requestData.OmniRequestItem;
import framework.qa.models.wiremock.response.RootWiremockResponse;
import framework.qa.utils.ServiceUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

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
    private final OmniApiClient initApi = new OmniApiClient();


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
    void exampleTest(RootWiremockResponse rwr,
                     @InitRequest OmniRequestItem init
    ) throws IOException {
        String gpbrequestId = rwr.getRequest().getHeaders().getGpbrequestId().getEqualTo();
        ;
        String myFieldName = "CELLPHONE";

        ResponseItem response = initApi.initRequest(gpbrequestId, init);

        List<ValuesItem> operationValues = response.getData().getOperation().getValues();
        String value = Optional.ofNullable(response.getData()).map(Data::getOperation).map(Operation::getValues)
                .flatMap(valuesItems -> ServiceUtils.extractValue(operationValues, myFieldName))
                .map(ValuesItem::getValue).orElse(null);

        System.out.println(value);
        Assertions.assertEquals("+79645524477", value);

    }


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
    void exampleTest1(RootWiremockResponse rwr,
                      @InitRequest OmniRequestItem init
    ) throws IOException {
        String gpbrequestId = rwr.getRequest().getHeaders().getGpbrequestId().getEqualTo();
        ;
        String myFieldName = "docSeries";
        ResponseItem response = initApi.initRequest(gpbrequestId, init);

        List<ValuesItem> operationValues = response.getData().getOperation().getValues();

        Assertions.assertEquals("4509", Optional.ofNullable(response.getData()).map(Data::getOperation).map(Operation::getValues)
                .flatMap(valuesItems -> ServiceUtils.extractValue(operationValues, myFieldName))
                .map(ValuesItem::getValue).orElse(null));
    }


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
    void exampleTest2(RootWiremockResponse rwr,
                      @InitRequest OmniRequestItem init
    ) throws IOException {
        String gpbrequestId = rwr.getRequest().getHeaders().getGpbrequestId().getEqualTo();
        ;
        String myFieldName = "##clientPhone";
        ResponseItem response = initApi.initRequest(gpbrequestId, init);

        List<ValuesItem> operationValues = response.getData().getOperation().getValues();
        String value = Optional.ofNullable(response.getData()).map(Data::getOperation).map(Operation::getValues)
                .flatMap(valuesItems -> ServiceUtils.extractValue(operationValues, myFieldName))
                .map(ValuesItem::getValue).orElse(null);

        System.out.println(value);
        Assertions.assertEquals("79645524477", value);
    }


}





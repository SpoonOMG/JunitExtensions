package framework.qa.test.example;

import framework.qa.api.InitApiClient;
import framework.qa.jupiter.annotations.InitRequest;
import framework.qa.jupiter.annotations.Wmock;
import framework.qa.jupiter.annotations.Wmocks;
import framework.qa.jupiter.callbacks.WmockExtension;
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
import java.util.List;
import java.util.Optional;


@ExtendWith({WmockExtension.class, InitRequestResolver.class
})

public class InitVeteranTest2 {
    private final InitApiClient initApi = new InitApiClient();



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
    void exampleTest3( RootWiremockResponse rwr,
                     @InitRequest OmniRequestItem init
    ) throws IOException {
        String gpbrequestId =  rwr.getRequest().getHeaders().getGpbrequestId().getEqualTo();;
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
    void exampleTest4( RootWiremockResponse rwr,
                      @InitRequest OmniRequestItem init
    ) throws IOException {
        String gpbrequestId =  rwr.getRequest().getHeaders().getGpbrequestId().getEqualTo();;
        String myFieldName = "docSeries";
        ResponseItem response = initApi.initRequest(gpbrequestId, init);

        List<ValuesItem> operationValues = response.getData().getOperation().getValues();
        String value = Optional.ofNullable(response.getData()).map(Data::getOperation).map(Operation::getValues)
                .flatMap(valuesItems -> ServiceUtils.extractValue(operationValues, myFieldName))
                .map(ValuesItem::getValue).orElse(null);

        System.out.println(value);
        Assertions.assertEquals("4509", value);

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
    void exampleTest5( RootWiremockResponse rwr,
                       @InitRequest OmniRequestItem init
    ) throws IOException {
        String gpbrequestId =  rwr.getRequest().getHeaders().getGpbrequestId().getEqualTo();;
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





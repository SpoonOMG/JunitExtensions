package framework.qa.jupiter.callbacks;

import framework.qa.api.InitApi;
import framework.qa.api.WiremockApi;
import framework.qa.config.Config;
import framework.qa.jupiter.annotations.InitRq;
import framework.qa.jupiter.annotations.Wmock;
import framework.qa.models.omniresponseitem.ResponseItem;
import framework.qa.models.requestData.*;
import framework.qa.models.wiremock.request.*;
import framework.qa.models.wiremock.response.RootWiremockResponse;
import framework.qa.test.example.InitVeteranTest;
import framework.qa.utils.JsonAttChanger;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.junit.jupiter.api.extension.*;
import org.junit.platform.commons.support.AnnotationSupport;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class InitRqExtension implements BeforeEachCallback, ParameterResolver {
    protected static final Config CFG = Config.getInstance();
    protected String uuid;
    public static final ExtensionContext.Namespace NAMESPACE = ExtensionContext.Namespace.create(InitRqExtension.class);

    private static final OkHttpClient okHttpClient = new OkHttpClient.Builder().addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build();

    private final Retrofit retrofit = new Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(CFG.baseUrl())
            .addConverterFactory(JacksonConverterFactory.create())
            .build();

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        InitApi initApi = retrofit.create(InitApi.class);
        AnnotationSupport.findAnnotation(
                        extensionContext.getRequiredTestMethod(),
                        InitRq.class
                )
                .ifPresent(
                        init -> {
                            OmniRequestItem requestItem = new OmniRequestItem(
                                    new OmniRequestMeta(init.channel()),
                                    new RequestData(new Scenario(null, init.scenarioCode(), null),
                                            new Operation(UUID.randomUUID().toString()),
                                            new ClientContext(),
                                            new VerifyData()
                                    ));

                            try {
                                ResponseItem result = initApi.initRequest(CFG.token(), "123", "1234", requestItem).execute().body();
                                extensionContext.getStore(NAMESPACE).put("init", result);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                );
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().isAssignableFrom(ResponseItem.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return extensionContext.getStore(NAMESPACE).get("init");
    }
}

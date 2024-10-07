package framework.qa.jupiter.callbacks;

import framework.qa.api.WiremockApi;
import framework.qa.config.Config;
import framework.qa.jupiter.annotations.Wmock;
import framework.qa.models.wiremock.request.*;
import framework.qa.models.wiremock.response.RootWiremockResponse;
import framework.qa.utils.JsonAttChanger;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.junit.jupiter.api.extension.*;
import org.junit.platform.commons.support.AnnotationSupport;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.UUID;

public class WmockExtension implements BeforeEachCallback, ParameterResolver, AfterEachCallback {
    protected static final Config CFG = Config.getInstance();
    protected String uuid;
    public static final ExtensionContext.Namespace NAMESPACE = ExtensionContext.Namespace.create(WmockExtension.class);

    private static final OkHttpClient okHttpClient = new OkHttpClient.Builder().addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build();

    private final Retrofit retrofit = new Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(CFG.wiremockUrl())
            .addConverterFactory(JacksonConverterFactory.create())
            .build();

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        WiremockApi wiremockApi = retrofit.create(WiremockApi.class);


        AnnotationSupport.findAnnotation(
                        extensionContext.getRequiredTestMethod(),
                        Wmock.class
                )
                .ifPresent(
                        mock -> {
                            WiremockRoot wiremockRoot = new WiremockRoot(
                                    new Request("POST", mock.enpointMapping(), new Headers(new GpbRequestId(UUID.randomUUID().toString()))),
                                    new Response(200, new ResponseHeaders("application/json"), new JsonAttChanger().apply(mock.mockFile(), mock.pathToField(), mock.value()))
                            );
                            try {
                                RootWiremockResponse result = wiremockApi.makeMock(wiremockRoot).execute().body();
                                uuid = result.getUuid();
                                extensionContext.getStore(NAMESPACE).put("mock", result);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                );
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().isAssignableFrom(RootWiremockResponse.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return extensionContext.getStore(NAMESPACE).get("mock");
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception {
        WiremockApi wiremockApi = retrofit.create(WiremockApi.class);
        wiremockApi.deleteMock(uuid).execute();
    }
}

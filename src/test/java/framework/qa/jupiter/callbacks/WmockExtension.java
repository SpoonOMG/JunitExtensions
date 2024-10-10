package framework.qa.jupiter.callbacks;

import framework.qa.api.WiremockApi;
import framework.qa.config.Config;
import framework.qa.jupiter.annotations.Wmock;
import framework.qa.jupiter.annotations.Wmocks;
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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class WmockExtension implements BeforeEachCallback, ParameterResolver, AfterEachCallback {
    protected static final Config CFG = Config.getInstance();
    protected List<String> uuidList;
    public String gpbrequestId = UUID.randomUUID().toString();
    public static final ExtensionContext.Namespace NAMESPACE = ExtensionContext.Namespace.create(WmockExtension.class);

    private static final OkHttpClient okHttpClient = new OkHttpClient.Builder().addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE))
            .build();

    private final Retrofit retrofit = new Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(CFG.wiremockUrl())
            .addConverterFactory(JacksonConverterFactory.create())
            .build();

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws RuntimeException {
        WiremockApi wiremockApi = retrofit.create(WiremockApi.class);
        AnnotationSupport.findAnnotation(extensionContext.getRequiredTestMethod(),
                Wmocks.class).ifPresent(
                mocks -> {
                    List<RootWiremockResponse> created = new ArrayList<>();
                    for (Wmock wmock : mocks.value()) {
                        RootWiremockResponse result = null;
                        try {
                            result = wiremockApi.makeMock(new WiremockRoot(
                                    new Request("POST", wmock.enpointMapping(), new Headers(new GpbRequestId(gpbrequestId))),
                                    new Response(200, new ResponseHeaders("application/json"), new JsonAttChanger().apply(wmock.mockFile(), wmock.pathToField(), wmock.value()))
                            )).execute().body();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
//                        uuid = result.getUuid();
//                        System.out.println("МОЙ ЮИД----->"+uuid);
                        created.add(result);
                    }
                    extensionContext.getStore(NAMESPACE).put(extensionContext.getUniqueId(), created);

                }
        );
        AnnotationSupport.findAnnotation(
                        extensionContext.getRequiredTestMethod(),
                        Wmock.class
                )
                .ifPresent(
                        mock -> {
                            WiremockRoot wiremockRoot = new WiremockRoot(
                                    new Request("POST", mock.enpointMapping(), new Headers(new GpbRequestId(gpbrequestId))),
                                    new Response(200, new ResponseHeaders("application/json"), new JsonAttChanger().apply(mock.mockFile(), mock.pathToField(), mock.value()))
                            );
                            try {
                                RootWiremockResponse result = wiremockApi.makeMock(wiremockRoot).execute().body();
//                                uuid = result.getUuid();
                                extensionContext.getStore(NAMESPACE).put(extensionContext.getUniqueId(), result);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                );
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        Class<?> type = parameterContext.getParameter().getType();


        return type.isAssignableFrom(RootWiremockResponse.class) || type.isAssignableFrom(RootWiremockResponse[].class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        Class<?> type = parameterContext.getParameter().getType();
        List<RootWiremockResponse> createdMocks = extensionContext.getStore(NAMESPACE).get(extensionContext.getUniqueId(), List.class);

        return type.isAssignableFrom(RootWiremockResponse.class) ? createdMocks.get(0) : createdMocks.toArray();
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception {
        WiremockApi wiremockApi = retrofit.create(WiremockApi.class);
        List<RootWiremockResponse> removeMocks = extensionContext.getStore(NAMESPACE).get(extensionContext.getUniqueId(), List.class);

        AnnotationSupport.findAnnotation(extensionContext.getRequiredTestMethod(),
                Wmocks.class).ifPresent(
                mocks -> {
                    for (RootWiremockResponse rwr : removeMocks) {
                        try {
                            wiremockApi.deleteMock(rwr.getUuid()).execute();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
        AnnotationSupport.findAnnotation(extensionContext.getRequiredTestMethod(),
                Wmock.class).ifPresent(
                mocks -> {
                    for (RootWiremockResponse rwr : removeMocks) {
                        try {
                            wiremockApi.deleteMock(rwr.getUuid()).execute();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
    }
}

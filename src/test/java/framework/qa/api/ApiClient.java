package framework.qa.api;

import framework.qa.config.Config;
import okhttp3.Interceptor;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public abstract class ApiClient {

    protected static final Config CFG = Config.getInstance();

    protected final OkHttpClient okHttpClient;
    protected final Retrofit retrofit;

    public ApiClient(String baseUrl) {
        this(baseUrl, false, JacksonConverterFactory.create(), HttpLoggingInterceptor.Level.BODY);
    }


    public ApiClient(OkHttpClient okHttpClient, Retrofit retrofit) {
        this.okHttpClient = okHttpClient;
        this.retrofit = retrofit;
    }


    public ApiClient(String baseUrl,
                     boolean followRedirect,
                     Converter.Factory converter,
                     HttpLoggingInterceptor.Level loggingLevel,
                     Interceptor... interceptors) {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        if (interceptors != null) {
            for (Interceptor interceptor : interceptors) {
                okHttpClientBuilder.addNetworkInterceptor(interceptor);
            }
        }
        this.okHttpClient = okHttpClientBuilder.addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(loggingLevel))
                .followRedirects(followRedirect)
                .build();

        this.retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(converter)
                .client(this.okHttpClient)
                .build();
    }


}

package br.edu.ifpb.analyzerQuestions.stackExchangeAPI;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class StackExchangeAPI  {

    public static final double VERSION = 2.2;
    public static final String SITE_WITH_VERSION = "https://api.stackexchange.com/" + VERSION;

    private final String key;
    private final RestAdapter.Builder builder;
    private String accessToken;

    public StackExchangeAPI(String key) {
        this.key = key;
        
        builder = new RestAdapter.Builder()
            .setEndpoint(SITE_WITH_VERSION)
            .setErrorHandler(new StackExchangeErrorHandler())
            .setLogLevel(RestAdapter.LogLevel.FULL)
            .setConverter(new GsonConverter(this.gsonBuilder(new Gson())));
    }

    public void authorize(String accessToken) {
        this.accessToken = accessToken;
    }

    public StackExchangeSite getSiteService(final String site) {
        return builder.setRequestInterceptor(new RequestInterceptor() {
                
                public void intercept(RequestFacade request) {
                    request.addQueryParam("site", site);
                    request.addQueryParam("key", key);
                    request.addQueryParam("access_token", accessToken);
                    request.addQueryParam("filter","!9YdnSJ*_T");
                }
            }).build().create(StackExchangeSite.class);
    }
    
    public Gson gsonBuilder(Gson gson){
        gson = new GsonBuilder()
        		.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE_WITH_SPACES).create();
        return gson;
    }
}

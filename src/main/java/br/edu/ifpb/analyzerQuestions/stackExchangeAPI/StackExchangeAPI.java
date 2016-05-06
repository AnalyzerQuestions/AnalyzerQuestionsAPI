package br.edu.ifpb.analyzerQuestions.stackExchangeAPI;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class StackExchangeAPI {

	public static final double VERSION = 2.2;
	public static final String SITE_WITH_VERSION = "https://api.stackexchange.com/"
			+ VERSION;

	private final String key;
	private String accessToken;
	private final RestAdapter.Builder builder;

	public StackExchangeAPI(String key) {
		this.key = key;

		builder = new RestAdapter.Builder().setEndpoint(SITE_WITH_VERSION)
				.setErrorHandler(new StackExchangeError())
				.setLogLevel(RestAdapter.LogLevel.FULL)
				.setConverter(new GsonConverter(this.gsonBuilder(new Gson())));
	}

	public void authorize(String accessToken) {
		this.accessToken = accessToken;
	}

	public IStackExchange getSiteService(final String site) {
		return builder.setRequestInterceptor(new RequestInterceptor() {

			public void intercept(RequestFacade request) {
				request.addQueryParam("site", site);
				request.addQueryParam("key", key);
				request.addQueryParam("access_token", accessToken);
				
				//Filtro inseguro
				request.addQueryParam("unsafe", "true");
				
				//Filtro pega apenas alguns fields de uma question
				request.addQueryParam("filter", "!)re8-BDP6GTMm0itK0*9");
			}
		}).build().create(IStackExchange.class);
	}

	public Gson gsonBuilder(Gson gson) {
		gson = new GsonBuilder().setFieldNamingPolicy(
				FieldNamingPolicy.UPPER_CAMEL_CASE_WITH_SPACES).create();
		return gson;
	}
}

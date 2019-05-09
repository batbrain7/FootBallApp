package com.example.mohitkumar.footballapp.di.modules;


import android.util.Log;

import com.example.mohitkumar.footballapp.FootBallApplication;
import com.example.mohitkumar.footballapp.Utils.Utils;
import com.example.mohitkumar.footballapp.data.auth.AuthHolder;
import com.example.mohitkumar.footballapp.data.teams.TeamResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.github.jasminb.jsonapi.retrofit.JSONAPIConverterFactory;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Module(includes = ApiModule.class)
public class NetworkModule {

    public static final String TAG = "FootBall App Log";

    @Provides
    @Singleton
    ObjectMapper providesObjectMapper() {
        return new ObjectMapper()
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                .setSerializationInclusion(JsonInclude.Include.NON_ABSENT);
    }

    @Provides
    Class[] providesMappedClasses() {
        return new Class[] {TeamResponse.class};
    }

    @Provides
    @Singleton
    @Named("jsonapi")
    Converter.Factory providesJsonApiFactory(ObjectMapper objectMapper, Class... mappedClasses) {
        return new JSONAPIConverterFactory(objectMapper, mappedClasses);
    }

    @Provides
    @Singleton
    @Named("jackson")
    Converter.Factory providesJacksonFactory(ObjectMapper objectMapper) {
        return JacksonConverterFactory.create(objectMapper);
    }

    @Provides
    @Singleton
    Cache providesCache() {
        int cacheSize = 10 * 1024 * 1024; // 10 MB
        return new Cache(FootBallApplication.context.getCacheDir(), cacheSize);
    }

    @Provides
    @Singleton
    CallAdapter.Factory providesCallAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }

    @Provides
    @Singleton
    OkHttpClient providesOkHttpClient(Cache cache) {
        return new OkHttpClient.Builder()
                .cache(cache)
                .addNetworkInterceptor(chain -> {
                    Response response = chain.proceed(chain.request());
                    CacheControl cacheControl =
                            new CacheControl.Builder().maxAge(1, TimeUnit.MINUTES).build();
                    return response.newBuilder()
                            .removeHeader("pragma")
                            .removeHeader("Cache-Control")
                            .header("Cache-Control", cacheControl.toString())
                            .build();
                })
                .build();
    }

    @Provides
    @Singleton
    @Named("authenticator")
    Interceptor authenticator(AuthHolder authHolder) {
        return chain -> {
            Request original = chain.request();

            String authorization = authHolder.getAuthorization();
            if (authorization == null) {
                Log.d(TAG, "Someone tried to access resources without auth token. Maybe auth request?");
                return chain.proceed(original);
            }

            Request request = original.newBuilder()
                    .header("X-Auth-Token", authorization)
                    .method(original.method(), original.body())
                    .build();

            return chain.proceed(request);
        };
    }

    @Provides
    @Singleton
    Retrofit providesRetrofitBuilder(CallAdapter.Factory callAdapterFactory,
                                     OkHttpClient client, @Named("jackson") Converter.Factory factory) {
        return new Retrofit.Builder()
                .client(client)
                .addConverterFactory(factory)
                .addCallAdapterFactory(callAdapterFactory)
                .baseUrl("http://api.football-data.org/v2/competitions/")
                .build();
    }
}

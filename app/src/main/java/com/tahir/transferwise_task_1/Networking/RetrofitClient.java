package com.tahir.transferwise_task_1.Networking;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitClient {

    private static Retrofit mInstance;
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    private static HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

    public static Retrofit getRetrofitInstance() {

        //adding interceptor in retrofit API call to log request and response data
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(logging);
        httpClient.connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS);


        if (mInstance == null) {
        mInstance = new Retrofit.Builder()
        .baseUrl(ApiConstants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient.build())
        .build();
        }
        return mInstance;
        }
        }
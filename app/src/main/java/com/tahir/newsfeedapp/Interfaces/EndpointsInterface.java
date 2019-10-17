package com.tahir.newsfeedapp.Interfaces;

import com.tahir.newsfeedapp.Models.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EndpointsInterface {
    @GET("top-headlines")
    Call<News> getNewsList(@Query("country") String country,
                           @Query("apiKey") String apiKey);

}




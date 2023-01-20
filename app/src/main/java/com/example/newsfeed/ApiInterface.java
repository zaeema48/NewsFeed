package com.example.newsfeed;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    String BASE_URL="https://newsapi.org/v2/";

    //THIS IS AN INTERFACE FOR RETROFIT LIBRARY IN WHICH WE HAVE DEFINED METHODS THAT WE NEED TO CALL
    //FROM RETROFIT LIBRARY


    //The @GET annotation is a request method designator and corresponds to the similarly named HTTP method.
    @GET("top-headlines")
    Call<MainNews> getNews(
            @Query("country") String country,
            @Query("pageSize") int pagesize,
            @Query("apiKey")String apikey
    );

    //top headlines for specific categories
    @GET("top-headlines")
    Call<MainNews> getCategroyNews(
            @Query("country") String country,
            @Query("pageSize") String pagesize,
            @Query("category") int category,
            @Query("apiKey")String apikey
    );
}

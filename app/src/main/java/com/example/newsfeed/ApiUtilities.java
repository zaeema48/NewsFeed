package com.example.newsfeed;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtilities {

    //Retrofit is an easy and fast library to retrieve and upload data via REST API based web service
    private static Retrofit retrofit = null;

    //In ApiInterface we have defined the methods that we need to call
    //Now use the object of retrofit class to call ApiInterface
    public static ApiInterface getApiInterface(){
        if(retrofit==null){

            retrofit=new Retrofit.Builder().baseUrl(ApiInterface.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build() ;
        }
        return retrofit.create(ApiInterface.class);
    }

}

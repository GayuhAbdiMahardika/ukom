package com.gayuh.cariguru.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "http://192.168.43.212/";
//    private static final String BASE_URL = "http://192.168.100.11/";
//    private static final String BASE_URL = "http://192.168.0.173/";
    private static Retrofit retrofit = null;

    public static ApiInterface getClient(){
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        ApiInterface api = retrofit.create(ApiInterface.class);
        return api;
    }
}
//public class ApiClient {
//    private static final String BASE_URL = ServerConfig.API_ENDPOINT;
//    private static Retrofit retrofit = null;
//
//    public static Retrofit getClient(){
//        if(retrofit==null){
//            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
//        }
//        return retrofit;
//    }
//}

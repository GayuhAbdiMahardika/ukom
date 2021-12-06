package com.gayuh.cariguru.rest;

//import com.example.moviecatalog.model.Response;

import com.gayuh.cariguru.model.LoginForm;
import com.gayuh.cariguru.model.RegisterSiswaForm;
import com.gayuh.cariguru.model.ResponsesGetPenawaranGuru;
import com.gayuh.cariguru.model.ResponsesLogin;
import com.gayuh.cariguru.model.ResponsesPostRegisterSiswa;
import com.gayuh.cariguru.responses.Responses;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {


    @POST("auth")
    Call<ResponsesLogin> login(@Body LoginForm loginForm);

    @POST("register")
    Call<ResponsesPostRegisterSiswa> registerSiswa(@Body RegisterSiswaForm registerSiswaForm);

    @GET("penawaran/guru/{id}")
    Call<ResponsesGetPenawaranGuru> getPenawaranGuru(
            @Path("id") Integer id
    );
//    Call<Response> getMovie(
//            @Path("category") String category,
//            @Query("api_key") String api_key,
//            @Query("language") String language,
//            @Query("page") int page
//    );
//
//    @GET("/3/search/movie")
//    Call<Response> getQuery(
//            @Query("api_key") String apikey,
//            @Query("language") String language,
//            @Query("query") String query,
//            @Query("page") int page
//    );



}
//public interface ApiInterface {
//    @GET("/3/movie/{category}")
//    Call<Response> getMovie(
//            @Path("category") String category,
//            @Query("api_key") String api_key,
//            @Query("language") String Language,
//            @Query("page") int page
//    );
//}

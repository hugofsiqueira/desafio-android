package com.pitang.hlfs.movielist.rest;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by hugof on 01/02/2018.
 */

public class MovieListServerConsumer {

    private static IMovieListServer movieListServer;

    //public static final String API_BASE_URL = "http://acquamin.com.br:6637/acqua-core/";
    public static final String API_BASE_URL = "https://desafio-android-pitang.herokuapp.com/movies/";

    public static IMovieListServer getMovieListServer(){

        if(movieListServer == null) {

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.connectTimeout(60, TimeUnit.SECONDS);
            httpClient.readTimeout(60, TimeUnit.SECONDS);
            httpClient.writeTimeout(60, TimeUnit.SECONDS);

            Retrofit.Builder builder =
                    new Retrofit.Builder().baseUrl(API_BASE_URL).addConverterFactory(JacksonConverterFactory.create());
            Retrofit retrofit = builder.client(httpClient.build()).build();

            movieListServer = retrofit.create(IMovieListServer.class);
        }

        return movieListServer;
    }
}

package com.pitang.hlfs.movielist.rest;

import com.pitang.hlfs.movielist.model.Movie;
import com.pitang.hlfs.movielist.model.MovieDetail;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by hugof on 01/02/2018.
 */

public interface IMovieListServer {

    @GET("list")
    Call<List<Movie>> getListMovies(@Query("page") int page, @Query("size") int size);

    @GET("detail/{id}")
    Call<MovieDetail> getMovieDetail(@Path("id") String id);
}

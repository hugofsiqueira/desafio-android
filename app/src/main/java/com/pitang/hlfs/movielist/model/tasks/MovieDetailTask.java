package com.pitang.hlfs.movielist.model.tasks;

import android.os.AsyncTask;

import com.pitang.hlfs.movielist.model.MovieDetail;
import com.pitang.hlfs.movielist.rest.IMovieListServer;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by hugof on 06/02/2018.
 */

public class MovieDetailTask extends AsyncTask<Void, Void, MovieDetail> {

    private String id;
    private Response<MovieDetail> response;
    private IMovieListServer movieListServer;

    public MovieDetailTask(String id, IMovieListServer movieListServer) {
        this.id = id;
        this.movieListServer = movieListServer;
    }

    @Override
    protected MovieDetail doInBackground(Void... params) {

        Call<MovieDetail> listMoviesService = movieListServer.getMovieDetail(this.id);
        try {
            response = listMoviesService.execute();
            if(response.body() != null) {
                return response.body();
            }
        } catch (Exception e) {

        }

        return null;
    }

    @Override
    protected void onPostExecute(final MovieDetail movieDetail) {
    }

    @Override
    protected void onCancelled() {
    }
}

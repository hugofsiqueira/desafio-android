package com.pitang.hlfs.movielist.model.tasks;

import android.os.AsyncTask;

import com.pitang.hlfs.movielist.model.Movie;
import com.pitang.hlfs.movielist.rest.IMovieListServer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by hugof on 06/02/2018.
 */

public class MovieListTask extends AsyncTask<Void, Void, List<Movie>> {

    private int page;
    private Response<List<Movie>> response;
    private IMovieListServer movieListServer;

    public MovieListTask(int page, IMovieListServer movieListServer) {
        this.page = page;
        this.movieListServer = movieListServer;
    }

    @Override
    protected List<Movie> doInBackground(Void... params) {

        Call<List<Movie>> listMoviesService = movieListServer.getListMovies(page, 3);
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
    protected void onPostExecute(final List<Movie> movieList) {
    }

    @Override
    protected void onCancelled() {
    }
}

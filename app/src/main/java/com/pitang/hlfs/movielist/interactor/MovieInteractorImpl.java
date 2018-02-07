package com.pitang.hlfs.movielist.interactor;

import com.pitang.hlfs.movielist.model.Movie;
import com.pitang.hlfs.movielist.model.MovieDetail;
import com.pitang.hlfs.movielist.model.tasks.MovieDetailTask;
import com.pitang.hlfs.movielist.model.tasks.MovieListTask;
import com.pitang.hlfs.movielist.rest.IMovieListServer;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;

/**
 * Created by hlfs on 30/01/18.
 */

public class MovieInteractorImpl implements IMovieInteractor {

    private IMovieListServer movieListServer;
    private MovieListTask task;
    private MovieDetailTask movieDetailTask;

    @Inject
    public MovieInteractorImpl(IMovieListServer movieListServer) {
        this.movieListServer = movieListServer;
    }

    @Override
    public List<Movie> getMovieList(int page) {

        task = new MovieListTask(page, this.movieListServer);
        try {
            return (List<Movie>) task.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public MovieDetail getMovieDetails(Movie movie) {
        movieDetailTask = new MovieDetailTask(movie.get_id(), movieListServer);
        try {
            return movieDetailTask.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}

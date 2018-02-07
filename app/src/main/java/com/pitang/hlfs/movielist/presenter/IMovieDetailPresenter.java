package com.pitang.hlfs.movielist.presenter;

import com.pitang.hlfs.movielist.model.Movie;
import com.pitang.hlfs.movielist.view.MovieDetailActivity;

/**
 * Created by hugof on 06/02/2018.
 */

public interface IMovieDetailPresenter {

    String getMovieExtra();
    void setMovieDetailActivity(MovieDetailActivity movieDetailActivity);
    void showMovieDetail(Movie movie);
}

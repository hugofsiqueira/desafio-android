package com.pitang.hlfs.movielist.presenter;

import com.pitang.hlfs.movielist.R;
import com.pitang.hlfs.movielist.configuration.glide.GlideApp;
import com.pitang.hlfs.movielist.interactor.IMovieInteractor;
import com.pitang.hlfs.movielist.model.Movie;
import com.pitang.hlfs.movielist.model.MovieDetail;
import com.pitang.hlfs.movielist.view.MovieDetailActivity;

import javax.inject.Inject;

/**
 * Created by hugof on 06/02/2018.
 */

public class MovieDetailPresenterImpl implements IMovieDetailPresenter {

    private IMovieInteractor movieInteractor;

    private MovieDetailActivity movieDetailActivity;

    @Inject
    public MovieDetailPresenterImpl(IMovieInteractor interactor){
        movieInteractor = interactor;
    }

    @Override
    public String getMovieExtra() {
        return IMovieInteractor.MOVIE_EXTRA;
    }

    public MovieDetailActivity getMovieDetailActivity() {
        return movieDetailActivity;
    }

    public void setMovieDetailActivity(MovieDetailActivity movieDetailActivity) {
        this.movieDetailActivity = movieDetailActivity;
    }

    @Override
    public void showMovieDetail(Movie movie) {
        MovieDetail movieDetail = movieInteractor.getMovieDetails(movie);
        if(movieDetail != null){
            movieDetailActivity.getTitleTextView().setText(movieDetail.getName());
            movieDetailActivity.getDescTextView().setText(movieDetail.getDescription());

            GlideApp.with(movieDetailActivity.getApplicationContext()).load(movieDetail.getUrl()).
                    placeholder(R.drawable.movie_load).error(R.drawable.error_load).
                    into(movieDetailActivity.getImageView());
        }
    }
}

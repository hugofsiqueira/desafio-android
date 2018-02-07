package com.pitang.hlfs.movielist.presenter;

import android.content.Intent;

import com.pitang.hlfs.movielist.interactor.IMovieInteractor;
import com.pitang.hlfs.movielist.model.Movie;
import com.pitang.hlfs.movielist.model.adapters.MovieAdapter;
import com.pitang.hlfs.movielist.view.MainActivity;
import com.pitang.hlfs.movielist.view.MovieDetailActivity;

import java.util.List;

import javax.inject.Inject;


/**
 * Created by hlfs on 30/01/18.
 */

public class MoviePresenterImpl implements IMoviePresenter {


    private IMovieInteractor movieInteractor;


    private MainActivity mainActivity;

    @Inject
    public MoviePresenterImpl(IMovieInteractor interactor){
        movieInteractor = interactor;
    }

    @Override
    public void showMovieDetails(Movie movie) {
        Intent intent = new Intent(mainActivity, MovieDetailActivity.class);
        intent.putExtra(IMovieInteractor.MOVIE_EXTRA, movie);
        mainActivity.startActivity(intent);
    }

    @Override
    public List<Movie> getMovieList(int page) {
        return movieInteractor.getMovieList(page);
    }

    @Override
    public MovieAdapter.OnItemClickListener getMovieAdapterListener() {
        MovieAdapter.OnItemClickListener listener = new MovieAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Movie movie) {
                showMovieDetails(movie);
            }
        };

        return listener;
    }

    public MainActivity getMainActivity() {
        return mainActivity;
    }

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }
}

package com.pitang.hlfs.movielist.presenter;

import com.pitang.hlfs.movielist.model.Movie;
import com.pitang.hlfs.movielist.model.adapters.MovieAdapter;
import com.pitang.hlfs.movielist.view.MainActivity;

import java.util.List;

/**
 * Created by hlfs on 30/01/18.
 */

public interface IMoviePresenter {

    void showMovieDetails(Movie movie);

    List<Movie> getMovieList(int page);

    MovieAdapter.OnItemClickListener getMovieAdapterListener();

    void setMainActivity(MainActivity mainActivity);

}

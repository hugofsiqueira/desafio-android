package com.pitang.hlfs.movielist.interactor;

import com.pitang.hlfs.movielist.model.Movie;
import com.pitang.hlfs.movielist.model.MovieDetail;

import java.util.List;

/**
 * Created by hlfs on 30/01/18.
 */

public interface IMovieInteractor {

    List<Movie> getMovieList(int page);
    MovieDetail getMovieDetails(Movie movie);
    String MOVIE_EXTRA = "MOVIE";

}

package com.pitang.hlfs.movielist.configuration.modules;

import com.pitang.hlfs.movielist.interactor.IMovieInteractor;
import com.pitang.hlfs.movielist.interactor.MovieInteractorImpl;
import com.pitang.hlfs.movielist.rest.IMovieListServer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hugof on 01/02/2018.
 */

@Module(includes = MovieListServerModule.class)
public class MovieInteractorModule {

    @Provides
    @Singleton
    public IMovieInteractor provideIMovieInteractor(IMovieListServer  movieListServer){
        return new MovieInteractorImpl(movieListServer);
    }
}

package com.pitang.hlfs.movielist.configuration.modules;

import com.pitang.hlfs.movielist.rest.IMovieListServer;
import com.pitang.hlfs.movielist.rest.MovieListServerConsumer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hugof on 01/02/2018.
 */

@Module
public class MovieListServerModule {

    @Provides
    @Singleton
    public IMovieListServer provideIMovieListServer(){
        return MovieListServerConsumer.getMovieListServer();
    }
}

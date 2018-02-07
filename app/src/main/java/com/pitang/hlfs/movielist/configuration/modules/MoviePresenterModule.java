package com.pitang.hlfs.movielist.configuration.modules;

import com.pitang.hlfs.movielist.interactor.IMovieInteractor;
import com.pitang.hlfs.movielist.presenter.IMoviePresenter;
import com.pitang.hlfs.movielist.presenter.MoviePresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hlfs on 31/01/18.
 */

@Module(includes = {MovieInteractorModule.class})
public class MoviePresenterModule {

    @Provides
    @Singleton
    public IMoviePresenter provideIMoviePresenter(IMovieInteractor interactor){
        return new MoviePresenterImpl(interactor);
    }
}

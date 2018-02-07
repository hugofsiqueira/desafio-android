package com.pitang.hlfs.movielist.configuration.modules;

import com.pitang.hlfs.movielist.interactor.IMovieInteractor;
import com.pitang.hlfs.movielist.presenter.IMovieDetailPresenter;
import com.pitang.hlfs.movielist.presenter.MovieDetailPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hlfs on 06/01/18.
 */

@Module(includes = {MovieInteractorModule.class})
public class MovieDetailPresenterModule {

    @Provides
    @Singleton
    public IMovieDetailPresenter provideIMoviePresenter(IMovieInteractor interactor){
        return new MovieDetailPresenterImpl(interactor);
    }
}

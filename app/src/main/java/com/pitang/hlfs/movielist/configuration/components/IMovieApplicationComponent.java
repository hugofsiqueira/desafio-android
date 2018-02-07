package com.pitang.hlfs.movielist.configuration.components;

import com.pitang.hlfs.movielist.configuration.application.MovieApplication;
import com.pitang.hlfs.movielist.configuration.modules.ApplicationModule;
import com.pitang.hlfs.movielist.configuration.modules.MovieDetailPresenterModule;
import com.pitang.hlfs.movielist.configuration.modules.MovieInteractorModule;
import com.pitang.hlfs.movielist.configuration.modules.MovieListServerModule;
import com.pitang.hlfs.movielist.configuration.modules.MoviePresenterModule;
import com.pitang.hlfs.movielist.view.MainActivity;
import com.pitang.hlfs.movielist.view.MovieDetailActivity;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

/**
 * Created by hlfs on 31/01/18.
 */

@Singleton
@Component(modules = { AndroidInjectionModule.class, ApplicationModule.class,
        MoviePresenterModule.class, MovieDetailPresenterModule.class, MovieInteractorModule.class, MovieListServerModule.class})
public interface IMovieApplicationComponent extends AndroidInjector<MovieApplication> {

    void inject(MovieDetailActivity movieDetailActivity);
    void inject(MainActivity mainActivity);

}

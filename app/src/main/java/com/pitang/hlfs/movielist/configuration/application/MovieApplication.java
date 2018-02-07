package com.pitang.hlfs.movielist.configuration.application;

import android.app.Activity;
import android.app.Application;

import com.pitang.hlfs.movielist.configuration.components.DaggerIMovieApplicationComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by hlfs on 31/01/18.
 */

public class MovieApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerIMovieApplicationComponent.create().inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}

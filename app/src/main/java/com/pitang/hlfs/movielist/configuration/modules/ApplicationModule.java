package com.pitang.hlfs.movielist.configuration.modules;

import com.pitang.hlfs.movielist.view.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by hlfs on 31/01/18.
 */

@Module
public abstract class ApplicationModule {

    @ContributesAndroidInjector
    abstract MainActivity contributeActivityInjector();
}

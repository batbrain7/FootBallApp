package com.example.mohitkumar.footballapp.di.modules;

import android.content.Context;

import com.example.mohitkumar.footballapp.FootBallApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AndroidModule {

    @Provides
    @Singleton
    Context providesContext() {
        return FootBallApplication.context;
    }
}

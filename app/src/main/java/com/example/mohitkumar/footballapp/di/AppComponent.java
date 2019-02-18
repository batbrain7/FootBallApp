package com.example.mohitkumar.footballapp.di;

import com.example.mohitkumar.footballapp.FootBallApplication;
import com.example.mohitkumar.footballapp.di.modules.ActivityBuildersModule;
import com.example.mohitkumar.footballapp.di.modules.AppModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class,
        ActivityBuildersModule.class,
        AndroidSupportInjectionModule.class,
        AppModule.class})


public interface AppComponent extends AndroidInjector<FootBallApplication> {

    void inject(FootBallApplication footBallApplication);
}

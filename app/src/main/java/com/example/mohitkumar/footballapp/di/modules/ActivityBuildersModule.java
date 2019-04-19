package com.example.mohitkumar.footballapp.di.modules;

import com.example.mohitkumar.footballapp.FootballMainActivity;
import com.example.mohitkumar.footballapp.core.LeagueActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract FootballMainActivity contributesFootBallMainActivity();

    @ContributesAndroidInjector
    abstract LeagueActivity contributesLeagueActivity();
}

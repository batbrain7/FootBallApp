package com.example.mohitkumar.footballapp.di.modules;

import com.example.mohitkumar.footballapp.FootballMainActivity;
import com.example.mohitkumar.footballapp.core.LeagueActivity;
import com.example.mohitkumar.footballapp.core.teams.TeamFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract FootballMainActivity contributesFootBallMainActivity();

    @ContributesAndroidInjector
    abstract LeagueActivity contributesLeagueActivity();

    @ContributesAndroidInjector
    abstract TeamFragment contributesFragmentActivity();
}

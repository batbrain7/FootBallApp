package com.example.mohitkumar.footballapp.di.modules;

import com.example.mohitkumar.footballapp.data.teams.TeamService;
import com.example.mohitkumar.footballapp.data.teams.TeamServiceImpl;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ModelModule {

    @Binds
    @Singleton
    abstract TeamService bindsHeadlineServiceModule(TeamServiceImpl headlineService);

}

package com.example.mohitkumar.footballapp.di.modules;

import com.example.mohitkumar.footballapp.data.teams.TeamsApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ApiModule {

    @Singleton
    @Provides
    public TeamsApi providesTeamsApi(Retrofit retrofit) {
        return retrofit.create(TeamsApi.class);
    }
}

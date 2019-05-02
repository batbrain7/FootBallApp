package com.example.mohitkumar.footballapp.di.modules;

import android.arch.lifecycle.ViewModel;

import com.example.mohitkumar.footballapp.core.teams.TeamViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(TeamViewModel.class)
    public abstract ViewModel bindsTeamViewModel(TeamViewModel teamViewModel);

}

package com.example.mohitkumar.footballapp.di.modules;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.example.mohitkumar.footballapp.core.teams.TeamViewModel;
import com.example.mohitkumar.footballapp.di.FootBallViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(TeamViewModel.class)
    public abstract ViewModel bindsTeamViewModel(TeamViewModel teamViewModel);

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(FootBallViewModelFactory footBallViewModelFactory);
}

package com.example.mohitkumar.footballapp.core.teams;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.mohitkumar.footballapp.data.teams.TeamData;
import com.example.mohitkumar.footballapp.data.teams.TeamService;

import java.util.List;

import javax.inject.Inject;

public class TeamViewModel extends ViewModel {

    private final TeamService service;
    private final MutableLiveData<Integer> progress = new MutableLiveData<>();
    private final MutableLiveData<List<TeamData>> data = new MutableLiveData<>();

    @Inject
    public TeamViewModel(TeamService service) {
        this.service = service;
    }

    @SuppressLint("CheckResult")
    public LiveData<List<TeamData>> getTeamData() {
        service.getTeams(2001)
                .doOnSubscribe(disposable -> progress.setValue(0))
                .doFinally(() -> progress.setValue(8))
                .subscribe(status -> {
                    data.setValue(status.teamData);
                }, error -> {
                    Log.i("HeadlineFragment.class", "onStart: " + error);
                });
        return data;
    }

    public LiveData<Integer> getProgress() {
        return progress;
    }

}

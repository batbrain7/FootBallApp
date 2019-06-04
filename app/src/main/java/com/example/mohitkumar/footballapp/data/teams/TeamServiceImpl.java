package com.example.mohitkumar.footballapp.data.teams;

import android.content.Context;
import android.util.Log;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import static io.reactivex.android.schedulers.AndroidSchedulers.mainThread;

public class TeamServiceImpl implements TeamService {

    private final TeamsApi teamsApi;
    private final Context context;

    @Inject
    public TeamServiceImpl(TeamsApi teamsApi, Context context) {
        this.teamsApi = teamsApi;
        this.context = context;
    }

    @Override
    public Observable<TeamResponse> getTeams(int id) {
        Observable<TeamResponse> responseObservable = teamsApi.getTeams(id)
                .subscribeOn(Schedulers.io())
                .observeOn(mainThread());
        Log.d("TeamServiceImpl", responseObservable.toString());

        return responseObservable;
    }
}

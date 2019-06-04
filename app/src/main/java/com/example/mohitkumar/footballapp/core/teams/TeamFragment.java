package com.example.mohitkumar.footballapp.core.teams;


import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mohitkumar.footballapp.R;
import com.example.mohitkumar.footballapp.Utils.Utils;
import com.example.mohitkumar.footballapp.data.teams.TeamData;
import com.example.mohitkumar.footballapp.data.teams.TeamService;
import com.example.mohitkumar.footballapp.databinding.FragmentTeamBinding;
import com.example.mohitkumar.footballapp.di.Injectable;

import java.util.List;

import javax.inject.Inject;

public class TeamFragment extends Fragment implements Injectable {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Inject
    TeamService teamService;

    private List<TeamData> teamDataList;
    private TeamViewModel teamViewModel;
    private FragmentTeamBinding fragmentTeamBinding;
    int leagueCode;
    public static final String TAG = "Team Fragment";
    String name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentTeamBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_team, container, false);
        name = getActivity().getIntent().getStringExtra("name");
        if (!TextUtils.isEmpty(name))
            leagueCode = Utils.map.get(name);

        Log.d(TAG, leagueCode + " ");
        teamViewModel = ViewModelProviders.of(this, viewModelFactory).get(TeamViewModel.class);
        return fragmentTeamBinding.getRoot();
    }

    @SuppressLint("CheckResult")
    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "Loading the teams");
        loadTeams();
    }

    private void loadTeams() {
        teamViewModel.getTeamData(leagueCode).observe(this, list -> {
            teamDataList = list;
            if (list != null)
                Log.d(TAG, list.size() + " " + list.toString());
            else
                Log.d(TAG, "Empty list");
        });
    }
}

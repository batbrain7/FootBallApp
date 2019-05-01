package com.example.mohitkumar.footballapp.core;

import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import com.example.mohitkumar.footballapp.R;
import com.example.mohitkumar.footballapp.Utils.Utils;
import com.example.mohitkumar.footballapp.core.teams.TeamFragment;
import com.example.mohitkumar.footballapp.databinding.ActivityLeagueBinding;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;

public class LeagueActivity extends AppCompatActivity {

    private ActivityLeagueBinding leagueBinding;
    static int LEAGUE_CODE;

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        leagueBinding = DataBindingUtil.setContentView(this, R.layout.activity_league);

        String name = getIntent().getStringExtra("name");
        if (!TextUtils.isEmpty(name))
            LEAGUE_CODE = Utils.map.get(name);

        loadFragments();
    }

    private void loadFragments() {
        LeagueFragmentAdapter leagueFragmentAdapter;
        leagueFragmentAdapter = new LeagueFragmentAdapter(getSupportFragmentManager());
        leagueFragmentAdapter.addFragments(new TeamFragment(), this.getResources().getString(R.string.team_fragment));
        leagueBinding.viewPager.setAdapter(leagueFragmentAdapter);
        leagueBinding.tabLayout.setupWithViewPager(leagueBinding.viewPager);
    }
}

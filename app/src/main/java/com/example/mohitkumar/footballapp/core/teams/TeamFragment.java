package com.example.mohitkumar.footballapp.core.teams;


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
import com.example.mohitkumar.footballapp.databinding.FragmentTeamBinding;

public class TeamFragment extends Fragment {

    private FragmentTeamBinding fragmentTeamBinding;
    int leagueCode;
    public static final String TAG = "Team Fragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentTeamBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_team, container, false);
        String name = getActivity().getIntent().getStringExtra("name");
        if (!TextUtils.isEmpty(name))
            leagueCode = Utils.map.get(name);

        Log.d(TAG, leagueCode + " ");
        return fragmentTeamBinding.getRoot();
    }
}

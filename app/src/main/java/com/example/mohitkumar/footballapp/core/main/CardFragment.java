package com.example.mohitkumar.footballapp.core.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mohitkumar.footballapp.R;
import com.example.mohitkumar.footballapp.databinding.FragmentCardBinding;


public class CardFragment extends Fragment {
    private CardView cardView;
    private FragmentCardBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_card, container, false);

        binding.cardView.setMaxCardElevation(cardView.getCardElevation()
                * CardAdapter.MAX_ELEVATION_FACTOR);
        return binding.getRoot();
    }

    public CardView getCardView() {
        return cardView;
    }
}

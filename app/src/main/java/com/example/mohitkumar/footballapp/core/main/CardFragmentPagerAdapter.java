package com.example.mohitkumar.footballapp.core.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.CardView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class CardFragmentPagerAdapter extends FragmentStatePagerAdapter implements CardAdapter {

    private List<CardFragment> cardFragments;
    private float baseelevation;
    private final int NUM_LEAGUES = 11;

    public CardFragmentPagerAdapter(FragmentManager fm, float baseElevation) {
        super(fm);
        cardFragments = new ArrayList<>();
        baseelevation = baseElevation;

        for(int i = 0; i < NUM_LEAGUES; i++){
            addCardFragment(new CardFragment());
        }
    }

    @Override
    public float getBaseElevation() {
        return baseelevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return cardFragments.get(position).getCardView();
    }

    @Override
    public int getCount() {
        return cardFragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return cardFragments.get(position);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Object fragment = super.instantiateItem(container, position);
        cardFragments.set(position, (CardFragment) fragment);
        return fragment;
    }

    public void addCardFragment(CardFragment fragment) {
        cardFragments.add(fragment);
    }

}
package com.example.mohitkumar.footballapp;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.example.mohitkumar.footballapp.core.main.CardFragmentPagerAdapter;
import com.example.mohitkumar.footballapp.core.main.CardItem;
import com.example.mohitkumar.footballapp.core.main.CardPagerAdapter;
import com.example.mohitkumar.footballapp.core.main.ShadowTransformer;
import com.example.mohitkumar.footballapp.databinding.ActivityFootballMainBinding;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class FootballMainActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    private ActionBar actionBar;
    private ActivityFootballMainBinding mainBinding;

    private ViewPager viewPager;

    private CardPagerAdapter cardPagerAdapter;
    private ShadowTransformer shadowTransformer;
    private CardFragmentPagerAdapter cardFragmentPagerAdapter;
    private ShadowTransformer fragmentCardShadowTransformer;

    public static final String TAG = "FOOTBALL MAIN ACTIVITY";

    private boolean showingFragments = false;

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // Log.d(TAG, "IN HERE");
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_football_main);
        setup();
    }

    private void setup() {
        Log.d(TAG, "IN HERE");
        String[] leagueNames = this.getResources().getStringArray(R.array.LeagueNames);
        String[] country = this.getResources().getStringArray(R.array.CountryNames);
        String[] urls = this.getResources().getStringArray(R.array.LeagueNames);
        ArrayList<CardItem> itemList = new ArrayList<CardItem>();
        int i = 0;

        mainBinding.viewPager.setPageMargin(-75);

        Log.d(TAG,"SIZE" + Integer.toString(itemList.size()));
        cardPagerAdapter = new CardPagerAdapter(this);

        for (String arr : leagueNames) {
            cardPagerAdapter.addCardItem(new CardItem(arr, country[i], urls[i]));
            i++;
        }

        shadowTransformer = new ShadowTransformer(mainBinding.viewPager, cardPagerAdapter);

        mainBinding.viewPager.setAdapter(cardPagerAdapter);
        mainBinding.viewPager.setPageTransformer(false, shadowTransformer);
        mainBinding.viewPager.setOffscreenPageLimit(3);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return null;
    }

    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }

}

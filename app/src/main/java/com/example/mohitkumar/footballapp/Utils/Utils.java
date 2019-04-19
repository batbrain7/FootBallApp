package com.example.mohitkumar.footballapp.Utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.example.mohitkumar.footballapp.FootBallApplication;
import com.example.mohitkumar.footballapp.R;
import com.example.mohitkumar.footballapp.core.main.CardItem;
import com.example.mohitkumar.footballapp.core.main.CardPagerAdapter;

import java.util.HashMap;

public final class Utils {

    public static HashMap<String, Integer> map;

    public static boolean hasNetwork() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) FootBallApplication.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static void fillMap(Context context) {
        String[] names = context.getResources().getStringArray(R.array.LeagueNames);
        int[] arr = context.getResources().getIntArray(R.array.IDs);
        int i = 0;
        map = new HashMap<String, Integer>();
        for (String str: names) {
            map.put(str, arr[i]);
            i++;
        }
    }

    public static void insertCardAdapter(Context context, CardPagerAdapter cardPagerAdapter) {
        String[] leagueNames = context.getResources().getStringArray(R.array.LeagueNames);
        String[] country = context.getResources().getStringArray(R.array.CountryNames);
        String[] urls = context.getResources().getStringArray(R.array.links);
        int i = 0;
        for (String arr : leagueNames) {
            cardPagerAdapter.addCardItem(new CardItem(arr, country[i], urls[i]));
            i++;
        }
    }

}

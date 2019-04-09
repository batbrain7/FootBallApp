package com.example.mohitkumar.footballapp.core.main;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.example.mohitkumar.footballapp.R;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class CardPagerAdapter extends PagerAdapter implements CardAdapter {

    private List<CardView> cardViews;
    private List<CardItem> cardData;
    private float baseElevation;
    private Context context;

    public static final String TAG = "CARD PAGER ADAPTER";
    public CardPagerAdapter(Context context) {
        this.context = context;
        cardData = new ArrayList<>();
        cardViews = new ArrayList<>();
    }

    public void addCardItem(CardItem item) {
        cardViews.add(null);
        cardData.add(item);
    }

    public float getBaseElevation() {
        return baseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return cardViews.get(position);
    }

    @Override
    public int getCount() {
        return cardData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.adapter, container, false);
        container.addView(view);
        bind(cardData.get(position), view);
        CardView cardView = view.findViewById(R.id.cardView);

        if (baseElevation == 0) {
            baseElevation = cardView.getCardElevation();
        }

        cardView.setMaxCardElevation(baseElevation * MAX_ELEVATION_FACTOR);
        cardViews.set(position, cardView);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        cardViews.set(position, null);
    }

    private void bind(CardItem item, View view) {
        ImageView logo = view.findViewById(R.id.leagueImage);
        TextView leagueName = view.findViewById(R.id.leagueName);
        TextView country = view.findViewById(R.id.country);

        Glide.with(context)
                .asBitmap()
                .load(item.getImageURL())
//                .apply(RequestOptions.bitmapTransform(new RoundedCornersTransformation(50, 50,
//                        RoundedCornersTransformation.CornerType.)))
                .listener(new RequestListener<Bitmap>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                        logo.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_filter_2_white_24dp));
                        Toast.makeText(context, "FAILED", Toast.LENGTH_LONG).show();
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
                        logo.setImageBitmap(resource);
                        return true;
                    }
                }).submit();
        leagueName.setText(item.getLeagueName());
        country.setText(item.getCountry());
    }

}
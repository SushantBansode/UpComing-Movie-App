package com.example.upcomingmoviesapp.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.upcomingmoviesapp.R;
import com.example.upcomingmoviesapp.Util.Constant;


public class MovieDetailsFragment extends Fragment
{
    TextView text_movie_title,text_movie_overview;
    RatingBar rating_moview_popularity;
    ImageView image_movie_poster;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_details, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        text_movie_title=getView().findViewById(R.id.text_movie_title);
        text_movie_overview=getView().findViewById(R.id.text_movie_overview);
        rating_moview_popularity=getView().findViewById(R.id.rating_moview_popularity);
        image_movie_poster=getView().findViewById(R.id.image_movie_poster);

        text_movie_title.setText( getArguments().getString("MovieTitle"));

        text_movie_overview.setText(getArguments().getString("movieOverView"));
        String rating=getArguments().getString("movieRating");
        rating_moview_popularity.setRating(Float.parseFloat(rating ));

        Glide.with(getContext()).
                load(Constant.IMAGEURL+ getArguments().getString("moviePosterPath"))
                .into(image_movie_poster);

       ;
    }
}

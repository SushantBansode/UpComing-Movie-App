package com.example.upcomingmoviesapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.upcomingmoviesapp.R;
import com.example.upcomingmoviesapp.Util.Constant;
import com.example.upcomingmoviesapp.pojo.GetUpComingMovieResponse;


import java.util.ArrayList;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MyViewHolder>
{
    public static GetUpComingMovieResponse.Results[] mMovieList;
    public static Context mContext;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        public TextView item_movie_title,item_movie_release_date,item_movie_adult;
        public ImageView item_movie_poster;

        public MyViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            item_movie_title = (TextView) v.findViewById(R.id.item_movie_title);
            item_movie_release_date = (TextView) v.findViewById(R.id.item_movie_release_date);
            item_movie_adult = (TextView) v.findViewById(R.id.item_movie_adult);
            item_movie_poster=(ImageView)v.findViewById(R.id.item_movie_poster);
        }


        @Override
        public void onClick(View v) {
           int position= getAdapterPosition();
           Bundle movieDetails=new Bundle();
            movieDetails.putString("MovieTitle",MovieListAdapter.mMovieList[position].getTitle());
            movieDetails.putString("movieOverView",MovieListAdapter.mMovieList[position].getOverview());
            movieDetails.putString("movieRating",MovieListAdapter.mMovieList[position].getPopularity());
            movieDetails.putString("moviePosterPath",MovieListAdapter.mMovieList[position].getPoster_path());
            NavController navController = Navigation.findNavController((Activity) MovieListAdapter.mContext, R.id.my_nav_host_fragment);
            navController.navigate(R.id.action_moviesListFragment_to_movieDetailsFragment,movieDetails);
        }
    }


    public MovieListAdapter(GetUpComingMovieResponse.Results[] myDataset,Context context) {
        mMovieList = myDataset;
        mContext=context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MovieListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie, parent, false);


        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
       holder.item_movie_title.setText(mMovieList[position].getTitle());


        holder.item_movie_release_date.setText(mMovieList[position].getRelease_date());
        if(mMovieList[position].getAdult().equals("true"))
        {
            holder.item_movie_adult.setText("A");
        }else
            {
                holder.item_movie_adult.setText("UA");
            }
        String str=mMovieList[position].getPoster_path();
        String s1="";
       for (int i=1;i<str.length();i++)
       {
           s1=s1+str.charAt(i);
       }
       Glide.with(mContext).
                load(Constant.IMAGEURL+s1)
                .into(holder.item_movie_poster);

    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mMovieList.length;
    }
}

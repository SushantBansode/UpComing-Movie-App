package com.example.upcomingmoviesapp.fragments;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.upcomingmoviesapp.MainActivity;
import com.example.upcomingmoviesapp.R;
import com.example.upcomingmoviesapp.Util.APIClient;
import com.example.upcomingmoviesapp.Util.APIInterface;
import com.example.upcomingmoviesapp.adapter.MovieListAdapter;
import com.example.upcomingmoviesapp.pojo.GetUpComingMovieResponse;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MovieListFragment extends Fragment {

    APIInterface apiInterface;
    RecyclerView recycler_movie_list;
    ProgressDialog progressDoalog;
    ImageView image_information;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_list, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recycler_movie_list = getView().findViewById(R.id.recycler_movie_list);
        image_information=getView().findViewById(R.id.image_information);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        progressDoalog = new ProgressDialog(getContext());
        progressDoalog.setMessage("Loading....");
        progressDoalog.setTitle("Up Coming Movies App");
        progressDoalog.show();
        Call<GetUpComingMovieResponse> call = apiInterface.getUpComingMoviesList();
        call.enqueue(new Callback<GetUpComingMovieResponse>() {
            @Override
            public void onResponse(Call<GetUpComingMovieResponse> call, Response<GetUpComingMovieResponse> response) {

                progressDoalog.dismiss();
                MovieListAdapter movieListAdapter = new MovieListAdapter(response.body().getResults(), getActivity());
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
                recycler_movie_list.setLayoutManager(mLayoutManager);
                recycler_movie_list.setItemAnimator(new DefaultItemAnimator());
                recycler_movie_list.setAdapter(movieListAdapter);



            }

            @Override
            public void onFailure(Call<GetUpComingMovieResponse> call, Throwable t)
            {
                progressDoalog.dismiss();
            }
        });
        image_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController((Activity) MovieListAdapter.mContext, R.id.my_nav_host_fragment);
                navController.navigate(R.id.action_moviesListFragment_to_developerInformationFragment);
            }
        });


    }


}

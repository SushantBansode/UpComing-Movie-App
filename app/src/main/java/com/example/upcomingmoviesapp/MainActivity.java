package com.example.upcomingmoviesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.upcomingmoviesapp.Util.APIClient;
import com.example.upcomingmoviesapp.Util.APIInterface;
import com.example.upcomingmoviesapp.adapter.MovieListAdapter;
import com.example.upcomingmoviesapp.pojo.GetUpComingMovieResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
{
    APIInterface apiInterface;
    RecyclerView recycler_movie_list;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler_movie_list=findViewById(R.id.recycler_movie_list);
        apiInterface = APIClient.getClient().create(APIInterface.class);

        Call<GetUpComingMovieResponse> call = apiInterface.getUpComingMoviesList();
        call.enqueue(new Callback<GetUpComingMovieResponse>() {
            @Override
            public void onResponse(Call<GetUpComingMovieResponse> call, Response<GetUpComingMovieResponse> response) {



                MovieListAdapter movieListAdapter = new MovieListAdapter(response.body().getResults(),MainActivity.this);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MainActivity.this);
                recycler_movie_list.setLayoutManager(mLayoutManager);
                recycler_movie_list.setItemAnimator(new DefaultItemAnimator());
                recycler_movie_list.setAdapter(movieListAdapter);



            }

            @Override
            public void onFailure(Call<GetUpComingMovieResponse> call, Throwable t) {

            }
        });



    }
}

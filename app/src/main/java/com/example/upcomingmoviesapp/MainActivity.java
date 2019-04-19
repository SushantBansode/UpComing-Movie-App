package com.example.upcomingmoviesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.upcomingmoviesapp.Util.APIClient;
import com.example.upcomingmoviesapp.Util.APIInterface;
import com.example.upcomingmoviesapp.pojo.GetUpComingMovieResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
{
    APIInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface = APIClient.getClient().create(APIInterface.class);

        Call<GetUpComingMovieResponse> call = apiInterface.getUpComingMoviesList();
        call.enqueue(new Callback<GetUpComingMovieResponse>() {
            @Override
            public void onResponse(Call<GetUpComingMovieResponse> call, Response<GetUpComingMovieResponse> response) {

                GetUpComingMovieResponse r=response.body();



            }

            @Override
            public void onFailure(Call<GetUpComingMovieResponse> call, Throwable t) {

            }
        });



    }
}

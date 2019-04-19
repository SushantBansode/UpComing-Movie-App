package com.example.upcomingmoviesapp.Util;

import com.example.upcomingmoviesapp.pojo.GetUpComingMovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface
{
    @GET("upcoming?api_key=b7cd3340a794e5a2f35e3abb820b497f")
    Call<GetUpComingMovieResponse> getUpComingMoviesList();
}

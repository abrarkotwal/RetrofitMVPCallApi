package com.esmsquare.retrofitmvpcallapi.DB;


import com.esmsquare.retrofitmvpcallapi.Model.MovieResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetMovieDataService {

    @GET("movie/upcoming")
    Call<MovieResult> getUpcommingMovies(@Query("api_key") String apiKey);
}
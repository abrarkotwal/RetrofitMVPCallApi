package com.esmsquare.retrofitmvpcallapi.DB;

import android.support.annotation.NonNull;

import com.esmsquare.retrofitmvpcallapi.Model.MovieResult;
import com.esmsquare.retrofitmvpcallapi.Presenter.MainContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetMovieIntractorImpl implements MainContract.GetNoticeIntractor {

    @Override
    public void getNoticeArrayList(final OnFinishedListener onFinishedListener) {


        /** Create handle for the ApiInstance interface*/
        GetMovieDataService service = ApiInstance.getRetrofitInstance().create(GetMovieDataService.class);

        /** Call the method with parameter in the interface to get the notice data*/
        Call<MovieResult> call = service.getNoticeData("b7cd3340a794e5a2f35e3abb820b497f");

        call.enqueue(new Callback<MovieResult>() {
            @Override
            public void onResponse(@NonNull Call<MovieResult> call, @NonNull Response<MovieResult> response) {
                if (response.body() != null) {
                    onFinishedListener.onFinished(response.body().getNoticeArrayList());
                }

            }

            @Override
            public void onFailure(@NonNull Call<MovieResult> call, @NonNull Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });

    }

}

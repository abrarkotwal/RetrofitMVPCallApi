package com.esmsquare.retrofitmvpcallapi.DB;

import android.support.annotation.NonNull;
import android.util.Log;

import com.esmsquare.retrofitmvpcallapi.Model.NoticeList;
import com.esmsquare.retrofitmvpcallapi.Presenter.MainContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetNoticeIntractorImpl implements MainContract.GetNoticeIntractor {

    @Override
    public void getNoticeArrayList(final OnFinishedListener onFinishedListener) {


        /** Create handle for the ApiInstance interface*/
        GetNoticeDataService service = ApiInstance.getRetrofitInstance().create(GetNoticeDataService.class);

        /** Call the method with parameter in the interface to get the notice data*/
        Call<NoticeList> call = service.getNoticeData();

        call.enqueue(new Callback<NoticeList>() {
            @Override
            public void onResponse(@NonNull Call<NoticeList> call, @NonNull Response<NoticeList> response) {
                if (response.body() != null) {
                    onFinishedListener.onFinished(response.body().getNoticeArrayList());
                }

            }

            @Override
            public void onFailure(@NonNull Call<NoticeList> call, @NonNull Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });

    }

}

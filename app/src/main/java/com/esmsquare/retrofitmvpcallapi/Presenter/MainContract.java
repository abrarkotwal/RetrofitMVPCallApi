package com.esmsquare.retrofitmvpcallapi.Presenter;


import com.esmsquare.retrofitmvpcallapi.Model.Movies;

import java.util.ArrayList;

public interface MainContract {

    /**
     * Call when user interact with the view and other when view OnDestroy()
     * */
    interface Presenter{
        void onDestroy();
        void onRefreshButtonClick();
        void requestDataFromServer();
    }

    /**
     * showProgress() and hideProgress() would be used for displaying and hiding the progressBar
     * while the setDataToRecyclerView and onResponseFailure is fetched from the GetNoticeInteractorImpl class
     **/
    interface MainView {
        void showProgress();
        void hideProgress();
        void setDataToRecyclerView(ArrayList<Movies> moviesArrayList);
        void onResponseFailure(Throwable throwable);

    }

    /**
     * Interactors are classes built for fetching data from your database, web services, or any other data source.
     **/
    interface GetNoticeIntractor {

        interface OnFinishedListener {
            void onFinished(ArrayList<Movies> moviesArrayList);
            void onFailure(Throwable t);
        }

        void getNoticeArrayList(OnFinishedListener onFinishedListener);
    }
}

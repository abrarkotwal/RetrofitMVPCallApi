package com.esmsquare.retrofitmvpcallapi.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MovieResult {

    @SerializedName("results")
    private ArrayList<Movies> movieList;

    public ArrayList<Movies> getNoticeArrayList() {
        return movieList;
    }

    public void setMovieArrayList(ArrayList<Movies> moviesArrayList) {
        this.movieList = moviesArrayList;
    }
}
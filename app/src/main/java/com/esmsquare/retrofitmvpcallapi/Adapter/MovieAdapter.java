package com.esmsquare.retrofitmvpcallapi.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.esmsquare.retrofitmvpcallapi.Model.Movies;
import com.esmsquare.retrofitmvpcallapi.R;
import com.esmsquare.retrofitmvpcallapi.MyInterface.RecyclerItemClickListener;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private ArrayList<Movies> moviesList;
    private RecyclerItemClickListener recyclerItemClickListener;
    private Context context;

    public MovieAdapter(Context context,ArrayList<Movies> moviesList,RecyclerItemClickListener recyclerItemClickListener) {
        this.moviesList = moviesList;
        this.recyclerItemClickListener = recyclerItemClickListener;
        this.context = context;
    }


    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_movie_display, parent, false);
        return new MovieViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        final Movies currentMovie = moviesList.get(position);
        holder.movieTitle.setText(currentMovie.getTitle());
        holder.movieRating.setText("Rating:- "+currentMovie.getVote_average()+"("+currentMovie.getVote_count()+")");
        holder.movieOverView.setText(currentMovie.getOverview());
        holder.movieReleaseDate.setText("Release On:- "+currentMovie.getReleaseDate());

        Glide.with(context).load("http://image.tmdb.org/t/p/w500/"+currentMovie.getPosterPath()).into(holder.moviePoster);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerItemClickListener.onItemClick(moviesList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    static class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView moviePoster;
        TextView movieTitle,movieReleaseDate,movieOverView,movieRating;


        MovieViewHolder(View itemView) {
            super(itemView);
            moviePoster         =  itemView.findViewById(R.id.moviePoster);
            movieTitle          =  itemView.findViewById(R.id.movieTitle);
            movieReleaseDate    =  itemView.findViewById(R.id.movieReleaseDate);
            movieOverView       =  itemView.findViewById(R.id.movieOverView);
            movieRating         =  itemView.findViewById(R.id.movieRating);
        }
    }
}
package com.pitang.hlfs.movielist.model.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pitang.hlfs.movielist.R;
import com.pitang.hlfs.movielist.configuration.glide.GlideApp;
import com.pitang.hlfs.movielist.model.Movie;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by hlfs on 31/01/18.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(Movie movie);
    }

    private List<Movie> movieList;
    private final OnItemClickListener listener;

    public MovieAdapter(List<Movie> movieList, OnItemClickListener listener) {
        this.movieList = movieList;
        this.listener = listener;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);

        MovieViewHolder viewHolder = new MovieViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.bind(movie, this.listener);


        /*Movie movie = movieList.get(position);
        if(holder.getLayoutPosition() == position) {
            holder.bind(movie, this.listener);
        }else {
            GlideApp.with(holder.itemView.getContext()).clear(holder.movieImageView);
            Drawable draw = ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.movie_load);

            holder.movieImageView.setImageDrawable(draw);
        }*/
    }

    @Override
    public int getItemCount() {
        return movieList != null? movieList.size() : 0;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.movieNameView)
        TextView movieNameView;

        @BindView(R.id.movieImageView)
        ImageView movieImageView;

        private Movie movie;


        public MovieViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(final Movie movie, final OnItemClickListener listener) {
            movieNameView.setText(movie.getName());
            this.movie = movie;
            GlideApp.with(itemView.getContext()).load(movie.getUrl()).
                    placeholder(R.drawable.movie_load).error(R.drawable.error_load).into(movieImageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(getMovie());
                }
            });
        }

        public Movie getMovie() {
            return movie;
        }


    }


}

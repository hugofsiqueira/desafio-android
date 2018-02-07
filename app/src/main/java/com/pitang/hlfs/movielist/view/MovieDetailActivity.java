package com.pitang.hlfs.movielist.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.pitang.hlfs.movielist.R;
import com.pitang.hlfs.movielist.configuration.components.DaggerIMovieApplicationComponent;
import com.pitang.hlfs.movielist.model.Movie;
import com.pitang.hlfs.movielist.presenter.IMovieDetailPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieDetailActivity extends AppCompatActivity {

    private Movie movie;

    @BindView(R.id.movieDetailImageView)
    ImageView imageView;
    @BindView(R.id.movieTitleTextView)
    TextView titleTextView;
    @BindView(R.id.movieDescTextView)
    TextView descTextView;

    @Inject
    IMovieDetailPresenter movieDetailPresenter;


    public MovieDetailActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DaggerIMovieApplicationComponent.create().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);
        ButterKnife.bind(this);

        movieDetailPresenter.setMovieDetailActivity(this);

        movie = (Movie)getIntent().getSerializableExtra(movieDetailPresenter.getMovieExtra());

        movieDetailPresenter.showMovieDetail(movie);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public TextView getTitleTextView() {
        return titleTextView;
    }

    public TextView getDescTextView() {
        return descTextView;
    }
}

package com.pitang.hlfs.movielist.view;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.pitang.hlfs.movielist.R;
import com.pitang.hlfs.movielist.listeners.EndlessRecyclerViewScrollListener;
import com.pitang.hlfs.movielist.model.Movie;
import com.pitang.hlfs.movielist.model.adapters.MovieAdapter;
import com.pitang.hlfs.movielist.presenter.IMoviePresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.movieRecyclerView)
    RecyclerView recyclerView;

    @Inject
    IMoviePresenter moviePresenter;


    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        moviePresenter.setMainActivity(this);

        setupRecycler();
    }

    private void setupRecycler() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        MovieAdapter movieAdapter = new MovieAdapter(moviePresenter.getMovieList(0), moviePresenter.getMovieAdapterListener());
        recyclerView.setAdapter(movieAdapter);

        recyclerView.setHasFixedSize(false);

        recyclerView.getLayoutManager().setMeasurementCacheEnabled(false);

        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        EndlessRecyclerViewScrollListener scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                List<Movie> moreMovies = moviePresenter.getMovieList(page);
                final MovieAdapter adapter = (MovieAdapter) view.getAdapter();
                final int curSize = adapter.getItemCount();
                adapter.getMovieList().addAll(moreMovies);

                view.post(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        };

        recyclerView.addOnScrollListener(scrollListener);

    }

}

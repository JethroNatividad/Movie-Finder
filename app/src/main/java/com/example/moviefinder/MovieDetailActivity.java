package com.example.moviefinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.text.TextUtils;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;


import java.lang.reflect.Array;
import java.util.Arrays;

import java.util.List;
import java.util.stream.Collectors;

public class MovieDetailActivity extends AppCompatActivity {
    ImageView iv_poster;
    TextView tv_title;
    TextView tv_year;
    TextView tv_rated;
    TextView tv_runtime;
    TextView genre;
    TextView released;
    TextView plot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        Intent intent = getIntent();
        String movieId = intent.getStringExtra("movieId");
        setTitle("Movie Details");
        MovieDataService movieDataService = new MovieDataService(this);

        iv_poster = findViewById(R.id.iv_d_poster);
        tv_title = findViewById(R.id.tv_d_title);
        tv_year = findViewById(R.id.tv_d_year);
        tv_rated = findViewById(R.id.tv_d_rated);
        tv_runtime = findViewById(R.id.tv_d_runtime);
        genre = findViewById(R.id.tv_d_genre);
        released = findViewById(R.id.tv_d_released);
        plot = findViewById(R.id.tv_d_plot);

        movieDataService.getMovieDetails(movieId, new MovieDataService.GetMovieDetailsResponse() {
            @Override
            public void onError(String error) {
                Toast.makeText(MovieDetailActivity.this, error, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(MovieDetailModel response) {
                Picasso.get().load(response.Poster).into(iv_poster);
                tv_title.setText(response.Title);
                tv_year.setText(response.Year);
                tv_rated.setText(response.Rated);
                tv_runtime.setText(response.Runtime);

                String[] genresList = response.Genre.split(",");
                String genres = TextUtils.join(", ", 3 > genresList.length ? genresList : Arrays.copyOf(genresList, 3));
                genre.setText(genres);

                released.setText(response.Released);
                plot.setText(response.Plot);
            }
        });
    }
}
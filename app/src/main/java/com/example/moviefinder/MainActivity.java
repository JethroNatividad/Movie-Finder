package com.example.moviefinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText et_searchbar;
    Button btn_search;
    ListView lv_search_result;
    MovieSearchAdapter movieSearchAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MovieDataService movieDataService = new MovieDataService(this);
        et_searchbar = findViewById(R.id.et_searchbar);
        btn_search = findViewById(R.id.btn_search);
        lv_search_result = findViewById(R.id.lv_search_result);


        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchTerm = et_searchbar.getText().toString();
                movieDataService.searchMovie(searchTerm, new MovieDataService.SearchMovieResponse() {
                    @Override
                    public void onError(String error) {
                        Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(ArrayList<MovieSearchModel> response) {
                        movieSearchAdapter = new MovieSearchAdapter(MainActivity.this, response);
                        lv_search_result.setAdapter(movieSearchAdapter);
                        lv_search_result.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                MovieSearchModel currentModel = movieSearchAdapter.getItem(position);
                                openMovieDetails(currentModel);
                            }
                        });

                    }
                });
            }
        });


    }
    public void openMovieDetails(MovieSearchModel movieSearchModel){
        Intent intent = new Intent(this, MovieDetailActivity.class);
        intent.putExtra("movieId", movieSearchModel.imdbID);
        startActivity(intent);
    }
}
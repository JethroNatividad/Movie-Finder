package com.example.moviefinder;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MovieDataService {
    public static final String SEARCH_MOVIE_ENDPOINT = "https://www.omdbapi.com/?apikey=thewdb&s=";
    public static final String MOVIE_DETAIL_ENDPOINT = "https://www.omdbapi.com/?apikey=thewdb&i=";
    Context context;
    final Gson gson = new Gson();

    public MovieDataService(Context context) {
        this.context = context;
    }


    public interface SearchMovieResponse {
        void onError(String error);
        void onResponse(ArrayList<MovieSearchModel> response);
    }

    public void searchMovie(String searchTerm, SearchMovieResponse searchMovieResponse){
        String url = SEARCH_MOVIE_ENDPOINT + searchTerm;
        ArrayList<MovieSearchModel> movies = new ArrayList<>();

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray search_result = response.getJSONArray("Search");
                    for(int i = 0; i < search_result.length(); i++){
                        MovieSearchModel movie = gson.fromJson(search_result.getString(i), MovieSearchModel.class);
                        movies.add(movie);
                    }
                        searchMovieResponse.onResponse(movies);

                } catch (JSONException e) {
                    e.printStackTrace();
//                    searchMovieResponse.onError(e.getMessage());
                    searchMovieResponse.onError("No results found");

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                searchMovieResponse.onError(error.getMessage());
                searchMovieResponse.onError("Can't connect to the internet");
            }
        });
        MySingleton.getInstance(context).addToRequestQueue(request);
    }

    public interface GetMovieDetailsResponse {
        void onError(String error);
        void onResponse(MovieDetailModel response);
    }

    public void getMovieDetails(String movieId, GetMovieDetailsResponse getMovieDetailsResponse){
        String url = MOVIE_DETAIL_ENDPOINT + movieId;
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                MovieDetailModel movie = gson.fromJson(response.toString(), MovieDetailModel.class);
                getMovieDetailsResponse.onResponse(movie);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
//                getMovieDetailsResponse.onError(error.getMessage());
                getMovieDetailsResponse.onError("Can't connect to the internet");
            }
        });
        MySingleton.getInstance(context).addToRequestQueue(request);
    }

}

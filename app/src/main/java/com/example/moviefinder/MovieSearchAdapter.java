package com.example.moviefinder;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MovieSearchAdapter extends BaseAdapter {
    Activity context;
    ArrayList<MovieSearchModel> movies;
    private LayoutInflater inflater = null;

    public MovieSearchAdapter(Activity context, ArrayList<MovieSearchModel> movies) {
        this.context = context;
        this.movies = movies;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public MovieSearchModel getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        itemView = (itemView == null) ? inflater.inflate(R.layout.movie_list_item, null) : itemView;

        ImageView iv_poster = (ImageView) itemView.findViewById(R.id.iv_poster);
        TextView tv_title = (TextView) itemView.findViewById(R.id.tv_title);
        TextView tv_year = (TextView) itemView.findViewById(R.id.tv_year);
        TextView tv_type = (TextView) itemView.findViewById(R.id.tv_type);

        MovieSearchModel currentMovie = movies.get(position);


//        iv_poster.setImageResource(R.drawable.g);
        Picasso.get().load(currentMovie.Poster).into(iv_poster);
        tv_title.setText(currentMovie.Title);
        tv_year.setText(currentMovie.Year);
        tv_type.setText(currentMovie.Type);

        return itemView;

    }
}

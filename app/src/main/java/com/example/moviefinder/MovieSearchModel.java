package com.example.moviefinder;

public class MovieSearchModel {
    private String Title;
    private String Year;
    private String imdbID;
    private String Type;
    private String Poster;

    public MovieSearchModel(String Title, String Year, String imdbID, String Type, String Poster) {
        this.Title = Title;
        this.Year = Year;
        this.imdbID = imdbID;
        this.Type = Type;
        this.Poster = Poster;
    }

    @Override
    public String toString() {
        return "MovieSearchModel{" +
                "Title='" + Title + '\'' +
                ", Year='" + Year + '\'' +
                ", imdbID='" + imdbID + '\'' +
                ", Type='" + Type + '\'' +
                ", Poster='" + Poster + '\'' +
                '}';
    }
}

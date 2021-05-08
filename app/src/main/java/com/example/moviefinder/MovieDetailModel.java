package com.example.moviefinder;


public class MovieDetailModel {
    String Title;
    String Year;
    String Rated;
    String Released;
    String Runtime;
    String Genre;
    String Director;
    String Writer;
    String Actors;
    String Plot;
    String Language;
    String Country;
    String Awards;
    String Poster;
    String Metascore;
    String imdbRating;
    String imdbVotes;
    String imdbID;
    String Type;
    String DVD;
    String BoxOffice;
    String Production;
    String Website;
    String Response;

    public MovieDetailModel(String title, String year, String rated, String released, String runtime, String genre, String director, String writer, String actors, String plot, String language, String country, String awards, String poster, String metascore, String imdbRating, String imdbVotes, String imdbID, String type, String DVD, String boxOffice, String production, String website, String response) {
        this.Title = title;
        this.Year = year;
        this.Rated = rated;
        this.Released = released;
        this.Runtime = runtime;
        this.Genre = genre;
        this.Director = director;
        this.Writer = writer;
        this.Actors = actors;
        this.Plot = plot;
        this.Language = language;
        this.Country = country;
        this.Awards = awards;
        this.Poster = poster;
        this.Metascore = metascore;
        this.imdbRating = imdbRating;
        this.imdbVotes = imdbVotes;
        this.imdbID = imdbID;
        this.Type = type;
        this.DVD = DVD;
        this.BoxOffice = boxOffice;
        this.Production = production;
        this.Website = website;
        this.Response = response;
    }



    @Override
    public String toString() {
        return "MovieDetailModel{" +
                "Title='" + Title + '\'' +
                ", Year='" + Year + '\'' +
                ", Rated='" + Rated + '\'' +
                ", Released='" + Released + '\'' +
                ", Runtime='" + Runtime + '\'' +
                ", Genre='" + Genre + '\'' +
                ", Director='" + Director + '\'' +
                ", Writer='" + Writer + '\'' +
                ", Actors='" + Actors + '\'' +
                ", Plot='" + Plot + '\'' +
                ", Language='" + Language + '\'' +
                ", Country='" + Country + '\'' +
                ", Awards='" + Awards + '\'' +
                ", Poster='" + Poster + '\'' +
                ", Metascore='" + Metascore + '\'' +
                ", imdbRating='" + imdbRating + '\'' +
                ", imdbVotes='" + imdbVotes + '\'' +
                ", imdbID='" + imdbID + '\'' +
                ", Type='" + Type + '\'' +
                ", DVD='" + DVD + '\'' +
                ", BoxOffice='" + BoxOffice + '\'' +
                ", Production='" + Production + '\'' +
                ", Website='" + Website + '\'' +
                ", Response='" + Response + '\'' +
                '}';
    }
}

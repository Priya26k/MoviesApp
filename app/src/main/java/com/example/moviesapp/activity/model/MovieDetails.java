package com.example.moviesapp.activity.model;

import java.util.ArrayList;

public class MovieDetails {
    private boolean adult,video;
    private String backdrop_path,homepage,imdb_id,original_language,original_title,overview,poster_path,release_date,status,tagline;
    private ArrayList<MovieDetailsBelongToCollection> belongToCollectionArrayList;
    private int budget,revenue,runtime,vote_count;
    private ArrayList<MovieDetailsGenres> genres;
    private double popularity,vote_average;
    private ArrayList<MovieDetailProductionCompanies> productionCompanies;
    private ArrayList<MovieDetailsProductionCountries> productionCountries;
    private ArrayList<MovieDetailsSpokenLanguages> spokenLanguages;

    public MovieDetails() {
    }

    public MovieDetails(boolean adult, boolean video, String backdrop_path, String homepage, String imdb_id, String original_language, String original_title, String overview, String poster_path, String release_date, String status, String tagline, ArrayList<MovieDetailsBelongToCollection> belongToCollectionArrayList, int budget, int revenue, int runtime, int vote_count, ArrayList<MovieDetailsGenres> genres, double popularity, double vote_average, ArrayList<MovieDetailProductionCompanies> productionCompanies, ArrayList<MovieDetailsProductionCountries> productionCountries, ArrayList<MovieDetailsSpokenLanguages> spokenLanguages) {
        this.adult = adult;
        this.video = video;
        this.backdrop_path = backdrop_path;
        this.homepage = homepage;
        this.imdb_id = imdb_id;
        this.original_language = original_language;
        this.original_title = original_title;
        this.overview = overview;
        this.poster_path = poster_path;
        this.release_date = release_date;
        this.status = status;
        this.tagline = tagline;
        this.belongToCollectionArrayList = belongToCollectionArrayList;
        this.budget = budget;
        this.revenue = revenue;
        this.runtime = runtime;
        this.vote_count = vote_count;
        this.genres = genres;
        this.popularity = popularity;
        this.vote_average = vote_average;
        this.productionCompanies = productionCompanies;
        this.productionCountries = productionCountries;
        this.spokenLanguages = spokenLanguages;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public String getBackdrop_path() {
        String baseUrl = "https://image.tmdb.org/t/p/w500";
        return baseUrl+backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public ArrayList<MovieDetailsBelongToCollection> getBelongToCollectionArrayList() {
        return belongToCollectionArrayList;
    }

    public void setBelongToCollectionArrayList(ArrayList<MovieDetailsBelongToCollection> belongToCollectionArrayList) {
        this.belongToCollectionArrayList = belongToCollectionArrayList;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public ArrayList<MovieDetailsGenres> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<MovieDetailsGenres> genres) {
        this.genres = genres;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public ArrayList<MovieDetailProductionCompanies> getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(ArrayList<MovieDetailProductionCompanies> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public ArrayList<MovieDetailsProductionCountries> getProductionCountries() {
        return productionCountries;
    }

    public void setProductionCountries(ArrayList<MovieDetailsProductionCountries> productionCountries) {
        this.productionCountries = productionCountries;
    }

    public ArrayList<MovieDetailsSpokenLanguages> getSpokenLanguages() {
        return spokenLanguages;
    }

    public void setSpokenLanguages(ArrayList<MovieDetailsSpokenLanguages> spokenLanguages) {
        this.spokenLanguages = spokenLanguages;
    }
}

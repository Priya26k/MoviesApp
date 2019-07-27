package com.example.moviesapp.activity.model;

import java.util.ArrayList;

public class PersonResponseResults {
    private double popularity;
    private long id;
    private String profile_path,name;
    private ArrayList<PersonResponseResultsKnownFor> known_for;
    private boolean adult;

    public PersonResponseResults() {
    }

    public PersonResponseResults(double popularity, long id, String profile_path, String name, ArrayList<PersonResponseResultsKnownFor> known_for, boolean adult) {
        this.popularity = popularity;
        this.id = id;
        this.profile_path = profile_path;
        this.name = name;
        this.known_for = known_for;
        this.adult = adult;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProfile_path() {
        String baseUrl = "https://image.tmdb.org/t/p/w500";
        return baseUrl+profile_path;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<PersonResponseResultsKnownFor> getKnown_for() {
        return known_for;
    }

    public void setKnown_for(ArrayList<PersonResponseResultsKnownFor> known_for) {
        this.known_for = known_for;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

}

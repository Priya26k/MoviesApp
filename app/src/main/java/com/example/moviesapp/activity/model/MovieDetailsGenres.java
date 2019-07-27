package com.example.moviesapp.activity.model;

public class MovieDetailsGenres {
    private int id;
    private String name;

    public MovieDetailsGenres() {
    }

    public MovieDetailsGenres(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

package com.example.moviesapp.activity.model;

import java.util.ArrayList;

public class PersonDetails {
    private String birthday,known_for_department,deathday,name,biography,place_of_birth,profile_path,imdb_id,homepage;
    private int id,gender;
    private ArrayList<String> also_known_as;
    private float popularity;
    private boolean adult;

    public PersonDetails() {
    }

    public PersonDetails(String birthday, String known_for_department, String deathday, String name, String biography, String place_of_birth, String profile_path, String imdb_id, String homepage, int id, int gender, ArrayList<String> also_known_as, float popularity, boolean adult) {
        this.birthday = birthday;
        this.known_for_department = known_for_department;
        this.deathday = deathday;
        this.name = name;
        this.biography = biography;
        this.place_of_birth = place_of_birth;
        this.profile_path = profile_path;
        this.imdb_id = imdb_id;
        this.homepage = homepage;
        this.id = id;
        this.gender = gender;
        this.also_known_as = also_known_as;
        this.popularity = popularity;
        this.adult = adult;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getKnown_for_department() {
        return known_for_department;
    }

    public void setKnown_for_department(String known_for_department) {
        this.known_for_department = known_for_department;
    }

    public String getDeathday() {
        return deathday;
    }

    public void setDeathday(String deathday) {
        this.deathday = deathday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getPlace_of_birth() {
        return place_of_birth;
    }

    public void setPlace_of_birth(String place_of_birth) {
        this.place_of_birth = place_of_birth;
    }

    public String getProfile_path() {
        String baseUrl = "https://image.tmdb.org/t/p/w500";
        return baseUrl+profile_path;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public ArrayList<String> getAlso_known_as() {
        return also_known_as;
    }

    public void setAlso_known_as(ArrayList<String> also_known_as) {
        this.also_known_as = also_known_as;
    }

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }
}

package com.example.moviesapp.activity.model;

import java.util.ArrayList;

public class PersonImages {
    private ArrayList<PersonImageProfile> personImageProfileArrayList;
    private int id;

    public PersonImages() {
    }

    public PersonImages(ArrayList<PersonImageProfile> personImageProfileArrayList, int id) {
        this.personImageProfileArrayList = personImageProfileArrayList;
        this.id = id;
    }

    public ArrayList<PersonImageProfile> getPersonImageProfileArrayList() {
        return personImageProfileArrayList;
    }

    public void setPersonImageProfileArrayList(ArrayList<PersonImageProfile> personImageProfileArrayList) {
        this.personImageProfileArrayList = personImageProfileArrayList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

package com.example.moviesapp.activity.ApiService;

import com.example.moviesapp.activity.model.Movie;
import com.example.moviesapp.activity.model.Person;
import com.example.moviesapp.activity.model.PersonDetails;
import com.example.moviesapp.activity.model.PersonImages;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("search/movie")
    Call<Movie> getMoviesQuery(@Query("api_key")String api_key,
                               @Query("query")String query);

    @GET("search/person")
    Call<Person> getPersonQuery(@Query("api_key")String api_key,
                                @Query("query")String query);

    @GET("person/{person_id}")
    Call<PersonDetails> getPersonDetailsById(@Path("person_id")int person_id,
                                             @Query("api_key")String api_key);

    @GET("Person/{person_id}/images}")
    Call<PersonImages> getPrsonImages(@Path("person_id")int person_id,
                                      @Query("api_key")String api_key);
}

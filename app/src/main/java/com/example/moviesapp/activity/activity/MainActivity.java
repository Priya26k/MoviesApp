package com.example.moviesapp.activity.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.moviesapp.BuildConfig;
import com.example.moviesapp.R;
import com.example.moviesapp.activity.ApiService.ApiService;
import com.example.moviesapp.activity.Clients.RetrofitClient;
import com.example.moviesapp.activity.adapter.AdapterMovie;
import com.example.moviesapp.activity.adapter.AdapterPerson;
import com.example.moviesapp.activity.model.Movie;
import com.example.moviesapp.activity.model.MovieResponseResults;
import com.example.moviesapp.activity.model.Person;
import com.example.moviesapp.activity.model.PersonResponseResults;
import com.google.gson.Gson;

import java.util.ArrayList;

import io.paperdb.Paper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    String api_key = "09977444dc3d71c5cb9bed2e4c7b42c7",query,movie="By Movie Title",person="By Person name";
    Spinner spinner;
    EditText editText;
    Button button;
    RecyclerView recyclerView;
    ArrayList<String> category = new ArrayList<>();
    int position;
    ApiService apiService;
    AdapterMovie adapterMovie;
    AdapterPerson adapterPerson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.source_spinner);
        editText = (EditText)findViewById(R.id.edittext);
        button = (Button)findViewById(R.id.search);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        Paper.init(this);

        apiService = RetrofitClient.getClient().create(ApiService.class);

        category.add(movie);
        category.add(person);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,category);
        spinner.setAdapter(arrayAdapter);

        if(Paper.book().read("position")!=null){
            position = Paper.book().read("position");
            spinner.setSelection(position);
        }

        position = spinner.getSelectedItemPosition();
        if(position==0){
            editText.setHint("Enter any movie title..");
        } else {
            editText.setHint("Enter any person name..");
        }

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(position==0){
                    editText.setHint("Enter any movie title..");
                } else {
                    editText.setHint("Enter any person name..");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        if (Paper.book().read("cache")!=null){
            String results = Paper.book().read("cache");
            if (Paper.book().read("source")!=null){
                String source = Paper.book().read("source");
                if(source.equals("movie")){
                    Movie movie = new Gson().fromJson(results,Movie.class);
                    if(movie!=null){
                        ArrayList<MovieResponseResults> movieResponseResults = movie.getResults();
                        adapterMovie = new AdapterMovie(MainActivity.this,movieResponseResults);
                        recyclerView.setAdapter(adapterMovie);
                        LayoutAnimationController animationController = AnimationUtils.loadLayoutAnimation(MainActivity.this,R.anim.layout_slide_right);
                        recyclerView.setLayoutAnimation(animationController);
                        recyclerView.scheduleLayoutAnimation();

                        Paper.book().write("cache",new Gson().toJson(movie));
                        Paper.book().write("source","movie");
                    }
                } else {
                    Person person = new Gson().fromJson(results,Person.class);
                    if(person!=null){
                        ArrayList<PersonResponseResults> personResponseResults = person.getResults();
                        adapterPerson = new AdapterPerson(MainActivity.this,personResponseResults);
                        recyclerView.setAdapter(adapterPerson);
                        LayoutAnimationController animationController = AnimationUtils.loadLayoutAnimation(MainActivity.this,R.anim.layout_slide_right);
                        recyclerView.setLayoutAnimation(animationController);
                        recyclerView.scheduleLayoutAnimation();

                        Paper.book().write("cache",new Gson().toJson(person));
                        Paper.book().write("source","person");
                    }
                }
            }
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText.getText()!=null){
                    query = editText.getText().toString();
                    if(query.equals("")||query.equals(" ")){
                        Toast.makeText(MainActivity.this, "Please enter any text..", Toast.LENGTH_SHORT).show();
                    } else {
                        editText.setText("");
                        String finalQuery = query.replaceAll(" ","+");
                        if(category.size()>0){
                            String categoryname = category.get(spinner.getSelectedItemPosition());
                            if(categoryname.equals(movie)){
                                Call<Movie> movieCall = apiService.getMoviesQuery(BuildConfig.THE_MOVIE_DB_API_KEY,finalQuery);
                                movieCall.enqueue(new Callback<Movie>() {
                                    @Override
                                    public void onResponse(@NonNull Call<Movie> call,@NonNull Response<Movie> response) {
                                        Movie movie = response.body();
                                        if(movie!=null){
                                            ArrayList<MovieResponseResults> movieResponseResults = movie.getResults();
                                            adapterMovie = new AdapterMovie(MainActivity.this,movieResponseResults);
                                            recyclerView.setAdapter(adapterMovie);
                                            LayoutAnimationController animationController = AnimationUtils.loadLayoutAnimation(MainActivity.this,R.anim.layout_slide_right);
                                            recyclerView.setLayoutAnimation(animationController);
                                            recyclerView.scheduleLayoutAnimation();

                                            Paper.book().write("cache",new Gson().toJson(movie));
                                            Paper.book().write("source","movie");
                                        }
                                    }

                                    @Override
                                    public void onFailure(@NonNull Call<Movie> call,@NonNull Throwable t) {

                                    }
                                });
                            }else {
                                Call<Person> personCall = apiService.getPersonQuery(BuildConfig.THE_MOVIE_DB_API_KEY,finalQuery);
                                personCall.enqueue(new Callback<Person>() {
                                    @Override
                                    public void onResponse(@NonNull Call<Person> call,@NonNull Response<Person> response) {
                                        Person person = response.body();
                                        if(person!=null){
                                            ArrayList<PersonResponseResults> personResponseResults = person.getResults();
                                            adapterPerson = new AdapterPerson(MainActivity.this,personResponseResults);
                                            recyclerView.setAdapter(adapterPerson);
                                            LayoutAnimationController animationController = AnimationUtils.loadLayoutAnimation(MainActivity.this,R.anim.layout_slide_right);
                                            recyclerView.setLayoutAnimation(animationController);
                                            recyclerView.scheduleLayoutAnimation();

                                            Paper.book().write("cache",new Gson().toJson(person));
                                            Paper.book().write("source","person");
                                        }
                                    }

                                    @Override
                                    public void onFailure(@NonNull Call<Person> call,@NonNull Throwable t) {

                                    }
                                });
                            }
                        }
                    }
                }
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();

        Paper.book().write("position",spinner.getSelectedItemPosition());
    }

}
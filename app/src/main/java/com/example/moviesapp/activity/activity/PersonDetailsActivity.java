package com.example.moviesapp.activity.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moviesapp.BuildConfig;
import com.example.moviesapp.R;
import com.example.moviesapp.activity.ApiService.ApiService;
import com.example.moviesapp.activity.Clients.RetrofitClient;
import com.example.moviesapp.activity.adapter.PersonProfileImageAdapter;
import com.example.moviesapp.activity.model.PersonDetails;
import com.example.moviesapp.activity.model.PersonImageProfile;
import com.example.moviesapp.activity.model.PersonImages;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonDetailsActivity extends AppCompatActivity {
    int id;
    KenBurnsView imageView;
    LinearLayout alsoKnownAsLayout,birthdayLayout,placeOfBirthLayout,deathDayLayout,departmentLayout,homePageLayout,biographyLayout,profileImagesLayout;
    TextView textAlsoKnownAs,textBirthday,textPlaceOfBirth,textDeathDay,textDepartment,textHomePage,textBiography,textName;
    String profilePath,name,birthday,placeOfBirth,deathDay,department,homePage,biography;
    ArrayList<String> alsoknownas;
    RecyclerView recyclerView;
    PersonProfileImageAdapter personProfileImageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_details);
        imageView = (KenBurnsView)findViewById(R.id.person_detail_profile_image_view);
        alsoKnownAsLayout = (LinearLayout)findViewById(R.id.person_detail_also_known_as_layout);
        birthdayLayout = (LinearLayout)findViewById(R.id.person_detail_birthday_layout);
        placeOfBirthLayout = (LinearLayout)findViewById(R.id.person_detail_place_of_birth_layout);
        deathDayLayout = (LinearLayout)findViewById(R.id.person_detail_deathday_layout);
        departmentLayout = (LinearLayout)findViewById(R.id.person_detail_department_layout);
        homePageLayout = (LinearLayout)findViewById(R.id.person_detail_homepage_layout);
        biographyLayout = (LinearLayout)findViewById(R.id.person_detail_biography_layout);
        profileImagesLayout = (LinearLayout)findViewById(R.id.person_detail_profile_images_layout);

        textAlsoKnownAs = (TextView)findViewById(R.id.person_detail_also_known_as);
        textBirthday = (TextView)findViewById(R.id.person_detail_birthday);
        textPlaceOfBirth = (TextView)findViewById(R.id.person_detail_place_of_birth);
        textDeathDay = (TextView)findViewById(R.id.person_detail_deathday);
        textDepartment = (TextView)findViewById(R.id.person_detail_department);
        textHomePage = (TextView)findViewById(R.id.person_detail_homepage);
        textName = (TextView)findViewById(R.id.person_detail_name);
        textBiography = (TextView)findViewById(R.id.person_detail_biography);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);

        Intent intent = getIntent();
        ApiService apiService = RetrofitClient.getClient().create(ApiService.class);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        if (intent!=null && intent.getExtras()!=null){
            if (intent.getExtras().getString("id")!=null){
                id = Integer.parseInt(intent.getExtras().getString("id"));
                Call<PersonDetails> call = apiService.getPersonDetailsById(id, BuildConfig.THE_MOVIE_DB_API_KEY);
                call.enqueue(new Callback<PersonDetails>() {
                    @Override
                    public void onResponse(@NonNull Call<PersonDetails> call,@NonNull Response<PersonDetails> response) {
                        PersonDetails personDetails = response.body();
                        if (personDetails!=null){
                            preparePersonDetails(personDetails);
                        } else {
                            Toast.makeText(PersonDetailsActivity.this, "Any Details not found", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<PersonDetails> call,@NonNull Throwable t) {
                        Toast.makeText(PersonDetailsActivity.this, "Any Details not found", Toast.LENGTH_SHORT).show();
                    }
                });

                Call<PersonImages> call1 = apiService.getPrsonImages(id,BuildConfig.THE_MOVIE_DB_API_KEY);
                call1.enqueue(new Callback<PersonImages>() {
                    @Override
                    public void onResponse(@NonNull Call<PersonImages> call,@NonNull Response<PersonImages> response) {
                        PersonImages personImages = response.body();
                        if (personImages!=null){
                            ArrayList<PersonImageProfile> personImageProfileArrayList = personImages.getPersonImageProfileArrayList();
                            if (personImageProfileArrayList!=null&&personImageProfileArrayList.size()>0){
                                profileImagesLayout.setVisibility(View.VISIBLE);
                                personProfileImageAdapter = new PersonProfileImageAdapter(PersonDetailsActivity.this,personImageProfileArrayList);
                                recyclerView.setAdapter(personProfileImageAdapter);
                                LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(PersonDetailsActivity.this,R.anim.layout_slide_right);
                                recyclerView.setLayoutAnimation(controller);
                                recyclerView.scheduleLayoutAnimation();
                            } else {
                                profileImagesLayout.setVisibility(View.GONE);
                            }
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<PersonImages> call,@NonNull Throwable t) {

                    }
                });
            }

        }
    }

    private void preparePersonDetails(PersonDetails personDetails) {
        profilePath = personDetails.getProfile_path();
        name = personDetails.getName();
        birthday = personDetails.getBirthday();
        placeOfBirth = personDetails.getPlace_of_birth();
        deathDay = personDetails.getDeathday();
        department = personDetails.getKnown_for_department();
        homePage = personDetails.getHomepage();
        biography = personDetails.getBiography();
        alsoknownas = personDetails.getAlso_known_as();
        Picasso.with(this).load(profilePath).into(imageView);
        if(name!=null){
            if(name.length()>0){
                textName.setText(name);
                textName.setVisibility(View.VISIBLE);
            } else {
                textName.setVisibility(View.GONE);
            }
        } else {
           textName.setVisibility(View.GONE);
        }

        if(birthday!=null){
            if(birthday.length()>0){
                textBirthday.setText(birthday);
                birthdayLayout.setVisibility(View.VISIBLE);
            } else {
                birthdayLayout.setVisibility(View.GONE);
            }
        } else {
            birthdayLayout.setVisibility(View.GONE);
        }

        if(placeOfBirth!=null){
            if(placeOfBirth.length()>0){
                textPlaceOfBirth.setText(placeOfBirth);
                placeOfBirthLayout.setVisibility(View.VISIBLE);
            } else {
                placeOfBirthLayout.setVisibility(View.GONE);
            }
        } else {
            alsoKnownAsLayout.setVisibility(View.GONE);
        }

        if(deathDay!=null){
            if(deathDay.length()>0){
                textDeathDay.setText(deathDay);
                deathDayLayout.setVisibility(View.VISIBLE);
            } else {
                deathDayLayout.setVisibility(View.GONE);
            }
        } else {
            deathDayLayout.setVisibility(View.GONE);
        }

        if(homePage!=null){
            if(homePage.length()>0){
                textHomePage.setText(homePage);
                homePageLayout.setVisibility(View.VISIBLE);
            } else {
                homePageLayout.setVisibility(View.GONE);
            }
        } else {
            homePageLayout.setVisibility(View.GONE);
        }

        if(department!=null){
            if(department.length()>0){
                textDepartment.setText(department);
                departmentLayout.setVisibility(View.VISIBLE);
            } else {
                departmentLayout.setVisibility(View.GONE);
            }
        } else {
            departmentLayout.setVisibility(View.GONE);
        }

        if(biography!=null){
            if(biography.length()>0){
                textBiography.setText(biography);
                biographyLayout.setVisibility(View.VISIBLE);
            } else {
                biographyLayout.setVisibility(View.GONE);
            }
        } else {
            biographyLayout.setVisibility(View.GONE);
        }

        if(alsoknownas!=null){
            if(alsoknownas.size()>0){
                StringBuilder stringBuilder = new StringBuilder();
                for (int i=0;i<alsoknownas.size();i++){
                    if (i==alsoknownas.size()-1){
                        stringBuilder.append(alsoknownas.get(i));
                    } else {
                        stringBuilder.append(alsoknownas.get(i)).append(", ");
                    }
                }
                textAlsoKnownAs.setText(stringBuilder.toString());
                alsoKnownAsLayout.setVisibility(View.VISIBLE);
            } else {
                alsoKnownAsLayout.setVisibility(View.GONE);
            }
        } else {
            alsoKnownAsLayout.setVisibility(View.GONE);
        }
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }
}

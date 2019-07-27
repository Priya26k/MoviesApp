package com.example.moviesapp.activity.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviesapp.R;
import com.example.moviesapp.activity.ViewHolders.PersonProfileImageViewHolder;
import com.example.moviesapp.activity.activity.ImageViewerActivity;
import com.example.moviesapp.activity.model.PersonImageProfile;

import java.util.ArrayList;

public class PersonProfileImageAdapter extends RecyclerView.Adapter<PersonProfileImageViewHolder> {

    private Activity activity;
    private ArrayList<PersonImageProfile> personImageProfileArrayList;

    public PersonProfileImageAdapter(Activity activity, ArrayList<PersonImageProfile> personImageProfileArrayList) {
        this.activity = activity;
        this.personImageProfileArrayList = personImageProfileArrayList;
    }

    @NonNull
    @Override
    public PersonProfileImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.profile_image_layout,parent,false);
        return new PersonProfileImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PersonProfileImageViewHolder holder, int position) {
        final PersonImageProfile imageProfile = personImageProfileArrayList.get(position);
        holder.setProfileImage(activity,imageProfile.getFile_path());
        holder.profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, ImageViewerActivity.class);
                ActivityOptionsCompat compat = ActivityOptionsCompat.makeSceneTransitionAnimation(activity,holder.profileImage, ViewCompat.getTransitionName(holder.profileImage));
                intent.putExtra("image_url",imageProfile.getFile_path());
                activity.startActivity(intent,compat.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return personImageProfileArrayList.size();
    }
}

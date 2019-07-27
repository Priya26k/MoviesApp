package com.example.moviesapp.activity.ViewHolders;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviesapp.R;
import com.squareup.picasso.Picasso;

public class PersonProfileImageViewHolder extends RecyclerView.ViewHolder {
    public ImageView profileImage;
    public PersonProfileImageViewHolder(@NonNull View view){
        super(view);
        profileImage = (ImageView)view.findViewById(R.id.profile_images);
    }
    public void setProfileImage(Activity activity,String profilePath){
        Picasso.with(activity).load(profilePath).into(profileImage);
    }
}

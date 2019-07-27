package com.example.moviesapp.activity.ViewHolders;

import android.content.Context;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviesapp.R;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.flaviofaria.kenburnsview.RandomTransitionGenerator;
import com.squareup.picasso.Picasso;

public class SearchViewHolder extends RecyclerView.ViewHolder {

    private KenBurnsView posterimageview;
    public TextView posterTitle;

    public SearchViewHolder(@NonNull View view){
        super(view);
        posterimageview = (KenBurnsView)view.findViewById(R.id.poster_image_view);
        posterTitle = (TextView)view.findViewById(R.id.poster_title);

        RandomTransitionGenerator randomTransitionGenerator = new RandomTransitionGenerator(1000,new DecelerateInterpolator());
        posterimageview.setTransitionGenerator((randomTransitionGenerator));
    }

    public void setPosterimageview(Context context,String posterUrl) {
        Picasso.with(context).load(posterUrl).into(posterimageview);
    }
}

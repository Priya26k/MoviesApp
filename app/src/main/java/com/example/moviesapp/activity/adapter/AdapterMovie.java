package com.example.moviesapp.activity.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviesapp.R;
import com.example.moviesapp.activity.ViewHolders.SearchViewHolder;
import com.example.moviesapp.activity.model.MovieResponseResults;

import java.util.ArrayList;

public class AdapterMovie extends RecyclerView.Adapter<SearchViewHolder> {
    private Activity activity;
    private ArrayList<MovieResponseResults> results;

    public AdapterMovie(Activity activity, ArrayList<MovieResponseResults> results) {
        this.activity = activity;
        this.results = results;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.search_item,parent,false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        MovieResponseResults responseResults = results.get(position);
        holder.setPosterimageview(activity,responseResults.getPoster_path());
        String title = responseResults.getTitle();
        if (title!=null){
            holder.posterTitle.setVisibility(View.VISIBLE);
            holder.posterTitle.setText(title);
        } else {
            holder.posterTitle.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return results.size();
    }
}

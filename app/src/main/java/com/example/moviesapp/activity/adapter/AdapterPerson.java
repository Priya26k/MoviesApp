package com.example.moviesapp.activity.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviesapp.R;
import com.example.moviesapp.activity.ViewHolders.SearchViewHolder;
import com.example.moviesapp.activity.activity.PersonDetailsActivity;
import com.example.moviesapp.activity.model.PersonResponseResults;

import java.util.ArrayList;

public class AdapterPerson extends RecyclerView.Adapter<SearchViewHolder> {
    private Activity activity;
    private ArrayList<PersonResponseResults> results;

    public AdapterPerson(Activity activity, ArrayList<PersonResponseResults> results) {
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
        PersonResponseResults responseResults = results.get(position);
        holder.setPosterimageview(activity,responseResults.getProfile_path());
        String title = responseResults.getName();
        final long id = responseResults.getId();
        if (title!=null){
            holder.posterTitle.setVisibility(View.VISIBLE);
            holder.posterTitle.setText(title);
        } else {
            holder.posterTitle.setVisibility(View.GONE);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, PersonDetailsActivity.class);
                intent.putExtra("id",String.valueOf(id));
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });
    }

    @Override
    public int getItemCount() {
        return results.size();
    }
}

package com.example.moviesapp.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.moviesapp.R;
import com.jsibbold.zoomage.ZoomageView;
import com.squareup.picasso.Picasso;

public class ImageViewerActivity extends AppCompatActivity {
    ZoomageView zoomageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_viewer);
        zoomageView = (ZoomageView)findViewById(R.id.zoom_image_view);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Intent intent = getIntent();
        if (intent!=null&&intent.getExtras()!=null){
            if (intent.getExtras().getString("image_url")!=null){
                String url = intent.getExtras().getString("image_url");
                Picasso.with(this).load(url).into(zoomageView);
            }
        }
    }
}

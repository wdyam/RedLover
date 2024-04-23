package com.def.redlover;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private VideoView vidPlace;
    private ImageView btnPlayVid;
    private ImageView imgPlace;
    private MediaController m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vidPlace = findViewById(R.id.vidPlace);
        btnPlayVid = findViewById(R.id.buttonPlay);
        imgPlace = findViewById(R.id.imgPlace);

        btnPlayVid.setOnClickListener(v -> playVideo());
    }

    private void playVideo(){
        imgPlace.setAlpha(0f);
        btnPlayVid.setVisibility(View.GONE);

        MediaController m = new MediaController(MainActivity.this);
        vidPlace.setMediaController(m);

        String path = "android.resource://" + getPackageName() + "/" + R.raw.gambarvid1;
        Uri u = Uri.parse(path);

        vidPlace.setVideoURI(u);
        vidPlace.start();

        vidPlace.setOnCompletionListener(mp -> {
            btnPlayVid.setVisibility(View.VISIBLE);
        });
    }



}

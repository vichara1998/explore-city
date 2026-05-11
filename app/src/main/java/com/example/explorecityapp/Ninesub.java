package com.example.explorecityapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Ninesub extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ninesub);

        //Hide  the ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    public void videoad(View view) {

        startActivity(new Intent(this, Ninevideo.class));
    }

    public void ninemap(View view) {

        startActivity(new Intent(this, Ninearch.class));
    }

    public void backbutton(View view) {

        startActivity(new Intent(this, MainActivity4.class));
    }

    public void gallery(View view) {
        startActivity(new Intent(this, NinearchGallery.class));
    }
}
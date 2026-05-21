package com.example.explorecityapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Liptonsub extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liptonsub);

        //Hide  the ActionBar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    public void liptonvideo(View view) {


        startActivity(new Intent(this, Liptonvideo.class));
    }

    public void liptonmap(View view) {

        startActivity(new Intent(this, Liptonseat.class));
    }

    public void backbutton(View view) {
        finish();
    }

    public void homebutton(View view) {
        Intent intent = new Intent(this, MainActivity11.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    public void discriptionLipton(View view) {
        startActivity(new Intent(this, DiscriptionLipton.class));
    }
}
package com.example.explorecityapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Adishamsub extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adishamsub);

        //Hide  the ActionBar
        // Hide the ActionBar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

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


    public void addismvideo(View view) {
        startActivity(new Intent(this, Addismvideo.class));
    }

    public void adishammap(View view) {
        startActivity(new Intent(this,AdishamBanglow.class));
    }

    public void discriptionAdisham(View view) {startActivity(new Intent(this, DiscriptionAdisham.class));
    }
    }

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
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

    }

    public void backbutton(View view) {

        startActivity(new Intent(this,MainActivity11.class));
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

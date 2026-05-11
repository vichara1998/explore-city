package com.example.explorecityapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hide the ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }



    public void signinbtn(View view) {

        startActivity(new Intent(this, Signin.class));
    }

    public void createbtn(View view) {

        startActivity(new Intent(this, Createaccount.class));
    }
}
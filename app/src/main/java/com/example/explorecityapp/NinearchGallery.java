package com.example.explorecityapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class NinearchGallery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ninearch_gallery);

        //Hide  the ActionBar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    public void share(View view) {

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "https://www.google.com/maps/place/Nine+Arch+Bridge/@6.871067,81.0049247,17z/data=!3m1!4b1!4m5!3m4!1s0x3ae445f705bd5e29:0x560a57a28e97b936!8m2!3d6.871067!4d81.0071134");

        if (shareIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(shareIntent, "Share via"));
        } else {

        }
    }

    public void back(View view) {
        startActivity(new Intent(this, NineSub.class));
    }
}






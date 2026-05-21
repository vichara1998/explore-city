package com.example.explorecityapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Signin extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        // Hide the ActionBar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }
    public void forgotpass(View view) {
        startActivity(new Intent(this, Forgotpassword.class));
    }

    public void signupbtn(View view) {
        startActivity(new Intent(this, Createaccount.class));
    }

    public void signinbtn(View view) {

        EditText Email = findViewById(R.id.enteremail);
        EditText Password = findViewById(R.id.enterpassword);
        String email = Email.getText().toString();
        String password = Password.getText().toString();

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        if (dbHelper.login(email, password)) {
            // Login successful
            startActivity(new Intent(this, MainActivity4.class));
        } else {
            // Login failed
            Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();
        }
    }
}

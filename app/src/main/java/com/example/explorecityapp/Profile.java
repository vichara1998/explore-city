package com.example.explorecityapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Profile extends AppCompatActivity {
    DatabaseHelper mydb;
    EditText enteremail;
    Button details, delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        mydb = new DatabaseHelper(this);


        enteremail = findViewById(R.id.enterEmail);

        //View button
        details = findViewById(R.id.userDetails);
        //Delete button
        delete = findViewById(R.id.deleteAccount);
        //Update button
        // button3 = findViewById(R.id.button3);
        //Delete button


        viewAll();
        //updateData();
        deleteData();

        //hide actionbar
        getSupportActionBar().hide();
    }

    public void delete(View view) {
    }

    public void logout(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // Set the dialog title and message
        builder.setTitle("Logout Confirmation");
        builder.setMessage("Are you sure you want to log out?");

        // Add the buttons
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // Perform logout action
                // For example, you can call a logout method here
                Intent intent = new Intent(Profile.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
                dialog.dismiss();
            }
        });

        // Create the AlertDialog and show it
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    public void details(View view) {
    }

    public void viewAll() {
        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor results = mydb.getAllData();
                if (results.getCount() == 0) {
                    showMessage("Error Message:", "Please Create an Account");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (results.moveToNext()) {
                    //show id
                    buffer.append("ID :" + results.getString(0) + "\n");
                    //show first name+ last name
                    buffer.append("Full Name: " + results.getString(1) + " " + results.getString(2) + "\n");
                    //show email
                    buffer.append("Email :" + results.getString(3) + "\n");
                    //show password
                    //buffer.append("Password :" +results.getString(4)+ "\n\n");

                    showMessage("Your Information", buffer.toString());
                }


            }
        });
    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void deleteData() {
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = enteremail.getText().toString().trim();
                if (email.isEmpty()) {
                    Toast.makeText(Profile.this, "Please enter your email address!", Toast.LENGTH_LONG).show();
                } else {
                    // Call the deleteData method of the database helper object to delete the row with the specified email
                    int isDelete = mydb.deleteData(email);
                    if (isDelete > 0) {
                        Toast.makeText(Profile.this, "Account deleted successfully", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(Profile.this, "Failed to delete account. Please enter a correct email address!", Toast.LENGTH_LONG).show();
                    }

                    Intent intent = new Intent(Profile.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}

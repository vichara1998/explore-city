package com.example.explorecityapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity10 extends AppCompatActivity  {


    private SearchView searchView;


    private Menu menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        //Hide  the ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        // Initialize the SearchView
        searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                // Perform search operation here
                performSearch(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Perform filtering or suggestion operation here
                // You can perform real-time filtering based on the query here

                return false;
            }
        });
    }

    // Search function to handle the search operation
    private void performSearch(String query) {
        if (query.equals("lipton seat")|| query.equalsIgnoreCase("lipton") || query.equalsIgnoreCase("seat")) {
            // Start the search results activity or perform appropriate action
            startActivity(new Intent(this, MainActivity10.class));
        } else if (query.equalsIgnoreCase("adisham banglow") || query.equalsIgnoreCase("adisham") || query.equalsIgnoreCase("banglow")) {
            // Start the search results activity or perform appropriate action for Adisham Banglow
            startActivity(new Intent(this, MainActivity11.class));
        } else if (query.equalsIgnoreCase("nine arch") || query.equalsIgnoreCase("nine") || query.equalsIgnoreCase("arch")) {
            // Start the search results activity or perform appropriate action for Nine Arch
            startActivity(new Intent(this, MainActivity4.class));
        } else {
            // Handle case when search query doesn't match any known option
            Toast.makeText(this, "No results found", Toast.LENGTH_SHORT).show();
        }
    }

    // Logout Button
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
                Intent intent = new Intent(MainActivity10.this, MainActivity.class);
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


    //Location Button
    public void location(View view) {

        startActivity(new Intent(this, MapsActivity.class));
    }




    public void btnar1(View view) {

        startActivity(new Intent(this, Liptonsub.class));
    }

    public void btnls3(View view) {

        startActivity(new Intent(this, Liptonsub.class));
    }

    public void btnbw(View view) {
        //startActivity(new Intent(this, MainActivity4.class));
        Intent intent = new Intent(this, MainActivity4.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
    public void userbtn(View view) {
        startActivity(new Intent(this, Profile.class));
    }

}

package com.example.explorecityapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Forgotpassword extends AppCompatActivity {

DatabaseHelper mydb;
Button btnReset;
EditText enteremail,editpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);

        // Hide the ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        mydb =new DatabaseHelper(this);

        //new password
        editpassword = findViewById(R.id.editpassword);
        //email
        enteremail = findViewById(R.id.enteremail);

        //Reset button
        btnReset =findViewById(R.id.btnReset);
        updateData();
    }
    public void updateData(){
        btnReset.setOnClickListener(new View.OnClickListener() {
    @Override

        public void onClick(View view) {
     boolean isUpdate =mydb.updateData(
     enteremail.getText().toString(),
       editpassword.getText().toString());
      if(isUpdate == true)
           Toast.makeText(Forgotpassword.this, "Password Reset Successfully!",Toast.LENGTH_LONG).show();
       else
         Toast.makeText(Forgotpassword.this ,"Error!",Toast.LENGTH_LONG).show();


      }
     });
     }
}

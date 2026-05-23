package com.example.explorecityapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreateAccount extends AppCompatActivity {

    DatabaseHelper mydb;
    EditText editfirstname,editlastname,editemail,editpassword,enteremail;
    Button btnCreate,button2,button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createaccount);

        mydb =new DatabaseHelper(this);

        //Name
        editfirstname = findViewById(R.id.editfirstname);
        //Course
        editlastname = findViewById(R.id.editlastname);
        //Marks
        editemail = findViewById(R.id.editemail);
        //Password
        editpassword = findViewById(R.id.editPassword);
        //id
       // enteremail = findViewById(R.id.enteremail);


        //Create button
        btnCreate =findViewById(R.id.btnCreate);
        //View button
       // button2 =findViewById(R.id.button2);
        //Update button
       // button3 = findViewById(R.id.button3);
        //Delete button
       // button4 = findViewById(R.id.button4);

        addData();
        //viewAll();
        //updateData();
       // deleteData();

        //hide actionbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

    }
    public void addData() {
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //All text fields fill (no)
                if (editfirstname.getText().toString().isEmpty() ||
                        editlastname.getText().toString().isEmpty() ||
                        editemail.getText().toString().isEmpty() ||
                        editpassword.getText().toString().isEmpty()) {
                    Toast.makeText(CreateAccount.this, "Please fill in all fields", Toast.LENGTH_LONG).show();

                    //All text fields fill  (Yes)
                } else {
                    boolean isInserted = mydb.insertData(
                            editfirstname.getText().toString(),
                            editlastname.getText().toString(),
                            editemail.getText().toString(),
                            editpassword.getText().toString());

                    if (isInserted) {
                        //message
                        Toast.makeText(CreateAccount.this, "Account Created", Toast.LENGTH_LONG).show();

                        //go to main window
                        Intent intent = new Intent(CreateAccount.this, Signin.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(CreateAccount.this, "Account Creation Failed", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    public void signinbtn(View view) {
        Intent intent = new Intent(CreateAccount.this, Signin.class);
        startActivity(intent);
    }


   // public void viewAll(){
        //button2.setOnClickListener(new View.OnClickListener() {
           // @Override
           // public void onClick(View view) {
              //  Cursor results =mydb.getAllData();
                //if(results.getCount() ==0){
                  //  showMessage("Error Message:","Please Create an Account");
                   // return;
               // }
               // StringBuffer buffer =new StringBuffer();
               // while(results.moveToNext()){
                    //show id
                   // buffer.append("ID :" +results.getString(0)+ "\n");
                    //show first name+ last name
                   // buffer.append("Full Name: " + results.getString(1) + " " + results.getString(2) + "\n");
                    //show email
                  //  buffer.append("Email :" +results.getString(3)+ "\n");
                    //show password
                    //buffer.append("Password :" +results.getString(4)+ "\n\n");

                    //showMessage("Your Information",buffer.toString());
               // }


           // }
       // });
   // }
   // public void showMessage(String title, String message){
       // AlertDialog.Builder builder =new AlertDialog.Builder(this);
       // builder.setCancelable(true);
       // builder.setTitle(title);
       // builder.setMessage(message);
       // builder.show();
   // }

  // public void deleteData(){
      //  button4.setOnClickListener(new View.OnClickListener() {
         //   @Override
          //  public void onClick(View view) {
                // Call the deleteData method of the database helper object to delete the row with the specified email
            //    Integer isDelete =mydb.deleteData(enteremail.getText().toString());
             //   if(isDelete >0)
              //      Toast.makeText(createaccount.this, "Account Delete Successfully",Toast.LENGTH_LONG).show();
              //  else
              //      Toast.makeText(createaccount.this ,"Please Enter Your Correct Email Address!",Toast.LENGTH_LONG).show();


            }
      //  });
  //  }
//}
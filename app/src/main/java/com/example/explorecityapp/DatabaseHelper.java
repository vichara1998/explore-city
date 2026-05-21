package com.example.explorecityapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Explorecity.db";
    public static final String TABLE_NAME = "explorecity_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "FIRSTNAME";
    public static final String COL_3 = "LASTNAME";
    public static final String COL_4 = "EMAIL";

    public static final String COL_5 = "PASSWORD";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 2);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    //ID an integer primary key that auto-increments for each new row added to the table
    //firstname,lastname,email,password,,, text column for storing the user's first name,lastname,email,password
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " FIRSTNAME TEXT, LASTNAME TEXT, EMAIL TEXT, PASSWORD TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // Drop the existing table if it exists
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        // Call the onCreate method to create a new table
        onCreate(db);
    }

    //Create a new account
    public boolean insertData(String firstname, String lastname, String email, String password) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, firstname);
        contentValues.put(COL_3, lastname);
        contentValues.put(COL_4, email);
        contentValues.put(COL_5, password);

        long results = database.insert(TABLE_NAME, null, contentValues);
        if (results == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor results = db.rawQuery(" select * From " + TABLE_NAME, null);
        return results;
    }

    //Reset password(forgot password)
    public boolean updateData(String email, String newPassword) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_5, newPassword);
        int rowsAffected = db.update(TABLE_NAME, contentValues, "EMAIL =?", new String[]{email});
        return rowsAffected > 0;
    }

    //Account Detete
    public Integer deleteData(String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "EMAIL =?", new String[]{email});
    }

    //Check email and password
    public boolean login(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COL_1};
        // selection string that specifies the WHERE clause for the query
        // The selection string checks whether the email and password match any rows in the table
        String selection = COL_4 + "=? and " + COL_5 + "=?";
        String[] selectionArgs = {email, password};
        Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();
        return count > 0;
    }
}













// public boolean forgotpass(String email) {

           // SQLiteDatabase db = this.getReadableDatabase();
          //  String[] columns = {COL_1};

            // selection string that specifies the WHERE clause for the query
            // The selection string checks whether the email matches any rows in the table
          //  String selection = COL_4 + "=?";
           // String[] selectionArgs = {email};
          //  Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);

          //  int count = cursor.getCount();
          //  cursor.close();
          //  db.close();
          //  return count > 0;

        //}








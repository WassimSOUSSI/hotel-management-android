package com.example.gh_application.Models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Local_DBManager extends SQLiteOpenHelper {
    // Define database name, version, table name, and columns
    private static final String DATABASE_NAME = "local_db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "users";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";

    // Define the pre-defined user and login
    private static final String PREDEFINED_USERNAME = "wassim";
    private static final String PREDEFINED_PASSWORD = "wassim";

    // Define SQL statement to create the users table
    private static final String CREATE_TABLE_USERS = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_USERNAME + " TEXT NOT NULL, " +
            COLUMN_PASSWORD + " TEXT NOT NULL);";


    public Local_DBManager(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_USERS);
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, PREDEFINED_USERNAME);
        values.put(COLUMN_PASSWORD, PREDEFINED_PASSWORD);
        sqLiteDatabase.insert(TABLE_NAME, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean getUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE username='"+username+"' AND password='"+password+"'",null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        return count > 0;
    }
}

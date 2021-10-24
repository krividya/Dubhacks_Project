package com.example.dubhacks_project;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

import java.net.PasswordAuthentication;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Login.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "users";
    private static final String EMAIL_ADDRESS = "email_address";
    private static final String PASSWORD = "password";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private String emailAddress;
    private String password;
    private String firstName;
    private String lastName;
    private Context context;

    public DBHelper(Context context) {
        super(context,"users", null, DATABASE_VERSION);
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table users(emailAddress TEXT primary key, password TEXT, firstName TEXT, lastName TEXT, genderMe TEXT, genderYou TEXT, classStanding TEXT, major TEXT, smoke TEXT, sleep TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users");
    }

    public Boolean insertData(String firstName, String lastName, String emailAddress, String password) {
        this.emailAddress= emailAddress;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("emailAddress", emailAddress);
        contentValues.put("password", password);
        contentValues.put("firstName", firstName);
        contentValues.put("lastName", lastName);
       // contentValues.put("classStanding","");
       // contentValues.put("gender", "");
        /*
        contentValues.put("major", "");
        contentValues.put("smoke", "");
        contentValues.put("sleep", "");

         */
        long result = db.insert("users", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean insertInfo(String gender1, String gender2, String classStanding, String major, String smoke, String sleep) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValue = new ContentValues();
        contentValue.put("emailAddress", this.emailAddress);
        contentValue.put("password", this.password);
        contentValue.put("firstName", this.firstName);
        contentValue.put("lastName", this.lastName);
        contentValue.put("genderMe", gender1);
        contentValue.put("genderYou", gender2)
        contentValue.put("classStanding",classStanding);
        contentValue.put("major", major);
        contentValue.put("smoke", smoke);
        contentValue.put("sleep", sleep);
        db.update("users", contentValue, "emailAddress=?", new String[]{this.emailAddress});
        return true;
    }

    public Boolean checkEmailAddress(String emailAddress) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE emailAddress = ?", new String[]{emailAddress});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkPassword(String emailAddress, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from users where emailAddress = ? and password = ?", new String[]{emailAddress, password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }
}

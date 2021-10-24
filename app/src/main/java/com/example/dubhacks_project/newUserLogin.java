package com.example.dubhacks_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dubhacks_project.ui.home.HomeFragment;

public class newUserLogin extends  AppCompatActivity {
    EditText newUserFirstName, newUserLastName, newUserEmailAddress, newUserPassword;
    Button register;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_newuser);
        /*
        newUserFirstName = (EditText) findViewById(R.id.newUserFirstName);
        newUserLastName = (EditText) findViewById(R.id.newUserLastName);
        newUserEmailAddress = (EditText) findViewById(R.id.newUserEmailAddress);
        newUserPassword = (EditText) findViewById(R.id.newUserPassword);
        register = (Button) findViewById(R.id.register);
        db = new DBHelper(this);
        /*
        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String firstName = newUserFirstName.getText().toString();
                String lastName = newUserLastName.getText().toString();
                String emailAddress = newUserEmailAddress.getText().toString();
                String password = newUserPassword.getText().toString();
                if (firstName.equals("") || lastName.equals("") || emailAddress.equals("") || password.equals("")) {
                    Toast.makeText(newUserLogin.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkUser = db.checkEmailAddress(emailAddress);
                    if (checkUser == false) {
                        Boolean insert = db.insertData(firstName, lastName, emailAddress, password);
                        if (insert == true) {
                            Toast.makeText(newUserLogin.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainPage.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(newUserLogin.this, "User already exists!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

            }
        });

         */

    }
    public void registerMethod (View view){
        newUserFirstName = (EditText) findViewById(R.id.newUserFirstName);
        newUserLastName = (EditText) findViewById(R.id.newUserLastName);
        newUserEmailAddress = (EditText) findViewById(R.id.newUserEmailAddress);
        newUserPassword = (EditText) findViewById(R.id.newUserPassword);
        register = (Button) findViewById(R.id.register);
        db = new DBHelper(this);
        String firstName = newUserFirstName.getText().toString();
        String lastName = newUserLastName.getText().toString();
        String emailAddress = newUserEmailAddress.getText().toString();
        String password = newUserPassword.getText().toString();
        if (firstName.equals("") || lastName.equals("") || emailAddress.equals("") || password.equals("")) {
            Toast.makeText(newUserLogin.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
        } else {
            Boolean checkUser = db.checkEmailAddress(emailAddress);
            if (checkUser == false) {
                Boolean insert = db.insertData(firstName, lastName, emailAddress, password);
                if (insert == true) {
                    //Toast.makeText(newUserLogin.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
                    intentCall(view);
                }
                else{
                    //Toast.makeText(newUserLogin.this, "User already exists!", Toast.LENGTH_SHORT).show();
                }
            }
        }

    }
    public void intentCall (View view){
        Intent intent = new Intent(this, MainPage.class);
        startActivity(intent);
    }

}



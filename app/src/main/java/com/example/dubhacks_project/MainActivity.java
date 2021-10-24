package com.example.dubhacks_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dubhacks_project.ui.home.HomeFragment;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText emailAddress, password;
    Button login, newUser;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);
        /*
        emailAddress = (EditText)findViewById(R.id.EmailAddress);
        password = (EditText)findViewById(R.id.Password);
        db = new DBHelper(this);
        login = (Button) findViewById(R.id.login);
        newUser = (Button) findViewById(R.id.newUser);
        newUser.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), newUserLogin.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String email = emailAddress.getText().toString();
                String pass = password.getText().toString();
                if(email.equals("") || pass.equals("")){
                    Toast.makeText(MainActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkPassword = db.checkPassword(email, pass);
                    if(checkPassword == true){
                        Intent intent = new Intent(getApplicationContext(), HomeFragment.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "The Username or Password is incorrect!", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });


        /*
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_chat, R.id.navigation_profile)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        */
    }
    public void loginButton(View view){
        emailAddress = (EditText)findViewById(R.id.EmailAddress);
        password = (EditText)findViewById(R.id.Password);
        db = new DBHelper(this);
        String email = emailAddress.getText().toString();
        String pass = password.getText().toString();
        if(email.equals("") || pass.equals("")){
            Toast.makeText(MainActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
        }
        else{
            Boolean checkPassword = db.checkEmailAddress(email);
            if(checkPassword == true){
                homePage(view);
            }
            else{
                Toast.makeText(MainActivity.this, "The Username or Password is incorrect!", Toast.LENGTH_SHORT).show();
            }

        }
    }
    public void newUserButton(View view){
        Intent intent = new Intent(this, newUserLogin.class);
        startActivity(intent);
    }
    public void homePage(View view){
        Intent intent = new Intent(this, MainPage.class);
        startActivity(intent);
    }


}
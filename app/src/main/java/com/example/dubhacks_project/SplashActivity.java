package com.example.dubhacks_project;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.dubhacks_project.MainActivity;

public class SplashActivity extends AppCompatActivity {

    @Override//Initializes the layout for splash activity
    //Handles the duration of the splash activity
    //after user clicks app
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final Intent i = new Intent(SplashActivity.this, MainActivity.class);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(i);
                finish();
            }
        },  1500);

    }
}

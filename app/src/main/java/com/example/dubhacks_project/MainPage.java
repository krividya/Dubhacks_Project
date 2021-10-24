package com.example.dubhacks_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainPage extends AppCompatActivity {

    private Button accessChatButton;
    private String[] topMatches = new String[] {"Kriti", "Atharva", "Diandre"};
    private String currentUser = "Atharva";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Will need to use the algorithm to grab the top three matches from the database.
        // Then, make the current User match properly, and make the top three matches the contents
        // of the String[]

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
    }

    public void openChatActivity(View view){
        Intent intent = new Intent(this, ChatActivity.class);
        intent.putExtra("user", this.currentUser);
        intent.putExtra("match", ((Button)view).getText().toString());
        startActivity(intent);
    }

    public String getUser(){
        return this.currentUser;
    }

    public String[] getTopMatches(){
        return this.topMatches;
    }

    // substituting values rn so we can replace them with database values
    private String[] matchingAlgorithm(String[] userData, String[][] databaseValues){
        String[] result = new String[3];

        // The first value in the userData is the user's name, then the following values are the rest of the columns in the table

        // dataBaseValues is an array of arrays, where the first value in each array (databaseValues[?][0])
        // is the name of the user and the rest are synchronized with the rest of the columns of the table.

        // This is a 2d array; an array of arrays
        // The first value of each array (matches[?][0]) is the name of the prospective matched user
        // The second value of each array (matches[?][1]) is the integer score converted into a String
        String[][] matches = new String[3][2];
        for (int i = 0; i < matches.length; i++){
            for (int j = 0; j < matches[i].length; i++){
                matches[i][j] = "" + 0;
            }
        }

        // The heart of our algorithm; users will be compared against each other and earn a point
        // for every part of the survey that they answered similarly
        int minScore = 0;

        // Now we go into all the values in the database
        for (String[] array: databaseValues){
            String matchName = "";
            int score = 0;

            // Here we tally up the points for all the areas where each person matches up
            for (int i = 0; i < array.length; i++){
                if (i == 0){
                    matchName = array[i];
                }
                if (userData[i].equals(array[i])){
                    score++;
                }
            }

            // Next we go through the prospective matches and replace the lowest scorers with our
            // current person if the score is high enough
            for (int i = 0; i < matches.length; i++){
                if (matches[i][1].equals(minScore)){
                    if (score >= minScore){
                        matches[i][0] =  matchName;
                        matches[i][1] = "" + score;
                    }
                }
            }

            // Finally we change the value of whatever the minimum score is needed to be to be considered
            // a good candidate for a roommate
            for (int i = 0; i < matches.length; i++){
                int currentMin = Integer.MAX_VALUE;
                if (Integer.parseInt(matches[i][0]) < currentMin){
                    currentMin = Integer.parseInt(matches[i][0]);
                }
                minScore = currentMin;
            }
        }
        for (int i = 0; i < matches.length; i++){
            result[i] = matches[i][0];
        }
        return result;
    }


}

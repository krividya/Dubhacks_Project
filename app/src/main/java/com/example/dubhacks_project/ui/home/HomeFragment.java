package com.example.dubhacks_project.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.dubhacks_project.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        instructions(root);
        return root;
    }

    private void instructions(View root){
        String first = "Ahoy, Roomie! Let's find someone to join our crew!";
        String second = "Go to the Profile page to change your preferences";
        String third = "Go to the Chat page to find the people you matched with and text in real time";
        TextView firstText = root.findViewById(R.id.text_home_first);
        firstText.setText(first);
        TextView secondText = root.findViewById(R.id.text_home_second);
        secondText.setText(second);
        TextView thirdText = root.findViewById(R.id.text_home_third);
        thirdText.setText(third);
    }

}
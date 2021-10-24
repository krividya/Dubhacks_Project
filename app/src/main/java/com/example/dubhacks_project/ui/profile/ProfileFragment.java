package com.example.dubhacks_project.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.dubhacks_project.R;
import com.example.dubhacks_project.ui.profile.ProfileViewModel;

public class ProfileFragment extends Fragment {


    private ProfileViewModel profileViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        profileViewModel =
                new ViewModelProvider(this).get(ProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        createGender(root);
//        final TextView textView = root.findViewById(R.id.text_profile);
//        profileViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
    public void createGender(View root) {
//        this.getActivity().setContentView(R.layout.fragment_profile);
        RadioGroup group = (RadioGroup) root.findViewById(R.id.gender);
        String[] numPanels = getResources().getStringArray(R.array.sex);
        for (int i = 0; i < numPanels.length; i++) {
            String numPanel = numPanels[i];
            System.out.println(numPanel);

            RadioButton button = new RadioButton(this.getContext());
            button.setText(numPanel);

            group.addView(button);
        }
        createotherGender(root);
    }
    public void createotherGender(View root) {
//        this.getActivity().setContentView(R.layout.fragment_profile);
        RadioGroup group = (RadioGroup) root.findViewById(R.id.othergender);
        String[] numPanels = getResources().getStringArray(R.array.sex);
        for (int i = 0; i < numPanels.length; i++) {
            String numPanel = numPanels[i];
            System.out.println(numPanel);

            RadioButton button = new RadioButton(this.getContext());
            button.setText(numPanel);

            group.addView(button);
        }
        createGrades(root);
    }
    public void createGrades(View root) {
//        this.getActivity().setContentView(R.layout.fragment_profile);
        RadioGroup group = (RadioGroup) root.findViewById(R.id.gradeoptions);
        String[] numPanels = getResources().getStringArray(R.array.grade_array);
        for (int i = 0; i < numPanels.length; i++) {
            String numPanel = numPanels[i];
            System.out.println(numPanel);

            RadioButton button = new RadioButton(this.getContext());
            button.setText(numPanel);

            group.addView(button);
        }
        createMajorRadio(root);
    }
    public void createMajorRadio(View root) {
//        this.getActivity().setContentView(R.layout.fragment_profile);
        RadioGroup group = (RadioGroup) root.findViewById(R.id.majorsgroup);
        String[] numPanels = getResources().getStringArray(R.array.majors);
        //Create the buttons:
//        String[] majors = {"skhfkj", "hsakfjhasdjk", "skajsdh"};
        for (int i = 0; i < numPanels.length; i++) {
            String numPanel = numPanels[i];
            System.out.println(numPanel);

            RadioButton button = new RadioButton(this.getContext());
            button.setText(numPanel);

            // Add to radio group:
//            RadioGroup myButton = (RadioGroup) this.getActivity().findViewById(R.id.majorsgroup);
//            myButton.addView(button);
            group.addView(button);
        }
        createSmoker(root);
    }

    public void createSmoker(View root) {
//        this.getActivity().setContentView(R.layout.fragment_profile);
        RadioGroup group = (RadioGroup) root.findViewById(R.id.smoker);
        String[] numPanels = getResources().getStringArray(R.array.smokerValues);
        for (int i = 0; i < numPanels.length; i++) {
            String numPanel = numPanels[i];
            System.out.println(numPanel);

            RadioButton button = new RadioButton(this.getContext());
            button.setText(numPanel);

            group.addView(button);
        }
        createTime(root);
    }
    public void createTime(View root) {
//        this.getActivity().setContentView(R.layout.fragment_profile);
        RadioGroup group = (RadioGroup) root.findViewById(R.id.sleeptime);
        String[] numPanels = getResources().getStringArray(R.array.timevalues);
        for (int i = 0; i < numPanels.length; i++) {
            String numPanel = numPanels[i];
            System.out.println(numPanel);

            RadioButton button = new RadioButton(this.getContext());
            button.setText(numPanel);

            group.addView(button);
        }
    }
}
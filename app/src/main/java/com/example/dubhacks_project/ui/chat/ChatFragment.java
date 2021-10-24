package com.example.dubhacks_project.ui.chat;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.dubhacks_project.ChatActivity;
import com.example.dubhacks_project.MainPage;
import com.example.dubhacks_project.R;

public class ChatFragment extends Fragment {

    private ChatViewModel chatViewModel;
    private String[] topMatches = new String[] {"Kriti", "Atharva", "Diandre"};
    private String currentUser = "Kriti";
    LinearLayout linear;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        chatViewModel =
                new ViewModelProvider(this).get(ChatViewModel.class);
        View root = inflater.inflate(R.layout.fragment_chat, container, false);
        MainPage activity = (MainPage) this.getActivity();
        this.topMatches = activity.getTopMatches();
        this.currentUser = activity.getUser();
        Button button0 = root.findViewById(R.id.zero_match_button);
        Button button1 = root.findViewById(R.id.one_match_button);
        Button button2 = root.findViewById(R.id.two_match_button);
        button0.setText(this.topMatches[0]);
        button1.setText(this.topMatches[1]);
        button2.setText(this.topMatches[2]);
        return root;
    }

    public void openChatActivity(View view){
        Intent intent = new Intent(this.getActivity(), ChatActivity.class);
        intent.putExtra("user", this.currentUser);
        intent.putExtra("match", ((Button)view).getText().toString());
        startActivity(intent);
    }
}
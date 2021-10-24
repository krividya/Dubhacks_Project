package com.example.dubhacks_project;

public class Message {
    private String text; // message body
    private MemberData memberData; // data of the user that sent this message
    private boolean belongsToUser; // is the message sent by the user

    public Message(String text, MemberData memberData, boolean belongsToUser){
        this.text = text;
        this.memberData = memberData;
        this.belongsToUser = belongsToUser;
    }

    public String getText(){
        return text;
    }

    public MemberData getMemberData(){
        return memberData;
    }

    public boolean isBelongsToUser(){
        return belongsToUser;
    }
}

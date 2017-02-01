package com.example.carson.darkshadow;

import android.graphics.drawable.Drawable;

/**
 * Created by Carson on 1/30/2017.
 */

public class FeedItem {

    private String name, status, timeStamp;
    private Drawable profilePic;

    public FeedItem(){

    }

    public FeedItem(String n, String status, Drawable profilePic, String timeStamp){
        this.name = n;
        this.status = status;
        this.profilePic = profilePic;
        this.timeStamp = timeStamp;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }


    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }

    public void setProfilePic(Drawable profilePic){
        this.profilePic = profilePic;
    }

    public Drawable getProfilePic(){
        return profilePic;
    }

    public void setTimeStamp(String timeStamp){
        this.timeStamp = timeStamp;
    }

    public String getTimeStamp(){
        return timeStamp;
    }
}

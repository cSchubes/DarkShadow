package com.example.carson.darkshadow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EventCreator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_creator);
    }

    public void goHome(View v){
        Intent intent = new Intent(EventCreator.this, Container.class);
        startActivity(intent);
    }
}

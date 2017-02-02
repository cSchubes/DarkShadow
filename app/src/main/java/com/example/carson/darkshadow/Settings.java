package com.example.carson.darkshadow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        TextView title = (TextView) findViewById(R.id.profiletitle);
        title.setText("Settings");
    }

    public void goHome(View v){
        Intent intent = new Intent(Settings.this, Profile.class);
        startActivity(intent);
    }
}

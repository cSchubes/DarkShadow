package com.example.carson.darkshadow;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class Profile extends AppCompatActivity {

    private Button edit;
    private BitmapDrawable b;
    private BitmapDrawable plus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        edit = (Button) findViewById(R.id.edit);


        //contacts = (ToggleButton) findViewById(R.id.toggleButton);
        //contacts.setBackgroundColor(Color.DKGRAY);
        //contacts.setHeight(50);
        //contacts.setWidth(300);

        /*
        Bitmap check = decodeSampledBitmapFromResource(getResources(), R.drawable.checkcontact, 30, 30);
        b = new BitmapDrawable(getResources(), check);
        Bitmap plusContact = decodeSampledBitmapFromResource(getResources(), R.drawable.addcontact, 30, 30);
        plus = new BitmapDrawable(getResources(), plusContact);
        */

        //contacts.setButtonDrawable(R.drawable.addcontact);
    }
}

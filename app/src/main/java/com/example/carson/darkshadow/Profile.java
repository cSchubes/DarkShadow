package com.example.carson.darkshadow;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Profile extends AppCompatActivity {

    private Button edit, toolBar1;
    private BitmapDrawable b;
    private BitmapDrawable plus;
    private Toolbar bottom, top;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        edit = (Button) findViewById(R.id.edit);
        toolBar1 = (Button) findViewById(R.id.toolBar1);

        bottom = (Toolbar) findViewById(R.id.my_toolbar);
        top = (Toolbar) findViewById(R.id.toolbartop);
        setSupportActionBar(top);
        //bottom.setTitle("Test");
        //bottom.inflateMenu(R.menu.toolbar_menu);

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

    public void setSelected(View view){

    }
}

package com.example.anil.smarthelpline.Navigation_Elements;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.anil.smarthelpline.R;

public class AboutUs extends AppCompatActivity {
 Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_about_us );

        toolbar=(Toolbar)findViewById(R.id.toolbar) ;
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" About ");
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );
    }
}

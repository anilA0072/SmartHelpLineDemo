package com.example.anil.smarthelpline.Navigation_Elements;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.anil.smarthelpline.R;


public class Clinic extends AppCompatActivity {

Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_clinic );

        toolbar=findViewById(R.id.toolbar) ;
        setSupportActionBar(toolbar );
        getSupportActionBar().setTitle(" Clinic ");
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );
    }

}

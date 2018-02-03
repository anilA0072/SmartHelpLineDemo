package com.example.anil.smarthelpline.login_tabs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.anil.smarthelpline.R;

public class Book_AppoinmentActivity extends AppCompatActivity {

     Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_book__appoinment );

        toolbar=findViewById(R.id.toolbar) ;
        setSupportActionBar(toolbar );
        getSupportActionBar().setTitle(" Appoinment ");
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );
    }
}

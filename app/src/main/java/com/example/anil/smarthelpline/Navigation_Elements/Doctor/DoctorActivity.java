package com.example.anil.smarthelpline.Navigation_Elements.Doctor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;

import com.example.anil.smarthelpline.Navigation_Elements.Downloader;
import com.example.anil.smarthelpline.R;

public class DoctorActivity extends AppCompatActivity {
    Toolbar toolbar;
    SearchView searchView;
    RecyclerView recyclerView;
   // doctorAdapter adapter;
    final static String urlAddress="http://172.16.17.134/smarthelpline/doctor.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_doctor );
        toolbar=(Toolbar)findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );
        getSupportActionBar().setTitle( "Doctor Activity" );
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );
        searchView=  findViewById(R.id.doctorSearch);
        recyclerView= findViewById(R.id.doctorRecycle);
        new Downloader( this,urlAddress,recyclerView ).execute( );

        //SET ITS PROPETRIES
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
       // recyclerView.setAdapter(    );

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {


                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                doctorAdapter doctorAdapter= (com.example.anil.smarthelpline.Navigation_Elements.Doctor.doctorAdapter) recyclerView.getAdapter();
                doctorAdapter.getFilter().filter( query );
                return false;
            }
        });
    }
}

package com.example.anil.smarthelpline.Navigation_Elements.Doctor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anil.smarthelpline.R;

public class doctor_clickActivity extends AppCompatActivity {

    TextView docName,docSpecialization;
    ImageView docImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.doctor_click );
        Toolbar toolbar=(Toolbar)findViewById( R.id.toolbar );
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );

        docName=(TextView)findViewById( R.id.nameDetails );
        docSpecialization=(TextView)findViewById( R.id.specializationDetails );
        docImage=(ImageView)findViewById( R.id.doctorDetail );

        //RECEIVE
        Intent intent=this.getIntent();
        String name=intent.getExtras().getString( "Name_KEY" );
        String specialization=intent.getExtras().getString( "Specialization_key" );
        String image=intent.getExtras().getString( "Image_key" );

        //BIND
        docName.setText( name );
        docSpecialization.setText( specialization );
        PicassoClient.downloadImage( this,image,docImage );




    }
}

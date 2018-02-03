package com.example.anil.smarthelpline.login_tabs;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anil.smarthelpline.Navigation_Elements.modelListClick;
import com.example.anil.smarthelpline.R;


public class listClick extends AppCompatActivity {
TextView titleText,p0,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10;


    Toolbar toolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.listclick);
        Bundle bundle=getIntent().getExtras();
        String title_data=(String)bundle.get( "title" );
        String p0_data=(String)bundle.get("p0");
        String p1_data=(String)bundle.get("p1");
        String p2_data=(String)bundle.get("p2");
        String p3_data=(String)bundle.get("p3");
        String p4_data=(String)bundle.get("p4");
        String p5_data=(String)bundle.get("p5");
        String p6_data=(String)bundle.get("p6");
        String p7_data=(String)bundle.get("p7");
        String p8_data=(String)bundle.get("p8");
        String p9_data=(String)bundle.get("p9");
        String p10_data=(String)bundle.get("p10");


        titleText=findViewById( R.id.title);
        p0=findViewById( R.id.p0 );
        p1=findViewById( R.id.p1 );
        p2=findViewById( R.id.p2 );
        p3=findViewById( R.id.p3 );
        p4=findViewById( R.id.p4 );
        p5=findViewById( R.id.p5 );
        p6=findViewById( R.id.p6 );
        p7=findViewById( R.id.p7 );
        p8=findViewById( R.id.p8 );
        p9=findViewById( R.id.p9 );
        p10=findViewById( R.id.p10 );

        titleText.setText( title_data );
        p0.setText( p0_data );
        p1.setText( p1_data );
        p2.setText( p2_data );
        p3.setText( p3_data );
        p4.setText( p4_data );
        p5.setText( p5_data );
        p6.setText( p6_data );
        p7.setText( p7_data );
        p8.setText( p8_data );
        p9.setText( p9_data );
        p10.setText( p10_data );


        toolbar=(Toolbar)findViewById(R.id.toolbar) ;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );

    }
}

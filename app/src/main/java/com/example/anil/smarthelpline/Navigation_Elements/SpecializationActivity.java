package com.example.anil.smarthelpline.Navigation_Elements;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.anil.smarthelpline.R;
import com.example.anil.smarthelpline.login_tabs.MyAdapter;

public class SpecializationActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    private String DiseaseList[]=
            {
                    "Acupnuture","Anesthestia","Cardiology","Dentist","Dermatology","Dietitian",
                    "Endocrine","ENT","Gastrology","General Physician","Gynaecology","Hematology",
                    "Hepatology","Nephrology","Neurology","Oncology","Opthalmology","Orthopedic",

            };
    private int DiseaseImage[]=
            {
                    R.drawable.asthma,R.drawable.wheelchair,R.drawable.stomch,R.drawable.sneeze,
                    R.drawable.sick,R.drawable.scissor,R.drawable.mosquito,R.drawable.medicine,
                    R.drawable.liver,R.drawable.kidney,R.drawable.fever,R.drawable.bacteria

            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_specialization );
        toolbar=(Toolbar)findViewById(R.id.toolbar) ;
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" Specialization ");
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );

        recyclerView=findViewById(R.id.specialization);
        layoutManager=new GridLayoutManager(this,3);

        recyclerView.setLayoutManager(layoutManager);
        MyAdapter myAdapter=new MyAdapter(this,DiseaseImage,DiseaseList);
        recyclerView.setAdapter(myAdapter);
        // recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.HORIZONTAL));
        //  recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        recyclerView.setHasFixedSize(true);
    }
}

package com.example.anil.smarthelpline.login_tabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;

import com.example.anil.smarthelpline.Navigation_Elements.Clinic;
import com.example.anil.smarthelpline.Navigation_Elements.Doctor.DoctorActivity;
import com.example.anil.smarthelpline.Navigation_Elements.Hospital;
import com.example.anil.smarthelpline.Navigation_Elements.Medicine_trackerActivity;
import com.example.anil.smarthelpline.R;


public class Home_Fragment extends Fragment implements View.OnClickListener {

    public GridLayout gridLayout;
    CardView cardHospital,cardClinic,cardDoctor,cardMedicine;
    Button Book;
    private Fragment fragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    public Home_Fragment() {

    }

        @Override
        public View onCreateView (LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState){
        // Inflate the layout for this fragment
        View view=inflater.inflate( R.layout.fragment_home, container, false);
        gridLayout=(GridLayout)view.findViewById(R.id.GridView);
        cardClinic=(CardView)view.findViewById(R.id.cardClinic);
        cardDoctor=(CardView)view.findViewById(R.id.cardDoctor);
        cardHospital=(CardView)view.findViewById(R.id.cardHospital);
        cardMedicine=(CardView)view.findViewById(R.id.cardMedicine);
        Book=(Button)view.findViewById( R.id.BookAppoinment );

        cardMedicine.setOnClickListener(this);
        cardHospital.setOnClickListener(this);
        cardDoctor.setOnClickListener(this);
        cardClinic.setOnClickListener(this);
        Book.setOnClickListener( this );

            return view;
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.cardClinic){
            startActivity( new Intent( getContext(),Clinic.class) );

        }
        else if(view.getId()==R.id.cardHospital){
            startActivity( new Intent( getContext(),Hospital.class) );

        }
        else if(view.getId()==R.id.cardDoctor){
            startActivity( new Intent( getContext(),DoctorActivity.class) );

        }
        else if(view.getId()==R.id.cardMedicine){
            startActivity( new Intent( getContext(),Medicine_trackerActivity.class) );

        }
        else if(view.getId()==R.id.BookAppoinment){
            startActivity(new Intent(getContext(), Book_AppoinmentActivity.class));
        }

    }

    private android.app.FragmentManager getSupportFragmentManager() {
        return null;
    }
}
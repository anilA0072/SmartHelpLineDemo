package com.example.anil.smarthelpline.Navigation_Elements;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anil.smarthelpline.MainActivity;
import com.example.anil.smarthelpline.R;

public class bmi_Calculator_Fragment extends Fragment implements View.OnClickListener{

    EditText weight,height;
    TextView result;
    ImageButton man,woman;

    public bmi_Calculator_Fragment() {
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        weight=(EditText)view.findViewById(R.id.weight) ;
        height=(EditText)view.findViewById(R.id.height);
        result=(TextView)view.findViewById(R.id.result);
        man=(ImageButton) view.findViewById(R.id.man);
        woman=(ImageButton) view.findViewById(R.id.woman);

        ((MainActivity)getActivity()).setTItleSupport("BMI Calculator");


        man.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               BMIcalculate("men");
            }
        });
        woman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BMIcalculate("women");
            }
        });

    }
    public void BMIcalculate(String gender) {
        Toast.makeText(getContext(),"Data"+gender,Toast.LENGTH_LONG).show();
        String heightStr=height.getText().toString();
        String weightStr=weight.getText().toString();

        if(heightStr!=null&&!"".equals(heightStr)&&weightStr!=null&&!"".equals(weightStr)){
            float heightValue =Float.parseFloat(heightStr);
            float weightValue=Float.parseFloat(weightStr);

            float bmi=weightValue/(heightValue*heightValue);

            displayBMI(bmi);
        }
    }

    private void displayBMI(float bmi) {

        String bmiLabel="";

        if(Float.compare(bmi,15f)<=0){
            bmiLabel="Very severely underweight";
        }else if(Float.compare(bmi,15f)>0&&Float.compare(bmi,16f)<=0){
            bmiLabel="Severely underweight";
        }else if(Float.compare(bmi,16f)>0&&Float.compare(bmi,18.5f)<=0){
            bmiLabel="Underweight";
        }else if(Float.compare(bmi,18.5f)>0&&Float.compare(bmi,25f)<=0){
            bmiLabel="Normal";
        }else if(Float.compare(bmi,25f)>0&&Float.compare(bmi,30f)<=0){
            bmiLabel="Overweight";
        }else if(Float.compare(bmi,30f)>0&&Float.compare(bmi,35f)<=0){
            bmiLabel="Obese class I";
        }else if(Float.compare(bmi,35f)>0&&Float.compare(bmi,40f)<=0){
            bmiLabel="Obese class II";
        }else if(Float.compare(bmi,40f)>0){
            bmiLabel="Obese class III";
        }
        bmiLabel =bmi + "\n" + bmiLabel;
        result.setText(bmiLabel);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bmi__calculator, container, false);

        return view;
    }

    @Override
    public void onClick(View view) {

    }
}

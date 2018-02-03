package com.example.anil.smarthelpline.Navigation_Elements;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.anil.smarthelpline.Navigation_Elements.Doctor.docter;
import com.example.anil.smarthelpline.Navigation_Elements.Doctor.doctorAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DataParser extends AsyncTask<Void,Void,Boolean> {
    Context context;
    String jsonData;
    RecyclerView recyclerView;

    ProgressDialog progressDialog;
    ArrayList<docter> doctors=new ArrayList<>(  );

    public DataParser(Context context, String jsonData, RecyclerView recyclerView) {
        this.context = context;
        this.jsonData = jsonData;
        this.recyclerView = recyclerView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        progressDialog=new ProgressDialog( context );
        progressDialog.setTitle("Parse");
        progressDialog.setMessage( "Parsing......Please wait" );
        progressDialog.show();
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        return this.parseData();
    }

    @Override
    protected void onPostExecute(Boolean parsed) {
        super.onPostExecute( parsed );

        progressDialog.dismiss();

        if(parsed){
            //BIND
            doctorAdapter adapter=new doctorAdapter( context,doctors );
            recyclerView.setAdapter(adapter);



        }else{
            Toast.makeText( context,"Unable To Parse",Toast.LENGTH_LONG ).show();
        }
    }
    private Boolean parseData(){
        try
        {
            JSONArray jsonArray=new JSONArray( jsonData );
            JSONObject jsonObject;

            doctors.clear();
            docter doc;

            for(int i=0;i<jsonArray.length();i++)
            {
                jsonObject=jsonArray.getJSONObject( i );

                int id=jsonObject.getInt( "ID" );
                String name=jsonObject.getString("doctorName" );
                String address=jsonObject.getString("doctorAddress" );
                String number=jsonObject.getString("doctorNumber" );
                String image=jsonObject.getString( "doctorImage" );
                String specilization=jsonObject.getString( "doctorSpecialization" );

                doc=new  docter();
                doc.setId(id);
                doc.setName( name );
                doc.setAddress( address );
                doc.setNumber( number );
                doc.setImage( image );
                doc.setSpecialization( specilization );

                doctors.add( doc );
                Log.d( "data_key","data "+doc.getName() );

            }

            return true;
        } catch (JSONException e) {
            Log.v( "except_data",""+e.getMessage() );
        }

        Log.d( "main_datapracer","data "+"main" );
        return false;
    }
}

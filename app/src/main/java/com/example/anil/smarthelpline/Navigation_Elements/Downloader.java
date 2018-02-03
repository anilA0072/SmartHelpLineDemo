package com.example.anil.smarthelpline.Navigation_Elements;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.anil.smarthelpline.Navigation_Elements.Doctor.Connector;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;



public class Downloader extends AsyncTask<Void,Void,String> {
    Context context;
    String urlAddress;
    RecyclerView recyclerView;

    ProgressDialog progressDialog;

    public Downloader(Context context, String urlAddress, RecyclerView recyclerView) {
        this.context = context;
        this.urlAddress = urlAddress;
        this.recyclerView = recyclerView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        progressDialog=new ProgressDialog( context );
        progressDialog.setTitle("Retrieve");
        progressDialog.setMessage( "Retrieving......Please wait" );
        progressDialog.show();
    }

    @Override
    protected String doInBackground(Void... voids) {
        return this.downloadData();
    }

    @Override
    protected void onPostExecute(String jsonData) {
        super.onPostExecute( jsonData );

        progressDialog.dismiss();

        if(jsonData.equals("Unsuccessful")){
            Toast.makeText( context,"Unsucessful ,No data retrieved..",Toast.LENGTH_LONG ).show();
        }else{
            //PARSE

            new DataParser( context,jsonData,recyclerView).execute( );
        }
    }
    private String downloadData()
    {
        HttpURLConnection con= Connector.connect( urlAddress );


        try {
            Log.d( "msg","status"+con.getResponseCode() );
            if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = new BufferedInputStream( con.getInputStream() );
                BufferedReader bufferedReader = new BufferedReader( (new InputStreamReader( inputStream )) );
                String line;
                StringBuffer jsonData = new StringBuffer();

                while ((line = bufferedReader.readLine()) != null) {
                    jsonData.append( line + "\n" );
                }
                bufferedReader.close();
                inputStream.close();
                Log.d( "if_block","success" ) ;
                return  jsonData.toString();

            }

        }
        catch(Exception ex){
            Log.v( "msg" ,"exception"+ex.getMessage());
        }
        Log.d( "main_block","success" ) ;
        Log.v( "msg" ,"i am here");
        return "Unsuccessful";
    }
}






















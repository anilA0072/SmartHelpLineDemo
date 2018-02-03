package com.example.anil.smarthelpline.Navigation_Elements.Doctor;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anil.smarthelpline.R;
import com.squareup.picasso.Picasso;


public class PicassoClient {
    public static void downloadImage(Context c, String image, ImageView img){
        if(image!=null&&image.length()>0)
        {

            Picasso.with(c).load(image).placeholder( R.drawable.placeholder).into( img );
        }else{
           Picasso.with(c).load( R.drawable.placeholder).into(img);

        }
    }
}

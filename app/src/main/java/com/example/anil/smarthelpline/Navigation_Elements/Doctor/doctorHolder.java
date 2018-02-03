package com.example.anil.smarthelpline.Navigation_Elements.Doctor;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anil.smarthelpline.Navigation_Elements.itemClickListener;
import com.example.anil.smarthelpline.R;

import java.sql.Blob;


public class doctorHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    //OUR VIEWS
    ImageView img;
    TextView docName,docNumber;

    itemClickListener ClickListener;


    public doctorHolder(View itemView) {
        super(itemView);

        this.img= (ImageView) itemView.findViewById( R.id.doctorImage);
        this.docName= (TextView) itemView.findViewById(R.id.nameTxt);
        this.docNumber= (TextView) itemView.findViewById(R.id.doctorNumber);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.ClickListener.onItemClick(v,getLayoutPosition());

    }

    public void setItemClickListener(itemClickListener ic)
    {
        this.ClickListener=ic;
    }

}

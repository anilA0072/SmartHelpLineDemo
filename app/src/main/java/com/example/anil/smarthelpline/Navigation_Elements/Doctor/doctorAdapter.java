package com.example.anil.smarthelpline.Navigation_Elements.Doctor;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.example.anil.smarthelpline.Navigation_Elements.itemClickListener;
import com.example.anil.smarthelpline.R;

import java.util.ArrayList;



public class doctorAdapter extends RecyclerView.Adapter<doctorHolder> implements Filterable {

    Context c;
    ArrayList<docter> docters,filterList;
    CustomFilter filter;


    public doctorAdapter(Context ctx, ArrayList<docter> docters)
    {
        this.c=ctx;
        this.docters=docters;
        this.filterList=docters;
    }


    @Override
    public doctorHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //CONVERT XML TO VIEW ONBJ
        View v= LayoutInflater.from(parent.getContext()).inflate( R.layout.doctor_model,parent,false);

        //HOLDER
        doctorHolder holder=new doctorHolder(v);

        return holder;
    }

    //DATA BOUND TO VIEWS
    @Override
    public void onBindViewHolder(doctorHolder holder, int position) {

        final docter doc=docters.get(position);
        //BIND DATA
        holder.docNumber.setText(docters.get(position).getNumber() );
        holder.docName.setText(docters.get(position).getName());
        PicassoClient.downloadImage( c,doc.getImage(),holder.img );

        //IMPLEMENT CLICK LISTENET
        holder.setItemClickListener(new itemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Snackbar.make(v,docters.get(pos).getName(),Snackbar.LENGTH_SHORT).show();
                openDetailActivity(doc.getName(),doc.getSpecialization(),doc.getImage());

            }

            @Override
            public void onItemClickView() {
            }
        });

    }

    //GET TOTAL NUM OF PLAYERS
    @Override
    public int getItemCount() {
        return docters.size();
    }
    private void openDetailActivity(String name,String specialization,String image)
    {
        Intent intent=new Intent( c,doctor_clickActivity.class );

        //PACK DATA
        intent.putExtra( "Name_KEY",name );
        intent.putExtra( "Specialization_key",specialization );
        intent.putExtra( "Image_key",image );

        c.startActivity( intent );
    }

    //RETURN FILTER OBJ
    @Override
    public Filter getFilter() {
        if(filter==null)
        {
            filter=new CustomFilter(filterList,this);
        }

        return filter;
    }
}

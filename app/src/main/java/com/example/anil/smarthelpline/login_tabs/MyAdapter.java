package com.example.anil.smarthelpline.login_tabs;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anil.smarthelpline.R;
import com.example.anil.smarthelpline.Navigation_Elements.SpecializationActivity;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder>{

    private Context context;
    private int images[];
    private String names[];


    public MyAdapter(SpecializationActivity context, int[] images, String[] names) {
        this.context = context;
        this.images = images;
        this.names = names;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layout= LayoutInflater.from(parent.getContext()).inflate( R.layout.specializationrecyclelist,parent,false);
        MyHolder myHolder=new MyHolder(layout);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        holder.imageView.setImageResource(images[position]);
        holder.textView.setText(names[position]);
       // holder.cardView.setCardBackgroundColor(Color.DKGRAY);

    }


    @Override
    public int getItemCount() {
        return images.length;
    }

    public static class MyHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        CardView cardView;

        public MyHolder(View itemView){
            super(itemView);
            cardView=itemView.findViewById(R.id.cardView1);
            imageView=itemView.findViewById(R.id.imageView);
            textView=itemView.findViewById(R.id.textView);
        }

    }
}

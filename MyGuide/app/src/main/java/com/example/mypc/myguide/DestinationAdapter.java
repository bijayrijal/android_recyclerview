package com.example.mypc.myguide;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by my pc on 3/12/2016.
 */
public class DestinationAdapter extends RecyclerView.Adapter<DestinationAdapter.RecyclerViewHolder>{

    ArrayList<DestinationData> destArray=new ArrayList<DestinationData>();
    Context context;

    public DestinationAdapter(ArrayList<DestinationData> destArray, Context context) {
        this.destArray = destArray;
        this.context = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_destination_row, parent, false);
        RecyclerViewHolder recyclerViewHolder=new RecyclerViewHolder(view,context,destArray);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        DestinationData dd=destArray.get(position);
        holder.img.setImageResource(dd.getImageId());
        holder.dName.setText(dd.getDestinationName());
        holder.desc.setText(dd.getDescription());



    }


    @Override
    public int getItemCount() {
        return destArray.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView dName,desc;
        Context context;
        ArrayList<DestinationData> dDatas=new ArrayList<DestinationData>();

        public RecyclerViewHolder(View view,Context context,ArrayList<DestinationData> dDatas) {
            super(view);
            this.context=context;
            this.dDatas=dDatas;

            img= (ImageView) view.findViewById(R.id.dest_image);
            dName= (TextView) view.findViewById(R.id.dest_name);
            desc= (TextView) view.findViewById(R.id.dest_description);




        }


    }
}

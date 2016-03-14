package com.example.mypc.myguide.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mypc.myguide.GuideData;
import com.example.mypc.myguide.GuideDetail;
import com.example.mypc.myguide.R;

import java.util.ArrayList;

/**
 * Created by my pc on 3/9/2016.
 */
    public class GuideAdapter extends RecyclerView.Adapter<GuideAdapter.RecyclerViewHolder> {

    ArrayList<GuideData> guideArray=new ArrayList<GuideData>();
    Context context;


    public GuideAdapter(ArrayList<GuideData> guideArray,Context context) {
        this.guideArray = guideArray;
        this.context=context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.single_guide_row_copy, parent, false);
        RecyclerViewHolder recyclerViewHolder=new RecyclerViewHolder(view,context,guideArray);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        GuideData guideData=guideArray.get(position);
        holder.img.setImageResource(guideData.getImageId());
        holder.gName.setText(guideData.getGuideName());
        holder.e.setText(guideData.getEmail());
        holder.mNumber.setText(guideData.getMobileNumber());

    }

    @Override
    public int getItemCount() {
        return guideArray.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView img;
        TextView gName,e,mNumber;
        Context context;
        ArrayList<GuideData> guideDatas=new ArrayList<GuideData>();

        public RecyclerViewHolder(View view,Context context,ArrayList<GuideData> guideDatas) {
            super(view);
            this.context=context;
            this.guideDatas=guideDatas;

            view.setOnClickListener(this);

            img= (ImageView) view.findViewById(R.id.guideImage);
            gName= (TextView) view.findViewById(R.id.guideName);
            e= (TextView) view.findViewById(R.id.email);
            mNumber= (TextView) view.findViewById(R.id.mobile);



        }

        @Override
        public void onClick(View v) {

            int position=getAdapterPosition();

                GuideData gd = this.guideDatas.get(position);
                Intent intent = new Intent(this.context, GuideDetail.class);


                intent.putExtra("image_id", gd.getImageId());
                intent.putExtra("guide_name", gd.getGuideName());
                intent.putExtra("email_id", gd.getEmail());
                intent.putExtra("mobile_number", gd.getMobileNumber());

                this.context.startActivity(intent);





        }
    }
}

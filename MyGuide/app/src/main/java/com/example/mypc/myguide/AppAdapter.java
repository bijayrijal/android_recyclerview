package com.example.mypc.myguide;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by my pc on 3/8/2016.
 */
public class AppAdapter extends RecyclerView.Adapter<AppAdapter.MyViewHolder> {

    public final static int TYPE_HEADER=0;
    public final static int TYPE_MENU=1;
    private LayoutInflater inflater;
    private Context context;
    List<RecyclerData> data = Collections.emptyList();

    public AppAdapter(Context context,List<RecyclerData> data) {

        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    public void delete(int postion) {
        data.remove(postion);
        notifyItemRemoved(postion);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= inflater.inflate(R.layout.custom_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        RecyclerData current = data.get(position);
        holder.title.setText(current .title);
        holder.icon.setImageResource(current.iconID);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView icon;

        public MyViewHolder(View itemView) {
            super(itemView);
            //itemView.setOnClickListener(this);
            title = (TextView) itemView.findViewById(R.id.listText);
            icon = (ImageView) itemView.findViewById(R.id.listIcon);


        }

    }
}

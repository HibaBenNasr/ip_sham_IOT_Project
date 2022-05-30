package com.example.ip_sham_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Tempadapter extends RecyclerView.Adapter<Tempadapter.MyViewHolder> {

    Context context;
    ArrayList<Temp_Data> list;

    public Tempadapter(Context context, ArrayList<Temp_Data> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.temp_item, parent,false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Temp_Data temp_data = list.get(position);
        holder.tempDate.setText(temp_data.time);
        holder.tempValue.setText(temp_data.value);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tempDate, tempValue;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tempDate = itemView.findViewById(R.id.temp_date);
            tempValue = itemView.findViewById(R.id.temp_value);
        }
    }
}

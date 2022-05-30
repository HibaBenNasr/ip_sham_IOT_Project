package com.example.ip_sham_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HumAdapter extends RecyclerView.Adapter<HumAdapter.MyViewHolder> {
    Context context;
    ArrayList<Hum_Data> list;

    public HumAdapter(Context context, ArrayList<Hum_Data> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public HumAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.hum_item, parent,false);
        return  new HumAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HumAdapter.MyViewHolder holder, int position) {
        Hum_Data hum_data = list.get(position);
        holder.humDate.setText(hum_data.time);
        holder.humValue.setText(hum_data.value);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView humDate, humValue;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            humDate = itemView.findViewById(R.id.hum_date);
            humValue = itemView.findViewById(R.id.hum_value);
        }
    }
}

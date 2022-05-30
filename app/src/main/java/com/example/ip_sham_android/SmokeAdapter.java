package com.example.ip_sham_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SmokeAdapter extends RecyclerView.Adapter<SmokeAdapter.MyViewHolder> {

    Context context;
    ArrayList<Smoke_Data> list;


    public SmokeAdapter(Context context, ArrayList<Smoke_Data> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public SmokeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.smoke_item, parent,false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SmokeAdapter.MyViewHolder holder, int position) {
        Smoke_Data smoke_data = list.get(position);
        holder.smokeDAte.setText(smoke_data.time);
        holder.smokeValue.setText(smoke_data.value);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView smokeDAte, smokeValue;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            smokeDAte = itemView.findViewById(R.id.smoke_date);
            smokeValue = itemView.findViewById(R.id.smoke_value);
        }
    }
}

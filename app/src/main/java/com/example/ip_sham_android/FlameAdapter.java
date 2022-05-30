package com.example.ip_sham_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FlameAdapter extends RecyclerView.Adapter<FlameAdapter.MyViewHolder> {

    Context context;
    ArrayList<Flame_Data> list;

    public FlameAdapter(Context context, ArrayList<Flame_Data> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public FlameAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.flmae_item, parent,false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FlameAdapter.MyViewHolder holder, int position) {
        Flame_Data flame_data = list.get(position);
        holder.FlameDate.setText(flame_data.getTime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView FlameDate;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            FlameDate = itemView.findViewById(R.id.flame_date);
        }
    }
}

package com.example.myrvapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{
    private OnItemClickedListener itemClickedListener;
    private ArrayList<DataModel> dataSet;

    public CustomAdapter(ArrayList<DataModel> dataSet, OnItemClickedListener itemClickedListener) {
        this.itemClickedListener = itemClickedListener;
        this.dataSet = dataSet;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView textViewName;
        TextView textViewVersion;
        ImageView imageView;

        public MyViewHolder(View itemView){
            super(itemView);

            cardView = itemView.findViewById(R.id.cardViewCardPage);
            textViewName = itemView.findViewById(R.id.textViewONECard);
            textViewVersion = itemView.findViewById(R.id.textViewTWOCard);
            imageView = itemView.findViewById(R.id.imageViewCard);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TextView textViewName = holder.textViewName;
        TextView textViewVersion = holder.textViewVersion;
        ImageView imageView = holder.imageView;
        CardView cardView = holder.cardView;

        textViewName.setText(dataSet.get(position).getName());
        textViewVersion.setText(dataSet.get(position).getVersion());
        imageView.setImageResource(dataSet.get(position).getImage());

        holder.itemView.setOnClickListener(view -> {
            itemClickedListener.onItemClicked(dataSet.get(position).getName());
        });
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}

interface OnItemClickedListener {
    void onItemClicked(String name);
}
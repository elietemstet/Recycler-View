package com.example.myrvapp;

import android.provider.ContactsContract;
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

    private ArrayList<DataModel> dataSet;

    public CustomAdapter (ArrayList<DataModel> dataSet){

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

        MyViewHolder myViewHolder = new MyViewHolder(view);



        return myViewHolder;
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



    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }



}

//דקה 32:50
// static String[] nameArray = {"",""};
//    static String[] versionArray = {"",""};
//
//    static Integer[] drawableArray = {R.drawable. ,R.drawable. ,R.drawable. ,
//            R.drawable. ,R.drawable. ,R.drawable. ,R.drawable. ,
//            R.drawable. ,R.drawable. ,R.drawable. ,R.drawable. ,};
//
//    static Integer[] id_ = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ;}

package com.example.myrvapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<DataModel> dataset;
    private LinearLayoutManager layoutManager;
    private CustomAdapter adapter;

    public RecyclerViewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recycleViewCon);

        layoutManager = new LinearLayoutManager(requireActivity());
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        dataset = new ArrayList<>();

        for ( int i=0 ; i<MyDATA.nameArray.length ; i++){

            dataset.add(new DataModel( MyDATA.nameArray[i],MyDATA.versionArray[i],
                    MyDATA.id_[i],MyDATA.drawableArray[i]));
        }

        adapter = new CustomAdapter(dataset, (name) -> {
            switch (name) {
                case "Assaf Granit": {
                    Navigation.findNavController(recyclerView).navigate(R.id.assafFragment);
                    break;
                }
                case "Erez Komrovski": {
                    Navigation.findNavController(recyclerView).navigate(R.id.erezFragment);
                    break;
                }
                case "Meir Adoni": {
                    Navigation.findNavController(recyclerView).navigate(R.id.meirFragment);
                    break;
                }
                case "Moshik Rot": {
                    Navigation.findNavController(recyclerView).navigate(R.id.moshikFragment);
                    break;
                }
                case "Raz Rahav": {
                    Navigation.findNavController(recyclerView).navigate(R.id.razFragment);
                    break;
                }
                case "Yossi Chitrit": {
                    Navigation.findNavController(recyclerView).navigate(R.id.yossiFragment);
                    break;
                }
            }
        });

        recyclerView.setAdapter(adapter);
    }
}
package com.example.newsfeed;

import static com.example.newsfeed.MainActivity.findCategoryNews;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HealthFragment extends Fragment {

    ArrayList<Model> modelClassArrayList;
    RecyclerAdapter adapter;
    private RecyclerView recyclerViewOfHealth;
    private String category="health";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_health,container,false);

        //fetching the ids of recyclerview, model, recycler adapter to set the adapter we have initialise in this class
        recyclerViewOfHealth=view.findViewById(R.id.healthRV);
        modelClassArrayList=new ArrayList<>();
        recyclerViewOfHealth.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new RecyclerAdapter(getContext(), modelClassArrayList);
        recyclerViewOfHealth.setAdapter(adapter);

        findCategoryNews(category, modelClassArrayList, adapter);


        return view;
    }

}
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


public class TechnologyFragment extends Fragment {
    ArrayList<Model> modelClassArrayList;
    RecyclerAdapter adapter;
    private RecyclerView recyclerViewOfTechnology;
    private String category = "technology";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_technology, container, false);

        //fetching the ids of recyclerview, model, recycler adapter to set the adapter we have initialise in this class
        recyclerViewOfTechnology = view.findViewById(R.id.technologyRV);
        modelClassArrayList = new ArrayList<>();
        recyclerViewOfTechnology.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RecyclerAdapter(getContext(), modelClassArrayList);
        recyclerViewOfTechnology.setAdapter(adapter);

        findCategoryNews(category, modelClassArrayList, adapter);


        return view;
    }
}
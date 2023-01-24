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

public class EntertainmentFragment extends Fragment {
    ArrayList<Model> modelClassArrayList;
    RecyclerAdapter adapter;
    private RecyclerView recyclerViewOfEntertainment;
    private String category="entertainment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_entertainment,container,false);

        //fetching the ids of recyclerview, model, recycler adapter to set the adapter we have initialise in this class
        recyclerViewOfEntertainment=view.findViewById(R.id.entertainmentRV);
        modelClassArrayList=new ArrayList<>();
        recyclerViewOfEntertainment.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new RecyclerAdapter(getContext(), modelClassArrayList);
        recyclerViewOfEntertainment.setAdapter(adapter);

        findCategoryNews(category, modelClassArrayList, adapter);

        return view;
    }

}
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

public class BusinessFragment extends Fragment {


    String api = "99eee101575345e88ca9d2fb132b9983" ;
    ArrayList<Model> modelClassArrayList;
    RecyclerAdapter adapter;
    private RecyclerView recyclerViewOfBusiness;
    private String category="business";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_business,container,false);

        //fetching the ids of recyclerview, model, recycler adapter to set the adapter we have initialise in this class
        recyclerViewOfBusiness=view.findViewById(R.id.businessRV);
        modelClassArrayList=new ArrayList<>();
        recyclerViewOfBusiness.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new RecyclerAdapter(getContext(), modelClassArrayList);
        recyclerViewOfBusiness.setAdapter(adapter);


//        MainActivity obj= new MainActivity();
//        obj.findCategoryNews(category, modelClassArrayList, adapter);
        findCategoryNews(category, modelClassArrayList, adapter);


        return view;
    }






}
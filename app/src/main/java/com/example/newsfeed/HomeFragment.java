package com.example.newsfeed;

import static com.example.newsfeed.MainActivity.findNews;
import static com.example.newsfeed.MainActivity.searchNews;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
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

public class HomeFragment extends Fragment {

    ArrayList<Model> modelClassArrayList;
    RecyclerAdapter adapter;
    private RecyclerView recyclerViewOfHome;
    SearchView searchView;

    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_home ,container, false);

        //fetching the ids of recyclerview, model, recycler adapter to set the adapter we have initialise in this class
        recyclerViewOfHome=view.findViewById(R.id.homeRV);
        searchView=view.findViewById(R.id.searchbar);
        modelClassArrayList=new ArrayList<>();
        recyclerViewOfHome.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new RecyclerAdapter(getContext(), modelClassArrayList);
        recyclerViewOfHome.setAdapter(adapter);

        findNews(adapter, modelClassArrayList );

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchNews(query, adapter, modelClassArrayList);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return view;
    }

}
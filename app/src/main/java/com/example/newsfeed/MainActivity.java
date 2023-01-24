package com.example.newsfeed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    TabItem tHome, tSports, tBusiness, tEntertainment, tHealth, tScience, tTech;
    Toolbar toolbar;
    PagerAdapter pageAdapter;
    static String country="in";
    static String api = "99eee101575345e88ca9d2fb132b9983" ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tHome = findViewById(R.id.homeTab);
        tSports = findViewById(R.id.sportsTab);
        tBusiness = findViewById(R.id.businessTab);
        tEntertainment = findViewById(R.id.entertainmentTab);
        tHealth = findViewById(R.id.healthTab);
        tScience = findViewById(R.id.scienceTab);
        tTech = findViewById(R.id.technologyTab);

        tabLayout=findViewById(R.id.TabLayout);

        ViewPager viewPager = findViewById(R.id.viewPager);

        pageAdapter = new PagerAdapter(getSupportFragmentManager(), 7);

        viewPager.setAdapter(pageAdapter); //setting page adapter to our view
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { //adding listeners to all tab items in tablayout

            @Override
            public void onTabSelected(TabLayout.Tab tab) {  // changing the tabs
                viewPager.setCurrentItem(tab.getPosition());    //finding which tab item
                if (tab.getPosition() == 0 || tab.getPosition() == 1 || tab.getPosition() == 2 || tab.getPosition() == 3 || tab.getPosition() == 4 || tab.getPosition() == 5 || tab.getPosition() == 6)
                    pageAdapter.notifyDataSetChanged(); //notifying our page adapter to change the fragment
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //so that  view pager will also be changed
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    public static void findNews(RecyclerAdapter adapter, ArrayList<Model>modelClassArrayList) {
        modelClassArrayList.clear();
        ApiUtilities.getApiInterface().getNews(country, 100, api).enqueue(new Callback<MainNews>() {
            @Override
            public void onResponse(Call<MainNews> call, Response<MainNews> response) {
                if(response.isSuccessful()){
                    modelClassArrayList.addAll(response.body().getArticles());

                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MainNews> call, Throwable t) {

            }
        });
    }

    public static void findCategoryNews(String category, ArrayList<Model>modelClassArrayList, RecyclerAdapter adapter) {

        ApiUtilities.getApiInterface().getCategoryNews(country, 100, category,  api).enqueue(new Callback<MainNews>() {
            @Override
            public void onResponse(Call<MainNews> call, Response<MainNews> response) {
                if(response.isSuccessful()){
                    modelClassArrayList.addAll(response.body().getArticles());

                    adapter.notifyDataSetChanged(); //notify adapter to update the recycler view according to the new views
                }
            }

            @Override
            public void onFailure(Call<MainNews> call, Throwable t) {

            }
        });

    }

    public static void searchNews(String keyword, RecyclerAdapter adapter, ArrayList<Model>modelClassArrayList){
        modelClassArrayList.clear();
        ApiUtilities.getApiInterface().searchNews(keyword, 100, api).enqueue(new Callback<MainNews>() {
            @Override
            public void onResponse(Call<MainNews> call, Response<MainNews> response) {
                if(response.isSuccessful()){
                    modelClassArrayList.addAll(response.body().getArticles());

                    adapter.notifyDataSetChanged(); //notify adapter to update the recycler view according to the new views
                }
            }

            @Override
            public void onFailure(Call<MainNews> call, Throwable t) {

            }
        });

    }
}
package com.example.newsfeed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    TabItem tHome, tSports, tBusiness, tEntertainment, tHealth, tScience, tTech;
    Toolbar toolbar;
    PagerAdapter pageAdapter;

    String api = "99eee101575345e88ca9d2fb132b9983" ;


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
}
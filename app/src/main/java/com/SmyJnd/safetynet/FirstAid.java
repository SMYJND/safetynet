package com.SmyJnd.safetynet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FirstAid extends AppCompatActivity {

    RecyclerView recyclerView;
    List<DataClassFirstAid> dataList;
    MyAdapterII adapter;
    DataClassFirstAid androidData;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_aid);

        recyclerView = findViewById(R.id.recycleView);
        searchView = findViewById(R.id.search_list);

        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchList(newText);
                return true;
            }

        });

        GridLayoutManager gridLayoutManager = new GridLayoutManager(FirstAid.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        // Add these lines to add scrolling programmatically
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

        dataList = new ArrayList<>();

        androidData = new DataClassFirstAid("BLEEDING\n", R.string.bleeding, R.drawable.bleeding);
        dataList.add(androidData);

        androidData = new DataClassFirstAid("CLEANING & BANDAGING WOUNDS\n", R.string.wounds, R.drawable.wounds);
        dataList.add(androidData);

        androidData = new DataClassFirstAid("EYE INJURIES\n", R.string.eye_injuries, R.drawable.eye);
        dataList.add(androidData);

        androidData = new DataClassFirstAid("BURNS\n", R.string.burns, R.drawable.burns);
        dataList.add(androidData);

        androidData = new DataClassFirstAid("CHEMICAL BURNS\n", R.string.chemical_burns, R.drawable.chemical);
        dataList.add(androidData);

        androidData = new DataClassFirstAid("SUNBURN\n", R.string.sunburn, R.drawable.sunburn);
        dataList.add(androidData);

        androidData = new DataClassFirstAid("UNCONSCIOUSNESS\n", R.string.unconscious, R.drawable.unconscious);
        dataList.add(androidData);

        androidData = new DataClassFirstAid("CHOKING\n", R.string.choking, R.drawable.choking);
        dataList.add(androidData);

        androidData = new DataClassFirstAid("POISON\n", R.string.poison, R.drawable.poison);
        dataList.add(androidData);

        androidData = new DataClassFirstAid("ANIMAL BITES\n", R.string.animal_bites, R.drawable.animal);
        dataList.add(androidData);

        androidData = new DataClassFirstAid("BEE STING\n", R.string.bee_sting, R.drawable.bee);
        dataList.add(androidData);

        adapter = new MyAdapterII(FirstAid.this, dataList);
        recyclerView.setAdapter(adapter);
    }

    private void searchList(String text){
        List<DataClassFirstAid> dataSearchList = new ArrayList<>();
        for (DataClassFirstAid data : dataList){
            if(data.getDataTitle().toLowerCase().contains(text.toLowerCase()));

        }
    }
}

package com.SmyJnd.safetynet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Contact_listActivity extends AppCompatActivity {

        RecyclerView recyclerView;
        List<DataClass> dataList;
        MyAdapter adapter;
        DataClass androidData;
        SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

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

        GridLayoutManager gridLayoutManager = new GridLayoutManager(Contact_listActivity.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        dataList = new ArrayList<>();

        androidData = new DataClass("Ambulance", R.drawable.bb, "1990");
        dataList.add(androidData);

        androidData = new DataClass("Police Emergency", R.drawable.police, "118/119");
        dataList.add(androidData);

        androidData = new DataClass("Fire and Rescue", R.drawable.fire_rescue, "111");
        dataList.add(androidData);

        androidData = new DataClass("Government IC", R.drawable.gov, "1919");
        dataList.add(androidData);

        androidData = new DataClass("Sri Lanka Tourism", R.drawable.sl_tourism, "1912");
        dataList.add(androidData);

        androidData = new DataClass("Immigration and Emigration", R.drawable.immigration, "1962");
        dataList.add(androidData);

        androidData = new DataClass("Child & Women Bureau", R.drawable.child_women, "1929/1938");
        dataList.add(androidData);

        adapter = new MyAdapter(Contact_listActivity.this, dataList);
        recyclerView.setAdapter(adapter);
    }

    private void searchList(String text){
        List<DataClass> dataSearchList = new ArrayList<>();
        for (DataClass data : dataList){
            if(data.getDataTitle().toLowerCase().contains(text.toLowerCase())) {
                dataSearchList.add(data);
            }
            if (dataSearchList.isEmpty()){
                Toast.makeText(this, "Not Found", Toast.LENGTH_SHORT).show();
            } else {
                adapter.setSearchList(dataSearchList);
            }
        }
    }

}


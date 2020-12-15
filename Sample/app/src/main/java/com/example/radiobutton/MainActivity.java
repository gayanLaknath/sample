package com.example.radiobutton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterClass adapterClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.mainRecyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);


        adapterClass = new AdapterClass(getBrands(),this);
        recyclerView.setAdapter(adapterClass);
    }

    public List<OffersModel> getBrands(){
        List<OffersModel> modelList = new ArrayList<OffersModel>();
        modelList.add(new OffersModel("Get 1",1000));
        modelList.add(new OffersModel("Get 2",2000));
        modelList.add(new OffersModel("Get 3",3000));
        modelList.add(new OffersModel("Get 4",4000));
        modelList.add(new OffersModel("Get 5",5000));
        return modelList;
    }
}
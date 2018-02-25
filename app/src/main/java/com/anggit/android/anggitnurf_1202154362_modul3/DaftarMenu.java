package com.anggit.android.anggitnurf_1202154362_modul3;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by Anggit Nur on 2/25/2018.
 */

public class DaftarMenu extends AppCompatActivity {
    //Member variables
    private RecyclerView mRecyclerView;
    private ArrayList<drink> mDrinksData;
    private minumAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_menu);

        //Initialize the RecyclerView
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        //Get the appropriate column count
        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

        //Set Layout Manager
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));

        //Initialize the ArrayList that will contain the data
        mDrinksData = new ArrayList<>();

        //Initialize the adapter and set it ot the RecyclerView
        mAdapter = new minumAdapter(this, mDrinksData);
        mRecyclerView.setAdapter(mAdapter);

        //Get data
        initializeData();
    }

    private void initializeData() {
        //Get the resources from the XML file
        String[] drinksList = getResources().getStringArray(R.array.minum_titles);
        String[] drinksInfo = getResources().getStringArray(R.array.minum_info);
        TypedArray drinksImageResources = getResources().obtainTypedArray(R.array.minum_images);
        String[] drinksDetail = getResources().getStringArray(R.array.drinks_detail);
        //Clear the existing data (to avoid duplication)
        mDrinksData.clear();


        //Create the ArrayList of drinks objects containing the titles,
        // images and information about each drinks
        for(int i = 0; i<drinksList.length; i++){
            mDrinksData.add(new drink(drinksList[i], drinksInfo[i],
                    drinksImageResources.getResourceId(i,0), drinksDetail[i]));
        }

        //Recycle the typed array
        drinksImageResources.recycle();

        //Notify the adapter of the change
        mAdapter.notifyDataSetChanged();
    }
}


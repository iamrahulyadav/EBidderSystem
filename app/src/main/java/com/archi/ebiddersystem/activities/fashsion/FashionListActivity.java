package com.archi.ebiddersystem.activities.fashsion;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.archi.ebiddersystem.R;
import com.archi.ebiddersystem.adapter.FashionListAdapter;
import com.archi.ebiddersystem.model.FashionListClass;

import java.util.ArrayList;

public class FashionListActivity extends AppCompatActivity {
    public ImageView img_back;

    LinearLayoutManager layoutManager;
    RecyclerView fashionRecyclerView;
    ArrayList<FashionListClass> fashionArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fashion_list);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        img_back = findViewById(R.id.img_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        init();
    }

    private void init() {
        fashionRecyclerView = (RecyclerView) findViewById(R.id.fashionlist_recyclerView);
        fashionArrayList = new ArrayList<FashionListClass>();
        layoutManager = new LinearLayoutManager(FashionListActivity.this, LinearLayoutManager.VERTICAL, false);
        fashionRecyclerView.setLayoutManager(layoutManager);

        fashionRecyclerView.setItemAnimator(new DefaultItemAnimator());
        FashionListAdapter fashionListAdapter = new FashionListAdapter(FashionListActivity.this, fashionArrayList);
        fashionRecyclerView.setAdapter(fashionListAdapter);
    }

}
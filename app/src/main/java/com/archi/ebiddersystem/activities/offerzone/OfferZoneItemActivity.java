package com.archi.ebiddersystem.activities.offerzone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.archi.ebiddersystem.R;
import com.archi.ebiddersystem.adapter.OfferZoneItemAdapter;
import com.archi.ebiddersystem.adapter.TopDealsAdapter;
import com.archi.ebiddersystem.model.OfferZonListClass;
import com.archi.ebiddersystem.model.OfferzoneClass;

import java.util.ArrayList;

public class OfferZoneItemActivity extends AppCompatActivity {
    LinearLayoutManager layoutManager;
    RecyclerView offerItem_recycerView;
    ArrayList<OfferZonListClass> offerzoneListArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offerzone_item);
        initViews();
    }

    private void initViews() {
        offerItem_recycerView = (RecyclerView) findViewById(R.id.offerItem_recycerView);
        offerzoneListArrayList = new ArrayList<OfferZonListClass>();

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        offerItem_recycerView.setLayoutManager(layoutManager);
        OfferZoneItemAdapter offerListAdapter = new OfferZoneItemAdapter(this, offerzoneListArrayList);
        offerItem_recycerView.setAdapter(offerListAdapter);
    }
}

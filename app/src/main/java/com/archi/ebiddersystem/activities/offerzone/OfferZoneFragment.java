package com.archi.ebiddersystem.activities.offerzone;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.archi.ebiddersystem.R;
import com.archi.ebiddersystem.adapter.OfferZoneAdapter;
import com.archi.ebiddersystem.model.OfferzoneClass;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class OfferZoneFragment extends Fragment {


    LinearLayoutManager layoutManager;
    RecyclerView offerZoneRecyclerView;
    ArrayList<OfferzoneClass> offerzoneArrayList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.activity_offer_zone, container, false);

        initViews(view);
        return view;
    }

    public void initViews(View view) {

        offerZoneRecyclerView = (RecyclerView) view.findViewById(R.id.offerzone_recyclerView);
        offerzoneArrayList = new ArrayList<OfferzoneClass>();

        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        offerZoneRecyclerView.setLayoutManager(layoutManager);
        OfferZoneAdapter offerzoneAdapter = new OfferZoneAdapter(getActivity(), offerzoneArrayList);
        offerZoneRecyclerView.setAdapter(offerzoneAdapter);

    }

}

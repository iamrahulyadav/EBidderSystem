package com.archi.ebiddersystem.activities.loginmodule;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.archi.ebiddersystem.R;
import com.archi.ebiddersystem.activities.offerzone.OfferZoneFragment;
import com.archi.ebiddersystem.adapter.BrandStoreAdapter;
import com.archi.ebiddersystem.adapter.CategoryAdapter;
import com.archi.ebiddersystem.adapter.RecommendAdapter;
import com.archi.ebiddersystem.adapter.TopDealsAdapter;
import com.archi.ebiddersystem.adapter.ViewPagerAdapter;
import com.archi.ebiddersystem.model.CategoryClass;
import com.archi.ebiddersystem.model.RecommendClass;
import com.archi.ebiddersystem.model.TopDealClass;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private ViewPager viewPager;
    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;
    RecyclerView topDealRecyclerView, catogoryRecyclerView, brandstoreRecyclerView, recommendRecyclerView, perfumeRecyclerView,
            supermarketRecyclerView, homenkitchenRecyclerView, bestbuyRecyclerView, sportsnfitnessRecyclerView, babyRecyclerView,
            toysRecyclerView, toolsRecyclerView, clothingRecyclerView, footwearRecyclerView;
    LinearLayoutManager layoutManager;
    ArrayList<TopDealClass> dealArrayList;
    ArrayList<CategoryClass> categoryArrayList;
    ArrayList<RecommendClass> recommendArrayList;
    RecommendAdapter recommendAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.content_dashboard, container, false);
        init(view);
        return view;
    }

    private void init(View view) {

        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        sliderDotspanel = (LinearLayout) view.findViewById(R.id.SliderDots);
        topDealRecyclerView = (RecyclerView) view.findViewById(R.id.topDealsRecyclerView);
        catogoryRecyclerView = (RecyclerView) view.findViewById(R.id.category_recylerVw);
        brandstoreRecyclerView = (RecyclerView) view.findViewById(R.id.brandRecyclerView);
        recommendRecyclerView = (RecyclerView) view.findViewById(R.id.recommanded_recylerVw);
        perfumeRecyclerView = (RecyclerView) view.findViewById(R.id.perfume_recylerVw);
        supermarketRecyclerView = (RecyclerView) view.findViewById(R.id.supermarket_recylerVw);
        homenkitchenRecyclerView = (RecyclerView) view.findViewById(R.id.homenkitchen_recylerVw);
        bestbuyRecyclerView = (RecyclerView) view.findViewById(R.id.bestbuy_recylerVw);
        sportsnfitnessRecyclerView = (RecyclerView) view.findViewById(R.id.sportsnfitness_recylerVw);
        babyRecyclerView = (RecyclerView) view.findViewById(R.id.baby_recylerVw);
        toysRecyclerView = (RecyclerView) view.findViewById(R.id.toys_recylerVw);
        toolsRecyclerView = (RecyclerView) view.findViewById(R.id.tools_recylerVw);
        clothingRecyclerView = (RecyclerView) view.findViewById(R.id.clothing_recylerVw);
        footwearRecyclerView = (RecyclerView) view.findViewById(R.id.footwear_recylerVw);


        dealArrayList = new ArrayList<TopDealClass>();
        categoryArrayList = new ArrayList<>();
        recommendArrayList = new ArrayList<>();

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getActivity());
        viewPager.setAdapter(viewPagerAdapter);

        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        for (int i = 0; i < dotscount; i++) {

            dots[i] = new ImageView(getActivity());
            dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.non_active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0, 8, 0);
            sliderDotspanel.addView(dots[i], params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.non_active_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        topDealRecyclerView.setLayoutManager(layoutManager);
        TopDealsAdapter topDealsAdapter = new TopDealsAdapter(getActivity(), dealArrayList);
        topDealRecyclerView.setAdapter(topDealsAdapter);

        layoutManager = new GridLayoutManager(getActivity(), 2, GridLayoutManager.HORIZONTAL, false);
        catogoryRecyclerView.setLayoutManager(layoutManager);
        catogoryRecyclerView.setHorizontalScrollBarEnabled(false);
        CategoryAdapter categoryAdapter = new CategoryAdapter(getActivity(), categoryArrayList);
        catogoryRecyclerView.setAdapter(categoryAdapter);

        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        brandstoreRecyclerView.setLayoutManager(layoutManager);
        BrandStoreAdapter brandStoreAdapter = new BrandStoreAdapter(getActivity(), dealArrayList);
        brandstoreRecyclerView.setAdapter(brandStoreAdapter);

        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recommendRecyclerView.setLayoutManager(layoutManager);
        recommendAdapter = new RecommendAdapter(getActivity(), recommendArrayList);
        recommendRecyclerView.setAdapter(recommendAdapter);

        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        perfumeRecyclerView.setLayoutManager(layoutManager);
        recommendAdapter = new RecommendAdapter(getActivity(), recommendArrayList);
        perfumeRecyclerView.setAdapter(recommendAdapter);

        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        supermarketRecyclerView.setLayoutManager(layoutManager);
        recommendAdapter = new RecommendAdapter(getActivity(), recommendArrayList);
        supermarketRecyclerView.setAdapter(recommendAdapter);

        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        homenkitchenRecyclerView.setLayoutManager(layoutManager);
        recommendAdapter = new RecommendAdapter(getActivity(), recommendArrayList);
        homenkitchenRecyclerView.setAdapter(recommendAdapter);

        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        bestbuyRecyclerView.setLayoutManager(layoutManager);
        recommendAdapter = new RecommendAdapter(getActivity(), recommendArrayList);
        bestbuyRecyclerView.setAdapter(recommendAdapter);

        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        sportsnfitnessRecyclerView.setLayoutManager(layoutManager);
        recommendAdapter = new RecommendAdapter(getActivity(), recommendArrayList);
        sportsnfitnessRecyclerView.setAdapter(recommendAdapter);

        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        babyRecyclerView.setLayoutManager(layoutManager);
        recommendAdapter = new RecommendAdapter(getActivity(), recommendArrayList);
        babyRecyclerView.setAdapter(recommendAdapter);

        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        toysRecyclerView.setLayoutManager(layoutManager);
        recommendAdapter = new RecommendAdapter(getActivity(), recommendArrayList);
        toysRecyclerView.setAdapter(recommendAdapter);

        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        toolsRecyclerView.setLayoutManager(layoutManager);
        recommendAdapter = new RecommendAdapter(getActivity(), recommendArrayList);
        toolsRecyclerView.setAdapter(recommendAdapter);

        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        clothingRecyclerView.setLayoutManager(layoutManager);
        recommendAdapter = new RecommendAdapter(getActivity(), recommendArrayList);
        clothingRecyclerView.setAdapter(recommendAdapter);

        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        footwearRecyclerView.setLayoutManager(layoutManager);
        recommendAdapter = new RecommendAdapter(getActivity(), recommendArrayList);
        footwearRecyclerView.setAdapter(recommendAdapter);

    }



}

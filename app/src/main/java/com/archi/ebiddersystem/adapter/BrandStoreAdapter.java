package com.archi.ebiddersystem.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.archi.ebiddersystem.R;
import com.archi.ebiddersystem.model.TopDealClass;

import java.util.ArrayList;

/**
 * Created by archirayan on 8/12/17.
 */

public class BrandStoreAdapter extends RecyclerView.Adapter<BrandStoreAdapter.MyViewHolder> {

    Context context;
    ArrayList<TopDealClass> dealArrayList;

    public BrandStoreAdapter(Context context, ArrayList<TopDealClass>dealArrayList) {
        this.context = context;
        this.dealArrayList=dealArrayList;
    }

    @Override
    public BrandStoreAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_deals, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.imageIv.setImageResource(R.drawable.slider4);
        // Picasso.with(context).load(R.drawable.slide1).placeholder(R.drawable.slide1).into(holder.imageIv);

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageIv;

        public MyViewHolder(View itemView) {
            super(itemView);

            imageIv = (ImageView) itemView.findViewById(R.id.img_deals);
        }
    }
}


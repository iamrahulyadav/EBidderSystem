package com.archi.ebiddersystem.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.archi.ebiddersystem.R;
import com.archi.ebiddersystem.activities.fashsion.FashionListActivity;
import com.archi.ebiddersystem.activities.offerzone.OfferZoneItemActivity;
import com.archi.ebiddersystem.model.CategoryClass;
import com.archi.ebiddersystem.model.OfferzoneClass;

import java.util.ArrayList;

/**
 * Created by archirayan on 12/12/17.
 */

public class OfferZoneAdapter extends RecyclerView.Adapter<OfferZoneAdapter.MyViewHolder> {

    Context context;
    ArrayList<OfferzoneClass> dealArrayList;

    public OfferZoneAdapter(Context context, ArrayList<OfferzoneClass> dealArrayList) {
        this.context = context;
        this.dealArrayList = dealArrayList;
    }

    @Override
    public OfferZoneAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_offerzone, parent, false);
        return new MyViewHolder(itemView);    }

    @Override
    public void onBindViewHolder(OfferZoneAdapter.MyViewHolder holder, int position) {
        holder.ivOfferZoneImage.setImageResource(R.drawable.downloadimg);


        // // TODO: 13/12/17  Click Any Item In Recyclerview ...
        holder.ivOfferZoneImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, OfferZoneItemActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView ivOfferZoneImage;
        TextView tvOfferZonename;

        public MyViewHolder(View itemView) {
            super(itemView);
            ivOfferZoneImage = (ImageView) itemView.findViewById(R.id.offerzone_productIv);
            tvOfferZonename = (TextView) itemView.findViewById(R.id.offerzone_producttv);
        }
    }
}

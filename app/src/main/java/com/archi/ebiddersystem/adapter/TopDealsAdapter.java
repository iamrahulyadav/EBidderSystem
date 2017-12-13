package com.archi.ebiddersystem.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.archi.ebiddersystem.R;
import com.archi.ebiddersystem.model.TopDealClass;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TopDealsAdapter extends RecyclerView.Adapter<TopDealsAdapter.MyViewHolder> {

    Context context;
    ArrayList<TopDealClass>dealArrayList;

    public TopDealsAdapter(Context context, ArrayList<TopDealClass>dealArrayList) {
        this.context = context;
        this.dealArrayList=dealArrayList;
    }

    @Override
    public TopDealsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_deals, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TopDealsAdapter.MyViewHolder holder, int position) {
        holder.imageIv.setImageResource(R.drawable.slide3);
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

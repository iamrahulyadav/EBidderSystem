package com.archi.ebiddersystem.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.archi.ebiddersystem.R;
import com.archi.ebiddersystem.model.CategoryClass;
import com.archi.ebiddersystem.model.RecommendClass;

import java.util.ArrayList;

/**
 * Created by archirayan on 9/12/17.
 */

public class RecommendAdapter extends RecyclerView.Adapter<RecommendAdapter.MyViewHolder> {

    Context context;
    ArrayList<RecommendClass> recommendArrayList;
    boolean isClicked = false;

    public RecommendAdapter(Context context, ArrayList<RecommendClass> recommendArrayList) {
        this.context = context;
        this.recommendArrayList = recommendArrayList;
    }

    @Override
    public RecommendAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recommend, parent, false);
        return new RecommendAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        //    Picasso.with(context).load(R.drawable.ic_placeholder).placeholder(R.drawable.ic_placeholder).into(holder.imageIv);

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView ivProcuctImage, ivShare, ivLike, ivCart;
        TextView tvProductName, tvProductRegularPrice, tvCurrentPrice, tvPriceOff;

        public MyViewHolder(View itemView) {
            super(itemView);

            ivProcuctImage = (ImageView) itemView.findViewById(R.id.recommend_ivproductimg);
            ivShare = (ImageView) itemView.findViewById(R.id.recommend_ivShareimg);
            ivLike = (ImageView) itemView.findViewById(R.id.recommend_ivCartimg);
            ivCart = (ImageView) itemView.findViewById(R.id.recommend_ivLikeimg);
            tvProductName = (TextView) itemView.findViewById(R.id.recommend_tvProductName);
            tvPriceOff = (TextView) itemView.findViewById(R.id.recommend_tvPriceOff);
            tvProductRegularPrice = (TextView) itemView.findViewById(R.id.recommend_tvRegularPrice);
            tvCurrentPrice = (TextView) itemView.findViewById(R.id.recommend_tvCurrentPrice);
        }
    }
}

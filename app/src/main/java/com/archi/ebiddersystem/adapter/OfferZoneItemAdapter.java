package com.archi.ebiddersystem.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.archi.ebiddersystem.R;
import com.archi.ebiddersystem.model.OfferZonListClass;
import com.archi.ebiddersystem.model.OfferzoneClass;

import java.util.ArrayList;

/**
 * Created by archirayan on 14/12/17.
 */

public class OfferZoneItemAdapter extends RecyclerView.Adapter<OfferZoneItemAdapter.MyViewHolder> {

    Context context;
    ArrayList<OfferZonListClass> offerListArrayList;

    public OfferZoneItemAdapter(Context context, ArrayList<OfferZonListClass> offerListArrayList) {
        this.context = context;
        this.offerListArrayList = offerListArrayList;
    }

    @Override
    public OfferZoneItemAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_offerlist, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(OfferZoneItemAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView ivOfferListProductimg;
        TextView tvOfferListProductname,tvOfferListProductPrice,tvOfferListItemSold;
        ProgressBar pbOfferListProgressBar;
        Button btnOfferListAddToCart;
        ImageView ivOfferListShowCart,ivOfferListLike;

        public MyViewHolder(View itemView) {
            super(itemView);
            ivOfferListProductimg = (ImageView) itemView.findViewById(R.id.itemoffer_ivProductimg);
            tvOfferListProductname = (TextView) itemView.findViewById(R.id.item_offerProductName);
            tvOfferListProductPrice = (TextView) itemView.findViewById(R.id.item_offerProductPrice);
            tvOfferListItemSold = (TextView) itemView.findViewById(R.id.itemoffer_tvSold);
            btnOfferListAddToCart = (Button) itemView.findViewById(R.id.itemoffer_btnAddToCart);
            pbOfferListProgressBar = (ProgressBar) itemView.findViewById(R.id.itemoffer_progressBar);
            ivOfferListShowCart = (ImageView) itemView.findViewById(R.id.itemoffer_ibtnshowcart);
            ivOfferListLike = (ImageView) itemView.findViewById(R.id.itemoffer_ibtnshowlike);
        }
    }
}

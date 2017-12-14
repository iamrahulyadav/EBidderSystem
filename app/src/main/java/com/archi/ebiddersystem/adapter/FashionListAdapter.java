package com.archi.ebiddersystem.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.archi.ebiddersystem.R;
import com.archi.ebiddersystem.activities.fashsion.FashionListActivity;
import com.archi.ebiddersystem.model.FashionListClass;

import java.util.ArrayList;

/**
 * Created by archirayan on 14/12/17.
 */

public class FashionListAdapter extends RecyclerView.Adapter<FashionListAdapter.MyViewHolder> {

    Context context;
    ArrayList<FashionListClass> dealArrayList;

    public FashionListAdapter(Context context, ArrayList<FashionListClass> dealArrayList) {
        this.context = context;
        this.dealArrayList = dealArrayList;
    }

    @Override
    public FashionListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_fashion_list, parent, false);
        return new FashionListAdapter.MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(FashionListAdapter.MyViewHolder holder, int position) {
        holder.img_fashion.setImageResource(R.drawable.img_mentshirt);


        // // TODO: 13/12/17  Click Any Item In Recyclerview ...
        holder.rl_fashion_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FashionListActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView img_fashion;
        public TextView txt_fashion;
        public RelativeLayout rl_fashion_main;

        public MyViewHolder(View itemView) {
            super(itemView);
            img_fashion = (ImageView) itemView.findViewById(R.id.img_fashion);
            txt_fashion = (TextView) itemView.findViewById(R.id.txt_fashion);
            rl_fashion_main = (RelativeLayout) itemView.findViewById(R.id.rl_fashion_main);
        }
    }
}

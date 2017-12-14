package com.archi.ebiddersystem.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.archi.ebiddersystem.R;
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


        // // TODO: 13/12/17  Click Recycler Item Adapter ...
        holder.llayout_fashion_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Hello, Click Any Product ", Toast.LENGTH_SHORT).show();
            }
        });


        holder.llayout_like_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Like Unlike", Toast.LENGTH_SHORT).show();
            }
        });


        holder.llayout_addtocart_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "AddToCart", Toast.LENGTH_SHORT).show();
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
        public LinearLayout llayout_fashion_main;
        public ImageView llayout_like_product, llayout_addtocart_product;


        public MyViewHolder(View itemView) {
            super(itemView);
            img_fashion = (ImageView) itemView.findViewById(R.id.img_fashion);
            txt_fashion = (TextView) itemView.findViewById(R.id.txt_fashion);
            llayout_fashion_main = (LinearLayout) itemView.findViewById(R.id.llayout_fashion_main);
            llayout_like_product = (ImageView) itemView.findViewById(R.id.llayout_like_product);
            llayout_addtocart_product = (ImageView) itemView.findViewById(R.id.llayout_addtocart_product);
        }
    }
}

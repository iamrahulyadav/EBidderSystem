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

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    Context context;
    ArrayList<CategoryClass> dealArrayList;

    public CategoryAdapter(Context context, ArrayList<CategoryClass>dealArrayList) {
        this.context = context;
        this.dealArrayList=dealArrayList;
    }

    @Override
    public CategoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_category, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.ivcategoryImage.setImageResource(R.drawable.downloadimg);
        holder.tvcatogatyname.setText("GROCERY");
        //    Picasso.with(context).load(R.drawable.ic_placeholder).placeholder(R.drawable.ic_placeholder).into(holder.imageIv);

    }

    @Override
    public int getItemCount() {
        return 15;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView ivcategoryImage;
        TextView tvcatogatyname;

        public MyViewHolder(View itemView) {
            super(itemView);

            ivcategoryImage = (ImageView) itemView.findViewById(R.id.catogry_productIv);
            tvcatogatyname = (TextView) itemView.findViewById(R.id.catogry_productName);
        }
    }
}

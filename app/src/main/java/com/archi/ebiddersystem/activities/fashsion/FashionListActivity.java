package com.archi.ebiddersystem.activities.fashsion;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.archi.ebiddersystem.R;
import com.archi.ebiddersystem.adapter.FashionListAdapter;
import com.archi.ebiddersystem.model.FashionListClass;

import java.util.ArrayList;

public class FashionListActivity extends AppCompatActivity {
    public ImageView img_back;
    public ImageView img_sortinglist, img_gridviewlist, img_listviewlist;
    LinearLayoutManager layoutManager;
    RecyclerView fashionRecyclerView;
    ArrayList<FashionListClass> fashionArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fashion_list);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        img_back = findViewById(R.id.img_back);
        img_sortinglist = findViewById(R.id.img_sortinglist);
        img_gridviewlist = findViewById(R.id.img_gridviewlist);
        img_listviewlist = findViewById(R.id.img_listviewlist);

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        img_sortinglist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FashionListActivity.this, "Sorting", Toast.LENGTH_SHORT).show();
            }
        });

        img_gridviewlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fashionArrayList = new ArrayList<FashionListClass>();
                RecyclerView.LayoutManager layoutManager = new GridLayoutManager(FashionListActivity.this, 2);
                fashionRecyclerView.setLayoutManager(layoutManager);
                fashionRecyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
                fashionRecyclerView.setItemAnimator(new DefaultItemAnimator());
                FashionListAdapter fashionListAdapter = new FashionListAdapter(FashionListActivity.this, fashionArrayList);
                fashionRecyclerView.setAdapter(fashionListAdapter);
            }
        });

        img_listviewlist.setOnClickListener(new View.OnClickListener()
            {
            @Override
            public void onClick(View view) {
                fashionRecyclerView = (RecyclerView) findViewById(R.id.fashionlist_recyclerView);
                fashionArrayList = new ArrayList<FashionListClass>();
                layoutManager = new LinearLayoutManager(FashionListActivity.this, LinearLayoutManager.VERTICAL, false);
                fashionRecyclerView.setLayoutManager(layoutManager);
                fashionRecyclerView.setItemAnimator(new DefaultItemAnimator());
                FashionListAdapter fashionListAdapter = new FashionListAdapter(FashionListActivity.this, fashionArrayList);
                fashionRecyclerView.setAdapter(fashionListAdapter);
            }
        });


        init();
    }

    private void init() {
        fashionRecyclerView = (RecyclerView) findViewById(R.id.fashionlist_recyclerView);
        fashionArrayList = new ArrayList<FashionListClass>();
        layoutManager = new LinearLayoutManager(FashionListActivity.this, LinearLayoutManager.VERTICAL, false);
        fashionRecyclerView.setLayoutManager(layoutManager);
        fashionRecyclerView.setItemAnimator(new DefaultItemAnimator());
        FashionListAdapter fashionListAdapter = new FashionListAdapter(FashionListActivity.this, fashionArrayList);
        fashionRecyclerView.setAdapter(fashionListAdapter);
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item  Divider Space...
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge)
            {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)
                if (position < spanCount)
                {
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            }
        }
    }
}
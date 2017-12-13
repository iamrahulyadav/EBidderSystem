package com.archi.ebiddersystem.activities.fashsion;


import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.archi.ebiddersystem.R;
import com.archi.ebiddersystem.adapter.FashionAdapter;
import com.archi.ebiddersystem.model.FashionClass;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FashionFragment extends Fragment
{

    LinearLayoutManager layoutManager;
    RecyclerView fashionRecyclerView;
    ArrayList<FashionClass> fashionArrayList;

    public FashionFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fashion, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view)
    {
        fashionRecyclerView = (RecyclerView) view.findViewById(R.id.fashion_recyclerView);
        fashionArrayList = new ArrayList<FashionClass>();
        //layoutManager = new LinearLayoutManager(getActivity(), GridLayoutManager.VERTICAL, false);
        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(getActivity(),2);
        fashionRecyclerView.setLayoutManager(layoutManager);

         fashionRecyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        fashionRecyclerView.setItemAnimator(new DefaultItemAnimator());
        FashionAdapter fashionAdapter = new FashionAdapter(getActivity(), fashionArrayList);
        fashionRecyclerView.setAdapter(fashionAdapter);
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

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp)
    {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
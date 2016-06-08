package com.it.binarysatan.library.swipelayout.adapter;

import android.content.Context;

import com.it.binarysatan.library.BaseAdapter;
import com.it.binarysatan.library.recyclerview.GRecyclerView;
import com.it.binarysatan.library.swipelayout.manager.SwipeItemManger;

import java.util.List;

/**
 * Author : BinarySatan
 */
public abstract class BaseSwipeAdapter<T> extends BaseAdapter<T> {

    protected SwipeItemManger mItemManger = new SwipeItemManger();


    protected BaseSwipeAdapter(Context context, int layoutId, List<T> data, GRecyclerView recyclerView) {
        super(context, layoutId, data, recyclerView);
    }
}

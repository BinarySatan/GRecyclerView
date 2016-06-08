package com.it.binarysatan.library;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

/**
 * @author BinarySatan
 */
public  class BaseHolder extends RecyclerView.ViewHolder {


    private SparseArray<View> mViews = new SparseArray<>();
    private View mView;

    public BaseHolder(View itemView) {
        super(itemView);
        mView = itemView;
    }

    public static BaseHolder get(View itemview) {
        return new BaseHolder(itemview);
    }

    public BaseHolder setText(int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }


    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public View getRootView() {
        return mView;
    }

}

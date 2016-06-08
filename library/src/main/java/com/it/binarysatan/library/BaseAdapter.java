package com.it.binarysatan.library;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.it.binarysatan.library.recyclerview.GRecyclerView;

import java.util.List;

/**
 * @author BinarySatan
 */
public abstract class BaseAdapter<D> extends RecyclerView.Adapter<BaseHolder> {

    protected List<D> mDatas;
    protected Context mContext;
    protected int mLayoutId;
    private static BaseAdapter mAdapter;
    protected GRecyclerView mRecyclerView;
    protected LayoutInflater mLayoutInflater;

    public BaseAdapter(Context context, int layoutId, List<D> datas, GRecyclerView recyclerView) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mDatas = datas;
        mLayoutId = layoutId;
        mAdapter = this;
        mRecyclerView = recyclerView;
    }

    public int getLayoutId() {
        return mLayoutId;
    }

    public static BaseAdapter getAdapter() {
        return mAdapter;
    }


    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseHolder holder = BaseHolder.get(mLayoutInflater.inflate(mLayoutId, parent, false));
        setListener(holder);
        return holder;
    }

    @Override
    public void onBindViewHolder(BaseHolder holder, int position) {
        updateUI(holder, position, mDatas.get(position));
    }


    @Override
    public int getItemCount() {
        if (mDatas == null)
            return 0;
        return mDatas.size();
    }

    public abstract void updateUI(BaseHolder holder, int position, D data);


    protected void setListener(final BaseHolder holder) {
        setTouchListener(holder);
        rootViewClick(holder);
    }

    private void rootViewClick(final BaseHolder holder) {
        holder.getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick(holder, holder.getAdapterPosition() - (mRecyclerView == null ? 0 : mRecyclerView.getHeaderViews().size()));
            }
        });
    }

    protected void onItemClick(BaseHolder holder, int position) {
        //do something
    }

    protected void setTouchListener(BaseHolder holder) {
        //do something
    }

    public int getPosition(BaseHolder holder) {
        return holder.getAdapterPosition() - (mRecyclerView == null ? 0 : mRecyclerView.getHeaderViews().size());
    }
}

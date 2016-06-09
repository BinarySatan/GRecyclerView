package com.it.binarysatan.library;

import android.content.Context;
import android.view.ViewGroup;

import com.it.binarysatan.library.recyclerview.GRecyclerView;

import java.util.List;

/**
 * @author BinarySatan
 */
public abstract class MultiLayoutAdapter<T> extends BaseAdapter<T> {

    public MultiLayoutAdapter(Context context, List<T> data, GRecyclerView recyclerView) {
        super(context, -1, data, recyclerView);
    }

    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseHolder holder = BaseHolder.get(mLayoutInflater.inflate(viewType, parent, false));
        return holder;
    }

    @Override
    public int getItemViewType(int position) {
        return multiLayout(position);
    }

    public int getLayoutId(BaseHolder holder) {
        return getItemViewType(holder.getAdapterPosition());
    }


    public abstract int multiLayout(int position);

    @Override
    public void updateUI(BaseHolder holder, int position, T data) {
        updateMuiltUI(holder, position, mDatas);
    }


    public abstract void updateMuiltUI(BaseHolder holder, int position, List<T> data);
}

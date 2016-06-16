package com.it.binarysatan.library;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

import com.it.binarysatan.library.recyclerview.GRecyclerView;
import com.it.binarysatan.library.swipelayout.SwipeLayout;
import com.it.binarysatan.library.swipelayout.adapter.BaseSwipeAdapter;

import java.util.List;

/**
 * author : binarysatan
 * 侧滑删除  adapter
 */
public abstract class SwipeAdapter<T> extends BaseSwipeAdapter<T> {

    public static boolean isDeleting = false;

    public SwipeAdapter(Context context, int layoutId, List<T> datas, GRecyclerView recyclerView) {
        super(context, layoutId, datas, recyclerView);
    }


    @Override
    public void onBindViewHolder(final BaseHolder holder, final int position) {
        super.onBindViewHolder(holder, position);
        final SwipeLayout swipeLayout = (SwipeLayout) holder.getRootView();
        swipeLayout.setShowMode(SwipeLayout.ShowMode.PullOut);

        mItemManger.bind(swipeLayout, position);
    }


    @Override
    public void setTouchListener(BaseHolder holder) {
        holder.getRootView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                isDeleting = false;
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        if (mItemManger.isOpenLayout()) {
                            mItemManger.closeAllItems();
                            return true;
                        }
                }
                return false;
            }
        });
    }

    @Override
    protected void setListener(final BaseHolder holder) {
        super.setListener(holder);

        holder.getView(getDeleteViewId()).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDeleting = true;
                deleting(mDatas.get(holder.getAdapterPosition() - mRecyclerView.getHeaderViews().size()));
                mDatas.remove(holder.getAdapterPosition() - mRecyclerView.getHeaderViews().size());
                notifyItemRemoved(holder.getAdapterPosition());
                notifyItemChanged(holder.getAdapterPosition());
                mItemManger.closeAllItems();
            }
        });
    }

    /**
     * 在其内进行自己需要做的删除操作, 如联网告诉后台该数据已取消
     */
    protected abstract void deleting(T t);


    @Override
    protected void onItemClick(BaseHolder holder, int position) {
        if (mItemManger.isPreOpen(holder)) {
            return;
        }
        onItemClick(position);
    }

    public void onItemClick(int position) {
    }

    public abstract int getDeleteViewId();
 
}

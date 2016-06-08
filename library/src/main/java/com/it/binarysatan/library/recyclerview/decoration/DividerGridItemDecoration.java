package com.it.binarysatan.library.recyclerview.decoration;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.it.binarysatan.library.R;
import com.it.binarysatan.library.SwipeAdapter;
import com.it.binarysatan.library.recyclerview.GRecyclerView;

import java.util.List;

public class DividerGridItemDecoration extends RecyclerView.ItemDecoration {

    private Drawable mDivider;


    protected List<View> mHeaderViews;
    protected List<View> mFooterViews;
    protected int mHeaderViewSize;

    public DividerGridItemDecoration(Context context, GRecyclerView recyclerView) {
        this(context, recyclerView, null);
    }

    public DividerGridItemDecoration(Context context, GRecyclerView recyclerView, Drawable drawable) {

        mHeaderViews = recyclerView.getHeaderViews();
        mFooterViews = recyclerView.getFooterViews();


        mDivider = drawable == null ? ContextCompat.getDrawable(context, R.drawable.divider) : drawable;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, State state) {

        drawHorizontal(c, parent);
        drawVertical(c, parent);

    }

    private int getSpanCount(RecyclerView parent) {
        // 列数
        int spanCount = -1;
        LayoutManager layoutManager = parent.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {

            spanCount = ((GridLayoutManager) layoutManager).getSpanCount();
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            spanCount = ((StaggeredGridLayoutManager) layoutManager)
                    .getSpanCount();
        }
        return spanCount;
    }

    public void drawHorizontal(Canvas c, RecyclerView parent) {
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {

            if (handleDecoration(i, childCount))
                continue;


            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int left = child.getLeft() - params.leftMargin;
            final int right = child.getRight() + params.rightMargin
                    + mDivider.getIntrinsicWidth();
            final int top = child.getBottom() + params.bottomMargin;
            final int bottom = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }

    public void drawVertical(Canvas c, RecyclerView parent) {
        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {

            if (handleDecoration(i, childCount))
                continue;

            final View child = parent.getChildAt(i);

            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int top = child.getTop() - params.topMargin;
            final int bottom = child.getBottom() + params.bottomMargin;
            final int left = child.getRight() + params.rightMargin;
            final int right = left + mDivider.getIntrinsicWidth();

            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }

    private boolean isLastColum(RecyclerView parent, int pos, int spanCount,
                                int childCount) {
        LayoutManager layoutManager = parent.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            if ((pos + 1) % spanCount == 0) {// 如果是最后一列，则不需要绘制右边

                return true;
            }
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            int orientation = ((StaggeredGridLayoutManager) layoutManager)
                    .getOrientation();
            if (orientation == StaggeredGridLayoutManager.VERTICAL) {
                if ((pos + 1) % spanCount == 0)// 如果是最后一列，则不需要绘制右边
                {
                    return true;
                }
            } else {
                childCount = childCount - childCount % spanCount;
                if (pos >= childCount)// 如果是最后一列，则不需要绘制右边
                    return true;
            }
        }
        return false;
    }

    private boolean isLastRaw(RecyclerView parent, int pos, int spanCount,
                              int childCount) {
        LayoutManager layoutManager = parent.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            childCount = childCount - childCount % spanCount;
            if (pos >= childCount)// 如果是最后一行，则不需要绘制底部
                return true;
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            int orientation = ((StaggeredGridLayoutManager) layoutManager)
                    .getOrientation();
            // StaggeredGridLayoutManager 且纵向滚动
            if (orientation == StaggeredGridLayoutManager.VERTICAL) {
                childCount = childCount - childCount % spanCount;
                // 如果是最后一行，则不需要绘制底部
                if (pos >= childCount)
                    return true;
            } else
            // StaggeredGridLayoutManager 且横向滚动
            {
                // 如果是最后一行，则不需要绘制底部
                if ((pos + 1) % spanCount == 0) {
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, State state) {

//        if (handleOffsets(((GridLayoutManager.LayoutParams) view.getLayoutParams()).getViewLayoutPosition()))
//            return;

//        int spanCount = getSpanCount(parent);
//        int childCount = parent.getAdapter().getItemCount();
//        if (isLastRaw(parent, ((GridLayoutManager.LayoutParams) view.getLayoutParams()).getViewLayoutPosition(), spanCount, childCount)) {// 如果是最后一行，则不需要绘制底部
//
//            outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
//        } else if (isLastColum(parent, ((GridLayoutManager.LayoutParams) view.getLayoutParams()).getViewLayoutPosition(), spanCount, childCount)) {// 如果是最后一列，则不需要绘制右边
//
//            outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
//        } else {
//            outRect.set(0, 0, mDivider.getIntrinsicWidth(),
//                    mDivider.getIntrinsicHeight());
//        }

    }


    private boolean handleOffsets(int position) {
        mHeaderViewSize = mHeaderViews.size();

        for (int i = 0; i < mHeaderViewSize; i++) {
            if (i == position) return true;
        }

        return false;
    }

    /**
     * 添加header时,分割线处理.
     *
     * @param i
     * @param childCount
     * @return
     */


    protected boolean handleDecoration(int i, int childCount) {
        mHeaderViewSize = mHeaderViews.size();

        if (SwipeAdapter.isDeleting && i == mHeaderViewSize - 2 && mHeaderViews.get(mHeaderViewSize - 1).getParent() != null)
            return true;

        if (mHeaderViewSize > 0)
            for (int j = 0; j < mHeaderViewSize; j++)
                if (mHeaderViews.get(j).getParent() != null) {
                    final int n = mHeaderViewSize - (j + 1);
                    for (int m = 0; m <= n; m++)
                        if (i == m)
                            return true;
                }

        return i == childCount - 1 && mFooterViews.size() > 0;

    }
}
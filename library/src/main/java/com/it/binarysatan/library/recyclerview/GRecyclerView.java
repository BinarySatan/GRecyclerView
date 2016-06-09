package com.it.binarysatan.library.recyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.it.binarysatan.library.R;
import com.it.binarysatan.library.recyclerview.decoration.DividerGridItemDecoration;
import com.it.binarysatan.library.recyclerview.decoration.FlexibleDividerDecoration;
import com.it.binarysatan.library.recyclerview.decoration.HorizontalDividerItemDecoration;
import com.it.binarysatan.library.recyclerview.decoration.VerticalDividerItemDecoration;
import com.it.binarysatan.library.recyclerview.ref.IRefreshFooter;
import com.it.binarysatan.library.recyclerview.ref.IRefreshHeader;
import com.it.binarysatan.library.recyclerview.ref.RefreshFactory;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @see RefreshFactory
 * @see com.it.binarysatan.library.recyclerview.decoration.FlexibleDividerDecoration.PaintProvider
 * @see com.it.binarysatan.library.recyclerview.decoration.FlexibleDividerDecoration.SizeProvider
 * @see com.it.binarysatan.library.recyclerview.decoration.FlexibleDividerDecoration.ColorProvider
 * @see com.it.binarysatan.library.recyclerview.decoration.FlexibleDividerDecoration.VisibilityProvider
 * @see com.it.binarysatan.library.recyclerview.decoration.HorizontalDividerItemDecoration.MarginProvider
 * @see com.it.binarysatan.library.recyclerview.decoration.VerticalDividerItemDecoration.MarginProvider
 * @see com.it.binarysatan.library.recyclerview.decoration.FlexibleDividerDecoration.DrawableProvider
 */
public class GRecyclerView extends RecyclerView {

    private boolean mIsLoadingData = false;

    private boolean mIsNoMore = false;

    public ArrayList<View> mHeaderViews = new ArrayList<>();

    private ArrayList<View> mFootViews = new ArrayList<>();

    private Adapter mWrapAdapter;

    private float mLastY = -1;

    private static final float DRAG_RATE = 3;

    private OnRefreshListener mRefreshListener;

    private boolean pullRefreshEnabled = true;

    private boolean loadingMoreEnabled = true;

    private static final int TYPE_REFRESH_HEADER = -5;

    private static final int TYPE_NORMAL = 0;

    private static final int TYPE_FOOTER = -3;

    private static final int HEADER_INIT_INDEX = 10000;

    private static List<Integer> sHeaderTypes = new ArrayList<>();

    private View mEmptyView;
    private final RecyclerView.AdapterDataObserver mDataObserver = new DataObserver();

    private IRefreshHeader mRefreshHeader;

    private IRefreshFooter mRefreshFooter;

    private RefreshFactory mRefreshFactory;

    private int mDefDividerColor;

    private int mDividerColor = mDefDividerColor;

    private int mDefaultAttrValue = -1;

    private int mDividerWidthId = mDefaultAttrValue;

    private float mDividerMarginLeft = 0;

    private float mDividerMarginRight = 0;

    private float mDividerMarginTop = 0;
    private float mDividerMarginBottom = 0;


    private int mDrawableId = mDefaultAttrValue;

    private boolean mIsNeedDivider = true;

    private LayoutManager mLayoutManager;


    public GRecyclerView(Context context) {
        this(context, null);
    }

    public GRecyclerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }


    private void init(AttributeSet attrs) {

        initCusAttribute(attrs);
        initView();

    }

    private void initView() {
        mRefreshFactory = new RefreshFactory();

        mRefreshHeader = mRefreshFactory.createRefreshHeader(getContext());
        mHeaderViews.add(0, mRefreshFactory.getHeaderView());

        mRefreshFooter = mRefreshFactory.createRefreshFooter(getContext());
        mFootViews.add(mRefreshFactory.getFooterView());
    }

    private void initCusAttribute(AttributeSet attrs) {
        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.GRecyclerView);
        mDividerColor = ta.getColor(R.styleable.GRecyclerView_dividerColor, mDefDividerColor);
        mDividerWidthId = ta.getResourceId(R.styleable.GRecyclerView_dividerStrokeWidth, mDefaultAttrValue);
        mDividerMarginLeft = ta.getDimension(R.styleable.GRecyclerView_margin_left, mDividerMarginLeft);
        mDividerMarginRight = ta.getDimension(R.styleable.GRecyclerView_margin_right, mDividerMarginRight);
        mDividerMarginTop = ta.getDimension(R.styleable.GRecyclerView_margin_top, mDividerMarginTop);
        mDividerMarginBottom = ta.getDimension(R.styleable.GRecyclerView_margin_bottom, mDividerMarginBottom);
        mDrawableId = ta.getResourceId(R.styleable.GRecyclerView_drawable, mDrawableId);
        mIsNeedDivider = ta.getBoolean(R.styleable.GRecyclerView_needDivider, mIsNeedDivider);
        ta.recycle();
    }


    public void addHeaderView(View view) {
        if (pullRefreshEnabled && !(mHeaderViews.get(0) instanceof IRefreshHeader)) {
            mHeaderViews.add(0, mRefreshFactory.getHeaderView());
        }
        mHeaderViews.add(view);
        sHeaderTypes.add(HEADER_INIT_INDEX + mHeaderViews.size());
    }

    public void addFooterView(IRefreshFooter refreshFooter) {
        mFootViews.clear();
        View rootView = refreshFooter.getRootView();
        mFootViews.add(rootView);
    }

    public void loadMoreComplete() {
        mIsLoadingData = false;
        mRefreshFooter.loadComplete();
    }

    public void setNoMore(boolean noMore) {
        mIsNoMore = noMore;
        mRefreshFooter.setState(mIsNoMore ? IRefreshFooter.STATE_NOMORE : IRefreshFooter.STATE_COMPLETE);
    }

    public void setRefreshHeader(IRefreshHeader refreshHeader) {
        mHeaderViews.remove(0);
        mHeaderViews.add(0, refreshHeader.getRootView());
        mRefreshHeader = refreshHeader;
    }

    public void setRefreshFooter(IRefreshFooter refreshFooter) {
        mFootViews.remove(0);
        mFootViews.add(0, refreshFooter.getRootView());
        mRefreshFooter = refreshFooter;
    }


    public void reset() {
        setNoMore(false);
        loadMoreComplete();
        refreshComplete();
    }


    public void loadNoMore() {
//        mIsLoadingData = false;
        mIsNoMore = true;
        mRefreshFooter.setState(IRefreshFooter.STATE_NOMORE);

        loadMoreComplete();
    }

    public void refreshComplete() {
        mRefreshHeader.refreshComplete();
    }

    public void setRefreshingEnabled(boolean enabled) {
        pullRefreshEnabled = enabled;
    }

    public void setLoadingMoreEnabled(boolean enabled) {
        loadingMoreEnabled = enabled;
        if (!enabled && mFootViews.size() > 0) {
            mFootViews.clear();
        }
    }

    public void setEmptyView(View emptyView) {
        this.mEmptyView = emptyView;
        mDataObserver.onChanged();
    }

    public View getEmptyView() {
        return mEmptyView;
    }


    public List<View> getHeaderViews() {
        return mHeaderViews;
    }

    public List<View> getFooterViews() {
        return mFootViews;
    }

    @Override
    public void setAdapter(Adapter adapter) {
        mWrapAdapter = new WrapAdapter(adapter);
        super.setAdapter(mWrapAdapter);

        if (mIsNeedDivider)
            addDecoration(adapter);

        adapter.registerAdapterDataObserver(mDataObserver);
        mDataObserver.onChanged();
    }


    private void addDecoration(Adapter adapter) {
        if (mLayoutManager == null)
            return;

        if (mLayoutManager instanceof GridLayoutManager || mLayoutManager instanceof StaggeredGridLayoutManager) {
            addItemDecoration(mDrawableId == 0
                    ? new DividerGridItemDecoration(getContext(), this)
                    : new DividerGridItemDecoration(getContext(), this, ContextCompat.getDrawable(getContext(), mDrawableId)));
            return;
        }
        int orientation = ((LinearLayoutManager) mLayoutManager).getOrientation();

        if (orientation == LinearLayoutManager.VERTICAL) {
            addItemDecoration(new HorizontalDividerItemDecoration.Builder(getContext())
                    .drawable(mDrawableId)
                    .color(mDrawableId == -1 ? (mDividerColor == 0 ? -1 : mDividerColor) : -1)
                    .sizeResId(mDividerWidthId)
                    .margin(mDividerMarginLeft, mDividerMarginRight)
                    .sizeProvider(adapter instanceof FlexibleDividerDecoration.SizeProvider ? (FlexibleDividerDecoration.SizeProvider) adapter : null)
                    .paintProvider(adapter instanceof FlexibleDividerDecoration.PaintProvider ? (FlexibleDividerDecoration.PaintProvider) adapter : null)
                    .colorProvider(adapter instanceof FlexibleDividerDecoration.ColorProvider ? (FlexibleDividerDecoration.ColorProvider) adapter : null)
                    .visibilityProvider(adapter instanceof FlexibleDividerDecoration.VisibilityProvider ? (FlexibleDividerDecoration.VisibilityProvider) adapter : null)
                    .marginProvider(adapter instanceof HorizontalDividerItemDecoration.MarginProvider ? (HorizontalDividerItemDecoration.MarginProvider) adapter : null)
                    .build(this));
        } else {
            addItemDecoration(new VerticalDividerItemDecoration.Builder(getContext())
                    .drawable(mDrawableId)
                    .color(mDrawableId == -1 ? mDividerColor : -1)
                    .sizeResId(mDividerWidthId)
                    .margin(mDividerMarginTop, mDividerMarginBottom)
                    .sizeProvider(adapter instanceof FlexibleDividerDecoration.SizeProvider ? (FlexibleDividerDecoration.SizeProvider) adapter : null)
                    .paintProvider(adapter instanceof FlexibleDividerDecoration.PaintProvider ? (FlexibleDividerDecoration.PaintProvider) adapter : null)
                    .colorProvider(adapter instanceof FlexibleDividerDecoration.ColorProvider ? (FlexibleDividerDecoration.ColorProvider) adapter : null)
                    .visibilityProvider(adapter instanceof FlexibleDividerDecoration.VisibilityProvider ? (FlexibleDividerDecoration.VisibilityProvider) adapter : null)
                    .marginProvider(adapter instanceof VerticalDividerItemDecoration.MarginProvider ? (VerticalDividerItemDecoration.MarginProvider) adapter : null)
                    .build(this));
        }
    }


    @Override
    public ViewHolder getChildViewHolder(View child) {
        return super.getChildViewHolder(child);
    }


    @Override
    public void setLayoutManager(LayoutManager layout) {
        super.setLayoutManager(layout);

        mLayoutManager = layout;
    }

    @Override
    public void onScrollStateChanged(int state) {
        super.onScrollStateChanged(state);

        if (state == RecyclerView.SCROLL_STATE_IDLE && mRefreshListener != null && !mIsLoadingData && loadingMoreEnabled) {
            LayoutManager layoutManager = getLayoutManager();
            int lastVisibleItemPosition;
            if (layoutManager instanceof GridLayoutManager) {
                lastVisibleItemPosition = ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
            } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                int[] into = new int[((StaggeredGridLayoutManager) layoutManager).getSpanCount()];
                ((StaggeredGridLayoutManager) layoutManager).findLastVisibleItemPositions(into);
                lastVisibleItemPosition = findMax(into);
            } else {
                lastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
            }
            if (layoutManager.getChildCount() > 0
                    && lastVisibleItemPosition >= layoutManager.getItemCount() - 1 && layoutManager.getItemCount() > layoutManager.getChildCount() && !mIsNoMore && mRefreshHeader.getState() < IRefreshHeader.STATE_REFRESHING) {
//                mRefreshFooter.setState(IRefreshFooter.CLICK_LOAD);

            }
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (mLastY == -1) {
            mLastY = ev.getRawY();
        }
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastY = ev.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                final float deltaY = ev.getRawY() - mLastY;
                mLastY = ev.getRawY();
                if (isOnTop() && pullRefreshEnabled) {
                    if (mRefreshHeader.getVisibleHeight() > 0 && mRefreshHeader.getState() >= IRefreshHeader.STATE_RELEASE_TO_REFRESH) {
                        return true;
                    }

                    mRefreshHeader.onMove(deltaY / DRAG_RATE);

                } else if (isOnBottom() && loadingMoreEnabled) {
                    if (mRefreshFooter.getVisibleHeight() > 0 && mRefreshFooter.getState() >= IRefreshFooter.STATE_RELEASE_LOAD) {
                        return true;
                    }
                    mRefreshFooter.onMove(Math.abs(deltaY) / DRAG_RATE);

                }
                break;
            default:
                mLastY = -1; // reset
                if (isOnTop() && pullRefreshEnabled) {
                    if (mRefreshHeader.releaseAction()) {
                        if (mRefreshListener != null) {
                            mRefreshListener.onRefresh();
                        }
                    }
                } else if (isOnBottom() && loadingMoreEnabled) {
                    if (mRefreshFooter.releaseAction()) {
                        if (mRefreshListener != null) {
                            mRefreshListener.onLoadMore();
                        }
                    }
                } else {
                    reset();
                }
                break;
        }
        return super.onTouchEvent(ev);
    }

    private int findMax(int[] lastPositions) {
        int max = lastPositions[0];
        for (int value : lastPositions) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    private int findMin(int[] firstPositions) {
        int min = firstPositions[0];
        for (int value : firstPositions) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    private boolean isOnTop() {
        return !(mHeaderViews == null || mHeaderViews.isEmpty()) && mHeaderViews.get(0).getParent() != null;
    }

    private boolean isOnBottom() {
        return !(mFootViews == null || mFootViews.isEmpty()) && mFootViews.get(0).getParent() != null;
    }

    private class DataObserver extends RecyclerView.AdapterDataObserver {
        @Override
        public void onChanged() {
            Adapter<?> adapter = getAdapter();
            if (adapter != null && mEmptyView != null) {
                int emptyCount = 0;
                if (pullRefreshEnabled) {
                    emptyCount++;
                }
                if (loadingMoreEnabled) {
                    emptyCount++;
                }
                if (adapter.getItemCount() == emptyCount) {
                    mEmptyView.setVisibility(View.VISIBLE);
                    GRecyclerView.this.setVisibility(View.GONE);
                } else {
                    mEmptyView.setVisibility(View.GONE);
                    GRecyclerView.this.setVisibility(View.VISIBLE);
                }
            }
            if (mWrapAdapter != null) {
                mWrapAdapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onItemRangeInserted(int positionStart, int itemCount) {
            mWrapAdapter.notifyItemRangeInserted(positionStart, itemCount);
        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount) {
            mWrapAdapter.notifyItemRangeChanged(positionStart, itemCount);
        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount, Object payload) {
            mWrapAdapter.notifyItemRangeChanged(positionStart, itemCount, payload);
        }

        @Override
        public void onItemRangeRemoved(int positionStart, int itemCount) {
            mWrapAdapter.notifyItemRangeRemoved(positionStart, itemCount);
        }


        @Override
        public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
            mWrapAdapter.notifyItemMoved(fromPosition, toPosition);
        }
    }

    private class WrapAdapter extends RecyclerView.Adapter<ViewHolder> {

        private RecyclerView.Adapter adapter;

        private int headerPosition = 1;

        public WrapAdapter(RecyclerView.Adapter adapter) {
            this.adapter = adapter;
        }

        @Override
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
            RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
            if (manager instanceof GridLayoutManager) {
                final GridLayoutManager gridManager = ((GridLayoutManager) manager);
                gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                    @Override
                    public int getSpanSize(int position) {
                        return (isHeader(position) || isFooter(position))
                                ? gridManager.getSpanCount() : 1;
                    }
                });
            }
        }

        @Override
        public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
            super.onViewAttachedToWindow(holder);
            ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
            if (lp != null
                    && lp instanceof StaggeredGridLayoutManager.LayoutParams
                    && (isHeader(holder.getLayoutPosition()) || isFooter(holder.getLayoutPosition()))) {
                StaggeredGridLayoutManager.LayoutParams p = (StaggeredGridLayoutManager.LayoutParams) lp;
                p.setFullSpan(true);
            }
        }

        public boolean isHeader(int position) {
            return position >= 0 && position < mHeaderViews.size();
        }

        public boolean isContentHeader(int position) {
            return position >= 1 && position < mHeaderViews.size();
        }

        public boolean isFooter(int position) {
            return position < getItemCount() && position >= getItemCount() - mFootViews.size();
        }

        public boolean isRefreshHeader(int position) {
            return position == 0;
        }

        public int getHeadersCount() {
            return mHeaderViews.size();
        }

        public int getFootersCount() {
            return mFootViews.size();
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            if (viewType == TYPE_REFRESH_HEADER) {
                mCurrentPosition++;
                return new SimpleViewHolder(mHeaderViews.get(0));
            } else if (isContentHeader(mCurrentPosition)) {
                if (viewType == sHeaderTypes.get(mCurrentPosition - 1)) {
                    mCurrentPosition++;
                    return new SimpleViewHolder(mHeaderViews.get(headerPosition++));
                }
            } else if (viewType == TYPE_FOOTER) {
                return new SimpleViewHolder(mFootViews.get(0));
            }
            return adapter.onCreateViewHolder(parent, viewType);
        }

        private int mCurrentPosition;

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (isHeader(position)) {
                return;
            }

            if (isFooter(position))
                return;
            int adjPosition = position - getHeadersCount();
            int adapterCount;
            if (adapter != null) {
                adapterCount = adapter.getItemCount();
                if (adjPosition < adapterCount) {
                    adapter.onBindViewHolder(holder, adjPosition);
                    return;
                }
            }
        }

        @Override
        public int getItemCount() {
            if (adapter != null) {
                return getHeadersCount() + getFootersCount() + adapter.getItemCount();
            } else {
                return getHeadersCount() + getFootersCount();
            }
        }

        @Override
        public int getItemViewType(int position) {
            if (isRefreshHeader(position)) {
                return TYPE_REFRESH_HEADER;
            }
            if (isHeader(position)) {
                position = position - 1;
                return sHeaderTypes.get(position);
            }
            if (isFooter(position)) {
                return TYPE_FOOTER;
            }
            int adjPosition = position - getHeadersCount();
            int adapterCount;
            if (adapter != null) {
                adapterCount = adapter.getItemCount();
                if (adjPosition < adapterCount) {
                    return adapter.getItemViewType(adjPosition);
                }
            }
            return TYPE_NORMAL;
        }

        @Override
        public long getItemId(int position) {
            if (adapter != null && position >= getHeadersCount()) {
                int adjPosition = position - getHeadersCount();
                int adapterCount = adapter.getItemCount();
                if (adjPosition < adapterCount) {
                    return adapter.getItemId(adjPosition);
                }
            }
            return -1;
        }


        @Override
        public void unregisterAdapterDataObserver(AdapterDataObserver observer) {
            if (adapter != null) {
                adapter.unregisterAdapterDataObserver(observer);
            }
        }

        @Override
        public void registerAdapterDataObserver(AdapterDataObserver observer) {
            if (adapter != null) {
                adapter.registerAdapterDataObserver(observer);
            }
        }

        private class SimpleViewHolder extends RecyclerView.ViewHolder {
            public SimpleViewHolder(View itemView) {
                super(itemView);
            }
        }
    }

    public void setOnRefreshListener(OnRefreshListener listener) {
        mRefreshListener = listener;
    }

    public interface OnRefreshListener {

        void onRefresh();

        void onLoadMore();
    }

    public void setRefreshing(boolean refreshing) {
        if (refreshing && pullRefreshEnabled && mRefreshListener != null) {
            mRefreshHeader.setState(IRefreshHeader.STATE_REFRESHING);
            mRefreshHeader.onMove(mRefreshFactory.getHeaderView().getMeasuredHeight());
            mRefreshListener.onRefresh();
        }
    }


}
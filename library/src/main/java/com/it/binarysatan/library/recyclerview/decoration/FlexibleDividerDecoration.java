package com.it.binarysatan.library.recyclerview.decoration;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.it.binarysatan.library.SwipeAdapter;
import com.it.binarysatan.library.recyclerview.GRecyclerView;

import java.util.List;

public abstract class FlexibleDividerDecoration extends RecyclerView.ItemDecoration {

    private static final int DEFAULT_SIZE = 2;
    private static final int[] ATTRS = new int[]{
            android.R.attr.listDivider
    };

    protected enum DividerType {
        DRAWABLE, PAINT, COLOR
    }

    protected DividerType mDividerType = DividerType.DRAWABLE;
    protected VisibilityProvider mVisibilityProvider;
    protected PaintProvider mPaintProvider;
    protected ColorProvider mColorProvider;
    protected DrawableProvider mDrawableProvider;
    protected SizeProvider mSizeProvider;
    protected boolean mShowLastDivider;
    protected boolean mPositionInsideItem;
    private Paint mPaint;


    protected List<View> mHeaderViews;
    protected List<View> mFooterViews;
    protected int mHeaderViewSize;

    protected FlexibleDividerDecoration(Builder builder, GRecyclerView recyclerView) {

        mHeaderViews = recyclerView.getHeaderViews();
        mFooterViews = recyclerView.getFooterViews();

        if (builder.mPaintProvider != null) {
            mDividerType = DividerType.PAINT;
            mPaintProvider = builder.mPaintProvider;
        } else if (builder.mColorProvider != null) {
            mDividerType = DividerType.COLOR;
            mColorProvider = builder.mColorProvider;
            mPaint = new Paint();
            setSizeProvider(builder);
        } else {
            mDividerType = DividerType.DRAWABLE;
            if (builder.mDrawableProvider == null) {
                TypedArray a = builder.mContext.obtainStyledAttributes(ATTRS);
                final Drawable divider = a.getDrawable(0);
                a.recycle();
                mDrawableProvider = new DrawableProvider() {
                    @Override
                    public Drawable drawableProvider(int position, RecyclerView parent) {
                        return divider;
                    }
                };
            } else {
                mDrawableProvider = builder.mDrawableProvider;
            }
            mSizeProvider = builder.mSizeProvider;
        }

        mVisibilityProvider = builder.mVisibilityProvider;
        mShowLastDivider = builder.mShowLastDivider;
        mPositionInsideItem = builder.mPositionInsideItem;
    }

    private void setSizeProvider(Builder builder) {
        mSizeProvider = builder.mSizeProvider;
        if (mSizeProvider == null) {
            mSizeProvider = new SizeProvider() {
                @Override
                public float dividerSize(int position, RecyclerView parent) {
                    return DEFAULT_SIZE;
                }
            };
        }
    }

    /**
     * 添加header时,分割线处理.
     *
     * @param i
     * @return
     */


    protected boolean handleDecoration(int i, RecyclerView parent, int position) {
        mHeaderViewSize = mHeaderViews.size();

        if (SwipeAdapter.isDeleting)
            return true;


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


        if (mFooterViews.size() > 0)
            for (int g = 0; g < mFooterViews.size(); g++)
                if ((position == parent.getAdapter().getItemCount() - 1
                        || position == parent.getAdapter().getItemCount() - 2)
                        && mFooterViews.get(g).getParent() != null)
                    return true;

        return false;
    }


    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        RecyclerView.Adapter adapter = parent.getAdapter();
        if (adapter == null) {
            return;
        }

        int itemCount = adapter.getItemCount();
        int lastDividerOffset = getLastDividerOffset(parent);
        int validChildCount = parent.getChildCount();
        int lastChildPosition = -1;
        for (int i = 0; i < validChildCount; i++) {


            View child = parent.getChildAt(i);
            int childPosition = parent.getChildAdapterPosition(child);


            if (handleDecoration(i, parent, childPosition))
                continue;
            if (childPosition < lastChildPosition) {
                // Avoid remaining divider when animation starts
                continue;
            }
            lastChildPosition = childPosition;

            if (!mShowLastDivider && childPosition >= itemCount - lastDividerOffset) {
                // Don't draw divider for last line if mShowLastDivider = false
                continue;
            }

            if (wasDividerAlreadyDrawn(childPosition, parent)) {
                // No need to draw divider again as it was drawn already by previous column
                continue;
            }

            int groupIndex = getGroupIndex(childPosition, parent);
            if (mVisibilityProvider.shouldHideDivider(groupIndex, parent)) {
                continue;
            }

            Rect bounds = getDividerBound(groupIndex, parent, child);
            switch (mDividerType) {
                case DRAWABLE:
                    Drawable drawable = mDrawableProvider.drawableProvider(groupIndex, parent);
                    drawable.setBounds(bounds);
                    drawable.draw(c);
                    break;
                case PAINT:
                    mPaint = mPaintProvider.dividerPaint(groupIndex, parent);
                    c.drawLine(bounds.left, bounds.top, bounds.right, bounds.bottom, mPaint);
                    break;
                case COLOR:
                    mPaint.setColor(mColorProvider.dividerColor(groupIndex, parent));
                    mPaint.setStrokeWidth(mSizeProvider.dividerSize(groupIndex, parent));
                    c.drawLine(bounds.left, bounds.top, bounds.right, bounds.bottom, mPaint);
                    break;
            }
        }
    }

    @Override
    public void getItemOffsets(Rect rect, View v, RecyclerView parent, RecyclerView.State state) {


        int position = parent.getChildAdapterPosition(v);


        int itemCount = parent.getAdapter().getItemCount();


        if (handleOffsets(position, itemCount))
            return;
        int lastDividerOffset = getLastDividerOffset(parent);
        if (!mShowLastDivider && position >= itemCount - lastDividerOffset) {
            // Don't set item offset for last line if mShowLastDivider = false
            return;
        }

        int groupIndex = getGroupIndex(position, parent);
        setItemOffsets(rect, groupIndex, parent);
    }


    private boolean handleOffsets(int position, int childCount) {
        mHeaderViewSize = mHeaderViews.size();

        for (int i = 0; i < mHeaderViewSize; i++)
            if (i == position)
                return true;


        if (mFooterViews.size() > 0)
            if (position == childCount - 1 || position == childCount - 2)
                return true;

        return false;
    }


    /**
     * In the case mShowLastDivider = false,
     * Returns offset for how many views we don't have to draw a divider for,
     * for LinearLayoutManager it is as simple as not drawing the last child divider,
     * but for a GridLayoutManager it needs to take the span count for the last items into account
     * until we use the span count configured for the grid.
     *
     * @param parent RecyclerView
     * @return offset for how many views we don't have to draw a divider or 1 if its a
     * LinearLayoutManager
     */
    private int getLastDividerOffset(RecyclerView parent) {
        if (parent.getLayoutManager() instanceof GridLayoutManager) {
            GridLayoutManager layoutManager = (GridLayoutManager) parent.getLayoutManager();
            GridLayoutManager.SpanSizeLookup spanSizeLookup = layoutManager.getSpanSizeLookup();
            int spanCount = layoutManager.getSpanCount();
            int itemCount = parent.getAdapter().getItemCount();
            for (int i = itemCount - 1; i >= 0; i--) {
                if (spanSizeLookup.getSpanIndex(i, spanCount) == 0) {
                    return itemCount - i;
                }
            }
        }

        return 1;
    }

    /**
     * Determines whether divider was already drawn for the row the item is in,
     * effectively only makes sense for a grid
     *
     * @param position current view position to draw divider
     * @param parent   RecyclerView
     * @return true if the divider can be skipped as it is in the same row as the previous one.
     */
    private boolean wasDividerAlreadyDrawn(int position, RecyclerView parent) {
        if (parent.getLayoutManager() instanceof GridLayoutManager) {
            GridLayoutManager layoutManager = (GridLayoutManager) parent.getLayoutManager();
            GridLayoutManager.SpanSizeLookup spanSizeLookup = layoutManager.getSpanSizeLookup();
            int spanCount = layoutManager.getSpanCount();
            return spanSizeLookup.getSpanIndex(position, spanCount) > 0;
        }

        return false;
    }

    /**
     * Returns a group index for GridLayoutManager.
     * for LinearLayoutManager, always returns position.
     *
     * @param position current view position to draw divider
     * @param parent   RecyclerView
     * @return group index of items
     */
    private int getGroupIndex(int position, RecyclerView parent) {
        if (parent.getLayoutManager() instanceof GridLayoutManager) {
            GridLayoutManager layoutManager = (GridLayoutManager) parent.getLayoutManager();
            GridLayoutManager.SpanSizeLookup spanSizeLookup = layoutManager.getSpanSizeLookup();
            int spanCount = layoutManager.getSpanCount();
            return spanSizeLookup.getSpanGroupIndex(position, spanCount);
        }

        return position;
    }

    protected abstract Rect getDividerBound(int position, RecyclerView parent, View child);

    protected abstract void setItemOffsets(Rect outRect, int position, RecyclerView parent);

    /**
     * Interface for controlling divider visibility
     */
    public interface VisibilityProvider {

        /**
         * Returns true if divider should be hidden.
         *
         * @param position Divider position (or group index for GridLayoutManager)
         * @param parent   RecyclerView
         * @return True if the divider at position should be hidden
         */
        boolean shouldHideDivider(int position, RecyclerView parent);
    }

    /**
     * Interface for controlling paint instance for divider drawing
     */
    public interface PaintProvider {

        /**
         * Returns {@link Paint} for divider
         *
         * @param position Divider position (or group index for GridLayoutManager)
         * @param parent   RecyclerView
         * @return Paint instance
         */
        Paint dividerPaint(int position, RecyclerView parent);
    }

    /**
     * Interface for controlling divider color
     */
    public interface ColorProvider {

        /**
         * Returns {@link android.graphics.Color} value of divider
         *
         * @param position Divider position (or group index for GridLayoutManager)
         * @param parent   RecyclerView
         * @return Color value
         */
        int dividerColor(int position, RecyclerView parent);
    }

    /**
     * Interface for controlling drawable object for divider drawing
     */
    public interface DrawableProvider {

        /**
         * Returns drawable instance for divider
         *
         * @param position Divider position (or group index for GridLayoutManager)
         * @param parent   RecyclerView
         * @return Drawable instance
         */
        Drawable drawableProvider(int position, RecyclerView parent);
    }

    /**
     * Interface for controlling divider size
     */
    public interface SizeProvider {

        /**
         * Returns size value of divider.
         * Height for horizontal divider, width for vertical divider
         *
         * @param position Divider position (or group index for GridLayoutManager)
         * @param parent   RecyclerView
         * @return Size of divider
         */
        float dividerSize(int position, RecyclerView parent);
    }

    public static class Builder<T extends Builder> {

        private Context mContext;
        protected Resources mResources;
        private PaintProvider mPaintProvider;
        private ColorProvider mColorProvider;
        private DrawableProvider mDrawableProvider;
        private SizeProvider mSizeProvider;
        private VisibilityProvider mVisibilityProvider = new VisibilityProvider() {
            @Override
            public boolean shouldHideDivider(int position, RecyclerView parent) {
                return false;
            }
        };
        private boolean mShowLastDivider = false;
        private boolean mPositionInsideItem = false;

        public Builder(Context context) {
            mContext = context;
            mResources = context.getResources();
        }

        public T paint(final Paint paint) {
            return paintProvider(new PaintProvider() {
                @Override
                public Paint dividerPaint(int position, RecyclerView parent) {
                    return paint;
                }
            });
        }

        public T paintProvider(PaintProvider provider) {
            if (null == provider)
                return (T) this;

            mPaintProvider = provider;
            return (T) this;
        }

        public T color(final int color) {
            if (color == -1)
                return (T) this;
            return colorProvider(new ColorProvider() {
                @Override
                public int dividerColor(int position, RecyclerView parent) {
                    return color;
                }
            });
        }

        public T colorResId(@ColorRes int colorId) {
            return color(ContextCompat.getColor(mContext, colorId));
        }

        public T colorProvider(ColorProvider provider) {
            if (null == provider)
                return (T) this;
            mColorProvider = provider;
            return (T) this;
        }

        public T drawable(@DrawableRes int id) {
            if (id == -1)
                return (T) this;
            return drawable(ContextCompat.getDrawable(mContext, id));
        }

        public T drawable(final Drawable drawable) {
            return drawableProvider(new DrawableProvider() {
                @Override
                public Drawable drawableProvider(int position, RecyclerView parent) {
                    return drawable;
                }
            });
        }

        public T drawableProvider(DrawableProvider provider) {
            mDrawableProvider = provider;
            return (T) this;
        }

        public T size(final float size) {
            return sizeProvider(new SizeProvider() {
                @Override
                public float dividerSize(int position, RecyclerView parent) {
                    return size;
                }
            });
        }

        public T sizeResId(@DimenRes int sizeId) {
            if (sizeId == -1)
                return (T) this;
            return size(mResources.getDimensionPixelSize(sizeId));
        }

        public T sizeProvider(SizeProvider provider) {
            if (null == provider)
                return (T) this;
            mSizeProvider = provider;
            return (T) this;
        }

        public T visibilityProvider(VisibilityProvider provider) {
            if (null == provider)
                return (T) this;
            mVisibilityProvider = provider;
            return (T) this;
        }

        public T showLastDivider() {
            mShowLastDivider = true;
            return (T) this;
        }

        public T positionInsideItem(boolean positionInsideItem) {
            mPositionInsideItem = positionInsideItem;
            return (T) this;
        }

        protected void checkBuilderParams() {
            if (mPaintProvider != null) {
                if (mColorProvider != null) {
                    throw new IllegalArgumentException(
                            "Use setColor method of Paint class to specify line color. Do not provider ColorProvider if you set PaintProvider.");
                }
                if (mSizeProvider != null) {
                    throw new IllegalArgumentException(
                            "Use setStrokeWidth method of Paint class to specify line size. Do not provider SizeProvider if you set PaintProvider.");
                }
            }
        }
    }
}
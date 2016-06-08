package com.it.binarysatan.library.swipelayout.manager;


import com.it.binarysatan.library.BaseHolder;
import com.it.binarysatan.library.swipelayout.SwipeLayout;
import com.it.binarysatan.library.swipelayout.SwipeListener;
import com.it.binarysatan.library.swipelayout.util.Attributes;

import java.util.HashSet;
import java.util.Set;

/**
 * SwipeItemMangerImpl is a helper class to help all the adapters to maintain open status.
 */
public  class SwipeItemManger {

    private Attributes.Mode mode = Attributes.Mode.Single;
    public final int INVALID_POSITION = -1;

    protected int mOpenPosition = INVALID_POSITION;

    protected Set<Integer> mOpenPositions = new HashSet<>();
    protected Set<SwipeLayout> mShownLayouts = new HashSet<>();



    public void bind(SwipeLayout swipeLayout, int position) {
        int resId = swipeLayout.getId();

        if (swipeLayout == null)
            throw new IllegalStateException("can not find SwipeLayout in target view");

        if (swipeLayout.getTag(resId) == null) {
            OnLayoutListener onLayoutListener = new OnLayoutListener(position);
            SwipeMemory swipeMemory = new SwipeMemory(position);
            swipeLayout.addSwipeListener(swipeMemory);
            swipeLayout.addOnLayoutListener(onLayoutListener);
            swipeLayout.setTag(resId, new ValueBox(position, swipeMemory, onLayoutListener));
            mShownLayouts.add(swipeLayout);
        } else {
            ValueBox valueBox = (ValueBox) swipeLayout.getTag(resId);
            valueBox.swipeMemory.setPosition(position);
            valueBox.onLayoutListener.setPosition(position);
            valueBox.position = position;
        }
    }

    public void closeAllExcept(SwipeLayout layout) {
        for (SwipeLayout s : mShownLayouts) {
            if (s != layout)
                s.close();
        }
    }

    public boolean isOpenLayout() {
        for (SwipeLayout sl : mShownLayouts) {
            if (sl.isOpen()) {
                return true;
            }
        }
        return false;
    }

    public void closeAllItems() {
        if (mode == Attributes.Mode.Multiple) {
            mOpenPositions.clear();
        } else {
            mOpenPosition = INVALID_POSITION;
        }
        for (SwipeLayout s : mShownLayouts) {
            s.close();
        }
    }


    public boolean isPreOpen(BaseHolder holder) {
        return ((SwipeLayout) holder.getRootView()).isOpen();
    }

    public boolean isOpen(int position) {
        if (mode == Attributes.Mode.Multiple) {
            return mOpenPositions.contains(position);
        } else {
            return mOpenPosition == position;
        }
    }

    class ValueBox {
        OnLayoutListener onLayoutListener;
        SwipeMemory swipeMemory;
        int position;

        ValueBox(int position, SwipeMemory swipeMemory, OnLayoutListener onLayoutListener) {
            this.swipeMemory = swipeMemory;
            this.onLayoutListener = onLayoutListener;
            this.position = position;
        }
    }

    public class OnLayoutListener implements SwipeLayout.OnLayout {

        private int position;

        OnLayoutListener(int position) {
            this.position = position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        @Override
        public void onLayout(SwipeLayout v) {
            if (isOpen(position)) {
                v.open(false, false);
            } else {
                v.close(false, false);
            }
        }

    }

    class SwipeMemory extends SwipeListener {

        private int position;

        SwipeMemory(int position) {
            this.position = position;
        }

        @Override
        public void onClose(SwipeLayout layout) {
            if (mode == Attributes.Mode.Multiple) {
                mOpenPositions.remove(position);
            } else {
                mOpenPosition = INVALID_POSITION;
            }
        }

        @Override
        public void onStartOpen(SwipeLayout layout) {
            if (mode == Attributes.Mode.Single) {
                closeAllExcept(layout);
            }
        }

        @Override
        public void onOpen(SwipeLayout layout) {
            if (mode == Attributes.Mode.Multiple)
                mOpenPositions.add(position);
            else {
                closeAllExcept(layout);
                mOpenPosition = position;
            }
        }

        public void setPosition(int position) {
            this.position = position;
        }
    }

}

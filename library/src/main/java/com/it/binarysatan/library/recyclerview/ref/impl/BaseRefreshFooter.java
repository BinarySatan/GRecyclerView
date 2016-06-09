package com.it.binarysatan.library.recyclerview.ref.impl;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;

import com.it.binarysatan.library.recyclerview.ref.IRefreshFooter;


/**
 * Author : BinarySatan
 */
public abstract class BaseRefreshFooter extends BaseRefresh implements IRefreshFooter {

    protected int mState = STATE_NORMAL;


    public BaseRefreshFooter(Context context) {
        this(context, null);
    }

    public BaseRefreshFooter(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseRefreshFooter(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onMove(float delta) {
        if (getVisibleHeight() > 0 || delta > 0) {
            setVisibleHeight((int) delta + getVisibleHeight());
            if (mState <= STATE_LOADING) {
                if (getVisibleHeight() > mMeasuredHeight) {
                    setState(STATE_RELEASE_LOAD);
                    mState =STATE_RELEASE_LOAD;
                } else {
                    setState(STATE_NORMAL);
                    mState =STATE_NORMAL;
                }
            }
        }
    }

    @Override
    public void loadComplete() {
        if (!(getState() == STATE_NOMORE)) {
            setState(STATE_COMPLETE);
            mState =STATE_COMPLETE;
        }
        new Handler().postDelayed(new Runnable() {
            public void run() {
                reset();
            }
        }, 200);
    }

    public void reset() {
        smoothScrollTo(0);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                setState(STATE_NORMAL);
                mState =STATE_NORMAL;
            }
        }, 500);
    }

    @Override
    public boolean releaseAction() {
        boolean isOnLoad = false;
        int height = getVisibleHeight();
        if (height == 0)
            isOnLoad = false;
        if (getVisibleHeight() > mMeasuredHeight && mState < STATE_LOADING) {
            setState(STATE_LOADING);
            mState =STATE_LOADING;
            isOnLoad = true;
        }

        int destHeight = 0;
        if (mState == STATE_LOADING) {
            destHeight = mMeasuredHeight;
        }
        smoothScrollTo(destHeight);

        return isOnLoad;
    }

    @Override
    public int getState() {
        return mState;
    }
}

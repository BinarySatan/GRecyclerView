package com.it.binarysatan.library.recyclerview.ref.impl;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;

import com.it.binarysatan.library.recyclerview.ref.IRefreshHeader;


/**
 * @author BinarySatan
 * @Description
 */
public abstract class BaseRefreshHeader extends BaseRefresh implements IRefreshHeader {

    protected int mState = STATE_NORMAL;


    public BaseRefreshHeader(Context context) {
        this(context, null);
    }

    public BaseRefreshHeader(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseRefreshHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onMove(float delta) {
        if (getVisibleHeight() > 0 || delta > 0) {
            setVisibleHeight((int) delta + getVisibleHeight());
            if (mState <= STATE_RELEASE_TO_REFRESH) { // 未处于刷新状态，更新箭头
                if (getVisibleHeight() > mMeasuredHeight) {
                    setState(STATE_RELEASE_TO_REFRESH);
                    mState = STATE_RELEASE_TO_REFRESH;
                } else {
                    setState(STATE_NORMAL);
                    mState = STATE_NORMAL;
                }
            }
        }
    }

    @Override
    public boolean releaseAction() {
        boolean isOnRefresh = false;
        int height = getVisibleHeight();
        if (height == 0) // not visible.
            isOnRefresh = false;
        if (getVisibleHeight() > mMeasuredHeight && mState < STATE_REFRESHING) {
            setState(STATE_REFRESHING);
            mState = STATE_REFRESHING;
            isOnRefresh = true;
        }

        int destHeight = 0; // default: 松开手指时 refreshHeader 应该到达的高度
        if (mState == STATE_REFRESHING) {
            destHeight = mMeasuredHeight;
        }
        smoothScrollTo(destHeight);

        return isOnRefresh;
    }

    @Override
    public void refreshComplete() {
        setState(STATE_DONE);
        mState = STATE_DONE;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                reset();
            }
        }, 200);
    }

    /**
     * 重置状态
     */
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
    public int getState() {
        return mState;
    }

}

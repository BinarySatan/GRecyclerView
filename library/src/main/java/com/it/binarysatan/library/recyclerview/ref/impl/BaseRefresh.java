package com.it.binarysatan.library.recyclerview.ref.impl;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.it.binarysatan.library.recyclerview.ref.IBaseRefresh;


/**
 * Author : BinarySatan
 */
public abstract class BaseRefresh extends LinearLayout implements IBaseRefresh {

    protected LayoutInflater mInflater;

    protected View mContainerView;
    protected int mMeasuredHeight;

    public BaseRefresh(Context context) {
        this(context, null);
    }

    public BaseRefresh(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseRefresh(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        initView();
    }

    private void initView() {
        mInflater = LayoutInflater.from(getContext());

        mContainerView = getContainerView(mInflater);


        if (mContainerView == null)
            throw new IllegalArgumentException("container view must be not null");

        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, 0, 0, 0);
        setLayoutParams(lp);
        setPadding(0, 0, 0, 0);

        addView(mContainerView, new LayoutParams(LayoutParams.MATCH_PARENT, 0));
        setGravity(Gravity.CENTER);

        measure(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mMeasuredHeight = getMeasuredHeight();
    }



    public void setVisibleHeight(int height) {
        if (height < 0) height = 0;
        LayoutParams lp = (LayoutParams) mContainerView.getLayoutParams();
        lp.height = height;
        mContainerView.setLayoutParams(lp);
        ViewCompat.offsetTopAndBottom(this, height);
    }

    protected void smoothScrollTo(int destHeight) {
        ValueAnimator animator = ValueAnimator.ofInt(getVisibleHeight(), destHeight);
        animator.setDuration(300).start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                setVisibleHeight((int) animation.getAnimatedValue());
            }
        });
        animator.start();
    }


    @Override
    public int getVisibleHeight() {
        LayoutParams lp = (LayoutParams) mContainerView.getLayoutParams();
        return lp.height;
    }

    public abstract View getContainerView(LayoutInflater inflater);
}

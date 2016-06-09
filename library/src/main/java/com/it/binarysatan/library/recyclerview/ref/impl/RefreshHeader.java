package com.it.binarysatan.library.recyclerview.ref.impl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.it.binarysatan.library.R;
import com.it.binarysatan.library.recyclerview.ref.IRefreshHeader;


/**
 * @author BinarySatan
 */
public class RefreshHeader extends BaseRefreshHeader {

    public TextView mTv;

    public RefreshHeader(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        mTv = (TextView) findViewById(R.id.tv);
    }

    @Override
    public View getContainerView(LayoutInflater inflater) {
        return inflater.inflate(R.layout.header, new FrameLayout(getContext()));
    }

    @Override
    public void setState(int state) {
        switch (state) {
            case IRefreshHeader.STATE_NORMAL:
                mTv.setText("up refresh");
                break;
            case IRefreshHeader.STATE_RELEASE_TO_REFRESH:
                mTv.setText("relrese refresh");
                break;
            case IRefreshHeader.STATE_REFRESHING:
                mTv.setText("refreshing");
                break;
            case IRefreshHeader.STATE_DONE:
                mTv.setText("refresh complete");
                break;
        }
    }

    @Override
    public View getRootView() {
        return this;
    }
}

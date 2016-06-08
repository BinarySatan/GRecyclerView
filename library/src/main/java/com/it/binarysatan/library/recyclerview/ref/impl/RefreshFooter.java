package com.it.binarysatan.library.recyclerview.ref.impl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.it.binarysatan.library.R;
import com.it.binarysatan.library.recyclerview.ref.IRefreshFooter;


/**
 * @author BinarySatan
 */
public class RefreshFooter extends BaseRefreshFooter {

    private TextView mTv;

    public RefreshFooter(final Context context) {
        super(context);
        mTv = (TextView) findViewById(R.id.tv);
        mTv.setText("上啦加载");
    }


    @Override
    public View getContainerView(LayoutInflater inflater) {
        return inflater.inflate(R.layout.footer, new FrameLayout(getContext()));
    }

    @Override
    public void setState(int state) {
        switch (state) {
            case IRefreshFooter.STATE_LOADING:
                mTv.setText("正在加载");
                break;
            case IRefreshFooter.STATE_COMPLETE:
                mTv.setText("加载完成");
                break;
            case IRefreshFooter.STATE_NOMORE:
                mTv.setText("无更多数据");
                break;
            case IRefreshFooter.STATE_NORMAL:
                mTv.setText("上拉加载");
                break;
            case IRefreshFooter.STATE_RELEASE_LOAD:
                mTv.setText("释放加载");
                break;

        }
    }

}

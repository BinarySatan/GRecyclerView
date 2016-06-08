package com.it.binarysatan.library.recyclerview.ref;

import android.content.Context;
import android.view.View;

import com.it.binarysatan.library.recyclerview.ref.impl.RefreshFooter;
import com.it.binarysatan.library.recyclerview.ref.impl.RefreshHeader;


/**
 * Author : BinarySatan
 */
public class RefreshFactory implements IRefreshFactory {

    public View mHeaderView;
    public View mFooterView;

    @Override
    public IRefreshHeader createRefreshHeader(Context context) {
        RefreshHeader headerView = new RefreshHeader(context);
        mHeaderView = headerView;
        return headerView;
    }

    @Override
    public IRefreshFooter createRefreshFooter(Context context) {
        RefreshFooter footerView = new RefreshFooter(context);
        mFooterView = footerView;
        return footerView;
    }


    public View getHeaderView() {
        return mHeaderView;
    }

    public View getFooterView() {
        return mFooterView;
    }
}

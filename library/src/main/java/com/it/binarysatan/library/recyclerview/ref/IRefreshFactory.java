package com.it.binarysatan.library.recyclerview.ref;

import android.content.Context;

/**
 * Author : BinarySatan
 */
public interface IRefreshFactory {
    IBaseRefresh createRefreshHeader(Context context);

    IBaseRefresh createRefreshFooter(Context context);
}

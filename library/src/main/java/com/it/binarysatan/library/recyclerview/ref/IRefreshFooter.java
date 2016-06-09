package com.it.binarysatan.library.recyclerview.ref;

/**
 * Author : BinarySatan
 */
public interface IRefreshFooter extends IBaseRefresh {


    int STATE_COMPLETE = 7;

    int STATE_NOMORE = 8;


    int STATE_NORMAL = 4;

    int STATE_RELEASE_LOAD = 5;

    int STATE_LOADING = 6;

    void loadComplete();

}

package com.it.binarysatan.library.recyclerview.ref;

/**
 * Author : BinarySatan
 */
public interface IRefreshHeader extends IBaseRefresh{

    int STATE_NORMAL = 0;

    int STATE_RELEASE_TO_REFRESH = 1;

    int STATE_REFRESHING = 2;

    int STATE_DONE = 3;

    void refreshComplete();

}
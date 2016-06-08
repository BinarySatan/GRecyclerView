package com.it.binarysatan.library.recyclerview.ref;

/**
 * Author : BinarySatan
 */
public interface IRefreshHeader extends IBaseRefresh{

    int STATE_NORMAL = 0;  //普通状态

    int STATE_RELEASE_TO_REFRESH = 1; // 释放刷新状态

    int STATE_REFRESHING = 2;  // 正在刷新状态

    int STATE_DONE = 3;  //刷新完成状态

    /**
     * 刷新完成
     */
    void refreshComplete();

}
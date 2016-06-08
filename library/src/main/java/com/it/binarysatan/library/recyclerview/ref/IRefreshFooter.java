package com.it.binarysatan.library.recyclerview.ref;

/**
 * Author : BinarySatan
 */
public interface IRefreshFooter extends IBaseRefresh {

    /**
     * 加载完成
     */
    int STATE_COMPLETE = 7;
    /**
     * 无更多数据
     */
    int STATE_NOMORE = 8;

    /**
     * 普通状态
     */
    int STATE_NORMAL = 4;
    /**
     * 释放加载
     */
    int STATE_RELEASE_LOAD = 5;
    /**
     * 正在加载
     */
    int STATE_LOADING = 6;

    /**
     * 加载完成
     */
    void loadComplete();

}

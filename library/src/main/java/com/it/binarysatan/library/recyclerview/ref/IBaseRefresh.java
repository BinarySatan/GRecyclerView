package com.it.binarysatan.library.recyclerview.ref;

import android.view.View;

/**
 * Author : BinarySatan
 */
public interface IBaseRefresh {

    /**
     * 手指移动时回调,
     *
     * @param delta 移动的距离
     */
    void onMove(float delta);

    /**
     * 释放动作
     *
     * @return true 满足刷新条件, false不满足
     */
    boolean releaseAction();


    /**
     * 刷新的各个状态
     * 注, 操作完成后, 需要给 BaseHeader 里的 mState赋值,  mState = state;
     *
     * @param state
     */
    void setState(int state);

    int getState();


    /**
     * @return 头部 or 底部 显示高度, 需要返回inflater  View 的 高度, view.getLayoutParams.height();
     */
    int getVisibleHeight();

    View getRootView();
}

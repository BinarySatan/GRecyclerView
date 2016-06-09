package com.it.binarysatan.library.recyclerview.ref;

import android.view.View;

/**
 * Author : BinarySatan
 */
public interface IBaseRefresh {

    void onMove(float delta);

    boolean releaseAction();


    void setState(int state);

    int getState();


    int getVisibleHeight();

    View getRootView();
}

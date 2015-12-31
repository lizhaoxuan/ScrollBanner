package com.zhaoxuan.scrollbanner;

import android.view.MotionEvent;

/**
 * banner手势操作事件
 * Created by lizhaoxuan on 15/12/31.
 */
public interface OnBannerScrollTouchListener {
    void onScrollTouch(int position, MotionEvent e1, MotionEvent e2,
                       float distanceX, float distanceY);
}

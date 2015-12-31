package com.zhaoxuan.scrollbanner;

import android.view.View;

/**
 * banner 适配器
 * Created by lizhaoxuan on 15/12/25.
 */
public abstract class ScrollBannerAdapter {

    private int mBannerHeight;

    public abstract int getCount();

    public abstract Object getItem(int position);

    public abstract int getItemId(int position);

    public abstract View getView(int position, View convertView);

    public abstract View getFixView(int position, View convertView);

    public abstract int getItemViewType(int position);

    public abstract boolean isEmpty();

    public int getWheelTime(int position) {
        return 4000;
    }

    public abstract int getBannerHeight();

    public abstract int setFocusable(int position);
}

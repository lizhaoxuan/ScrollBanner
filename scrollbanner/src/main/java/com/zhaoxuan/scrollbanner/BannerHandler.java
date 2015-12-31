package com.zhaoxuan.scrollbanner;

import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

/**
 * 控制banner滚动
 * Created by lizhaoxuan on 15/12/31.
 */
public class BannerHandler  extends Handler {
    private WeakReference<ScrollBanner> weakReference;

    public BannerHandler(ScrollBanner banner) {
        this.weakReference = new WeakReference<>(banner);
    }

    @Override
    public void handleMessage(Message msg) {
        ScrollBanner banner = weakReference.get();
        if (banner == null) {
            return;
        }
        if (msg.what == ScrollBanner.WHEEL_SHOW) {
            if (banner.mAdapter.getCount() <= 0) {
                banner.hideCustomBanner();
                return;
            } else {
                banner.showCustomBanner();
            }
            if (banner.mAdapter.getCount() == 1) {
                banner.showOnlyOne();
            } else {
                banner.scrollNext();
            }
        }
    }
}

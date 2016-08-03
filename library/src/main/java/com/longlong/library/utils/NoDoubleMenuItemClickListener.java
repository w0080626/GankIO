package com.longlong.library.utils;

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.Calendar;


/**
 * Author:  Chenglong.Lu
 * Email:   1053998178@qq.com | w490576578@gmail.com
 * Date:    2016/05/20
 * Description:防止重复点击
 */
public abstract class NoDoubleMenuItemClickListener implements Toolbar.OnMenuItemClickListener {

    public static final int MIN_CLICK_DELAY_TIME = 1500;
    private long lastClickTime = 0;

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        long currentTime = Calendar.getInstance().getTimeInMillis();
        if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
            lastClickTime = currentTime;
            onNoDoubleClick(item);
        }
        return true;
    }

    /**
     * 子类实现抽象方法
     */
    public abstract void onNoDoubleClick(MenuItem item);


}
package com.longlong.gankio.presenter.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.longlong.gankio.view.Fragment.FragmentListImage;
import com.longlong.gankio.view.Fragment.FragmentListText;

import java.util.HashMap;

/**
 * Author:  Chenglong.Lu
 * Email:   1053998178@qq.com | w490576578@gmail.com
 * Date:   2016/07/22
 * Description:
 */
public class TabFragmentAdapter extends FragmentPagerAdapter {
    private HashMap<String, Fragment> fragments;
    private String[] tabs;

    public TabFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        tabs = new String[]{"福利", "Android", "iOS", "休息视频", "拓展资源", "前端"};
        fragments = new HashMap<>();
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {
            case 0:
                fragment = new FragmentListImage();
                break;
            default:
                fragment = new FragmentListText();
                break;

        }
        fragments.put(position + "", fragment);
        return fragment;
    }

    @Override
    public int getCount() {
        return tabs.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

    public Fragment getFragment(int position) {
        return fragments.get(position + "");
    }

}

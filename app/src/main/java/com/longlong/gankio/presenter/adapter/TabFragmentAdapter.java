package com.longlong.gankio.presenter.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.longlong.gankio.config.Constant;
import com.longlong.gankio.view.Fragment.FragmentListImage;
import com.longlong.gankio.view.Fragment.FragmentListText;

/**
 * Author:  Chenglong.Lu
 * Email:   1053998178@qq.com | w490576578@gmail.com
 * Date:   2016/07/22
 * Description:
 */
public class TabFragmentAdapter extends FragmentPagerAdapter {

    public TabFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {
            case 0:
                fragment = new FragmentListImage();
                break;
            default:
                fragment = FragmentListText.getInstance(Constant.TABS[position]);
                break;

        }
        return fragment;
    }

    @Override
    public int getCount() {
        return Constant.TABS.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Constant.TABS[position];
    }

}

package com.longlong.gankio.ui.Activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.BeamBaseActivity;
import com.longlong.gankio.R;
import com.longlong.gankio.presenter.PresenterMain;
import com.longlong.gankio.ui.Fragment.FragmentListImage;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author:  Chenglong.Lu
 * Email:   1053998178@qq.com | w490576578@gmail.com
 * Date:    2016/06/28
 * Description:
 */
@RequiresPresenter(PresenterMain.class)
public class ActivityMain extends BeamBaseActivity<PresenterMain> {

    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.vp_view)
    ViewPager vpView;

    private String[] mTitle = {"福利", "Android", "iOS", "休息视频", "拓展资源", "前端"};
    private MainPagerAdapter mMainPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle(R.string.app_name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        vpView.setAdapter(mMainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager()));
        tabs.setupWithViewPager(vpView);
    }


    private class MainPagerAdapter extends FragmentStatePagerAdapter {

        public MainPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new FragmentListImage();
                default:
                    return new FragmentListImage();
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return mTitle[0];
                case 1:
                    return mTitle[1];
                case 2:
                    return mTitle[2];
                case 3:
                    return mTitle[3];
                case 4:
                    return mTitle[4];
                case 5:
                    return mTitle[5];
                default:
                    return "";
            }
        }

        @Override
        public int getCount() {
            return 6;
        }
    }

}

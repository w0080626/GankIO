package com.longlong.gankio.view.Activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.BeamBaseActivity;
import com.longlong.gankio.R;
import com.longlong.gankio.presenter.PresenterActivity.PresenterMain;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author:  Chenglong.Lu
 * Email:   1053998178@qq.com | w490576578@gmail.com
 * Date:    2016/06/28
 * Description: 主页
 */
@RequiresPresenter(PresenterMain.class)
public class ActivityMain extends BeamBaseActivity<PresenterMain> {

    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.vp_view)
    ViewPager vpView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    public ViewPager getViewPager() {
        return vpView;
    }

    public TabLayout getTabLayout() {
        return tabs;
    }
}

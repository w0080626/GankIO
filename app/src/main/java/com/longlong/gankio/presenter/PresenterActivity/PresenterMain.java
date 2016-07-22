package com.longlong.gankio.presenter.PresenterActivity;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

import com.jude.beam.expansion.BeamBasePresenter;
import com.longlong.gankio.R;
import com.longlong.gankio.presenter.adapter.TabFragmentAdapter;
import com.longlong.gankio.view.Activity.ActivityMain;

/**
 * Author:  Chenglong.Lu
 * Email:   1053998178@qq.com | w490576578@gmail.com
 * Date:    2016/06/28
 * Description:
 */
public class PresenterMain extends BeamBasePresenter<ActivityMain> {
    private TabFragmentAdapter adapter;
    private FragmentManager fragmentManager;
    public int item = -1;

    @Override
    protected void onCreateView(@NonNull ActivityMain view) {
        super.onCreateView(view);
        view.getTabLayout().setSelectedTabIndicatorColor(view.getResources().getColor(R.color.white));
        fragmentManager = view.getSupportFragmentManager();
        replaceFragment(0);
    }

    public void replaceFragment(int position) {
        item = position;
        adapter = new TabFragmentAdapter(getView(), fragmentManager);
        getView().getViewPager().setAdapter(adapter);
        getView().getTabLayout().setupWithViewPager(getView().getViewPager());
    }

}

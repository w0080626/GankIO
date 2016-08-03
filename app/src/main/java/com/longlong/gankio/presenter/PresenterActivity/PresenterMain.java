package com.longlong.gankio.presenter.PresenterActivity;

import android.Manifest;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;

import com.jude.beam.expansion.BeamBasePresenter;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.longlong.gankio.R;
import com.longlong.gankio.presenter.adapter.TabFragmentAdapter;
import com.longlong.gankio.view.Activity.ActivityMain;

import java.util.List;


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
        view.getTabLayout().setSelectedTabIndicatorColor(view.getResources().getColor(R.color.colorAccent));
        fragmentManager = view.getSupportFragmentManager();
        replaceFragment(0);
        checkPermission();
    }

    public void replaceFragment(int position) {
        item = position;
        adapter = new TabFragmentAdapter(getView(), fragmentManager);
        getView().getViewPager().setAdapter(adapter);
        getView().getTabLayout().setupWithViewPager(getView().getViewPager());
    }

    public void setupDrawerContent(NavigationView navigationView, final DrawerLayout drawerLayout) {

    }

    private void checkPermission() {
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        try {
            Dexter.checkPermissionsOnSameThread(new MultiplePermissionsListener() {
                @Override
                public void onPermissionsChecked(MultiplePermissionsReport report) {

                }

                @Override
                public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                    token.continuePermissionRequest();
                }
            }, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

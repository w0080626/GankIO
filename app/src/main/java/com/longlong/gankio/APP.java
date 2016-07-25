package com.longlong.gankio;

import android.app.Application;

import com.jude.beam.Beam;
import com.jude.beam.bijection.ActivityLifeCycleDelegate;
import com.jude.beam.bijection.ActivityLifeCycleDelegateProvider;
import com.jude.beam.bijection.BeamAppCompatActivity;
import com.jude.beam.expansion.BeamBaseActivity;
import com.jude.beam.expansion.list.ListConfig;
import com.jude.beam.expansion.overlay.ViewExpansionDelegate;
import com.jude.beam.expansion.overlay.ViewExpansionDelegateProvider;
import com.longlong.gankio.delegate.MyActivityLifeCycleDelegate;

/**
 * Author:  Chenglong.Lu
 * Email:   1053998178@qq.com | w490576578@gmail.com
 * Date:    2016/06/28
 * Description: Application DIY
 */
public class APP extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        BeamInit();
        Beam.setActivityLifeCycleDelegateProvider(new ActivityLifeCycleDelegateProvider() {
            @Override
            public ActivityLifeCycleDelegate createActivityLifeCycleDelegate(BeamAppCompatActivity activity) {
                return new MyActivityLifeCycleDelegate(activity);
            }
        });
    }


    private void BeamInit() {
        Beam.init(this);
        Beam.setViewExpansionDelegateProvider(new ViewExpansionDelegateProvider() {
            @Override
            public ViewExpansionDelegate createViewExpansionDelegate(BeamBaseActivity activity) {
                return null;
            }
        });
        ListConfig.setDefaultListConfig(
                new ListConfig()
                        .setLoadmoreAble(true)
                        .setRefreshAble(true)
                        .setNoMoreAble(true)
                        .setErrorAble(true)
                        .setErrorTouchToResumeAble(true));
    }

}

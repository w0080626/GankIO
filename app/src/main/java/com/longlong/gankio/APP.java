package com.longlong.gankio;

import android.app.Application;

import com.jude.beam.Beam;
import com.jude.beam.expansion.list.ListConfig;
import com.karumi.dexter.Dexter;
import com.longlong.gankio.delegate.MyActivityLifeCycleDelegate;
import com.longlong.library.utils.KLog;

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
        OtherInit();
        BeamInit();
        Dexter.initialize(this);

    }

    private void OtherInit() {
        KLog.init("GANKIO", BuildConfig.DEBUG);
    }


    private void BeamInit() {
        Beam.init(this);
        ListConfig.setDefaultListConfig(
                new ListConfig()
                        .setLoadmoreAble(true)
                        .setRefreshAble(true)
                        .setNoMoreAble(true)
                        .setErrorAble(true)
                        .setErrorTouchToResumeAble(true));
        Beam.setActivityLifeCycleDelegateProvider(MyActivityLifeCycleDelegate::new);
    }

}

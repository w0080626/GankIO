package com.longlong.gankio.APP;

import android.app.Application;

import com.jude.beam.Beam;
import com.jude.beam.expansion.BeamBaseActivity;
import com.jude.beam.expansion.overlay.ViewExpansionDelegate;
import com.jude.beam.expansion.overlay.ViewExpansionDelegateProvider;

import retrofit2.Retrofit;

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
        RetrofitInit();
    }

    private void RetrofitInit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://gank.io/api/")
                .build();
    }

    private void BeamInit() {
        Beam.init(this);
        Beam.setViewExpansionDelegateProvider(new ViewExpansionDelegateProvider() {
            @Override
            public ViewExpansionDelegate createViewExpansionDelegate(BeamBaseActivity activity) {
                return null;
            }
        });
    }

}

package com.longlong.gankio;

import android.app.Application;

import com.jude.beam.Beam;

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
    }


    private void BeamInit() {
        Beam.init(this);
    }

}

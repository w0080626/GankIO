package com.longlong.gankio.APP;

import com.jude.beam.bijection.ActivityLifeCycleDelegate;
import com.jude.beam.bijection.BeamAppCompatActivity;

/**
 * Author:  Chenglong.Lu
 * Email:   1053998178@qq.com | w490576578@gmail.com
 * Date:    2016/06/28
 * Description: 生命周期Delegate
 */
public class MineActivityLifeCycleDelegate extends ActivityLifeCycleDelegate {
    public MineActivityLifeCycleDelegate(BeamAppCompatActivity act) {
        super(act);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}

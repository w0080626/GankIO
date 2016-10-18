package com.longlong.gankio.module.main;


import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.jude.beam.bijection.BeamAppCompatActivity;

/**
 * Author:  Chenglong.Lu
 * Email:   1053998178@qq.com | w490576578@gmail.com
 * Date:   2016/07/21
 * Description: 闪屏页
 */
public class ActivitySplash extends BeamAppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        startActivity(new Intent(this, ActivityMain.class));
    }
}

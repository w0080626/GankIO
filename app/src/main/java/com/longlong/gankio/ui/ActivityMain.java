package com.longlong.gankio.ui;

import android.os.Bundle;

import com.jude.beam.expansion.BeamBaseActivity;
import com.jude.beam.expansion.overlay.ViewExpansionDelegate;
import com.longlong.gankio.R;
import com.longlong.gankio.presenter.PresenterMain;

/**
 * Author:  Chenglong.Lu
 * Email:   1053998178@qq.com | w490576578@gmail.com
 * Date:    2016/06/28
 * Description:
 */
public class ActivityMain extends BeamBaseActivity<PresenterMain> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getExpansion().showProgressPage();
    }

    @Override
    public ViewExpansionDelegate createViewExpansionDelegate() {
        return super.createViewExpansionDelegate();
    }
}

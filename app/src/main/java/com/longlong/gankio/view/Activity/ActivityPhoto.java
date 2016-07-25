package com.longlong.gankio.view.Activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.widget.ImageView;

import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.data.BeamDataActivity;
import com.longlong.gankio.R;
import com.longlong.gankio.model.bean.Result;
import com.longlong.gankio.presenter.PresenterActivity.PresenterPhoto;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author:  Chenglong.Lu
 * Email:   1053998178@qq.com | w490576578@gmail.com
 * Date:   2016/07/25
 * Description:
 */
@RequiresPresenter(PresenterPhoto.class)
public class ActivityPhoto extends BeamDataActivity<PresenterPhoto, Result> {
    @BindView(R.id.photo)
    ImageView photo;
    @BindView(R.id.appbar_layout)
    AppBarLayout appbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        ButterKnife.bind(this);
    }

    public ImageView getImageView() {
        return photo;
    }

    public AppBarLayout getAppBarLaytout() {
        return appbarLayout;
    }
}

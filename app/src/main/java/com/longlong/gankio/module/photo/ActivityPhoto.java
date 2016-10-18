package com.longlong.gankio.module.photo;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.data.BeamDataActivity;
import com.longlong.gankio.R;
import com.longlong.gankio.entity.Result;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_photo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.savePhoto) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

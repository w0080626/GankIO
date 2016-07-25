package com.longlong.gankio.presenter.PresenterActivity;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.jude.beam.expansion.data.BeamDataActivityPresenter;
import com.longlong.gankio.R;
import com.longlong.gankio.model.bean.Result;
import com.longlong.gankio.view.Activity.ActivityPhoto;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Author:  Chenglong.Lu
 * Email:   1053998178@qq.com | w490576578@gmail.com
 * Date:   2016/07/25
 * Description:
 */
public class PresenterPhoto extends BeamDataActivityPresenter<ActivityPhoto, Result> {
    PhotoViewAttacher mAttacher;
    private boolean mIsHidden = false;

    @Override
    protected void onCreateView(@NonNull ActivityPhoto view) {
        super.onCreateView(view);
        initToolBar();
        initPhoto();
    }

    private void initPhoto() {
        Glide.with(getView()).load(getData().getUrl()).asBitmap().thumbnail(0.1f).error(R.mipmap.ic_launcher).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                getView().getImageView().setImageBitmap(resource);
                mAttacher = new PhotoViewAttacher(getView().getImageView());
                mAttacher.update();
                mAttacher.setOnViewTapListener(new PhotoViewAttacher.OnViewTapListener() {
                    @Override
                    public void onViewTap(View view, float v, float v1) {
                        hideOrShowToolbar();
                    }
                });
            }
        });
    }

    public void hideOrShowToolbar() {
        getView().getAppBarLaytout().animate()
                .translationY(mIsHidden ? 0 : -getView().getAppBarLaytout().getHeight())
                .setInterpolator(new DecelerateInterpolator(2))
                .start();
        mIsHidden = !mIsHidden;
    }


    private void initToolBar() {
        getView().getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getView().getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_white_24dp);
        getView().getSupportActionBar().setTitle(getData().getDesc());
    }

}

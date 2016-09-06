package com.longlong.gankio.presenter.PresenterActivity;

import android.Manifest;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.jude.beam.expansion.data.BeamDataActivityPresenter;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.longlong.gankio.R;
import com.longlong.gankio.entity.Result;
import com.longlong.gankio.view.Activity.ActivityPhoto;
import com.longlong.library.utils.BitmapUtils;
import com.longlong.library.utils.NoDoubleMenuItemClickListener;
import com.longlong.library.utils.SnackBarUtils;
import com.longlong.library.utils.StringUtils;
import com.longlong.library.utils.io.FilenameUtils;

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
        getView().getToolbar().setOnMenuItemClickListener(new NoDoubleMenuItemClickListener() {
            @Override
            public void onNoDoubleClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.savePhoto:
                        checkPremission();
                        break;
                }
            }
        });
    }


    private void checkPremission() {
        Dexter.checkPermission(new PermissionListener() {
            @Override
            public void onPermissionGranted(PermissionGrantedResponse response) {
                savePhoto();
            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse response) {
                SnackBarUtils.makeShort(getView().getToolbar(), "没有权限保存图片").danger();
            }

            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                token.continuePermissionRequest();
            }
        }, Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    private void savePhoto() {
        String photoPath = BitmapUtils.saveImageToGallery(getView(), ((BitmapDrawable) getView().getImageView().getDrawable()).getBitmap(), FilenameUtils.getName(getData().getUrl()));
        if (StringUtils.notBlankAndNull(photoPath))
            SnackBarUtils.makeShort(getView().getToolbar(), "图片位置:" + photoPath).info();
        else
            SnackBarUtils.makeShort(getView().getToolbar(), "保存失败").danger();
    }


}

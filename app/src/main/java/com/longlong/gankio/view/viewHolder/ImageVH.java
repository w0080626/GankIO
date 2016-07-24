package com.longlong.gankio.view.viewHolder;

import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.longlong.gankio.R;
import com.longlong.gankio.model.bean.Result;

/**
 * Author:  Chenglong.Lu
 * Email:   1053998178@qq.com | w490576578@gmail.com
 * Date:   2016/07/22
 * Description:
 */
public class ImageVH extends BaseViewHolder<Result> {
    ImageView imgPicture;

    public ImageVH(ViewGroup parent) {
        super(new ImageView(parent.getContext()));
        imgPicture = (ImageView) itemView;
        imgPicture.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        imgPicture.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    @Override
    public void setData(Result data) {
        Glide.with(getContext()).load(data.getUrl()).asBitmap().placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {

                ViewGroup.LayoutParams params = imgPicture.getLayoutParams();
                DisplayMetrics dm = getContext().getResources().getDisplayMetrics();
                int width = dm.widthPixels/2;//宽度为屏幕宽度一半
                int height = resource.getHeight()*width/resource.getWidth();//计算View的高度
                params.height = height;
                imgPicture.setLayoutParams(params);
                imgPicture.setImageBitmap(resource);
            }
        });
    }
}

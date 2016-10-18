package com.longlong.gankio.module.list;

import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.longlong.gankio.entity.Result;

import java.util.List;

/**
 * Author:  Chenglong.Lu
 * Email:   1053998178@qq.com | w490576578@gmail.com
 * Date:   2016/07/22
 * Description:
 */
public class ImageVH extends BaseViewHolder<Result> {
    ImageView imgPicture;
    List<Integer> mHeights;

    public ImageVH(ViewGroup parent, List<Integer> mHeights) {
        super(new ImageView(parent.getContext()));
        this.mHeights = mHeights;
        imgPicture = (ImageView) itemView;
        imgPicture.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        imgPicture.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    @Override
    public void setData(Result data) {
        // 随机高度, 模拟瀑布效果.
        if (mHeights.size() <= getLayoutPosition()) {
            mHeights.add((int) (500 + Math.random() * 300));
        }
        ViewGroup.LayoutParams lp = imgPicture.getLayoutParams();
        lp.height = mHeights.get(getLayoutPosition());
        imgPicture.setLayoutParams(lp);
        Glide.with(getContext()).load(data.getUrl()).thumbnail(0.2f).into(imgPicture);
    }
}

package com.longlong.gankio.view.viewHolder;

import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.longlong.gankio.R;
import com.longlong.gankio.model.bean.Result;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author:  Chenglong.Lu
 * Email:   1053998178@qq.com | w490576578@gmail.com
 * Date:   2016/07/22
 * Description:
 */
public class ImageVH extends BaseViewHolder<Result> {
    @BindView(R.id.image)
    ImageView image;

    public ImageVH(ViewGroup parent) {
        super(parent, R.layout.item_image);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setData(Result data) {
        super.setData(data);
        Glide.with(getContext()).load(data.getUrl()).crossFade().placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(image);
    }
}

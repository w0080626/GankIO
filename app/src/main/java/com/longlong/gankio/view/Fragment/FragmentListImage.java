package com.longlong.gankio.view.Fragment;

import android.view.ViewGroup;

import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.list.BeamListFragment;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.longlong.gankio.entity.Result;
import com.longlong.gankio.presenter.PresenterFragment.PresenterImageList;
import com.longlong.gankio.view.viewHolder.ImageVH;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:  Chenglong.Lu
 * Email:   1053998178@qq.com | w490576578@gmail.com
 * Date:   2016/07/22
 * Description:
 */
@RequiresPresenter(PresenterImageList.class)
public class FragmentListImage extends BeamListFragment<PresenterImageList, Result> {
    List<Integer> mHeights = new ArrayList<>();
    @Override
    public BaseViewHolder getViewHolder(ViewGroup parent, int viewType) {
        return new ImageVH(parent,mHeights);
    }

}

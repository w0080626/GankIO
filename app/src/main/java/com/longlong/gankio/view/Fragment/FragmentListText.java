package com.longlong.gankio.view.Fragment;

import android.view.ViewGroup;

import com.jude.beam.expansion.list.BeamListFragment;
import com.jude.beam.expansion.list.ListConfig;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.longlong.gankio.model.bean.Result;
import com.longlong.gankio.presenter.PresenterFragment.PresenterTextList;
import com.longlong.gankio.view.viewHolder.TextVH;

/**
 * Author:  Chenglong.Lu
 * Email:   1053998178@qq.com | w490576578@gmail.com
 * Date:   2016/07/22
 * Description:
 */
public class FragmentListText extends BeamListFragment<PresenterTextList,Result> {
    @Override
    public BaseViewHolder getViewHolder(ViewGroup parent, int viewType) {
        return new TextVH(parent);
    }

    @Override
    public ListConfig getConfig() {
        return super.getConfig()
                .setLoadmoreAble(true)
                .setRefreshAble(true)
                .setNoMoreAble(true)
                .setErrorAble(true)
                .setErrorTouchToResumeAble(true);
    }
}

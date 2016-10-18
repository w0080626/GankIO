package com.longlong.gankio.module.list;

import android.os.Bundle;
import android.view.ViewGroup;

import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.list.BeamListFragment;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.longlong.gankio.entity.Result;

/**
 * Author:  Chenglong.Lu
 * Email:   1053998178@qq.com | w490576578@gmail.com
 * Date:   2016/07/22
 * Description:
 */
@RequiresPresenter(PresenterTextList.class)
public class FragmentListText extends BeamListFragment<PresenterTextList, Result> {
    @Override
    public BaseViewHolder getViewHolder(ViewGroup parent, int viewType) {
        return new TextVH(parent);
    }

    public static FragmentListText getInstance(String title) {
        FragmentListText fragmentListText = new FragmentListText();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        fragmentListText.setArguments(bundle);
        return fragmentListText;
    }
}

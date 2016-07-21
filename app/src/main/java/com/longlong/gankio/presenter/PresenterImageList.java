package com.longlong.gankio.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.jude.beam.expansion.list.BeamListFragmentPresenter;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.longlong.gankio.model.GanHuo;
import com.longlong.gankio.ui.Fragment.FragmentListImage;

/**
 * Author:  Chenglong.Lu
 * Email:   1053998178@qq.com | w490576578@gmail.com
 * Date:   2016/07/22
 * Description:
 */
public class PresenterImageList extends BeamListFragmentPresenter<FragmentListImage,GanHuo> {
    @Override
    protected void onCreate(@NonNull FragmentListImage view, Bundle savedState) {
        super.onCreate(view, savedState);
        onRefresh();
    }

    @Override
    protected void onCreateView(@NonNull FragmentListImage view) {
        super.onCreateView(view);
        getAdapter().setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //TODO.. 打开图片
            }
        });
    }
}

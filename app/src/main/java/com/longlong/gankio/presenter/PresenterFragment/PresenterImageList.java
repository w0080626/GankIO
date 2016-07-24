package com.longlong.gankio.presenter.PresenterFragment;

import android.support.v7.widget.StaggeredGridLayoutManager;

import com.jude.beam.expansion.list.BeamListFragmentPresenter;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;
import com.longlong.gankio.model.ListModel;
import com.longlong.gankio.model.bean.Result;
import com.longlong.gankio.view.Activity.ActivityWeb;
import com.longlong.gankio.view.Fragment.FragmentListImage;
import com.longlong.library.utils.DeviceUtils;

import rx.functions.Action0;

/**
 * Author:  Chenglong.Lu
 * Email:   1053998178@qq.com | w490576578@gmail.com
 * Date:   2016/07/22
 * Description:
 */
public class PresenterImageList extends BeamListFragmentPresenter<FragmentListImage, Result> implements RecyclerArrayAdapter.OnItemClickListener {

    private void initPinterest() {
        getView().getListView().setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        SpaceDecoration itemDecoration = new SpaceDecoration(DeviceUtils.dip2px(getView().getContext(), 8));//参数是距离宽度
        itemDecoration.setPaddingEdgeSide(true);//是否为左右2边添加padding.默认true.
        getView().getListView().addItemDecoration(itemDecoration);
    }

    @Override
    protected void onCreateView(FragmentListImage view) {
        super.onCreateView(view);
        initPinterest();
        onRefresh();
        getAdapter().setOnItemClickListener(this);
    }

    @Override
    public void onRefresh() {
        setCurPage(1);
        ListModel.getResult("福利", 20, getCurPage()).doAfterTerminate(new Action0() {
            @Override
            public void call() {
                setCurPage(2);
            }
        }).unsafeSubscribe(getRefreshSubscriber());
    }


    @Override
    public void onLoadMore() {
        ListModel.getResult("福利", 20, getCurPage()).unsafeSubscribe(getMoreSubscriber());
    }

    @Override
    public void onItemClick(int position) {
        startActivityWithData(getAdapter().getItem(position), ActivityWeb.class);
    }
}

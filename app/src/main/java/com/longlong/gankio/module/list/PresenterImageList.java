package com.longlong.gankio.module.list;

import android.support.v7.widget.StaggeredGridLayoutManager;

import com.jude.beam.expansion.list.BeamListFragmentPresenter;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;
import com.longlong.gankio.entity.Result;
import com.longlong.gankio.model.ListModel;
import com.longlong.gankio.module.photo.ActivityPhoto;
import com.longlong.library.utils.DeviceUtils;

import java.util.List;

import rx.Subscriber;

/**
 * Author:  Chenglong.Lu
 * Email:   1053998178@qq.com | w490576578@gmail.com
 * Date:   2016/07/22
 * Description:
 */
public class PresenterImageList extends BeamListFragmentPresenter<FragmentListImage, Result> implements RecyclerArrayAdapter.OnItemClickListener {

    private void initPinterest() {
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);

        getView().getListView().setLayoutManager(staggeredGridLayoutManager);

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
        //这里想的是当重复刷新的时候如果不判断是否一致的话 List 会闪一下。 所以Beam 自带的RxJava 满足不了需求 只能这么写了。
        ListModel.getInstance().getResult("福利", 20, getCurPage()).subscribe(new Subscriber<List<Result>>() {
            @Override
            public void onCompleted() {
                setCurPage(2);
            }

            @Override
            public void onError(Throwable e) {
                getView().stopRefresh();
                if (getAdapter() != null && getAdapter().getCount() == 0) {
                    //没有数据的时候出错，就显示全屏的错误提示
                    getView().showError(e);
                } else {
                    //有数据时的出错，在最后一条显示错误提示
                    getAdapter().pauseMore();
                }
            }

            @Override
            public void onNext(List<Result> results) {
                onCompleted();
                if (getAdapter().getCount() > 0) {
                    if (!getAdapter().getItem(0).get_id().equals(results.get(0).get_id())) {
                        getAdapter().clear();
                        getAdapter().addAll(results);
                    } else {
                        getView().stopRefresh();
                    }
                } else {
                    getAdapter().addAll(results);
                }
            }
        });
    }


    @Override
    public void onLoadMore() {
        ListModel.getInstance().getResult("福利", 20, getCurPage()).unsafeSubscribe(getMoreSubscriber());
    }

    @Override
    public void onItemClick(int position) {
        startActivityWithData(getAdapter().getItem(position), ActivityPhoto.class);
    }
}

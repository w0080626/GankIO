package com.longlong.gankio.presenter.PresenterFragment;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.jude.beam.expansion.list.BeamListFragmentPresenter;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.longlong.gankio.model.ListModel;
import com.longlong.gankio.model.bean.Result;
import com.longlong.gankio.view.Fragment.FragmentListText;

import java.util.ArrayList;

import rx.functions.Action1;

/**
 * Author:  Chenglong.Lu
 * Email:   1053998178@qq.com | w490576578@gmail.com
 * Date:   2016/07/22
 * Description:
 */
public class PresenterTextList extends BeamListFragmentPresenter<FragmentListText, Result> {

    @Override
    protected void onCreate(@NonNull FragmentListText view, Bundle savedState) {
        super.onCreate(view, savedState);
        onRefresh();
    }

    @Override
    protected void onCreateView(@NonNull FragmentListText view) {
        super.onCreateView(view);
        getAdapter().setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //TODO.. 跳转URL
            }
        });
    }

    @Override
    public void onRefresh() {
        setCurPage(1);
        ListModel.getResult("Android", 20, getCurPage()).doOnNext(new Action1<ArrayList<Result>>() {
            @Override
            public void call(ArrayList<Result> results) {

            }
        }).unsafeSubscribe(getRefreshSubscriber());
    }


    @Override
    public void onLoadMore() {
        ListModel.getResult("Android", 20, getCurPage()).doOnNext(new Action1<ArrayList<Result>>() {
            @Override
            public void call(ArrayList<Result> results) {

            }
        }).unsafeSubscribe(getMoreSubscriber());
    }
}

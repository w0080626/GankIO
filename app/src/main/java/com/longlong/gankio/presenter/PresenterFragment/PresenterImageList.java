package com.longlong.gankio.presenter.PresenterFragment;

import android.os.Bundle;
import android.util.Log;

import com.jude.beam.expansion.list.BeamListFragmentPresenter;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.longlong.gankio.model.ListModel;
import com.longlong.gankio.model.bean.Result;
import com.longlong.gankio.view.Fragment.FragmentListImage;

import java.util.ArrayList;

import rx.functions.Action0;
import rx.functions.Action1;

/**
 * Author:  Chenglong.Lu
 * Email:   1053998178@qq.com | w490576578@gmail.com
 * Date:   2016/07/22
 * Description:
 */
public class PresenterImageList extends BeamListFragmentPresenter<FragmentListImage, Result> {

    @Override
    protected void onCreate(FragmentListImage view, Bundle savedState) {
        super.onCreate(view, savedState);
//        onRefresh();
    }

    @Override
    protected void onCreateView(FragmentListImage view) {
        super.onCreateView(view);
        getAdapter().setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //TODO.. 打开图片
            }
        });
    }

    @Override
    public void onRefresh() {
        setCurPage(1);
        ListModel.getResult("福利", 20, getCurPage()).doOnNext(new Action1<ArrayList<Result>>() {
            @Override
            public void call(ArrayList<Result> results) {
                Log.d("LONGLONG", results.size() + "");
            }
        }).doAfterTerminate(new Action0() {
            @Override
            public void call() {
                setCurPage(2);
            }
        }).unsafeSubscribe(getRefreshSubscriber());
//        ListModel.getResult("福利", 20, getCurPage()).subscribe(new Subscriber<ArrayList<Result>>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                getView().stopRefresh();
//                getView().showError(e);
//            }
//
//            @Override
//            public void onNext(ArrayList<Result> results) {
//                getAdapter().clear();
//                getAdapter().addAll(results);
//            }
//        });
    }


    @Override
    public void onLoadMore() {
        ListModel.getResult("福利", 20, getCurPage()).doOnNext(new Action1<ArrayList<Result>>() {
            @Override
            public void call(ArrayList<Result> results) {

            }
        }).unsafeSubscribe(getMoreSubscriber());
    }

}

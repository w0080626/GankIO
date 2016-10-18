package com.longlong.gankio.module.list;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.jude.beam.expansion.list.BeamListFragmentPresenter;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.longlong.gankio.entity.Result;
import com.longlong.gankio.model.ListModel;
import com.longlong.gankio.module.web.ActivityWeb;

import rx.functions.Action0;

/**
 * Author:  Chenglong.Lu
 * Email:   1053998178@qq.com | w490576578@gmail.com
 * Date:   2016/07/22
 * Description:
 */
public class PresenterTextList extends BeamListFragmentPresenter<FragmentListText, Result> implements RecyclerArrayAdapter.OnItemClickListener {
    private String title;

    @Override
    protected void onCreate(FragmentListText view, Bundle savedState) {
        super.onCreate(view, savedState);
        Bundle bundle = view.getArguments();
        title = bundle.getString("title");
    }

    @Override
    protected void onCreateView(@NonNull FragmentListText view) {
        super.onCreateView(view);
        onRefresh();
        getAdapter().setOnItemClickListener(this);
    }

    @Override
    public void onRefresh() {
        setCurPage(1);
        ListModel.getInstance().getResult(title, 20, getCurPage()).doAfterTerminate(new Action0() {
            @Override
            public void call() {
                setCurPage(2);
            }
        }).unsafeSubscribe(getRefreshSubscriber());
    }


    @Override
    public void onLoadMore() {
        ListModel.getInstance().getResult(title, 20, getCurPage()).unsafeSubscribe(getMoreSubscriber());
    }

    @Override
    public void onItemClick(int position) {
        startActivityWithData(getAdapter().getItem(position), ActivityWeb.class);
    }

}

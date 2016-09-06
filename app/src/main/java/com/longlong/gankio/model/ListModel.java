package com.longlong.gankio.model;

import com.jude.beam.model.AbsModel;
import com.longlong.gankio.http.HttpMethods;
import com.longlong.gankio.http.HttpResultFunc;
import com.longlong.gankio.entity.Result;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Author:  Chenglong.Lu
 * Email:   1053998178@qq.com | w490576578@gmail.com
 * Date:   2016/07/22
 * Description:
 */
public class ListModel extends AbsModel {
    public static ListModel getInstance() {
        return getInstance(ListModel.class);
    }

    public Observable<List<Result>> getResult(String type, int count, int page) {
        return HttpMethods.getService().getGanHuo(type, count, page).map(new HttpResultFunc<List<Result>>())
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}

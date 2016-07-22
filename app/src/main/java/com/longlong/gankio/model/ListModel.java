package com.longlong.gankio.model;

import com.longlong.gankio.model.bean.GanHuo;
import com.longlong.gankio.model.bean.Result;
import com.longlong.gankio.retrofit.GankRetrofit;

import java.util.ArrayList;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Author:  Chenglong.Lu
 * Email:   1053998178@qq.com | w490576578@gmail.com
 * Date:   2016/07/22
 * Description:
 */
public class ListModel {
    public static Observable<ArrayList<Result>> getResult(String type, int count, int page) {
        Observable<ArrayList<Result>> observable = GankRetrofit.getService().getGanHuo(type, count, page)
                .map(new Func1<GanHuo, ArrayList<Result>>() {
                    @Override
                    public ArrayList<Result> call(GanHuo ganHuo) {
                        if (!ganHuo.isError())
                            return (ArrayList<Result>) ganHuo.getResults();
                        else
                            return new ArrayList<>();
                    }
                }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        return observable;
    }
}

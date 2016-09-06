package com.longlong.gankio.http;

import com.longlong.gankio.entity.GanHuo;

import rx.functions.Func1;


/**
 * Author:  Chenglong.Lu
 * Email:   1053998178@qq.com | w490576578@gmail.com
 * Date:    16/8/24
 * Description: 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
 */
public class HttpResultFunc<T> implements Func1<GanHuo<T>, T> {

    @Override
    public T call(GanHuo<T> tGanHuo) {
        if (tGanHuo.isError()) {
            throw new ApiException("服务器返回错误");
        }
        return tGanHuo.getResults();
    }
}

package com.longlong.gankio.retrofit;

import com.longlong.gankio.model.bean.Result;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Author:  Chenglong.Lu
 * Email:   1053998178@qq.com | w490576578@gmail.com
 * Date:   2016/07/21
 * Description:
 */
public interface GankService {

    @GET("data/{type}/{count}/{page}")
    Observable<Result[]> getGanHuo(
            @Query("type") String type,
            @Query("count") int count,
            @Query("page") int page
    );
}

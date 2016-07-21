package com.longlong.gankio.retrofit;

import com.longlong.gankio.model.GanHuo;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Author:  Chenglong.Lu
 * Email:   1053998178@qq.com | w490576578@gmail.com
 * Date:   2016/07/21
 * Description:
 */
public interface GankService {
    @GET("api/data/{type}/{count}/{page}")
    Observable<GanHuo> getGanHuo(
            @Path("type") String type,
            @Path("count") int count,
            @Path("page") int page
    );
}

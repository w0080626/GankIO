package com.longlong.gankio.http;

import com.longlong.gankio.entity.GanHuo;
import com.longlong.gankio.entity.Result;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Author:  Chenglong.Lu
 * Email:   1053998178@qq.com | w490576578@gmail.com
 * Date:    16/8/24
 * Description:接口API
 */
public interface HttpService {
    //分页获取数据
    @GET("data/{type}/{count}/{page}")
    Observable<GanHuo<List<Result>>> getGanHuo(
            @Path("type") String type,
            @Path("count") int count,
            @Path("page") int page
    );
}

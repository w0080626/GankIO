package com.longlong.gankio.retrofit;

import com.longlong.gankio.config.API;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author:  Chenglong.Lu
 * Email:   1053998178@qq.com | w490576578@gmail.com
 * Date:   2016/07/21
 * Description:
 */
public class GankRetrofit {
    public  static GankService mService;
    public static GankService getService(){
        if(mService==null){
            createService();
        }
        return mService;
    }

    private static void createService(){
        mService = createRetrofit().create(GankService.class);
    }

    private static Retrofit createRetrofit(){
        OkHttpClient client = new OkHttpClient.Builder()
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();
        return  retrofit;
    }
}

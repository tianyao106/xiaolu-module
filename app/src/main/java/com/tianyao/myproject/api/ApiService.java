package com.tianyao.myproject.api;

import com.tianyao.myproject.bean.CheckTaskListData;
import com.tianyao.xiaolu.bean.response.ResponseResult;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by 陆维淋
 * on 2018/9/18
 */
public interface ApiService {

    @GET("http://192.168.1.85:7240/cruise/rest/AppCrewCheck/getTasks")
    Observable<ResponseResult<CheckTaskListData>> getShipCrewList();

}

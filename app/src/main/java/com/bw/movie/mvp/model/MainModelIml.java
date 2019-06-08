package com.bw.movie.mvp.model;

import com.bw.movie.net.RxJavaUtils;

import java.util.Map;


/**
 * @Author：Administrator
 * @E-mail： victory52@163.com
 * @Date：2019/5/10 14:42
 * @Description：描述信息
 */
public class MainModelIml  implements MainModel {

    @Override
    public void post(int type, String url, Map<String, String> mapH, Map<String, String> mapQ, final CallBackLisenter callBackLisenter) {
        RxJavaUtils.getRxJavaUtils().post(type,url,mapH,mapQ).result(new RxJavaUtils.CallBackListener() {
            @Override
            public void success(int type, String data) {
                callBackLisenter.success(type,data);
            }

            @Override
            public void fail(int type, String error) {
                callBackLisenter.fail(type,error);
            }
        });
    }

    @Override
    public void get(int type, String url, Map<String, String> mapH, Map<String, String> mapQ, final CallBackLisenter callBackLisenter) {
        RxJavaUtils.getRxJavaUtils().get(type,url,mapH,mapQ).result(new RxJavaUtils.CallBackListener() {
            @Override
            public void success(int type, String data) {
                callBackLisenter.success(type,data);
            }

            @Override
            public void fail(int type, String error) {
                callBackLisenter.fail(type,error);
            }
        });
    }
    @Override
    public void put(int type, String url, Map<String, String> mapH, Map<String, String> mapQ, final CallBackLisenter callBackLisenter) {
        RxJavaUtils.getRxJavaUtils().put(type,url,mapH,mapQ).result(new RxJavaUtils.CallBackListener() {
            @Override
            public void success(int type, String data) {
                callBackLisenter.success(type,data);
            }

            @Override
            public void fail(int type, String error) {
                callBackLisenter.fail(type,error);
            }
        });
    }
    @Override
    public void delete(int type, String url, Map<String, String> mapH, Map<String, String> mapQ, final CallBackLisenter callBackLisenter) {
        RxJavaUtils.getRxJavaUtils().delete(type,url,mapH,mapQ).result(new RxJavaUtils.CallBackListener() {
            @Override
            public void success(int type, String data) {
                callBackLisenter.success(type,data);
            }

            @Override
            public void fail(int type, String error) {
                callBackLisenter.fail(type,error);
            }
        });
    }

}

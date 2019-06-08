package com.bw.movie.mvp.model;

import java.util.Map;

/**
 * @Author：Administrator
 * @E-mail： victory52@163.com
 * @Date：2019/5/10 14:42
 * @Description：描述信息
 */
public interface MainModel {
    interface CallBackLisenter{
        void success(int type, String data);
        void fail(int type, String error);
    }
    void post(int type, String url, Map<String, String> mapH, Map<String, String> mapQ, CallBackLisenter callBackLisenter);
    void get(int type, String url, Map<String, String> mapH, Map<String, String> mapQ, CallBackLisenter callBackLisenter);
    void put(int type, String url, Map<String, String> mapH, Map<String, String> mapQ, CallBackLisenter callBackLisenter);
    void delete(int type, String url, Map<String, String> mapH, Map<String, String> mapQ, CallBackLisenter callBackLisenter);
   /* void doZhuce(String phone, String pwd, CallBackLisenter callBackLisenter);
    void doShow(CallBackLisenter callBackLisenter);
    void doXiang(int id, CallBackLisenter callBackLisenter);*/
}

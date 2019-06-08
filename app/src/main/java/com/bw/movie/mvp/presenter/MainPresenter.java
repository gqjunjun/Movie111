package com.bw.movie.mvp.presenter;

import java.util.Map;

/**
 * @Author：Administrator
 * @E-mail： victory52@163.com
 * @Date：2019/5/10 14:42
 * @Description：描述信息
 */
public interface MainPresenter {
    void post(int type, String url, Map<String, String> mapH, Map<String, String> mapQ);
    void get(int type, String url, Map<String, String> mapH, Map<String, String> mapQ);
    void put(int type, String url, Map<String, String> mapH, Map<String, String> mapQ);
    void delete(int type, String url, Map<String, String> mapH, Map<String, String> mapQ);

}

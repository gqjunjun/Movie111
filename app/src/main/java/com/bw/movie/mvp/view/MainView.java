package com.bw.movie.mvp.view;

/**
 * @Author：Administrator
 * @E-mail： victory52@163.com
 * @Date：2019/5/10 14:41
 * @Description：描述信息
 */
public interface MainView {
    void success(int type, String data);
    void fail(int type, String error);
}

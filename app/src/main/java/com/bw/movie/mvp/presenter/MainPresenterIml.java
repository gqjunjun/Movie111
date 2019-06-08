package com.bw.movie.mvp.presenter;


import com.bw.movie.mvp.model.MainModel;
import com.bw.movie.mvp.view.MainView;

import java.util.Map;


/**
 * @Author：Administrator
 * @E-mail： victory52@163.com
 * @Date：2019/5/10 14:43
 * @Description：描述信息
 */
public class MainPresenterIml implements MainPresenter,MainModel.CallBackLisenter {
    private MainModel mainModel;
    private MainView mainView;
    private boolean isRunning;

    public MainPresenterIml(MainModel mainModel, MainView mainView) {
        this.mainModel = mainModel;
        this.mainView = mainView;
    }

    @Override
    public void post(int type, String url, Map<String, String> mapH, Map<String,String> mapQ) {
        if (isRunning)
            return;
        isRunning = true;
        mainModel.post(type,url,mapH,mapQ,this);
    }
    @Override
    public void get(int type, String url, Map<String,String> mapH, Map<String, String> mapQ) {
        if (isRunning)
            return;
        isRunning = true;
        mainModel.get(type,url,mapH,mapQ,this);
    }
    @Override
    public void put(int type, String url, Map<String,String> mapH, Map<String, String> mapQ) {
        if (isRunning)
            return;
        isRunning = true;
        mainModel.put(type,url,mapH,mapQ,this);
    }
    @Override
    public void delete(int type, String url, Map<String,String> mapH, Map<String, String> mapQ) {
        if (isRunning)
            return;
        isRunning = true;
        mainModel.delete(type,url,mapH,mapQ,this);
    }
    @Override
    public void success(int type, String data) {
        isRunning = false;
        mainView.success(type,data);
    }

    @Override
    public void fail(int type, String error) {
        isRunning = false;
        mainView.fail(type,error);
    }

    public void destory() {
        if (mainModel!=null){
            mainModel = null;
        }
        if (mainView!=null){
            mainView = null;
        }
        System.gc();
    }
}
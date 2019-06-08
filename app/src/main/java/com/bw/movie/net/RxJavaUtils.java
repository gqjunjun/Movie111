package com.bw.movie.net;

import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;


/**
 * @Author：Administrator
 * @E-mail： victory52@163.com
 * @Date：2019/6/8 14:42
 * @Description：描述信息
 */
public class RxJavaUtils {
    private static RxJavaUtils rxJavaUtils;
    private OkHttpClient okHttpClient;
    String URL = "http://mobile.bwstudent.com/";
    //双重检查
    public static RxJavaUtils getRxJavaUtils(){
        if (rxJavaUtils==null){
            synchronized (RxJavaUtils.class){
                if (rxJavaUtils==null){
                    rxJavaUtils = new RxJavaUtils();
                }
            }
        }
        return rxJavaUtils;
    }
    //设置超时时间--拦截器
    public RxJavaUtils(){
        okHttpClient = new OkHttpClient.Builder()
                .writeTimeout(60,TimeUnit.SECONDS)
                .readTimeout(60,TimeUnit.SECONDS)
                .connectTimeout(60,TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                    @Override
                    public void log(String message) {
                        Log.e("Messages:",message);
                    }
                }))
                .build();
    }
    public RxJavaUtils post(final int type, String url, Map<String,String> mapH , Map<String,String> mapQ){
        if (mapH==null){
            mapH = new HashMap<>();
        }
        if (mapQ==null){
            mapQ = new HashMap<>();
        }
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        retrofit.create(ServiceUtils.class)
                .post(url,mapH,mapQ)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            callBackListener.success(type,responseBody.string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBackListener.fail(type,e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return this;
    }
    public RxJavaUtils get(final int type, String url, Map<String,String> mapH, Map<String,String> mapQ){
        if (mapH==null){
            mapH = new HashMap<>();
        }
        if (mapQ==null){
            mapQ = new HashMap<>();
        }
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        retrofit.create(ServiceUtils.class)
                .get(url,mapH,mapQ)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            callBackListener.success(type,responseBody.string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBackListener.fail(type,e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return this;
    }
    public RxJavaUtils put(final int type, String url, Map<String,String> mapH, Map<String,String> mapQ){
        if (mapH==null){
            mapH = new HashMap<>();
        }
        if (mapQ==null){
            mapQ = new HashMap<>();
        }
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        retrofit.create(ServiceUtils.class)
                .put(url,mapH,mapQ)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            callBackListener.success(type,responseBody.string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBackListener.fail(type,e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return this;
    }
    public RxJavaUtils delete(final int type, String url, Map<String,String> mapH, Map<String,String> mapQ){
        if (mapH==null){
            mapH = new HashMap<>();
        }
        if (mapQ==null){
            mapQ = new HashMap<>();
        }
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        retrofit.create(ServiceUtils.class)
                .delete(url,mapH,mapQ)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            callBackListener.success(type,responseBody.string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBackListener.fail(type,e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return this;
    }



    //传递接口/接口回调
    private CallBackListener callBackListener;

    public void result(CallBackListener callBackListener) {
        this.callBackListener = callBackListener;
    }

    public interface CallBackListener {
        void success(int type, String data);
        void fail(int type, String error);
    }

}

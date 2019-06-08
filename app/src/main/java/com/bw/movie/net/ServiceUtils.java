package com.bw.movie.net;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * @Author：Administrator
 * @E-mail： victory52@163.com
 * @Date：2019/6/8 14:25
 * @Description：描述信息
 */
public interface ServiceUtils {
    @FormUrlEncoded
    @POST
    Observable<ResponseBody> post(@Url String url, @HeaderMap Map<String, String> mapH, @FieldMap Map<String, String> mapQ);
    @GET
    Observable<ResponseBody> get(@Url String url, @HeaderMap Map<String, String> mapH, @QueryMap Map<String, String> mapQ);
    @PUT
    Observable<ResponseBody> put(@Url String url, @HeaderMap Map<String, String> mapH, @QueryMap Map<String, String> mapQ);
    @DELETE
    Observable<ResponseBody> delete(@Url String url, @HeaderMap Map<String, String> mapH, @QueryMap Map<String, String> mapQ);

}

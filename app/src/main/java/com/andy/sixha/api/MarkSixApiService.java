package com.andy.sixha.api;

import com.andy.sixha.bean.MarkSix;
import com.andy.sixha.bean.User;

import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import rx.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
/**
 * @author hehaodong
 * @Filename:com.andy.sixha.api
 * @Description:
 * @Copyright: Copyright (c) 2014 Tuandai Inc. All Rights Reserved.
 * @date 2016-12-06 10:21
 */
public interface MarkSixApiService {
    @GET("/post/getmark")
    Observable<MarkSix> getLatestMark();

    @GET("/api/history/{year}")
    Observable<List<MarkSix>> getHistory(@Path("year") String year);


    @GET("users")
    Call<List<User>> getUsers();

    @POST("users")
    Call<List<User>> getUsersBySort(@Query("sort") String sort);

    @GET("{username}")
    Call<User> getUser(@Path("username") String username);

    @POST("add")
    Call<List<User>> addUser(@Body User user);

    @POST("login")
    @FormUrlEncoded
    Call<User> login(@Field("username") String username, @Field("password") String password);

    @Multipart
    @POST("register")
    Call<User> registerUser(@Part("photos") RequestBody photos, @Part("username") RequestBody username, @Part("password") RequestBody password);

    @Multipart
    @POST("register")
    Call<User> registerUser(@PartMap Map<String, RequestBody> params, @Part("password") RequestBody password);

    @GET("download")
    Call<ResponseBody> downloadTest();
}

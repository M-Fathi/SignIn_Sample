package com.mohammad_fathi.signin_sample.webService;

import com.mohammad_fathi.signin_sample.entity.Users;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface WebserviceApi {
    String get_webservice_address = "";
    String post_webservice_address = "";


    @GET(get_webservice_address)
    Call<Users> getUserInfo();

    @POST(post_webservice_address)
    @FormUrlEncoded
        //void postUserInfo(@Field("username") String username,@Field("password") String password);
    Call<Users> postUserInfo(@Field("username") String username, @Field("password") String password, @Field("name_user") String name_user);

    @POST(post_webservice_address)
    @FormUrlEncoded
        //void postUserInfo(@Field("username") String username,@Field("password") String password);
    Call<Users> postUserInfo(@Field("username") String username, @Field("password") String password);

}

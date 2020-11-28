package com.mohammad_fathi.signin_sample.webService;

import com.mohammad_fathi.signin_sample.entity.LoginRequestDto;
import com.mohammad_fathi.signin_sample.entity.LoginResponseDto;
import com.mohammad_fathi.signin_sample.entity.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface WebserviceApi {
    String getUserInfo = "/api/services/app/User/Get?Id=1";
    String SignUp = "/api/services/app/Account/Register";
    String Authenticate = "/api/TokenAuth/Authenticate";

    @GET(getUserInfo)
    Call<User> getUserInfo(@Query("id") String id, @Header("Authorization") String authenticationKey);

    @POST(SignUp)
    @Headers("Content-Type: application/json")
    //void signUp(@Field("username") String username,@Field("password") String password);
    Call<User> signUp(@Field("username") String username, @Field("password") String password, @Field("name_user") String name_user);

    @Headers("Content-Type: application/json")
    @POST(Authenticate)
    //void signUp(@Field("username") String username,@Field("password") String password);
    //Call<LoginResponseDto> login(@Field("UsernameOrEmailAddress") String usernameOrEmailAddress, @Field("password") String password);
    Call<LoginResponseDto> login(@Body LoginRequestDto loginRequestDto);
}


//post SignUp sample
//    {
//            "name": "sssss",
//            "surname": "1sdasdasdasd",
//            "userName": "iabidi22",
//            "emailAddress": "user@example.com",
//            "password": "1234Qwewwr"
//    }
//https://stackoverflow.com/questions/41078866/retrofit2-authorization-global-interceptor-for-access-token

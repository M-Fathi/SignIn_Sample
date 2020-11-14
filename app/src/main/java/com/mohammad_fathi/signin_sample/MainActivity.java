package com.mohammad_fathi.signin_sample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.mohammad_fathi.signin_sample.entity.LoginRequestDto;
import com.mohammad_fathi.signin_sample.entity.LoginResponseDto;
import com.mohammad_fathi.signin_sample.entity.User;
import com.mohammad_fathi.signin_sample.webService.WebserviceApi;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    //String BASE_URL = "http://10.0.2.2:21021";
    String BASE_URL = "http://bitiranwebhost20200905160203.azurewebsites.net";
    String name_user, username, password;
    EditText et_username, et_password;
    String accessToken;
    Integer userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initialize();
    }

    public void btn_login(View view) {
        try {
            // --------------------- Get Username and Password -----------------------------------------
            username = et_username.getText().toString();
            password = et_password.getText().toString();

            //-----------------------Start Retrofit (POST Method)----------------------------------------
            login(username, password);
            //-----------------------Start Retrofit (GET Method)----------------------------------------
            //    getRetrofit();
            // ------------------------- End Retrofit -------------------------------------------------
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void btn_GetUserInfo(View view) {
        //1) Create instance
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        //2) Create API
        WebserviceApi api = retrofit.create(WebserviceApi.class);

        //3) Create Request
        Call<User> userInfo = api.getUserInfo(userId,"Bearer " + accessToken);

        userInfo.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user1 = response.body();

                String message = String.format("%s , %s", response.code(), response.message());
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                name_user = user1.getName();
                Toast.makeText(MainActivity.this, name_user, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void login(String username, String password) {

        try {

            //1) Create instance
            Retrofit retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build();
            //2) Create API
            WebserviceApi api = retrofit.create(WebserviceApi.class);

            //3) Create Request
            Call<LoginResponseDto> loginResponseCall = api.login(new LoginRequestDto(username, password));

            loginResponseCall.enqueue(new Callback<LoginResponseDto>() {
                @Override
                public void onResponse(Call<LoginResponseDto> call, Response<LoginResponseDto> response) {

                    if (response.isSuccessful()) {
                        LoginResponseDto authenticationResponseDto = response.body();
                        if (authenticationResponseDto != null & authenticationResponseDto.success) {
                            accessToken = authenticationResponseDto.result.accessToken;
                            userId = authenticationResponseDto.result.userId;
                            Integer expireInSeconds = authenticationResponseDto.result.expireInSeconds;
                            // todo save auth token in preference
                            // todo redirect to main activity
                            Toast.makeText(MainActivity.this, "Successful login", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(MainActivity.this, "something is wrong with your request", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        String responseBodyJson = response.raw().body().toString();
                        // todo: it is better to deserialize the error exact response and show a more meaningful error
                        // Log.d("response", responseBodyJson);
                        // Gson gson = new Gson();
                        // LoginResponseDto obj2 = gson.fromJson(responseBodyJson, LoginResponseDto.class);
                        ResponseBody errorResp = response.errorBody();
                        String errorMessage = String.format("%s , %s", response.code(), response.message());
                        Toast.makeText(MainActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<LoginResponseDto> call, Throwable t) {
                    Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        } catch (Exception e) {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void btn_Signup(View view) {
        Intent intent = new Intent(MainActivity.this, Sign_up.class);
        startActivity(intent);
    }

    public void btn_forgot_pass(View view) {
    }

    public void initialize() {
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
    }
}
package com.mohammad_fathi.signin_sample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.mohammad_fathi.signin_sample.entity.Users;
import com.mohammad_fathi.signin_sample.webService.WebserviceApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    String BASE_URL = "";

    String name_user, username, password;
    EditText et_username, et_password;


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
            postRetrofit(username, password);
            //-----------------------Start Retrofit (GET Method)----------------------------------------
       //     getRetrofit();
            // ------------------------- End Retrofit -------------------------------------------------
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void getRetrofit() {
        //1) Create instance
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        //2) Create API
        WebserviceApi api = retrofit.create(WebserviceApi.class);

        //3) Create Request
        Call<Users> userInfo = api.getUserInfo();

        userInfo.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                Users user1 = response.body();
                int code = response.code();
                Toast.makeText(MainActivity.this, String.valueOf(code), Toast.LENGTH_SHORT).show();
                name_user = user1.getName();
                Toast.makeText(MainActivity.this, name_user, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void postRetrofit(String username, String password) {

        try {

        //1) Create instance
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
        //2) Create API
        WebserviceApi api = retrofit.create(WebserviceApi.class);

        //3) Create Request
        Call<Users> postUser_Info = api.postUserInfo(username, password);

        postUser_Info.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                Users user2 = response.body();
                int code = response.code();
                Toast.makeText(MainActivity.this, String.valueOf(code), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        }catch (Exception e){}
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
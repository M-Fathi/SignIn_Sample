package com.mohammad_fathi.signin_sample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.mohammad_fathi.signin_sample.entity.User;
import com.mohammad_fathi.signin_sample.webService.WebserviceApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Sign_up extends AppCompatActivity {

    String BASE_URL = "";
    String st_nameUser, st_nameUser_signup, st_password_signup;
    EditText et_nameUser, et_nameUser_signup, et_password_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        initialize();
    }

    public void btn_Register(View view) {
        st_nameUser = et_nameUser.getText().toString();
        st_nameUser_signup = et_nameUser_signup.getText().toString();
        st_password_signup = et_password_signup.getText().toString();

        //-----------------------Start Retrofit (POST Method)----------------------------------------
        postRetrofit(st_nameUser_signup, st_password_signup, st_nameUser);
        // ------------------------- End Retrofit -------------------------------------------------
    }

    public void to_signin_page(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }

    public void postRetrofit(String username, String password, String name_user) {
        //1) Create instance
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
        //2) Create API
        WebserviceApi api = retrofit.create(WebserviceApi.class);

        //3) Create Request
        Call<User> postUser_Info = api.signUp(username, password, name_user);

        postUser_Info.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user2 = response.body();
                int code = response.code();
                Toast.makeText(Sign_up.this, String.valueOf(code), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(Sign_up.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void initialize() {
        et_nameUser = findViewById(R.id.et_nameUser);
        et_nameUser_signup = findViewById(R.id.et_nameUser_signup);
        et_password_signup = findViewById(R.id.et_password_signup);
    }
}
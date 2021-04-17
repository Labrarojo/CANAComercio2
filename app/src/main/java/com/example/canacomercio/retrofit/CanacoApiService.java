package com.example.canacomercio.retrofit;

import com.example.canacomercio.retrofit.response.login.ResponseLogin;
import com.example.canacomercio.retrofit.request.RequestLogin;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface CanacoApiService {

    @POST("auth/login/comercios")
    Call<ResponseLogin> doLogin(@Body RequestLogin requestLogin);

}

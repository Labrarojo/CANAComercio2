package com.example.canacomercio.retrofit;

import com.example.canacomercio.retrofit.response.ResponseLogin;
import com.example.canacomercio.retrofit.request.RequestLogin;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface CanacoApiServicio {

    @POST("auth/login/comercios")
    Call<ResponseLogin> doLogin(@Body RequestLogin requestLogin);

}

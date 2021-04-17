package com.example.canacomercio.retrofit;

import com.example.canacomercio.common.Constants;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AuthCanacoClient {

    private static AuthCanacoClient instancia = null;
    private AuthCanacoApiService canacoApiServicio;
    private Retrofit retrofit;

    public AuthCanacoClient(){

        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.addInterceptor(new AuthInterceptor());
        OkHttpClient client = okHttpClientBuilder.build();

        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.API_CANACO_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        canacoApiServicio = retrofit.create(AuthCanacoApiService.class);
    }

    public static AuthCanacoClient getInstance(){
        if (instancia == null){
            instancia = new AuthCanacoClient();
        }
        return instancia;
    }

    public AuthCanacoApiService getAuthCanacoApiService(){
        return canacoApiServicio;
    }

}

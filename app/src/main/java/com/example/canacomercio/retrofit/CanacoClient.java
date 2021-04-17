package com.example.canacomercio.retrofit;

import com.example.canacomercio.common.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CanacoClient {

    private static CanacoClient instancia = null;
    private CanacoApiService canacoApiService;
    private Retrofit retrofit;

    public CanacoClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.API_CANACO_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        canacoApiService = retrofit.create(CanacoApiService.class);
    }

    public static CanacoClient getInstance(){
        if (instancia == null){
            instancia = new CanacoClient();
        }
        return instancia;
    }

    public CanacoApiService getCanacoApiService(){
        return canacoApiService;
    }

}

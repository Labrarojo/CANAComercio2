package com.example.canacomercio.retrofit;

import com.example.canacomercio.common.Constantes;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CanacoCliente {

    private static CanacoCliente instancia = null;
    private CanacoApiServicio canacoApiServicio;
    private Retrofit retrofit;

    public CanacoCliente(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Constantes.API_CANACO_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        canacoApiServicio = retrofit.create(CanacoApiServicio.class);
    }

    public static CanacoCliente getInstance(){
        if (instancia == null){
            instancia = new CanacoCliente();
        }
        return instancia;
    }

    public CanacoApiServicio getCanacoApiService(){
        return canacoApiServicio;
    }

}

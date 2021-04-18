package com.example.canacomercio.data;

import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.canacomercio.common.MyApp;
import com.example.canacomercio.retrofit.AuthCanacoApiService;
import com.example.canacomercio.retrofit.AuthCanacoClient;
import com.example.canacomercio.retrofit.response.offer.Offer;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OfferRepository {
    AuthCanacoApiService authCanacoApiService;
    AuthCanacoClient authCanacoClient;
    LiveData<Offer> allOffers;


    OfferRepository(){
        authCanacoClient = AuthCanacoClient.getInstance();
        authCanacoApiService = authCanacoClient.getAuthCanacoApiService();
        allOffers = getAllOffers();
    }

    public LiveData<Offer> getAllOffers(){
        final MutableLiveData<Offer> data = new MutableLiveData<>();
        Call<Offer> call = authCanacoApiService.getAllOffers();
        call.enqueue(new Callback<Offer>() {
            @Override
            public void onResponse(Call<Offer> call, Response<Offer> response) {
                if (response.isSuccessful()){
                    data.setValue(response.body());

                }else{
                    Toast.makeText(MyApp.getContext(),"Algo ha ido mal", Toast.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<Offer> call, Throwable t) {
                Toast.makeText(MyApp.getContext(),"Error en la conexión", Toast.LENGTH_SHORT);
            }
        });
        return data;
    }
}

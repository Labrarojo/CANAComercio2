package com.example.canacomercio.retrofit;

import com.example.canacomercio.retrofit.response.offer.Offer;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AuthCanacoApiService {

    @GET("comercios/11/ofertas")
    Call<Offer> getAllOffers();

}

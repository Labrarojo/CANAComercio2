package com.example.canacomercio.retrofit;

import com.example.canacomercio.retrofit.response.employee.Employee;
import com.example.canacomercio.retrofit.response.offer.Offer;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AuthCanacoApiService {

    @GET("comercios/11/ofertas")
    Call<Offer> getAllOffers();

    @GET("comercios/11/admins")
    Call<Employee> getAllEmployees();

}

package com.example.canacomercio.data;

import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.canacomercio.common.MyApp;
import com.example.canacomercio.retrofit.AuthCanacoApiService;
import com.example.canacomercio.retrofit.AuthCanacoClient;
import com.example.canacomercio.retrofit.response.employee.Employee;
import com.example.canacomercio.retrofit.response.offer.Offer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeRepository {
    AuthCanacoApiService authCanacoApiService;
    AuthCanacoClient authCanacoClient;
    LiveData<Employee> allEmployee;


    EmployeeRepository(){
        authCanacoClient = AuthCanacoClient.getInstance();
        authCanacoApiService = authCanacoClient.getAuthCanacoApiService();
        allEmployee = getAllEmployee();
    }

    public LiveData<Employee> getAllEmployee(){
        final MutableLiveData<Employee> data = new MutableLiveData<>();
        Call<Employee> callAdmin = authCanacoApiService.getAllAdmins();
        Call<Employee> callManager = authCanacoApiService.getAllManagers();
        Call<Employee> callEmployee = authCanacoApiService.getAllEmployees();
        callAdmin.enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {
                if (response.isSuccessful()){
                    data.setValue(response.body());
                }else{
                    Toast.makeText(MyApp.getContext(),"Algo ha ido mal", Toast.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<Employee> call, Throwable t) {
                Toast.makeText(MyApp.getContext(),"Error en la conexión", Toast.LENGTH_SHORT);
            }
        });

        callManager.enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {
                if (response.isSuccessful()){
                    data.setValue(response.body());
                }else{
                    Toast.makeText(MyApp.getContext(),"Algo ha ido mal", Toast.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<Employee> call, Throwable t) {
                Toast.makeText(MyApp.getContext(),"Error en la conexión", Toast.LENGTH_SHORT);
            }
        });

        callEmployee.enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {
                if (response.isSuccessful()){
                    data.setValue(response.body());
                }else{
                    Toast.makeText(MyApp.getContext(),"Algo ha ido mal", Toast.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<Employee> call, Throwable t) {
                Toast.makeText(MyApp.getContext(),"Error en la conexión", Toast.LENGTH_SHORT);
            }
        });
        return data;
    }
}

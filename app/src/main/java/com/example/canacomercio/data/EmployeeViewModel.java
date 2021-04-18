package com.example.canacomercio.data;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.canacomercio.retrofit.response.employee.Employee;
import com.example.canacomercio.retrofit.response.offer.Offer;

public class EmployeeViewModel extends AndroidViewModel {

    private EmployeeRepository employeeRepository;
    private LiveData<Employee> employee;

    public EmployeeViewModel(@NonNull Application application) {
        super(application);
        employeeRepository = new EmployeeRepository();
        employee = employeeRepository.getAllEmployee();
    }

    public LiveData<Employee> getEmployee(){
        return employee;
    }
}

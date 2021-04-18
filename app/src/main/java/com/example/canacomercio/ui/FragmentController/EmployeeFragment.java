package com.example.canacomercio.ui.FragmentController;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.canacomercio.R;
import com.example.canacomercio.retrofit.AuthCanacoApiService;
import com.example.canacomercio.retrofit.AuthCanacoClient;
import com.example.canacomercio.retrofit.response.employee.Datum;
import com.example.canacomercio.retrofit.response.employee.Employee;
import com.example.canacomercio.ui.RecyclerViewAdapter.MyEmployeeRecyclerViewAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A fragment representing a list of Items.
 */
public class EmployeeFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    RecyclerView recyclerView;
    private List<Datum> employeeList;
    private Employee employee;
    private MyEmployeeRecyclerViewAdapter adapterEmployee;
    AuthCanacoApiService authCanacoApiService;
    AuthCanacoClient authCanacoClient;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public EmployeeFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static EmployeeFragment newInstance(int columnCount) {
        EmployeeFragment fragment = new EmployeeFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_employee_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            retrofitInit();
            loadOfferData();
        }
        return view;
    }

    private void retrofitInit() {
        authCanacoClient = AuthCanacoClient.getInstance();
        authCanacoApiService = authCanacoClient.getAuthCanacoApiService();
    }

    private void loadOfferData() {
        Call<Employee> callAdmin = authCanacoApiService.getAllAdmins();
        Call<Employee> callManager = authCanacoApiService.getAllManagers();
        Call<Employee> callEmployee = authCanacoApiService.getAllEmployees();

        callAdmin.enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {
                if (response.isSuccessful()){
                    employee = response.body();
                    employeeList = employee.getData();
                    adapterEmployee = new MyEmployeeRecyclerViewAdapter(employeeList);
                    recyclerView.setAdapter(adapterEmployee);
                }else{
                    Toast.makeText(getActivity(),"Algo ha ido mal", Toast.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<Employee> call, Throwable t) {
                Toast.makeText(getActivity(),"Error en la conexión", Toast.LENGTH_SHORT);
            }
        });

        callManager.enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {
                if (response.isSuccessful()){
                    employee = response.body();
                    employeeList.addAll(employee.getData());
                    adapterEmployee = new MyEmployeeRecyclerViewAdapter(employeeList);
                    recyclerView.setAdapter(adapterEmployee);
                }else{
                    Toast.makeText(getActivity(),"Algo ha ido mal", Toast.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<Employee> call, Throwable t) {
                Toast.makeText(getActivity(),"Error en la conexión", Toast.LENGTH_SHORT);
            }
        });

        callEmployee.enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {
                if (response.isSuccessful()){
                    employee = response.body();
                    employeeList.addAll(employee.getData());
                    adapterEmployee = new MyEmployeeRecyclerViewAdapter(employeeList);
                    recyclerView.setAdapter(adapterEmployee);
                }else{
                    Toast.makeText(getActivity(),"Algo ha ido mal", Toast.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<Employee> call, Throwable t) {
                Toast.makeText(getActivity(),"Error en la conexión", Toast.LENGTH_SHORT);
            }
        });
    }
}
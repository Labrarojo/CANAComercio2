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
import com.example.canacomercio.retrofit.response.offer.Datum;
import com.example.canacomercio.retrofit.response.offer.Offer;
import com.example.canacomercio.ui.RecyclerViewAdapter.MyOfferRecyclerViewAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A fragment representing a list of Items.
 */
public class SalesFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    RecyclerView recyclerView;
    private List<Datum> offerList;
    private Offer offer;
    AuthCanacoApiService authCanacoApiService;
    AuthCanacoClient authCanacoClient;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SalesFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static SalesFragment newInstance(int columnCount) {
        SalesFragment fragment = new SalesFragment();
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
        View view = inflater.inflate(R.layout.fragment_sales_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
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
        Call<Offer> call = authCanacoApiService.getAllOffers();
        call.enqueue(new Callback<Offer>() {
            @Override
            public void onResponse(Call<Offer> call, Response<Offer> response) {
                if (response.isSuccessful()){
                    offer = response.body();
                    offerList = offer.getData();
                    System.out.println(offerList);
                    MyOfferRecyclerViewAdapter adapterOffer = new MyOfferRecyclerViewAdapter(offerList);
                    recyclerView.setAdapter(adapterOffer);
                }else{
                    Toast.makeText(getActivity(),"Algo ha ido mal", Toast.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<Offer> call, Throwable t) {
                Toast.makeText(getActivity(),"Error en la conexión", Toast.LENGTH_SHORT);
            }
        });
    }
}
package com.example.canacomercio.ui.FragmentController;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.canacomercio.R;
import com.example.canacomercio.data.OfferViewModel;
import com.example.canacomercio.retrofit.response.offer.Datum;
import com.example.canacomercio.retrofit.response.offer.Offer;
import com.example.canacomercio.ui.RecyclerViewAdapter.MyOfferRecyclerViewAdapter;

import java.util.List;


/**
 * A fragment representing a list of Items.
 */
public class OfferFragment extends Fragment {

    // TODO: Customize parameters
    private int mColumnCount = 1;
    RecyclerView recyclerView;
    private List<Datum> offerList;
    OfferViewModel offerViewModel;
    MyOfferRecyclerViewAdapter adapterOffer;


    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static OfferFragment newInstance(int columnCount) {
        OfferFragment fragment = new OfferFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public OfferFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        offerViewModel = new ViewModelProvider(this).get(OfferViewModel.class);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_offer_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(mColumnCount, StaggeredGridLayoutManager.VERTICAL));
            }
            adapterOffer = new MyOfferRecyclerViewAdapter(offerList);
            recyclerView.setAdapter(adapterOffer);
            loadOfferData();
        }
        return view;
    }

    private void loadOfferData() {
        offerViewModel.getOffer().observe(getActivity(), new Observer<Offer>() {
            @Override
            public void onChanged(Offer offer) {
                offerList = offer.getData();
                adapterOffer.setData(offerList);
            }
        });
    }
}
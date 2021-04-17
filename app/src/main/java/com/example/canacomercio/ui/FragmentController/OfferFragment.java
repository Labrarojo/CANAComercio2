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

import com.example.canacomercio.R;
import com.example.canacomercio.retrofit.response.offer.Datum;
import com.example.canacomercio.ui.RecyclerViewAdapter.MyOfferRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class OfferFragment extends Fragment {

    // TODO: Customize parameters
    private int mColumnCount = 1;
    RecyclerView recyclerView;
    private List<Datum> offerList;
    private MyOfferRecyclerViewAdapter adapterOffer;


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
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            
           loadOfferData();


        }
        return view;
    }

    private void loadOfferData() {
        adapterOffer = new MyOfferRecyclerViewAdapter(offerList);
        recyclerView.setAdapter(adapterOffer);
    }
}
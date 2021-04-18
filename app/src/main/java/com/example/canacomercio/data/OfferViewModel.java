package com.example.canacomercio.data;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.canacomercio.retrofit.response.offer.Offer;

public class OfferViewModel extends AndroidViewModel {

    private OfferRepository offerRepository;
    private LiveData<Offer> offer;

    public OfferViewModel(@NonNull Application application) {
        super(application);
        offerRepository = new OfferRepository();
        offer = offerRepository.getAllOffers();
    }

    public LiveData<Offer> getOffer(){
        return offer;
    }
}

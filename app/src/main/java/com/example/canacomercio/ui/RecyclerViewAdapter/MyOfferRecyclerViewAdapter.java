package com.example.canacomercio.ui.RecyclerViewAdapter;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.canacomercio.R;
import com.example.canacomercio.retrofit.response.offer.Datum;



import java.util.List;

/**
 * TODO: Replace the implementation with code for your data type.
 */
public class MyOfferRecyclerViewAdapter extends RecyclerView.Adapter<MyOfferRecyclerViewAdapter.ViewHolder> {

    private final List<Datum> mValues;

    public MyOfferRecyclerViewAdapter(List<Datum> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_offer, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.tvTittle.setText(holder.mItem.getAttributes().getNombre());
        holder.tvContents.setText(holder.mItem.getAttributes().getDescripcion());
        holder.tvStartDate.setText(holder.mItem.getAttributes().getFechaInicio().substring(0, 10));
        holder.tvEndDate.setText(holder.mItem.getAttributes().getFechaFin().substring(0, 10));
        holder.tvBonus.setText(holder.mItem.getAttributes().getBonificacion().toString());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView tvTittle;
        public final TextView tvContents;
        public final TextView tvStartDate;
        public final TextView tvEndDate;
        public final TextView tvBonus;
        public Datum mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            tvTittle = view.findViewById(R.id.textViewTittle);
            tvContents = view.findViewById(R.id.textViewContents);
            tvStartDate = view.findViewById(R.id.textViewStartDate);
            tvEndDate = view.findViewById(R.id.textViewEndDate);
            tvBonus = view.findViewById(R.id.textViewBonus);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + tvTittle.getText() + "'";
        }
    }
}
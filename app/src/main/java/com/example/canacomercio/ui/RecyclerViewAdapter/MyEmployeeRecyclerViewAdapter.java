package com.example.canacomercio.ui.RecyclerViewAdapter;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.canacomercio.R;
import com.example.canacomercio.retrofit.response.employee.Datum;

import java.util.List;

/**
 * TODO: Replace the implementation with code for your data type.
 */
public class MyEmployeeRecyclerViewAdapter extends RecyclerView.Adapter<MyEmployeeRecyclerViewAdapter.ViewHolder> {

    private final List<Datum> mValues;
    private String username;

    public MyEmployeeRecyclerViewAdapter(List<Datum> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_employee, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        username = holder.mItem.getAttributes().getNombre()+" "+
                holder.mItem.getAttributes().getApellidoPaterno()+" "+
                holder.mItem.getAttributes().getApellidoMaterno();

        holder.tvUsername.setText(username);
        holder.tvRole.setText(holder.mItem.getType());
        holder.tvEmail.setText(holder.mItem.getAttributes().getEmail());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView tvUsername;
        public final TextView tvRole;
        public final TextView tvEmail;
        public final ImageView ivAvatar;
        public Datum mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            tvUsername = view.findViewById(R.id.textViewUsername);
            tvRole = view.findViewById(R.id.textViewRole);
            tvEmail = view.findViewById(R.id.textViewEmail);
            ivAvatar = view.findViewById(R.id.imageViewAvatar);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + tvUsername.getText() + "'";
        }
    }
}
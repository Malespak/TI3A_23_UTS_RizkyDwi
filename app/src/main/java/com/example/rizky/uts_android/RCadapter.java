package com.example.rizky.uts_android;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RCadapter extends RecyclerView.Adapter<RCadapter.ViewHolder> {

    List<m_kota> kotaList;

    public RCadapter(List<m_kota> kotaList) {
        this.kotaList = kotaList;
    }

    @NonNull
    @Override
    public RCadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listkota, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RCadapter.ViewHolder holder, int position) {
        holder.txtKota.setText(kotaList.get(position).getNamaKota());
    }

    @Override
    public int getItemCount() {
        return kotaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtKota;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtKota = itemView.findViewById(R.id.resultKota1);

        }
    }
}

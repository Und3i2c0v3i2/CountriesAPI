package com.example.countriesapi.view.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.example.countriesapi.OnActionPerformedListener;
import com.example.countriesapi.R;
import com.example.countriesapi.model.entity.Country;

import java.util.List;



public class RVAdapter extends Adapter<RVAdapter.ViewHolder> {

    public static final String COUNTRY_NAME = "country_name";
    private List<Country> list;
    private OnActionPerformedListener listener;

    public RVAdapter(List<Country> list, OnActionPerformedListener listener) {
        this.list = list;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_holder, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.name.setText(list.get(position).getName() + ", " + list.get(position).getAlpha3Code());
        holder.capital.setText("capital: " + list.get(position).getCapital());
        holder.region.setText("region: " + list.get(position).getRegion());
        holder.population.setText("population: " + list.get(position).getPopulation() + "");

    }

    @Override
    public int getItemCount() {
        if (list != null)
            return list.size();
        else
            return 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView capital;
        private TextView region;
        private TextView population;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.c_name);
            capital = itemView.findViewById(R.id.c_capital);
            region = itemView.findViewById(R.id.c_region);
            population = itemView.findViewById(R.id.c_population);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Bundle bundle = new Bundle();
                    bundle.putString(COUNTRY_NAME, list.get(getAdapterPosition()).getName());

                    listener.onActionPerformed(bundle);
                }
            });
        }
    }
}

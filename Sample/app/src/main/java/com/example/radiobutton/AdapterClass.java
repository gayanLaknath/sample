package com.example.radiobutton;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.ViewHolder>{
    private List<OffersModel> offersList;
    private Context context;

    private int lastSelectPosition = -1;

    public AdapterClass(List<OffersModel> offersList, Context context) {
        this.offersList = offersList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OffersModel offersModel = offersList.get(position);

        holder.name.setText(offersModel.name);
        holder.radioButton.setChecked(lastSelectPosition == position);

    }

    @Override
    public int getItemCount() {
        return offersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        RadioButton radioButton;

        public ViewHolder(View view){
            super(view);

            name = view.findViewById(R.id.offerName);
            radioButton = view.findViewById(R.id.radioButton);

            radioButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    lastSelectPosition = getAdapterPosition();
                    notifyDataSetChanged();

                    Toast.makeText(AdapterClass.this.context, "Select "+name.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}

package com.example.tugasproject4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<CastandCrew> data;

    public DetailsAdapter(Context context, ArrayList<CastandCrew> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_castandcrew, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        CastandCrew p = data.get(position);
        holder.photocast.setImageResource(p.getPhoto());
        holder.nama.setText(p.getNama());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView photocast;
        private TextView nama;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            photocast = itemView.findViewById(R.id.imageView);
            nama = itemView.findViewById(R.id.textViewnama);
        }
    }
}

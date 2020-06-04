package com.example.tugasproject4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.MyViewHolder> {
    private Context kontext;
    private ArrayList<Details> data;

    public GridAdapter(Context context, ArrayList<Details> data) {
        this.kontext = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_grid, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridAdapter.MyViewHolder holder, int position) {
        Details p = data.get(position);
        holder.nama.setText(p.getNama());
        holder.photo.setImageResource(p.getPhoto());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView nama;
        private TextView desc;
        private ImageView photo;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),nama.getText(),Toast.LENGTH_LONG).show();
                }
            });
            nama = itemView.findViewById(R.id.txt_nama);
            desc = itemView.findViewById(R.id.txt_desc);
            photo = itemView.findViewById(R.id.img_foto); }
    }
}

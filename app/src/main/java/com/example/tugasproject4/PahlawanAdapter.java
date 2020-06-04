package com.example.tugasproject4;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class PahlawanAdapter extends RecyclerView.Adapter<PahlawanAdapter.MyViewHolder> {
    private Context kontext;
    private  ArrayList<Details>data;

    public PahlawanAdapter(Context context, ArrayList<Details> data) {
        this.kontext = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_pahlawan, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,final int position) {
        final Details p = data.get(position);
        holder.nama.setText(p.getNama());
        holder.desc.setText(p.getDesc());
        holder.photo.setImageResource(p.getPhoto());

        holder.list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),KlikActivity.class);
                intent.putExtra("nama",p.getNama());
                intent.putExtra("desc",p.getDesc());
                intent.putExtra("photo",p.getPhoto());
                intent.putExtra("genre",p.getGenre());
                intent.putExtra("time",p.getTime());
                intent.putExtra("sutradara",p.getSutradara());
                intent.putExtra("terbit",p.getTerbit());
                v.getContext().startActivities(new Intent[]{intent});
            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,data.size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView nama, desc;
        private ImageView photo;
        private LinearLayout list;
        private Button delete;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            nama = itemView.findViewById(R.id.txt_nama);
            desc = itemView.findViewById(R.id.txt_desc);
            photo = itemView.findViewById(R.id.img_foto);
            list = itemView.findViewById(R.id.list);
        delete = itemView.findViewById(R.id.btn_hapus);}
    }
}


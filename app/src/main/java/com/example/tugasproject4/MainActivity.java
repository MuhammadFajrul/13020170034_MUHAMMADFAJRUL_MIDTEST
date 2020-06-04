package com.example.tugasproject4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Details> data = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    String[]nama,desc,genre,sutradara,terbit,time;
    TypedArray photo;
    private Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        toolbar.setTitle("List Show TV");
        getData();
        dataList();
    }


    void prepare(){
        nama = getResources().getStringArray(R.array.nama);
        desc = getResources().getStringArray(R.array.desc);
        photo = getResources().obtainTypedArray(R.array.photo);
        genre = getResources().getStringArray(R.array.genre);
        time = getResources().getStringArray(R.array.time);
        sutradara = getResources().getStringArray(R.array.sutradara);
        terbit = getResources().getStringArray(R.array.terbit);
    }

    void additem(){
        for (int i = 0 ; i<nama.length;i++){
            Details p =  new Details(nama[i],desc[i],genre[i],time[i],sutradara[i],terbit[i],photo.getResourceId(i,-1));
            data.add(p);
        }
    }

    void getData(){
        prepare();
        additem();
    }

    public void dataGrid(){
        recyclerView = findViewById(R.id.recycleView);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        GridAdapter gridAdapter = new GridAdapter(this,data);
        recyclerView.setAdapter(gridAdapter);
        gridAdapter.notifyDataSetChanged();
    }

    public void dataList(){
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final PahlawanAdapter pahlawanAdapter = new PahlawanAdapter(this,data);
        recyclerView.setAdapter(pahlawanAdapter);
        pahlawanAdapter.notifyDataSetChanged();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    void setMode(int Selectmode){
        switch (Selectmode){
            case  R.id.grid:
                dataGrid();
                break;
            case  R.id.about:
                Intent intent = new Intent(this,About_Activity.class);
                startActivity(intent);
                break;
            case  R.id.List:
                dataList();
                break;
        }
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }


}

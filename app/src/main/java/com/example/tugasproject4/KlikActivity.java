package com.example.tugasproject4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class KlikActivity extends AppCompatActivity {
     ArrayList<CastandCrew> data = new ArrayList<>();
     RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    String[]nama;
    int getphoto;
    String  getnama,getdesc,gettime,getsutrada,getterbit,getgenre;
    TextView namajud,desc,genre,sutradara,terbit,time;
    ImageView fotojudul;
    TypedArray photo;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klik);
        toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        DetailsAdapter detailsAdapter = new DetailsAdapter(this, data);
        recyclerView.setAdapter(detailsAdapter);
        detailsAdapter.notifyDataSetChanged();


        namajud = findViewById(R.id.judul);
        genre = findViewById(R.id.genre);
        desc = findViewById(R.id.desc);
        time = findViewById(R.id.time);
        terbit = findViewById(R.id.terbit);
        sutradara = findViewById(R.id.sutradara);
        fotojudul = findViewById(R.id.fotojudul);

        getnama = getIntent().getStringExtra("nama");
        getdesc = getIntent().getStringExtra("desc");
        gettime = getIntent().getStringExtra("time");
        getsutrada = getIntent().getStringExtra("sutradara");
        getterbit = getIntent().getStringExtra("terbit");
        getgenre = getIntent().getStringExtra("genre");
        getphoto = getIntent().getIntExtra("photo",0);

        getData();

        desc.setText(getdesc);
        genre.setText(getgenre);
        namajud.setText(getnama);
        time.setText(gettime);
        sutradara.setText(getsutrada);
        terbit.setText(getterbit);
        fotojudul.setImageResource(getphoto);


    }

    void prepare(){
        switch (getnama){
            case "The Walking Dead(2010-)" :
                nama = getResources().getStringArray(R.array.castwalkingdead);
                photo = getResources().obtainTypedArray(R.array.photocastwalkingdead);
                break;
            case "Atlanta(2016)" :
                nama = getResources().getStringArray(R.array.castatlanta);
                photo = getResources().obtainTypedArray(R.array.photocastatalanta);
                break;
            case "Band Of Brothers(2001)" :
                nama = getResources().getStringArray(R.array.castbandofbrothers);
                photo = getResources().obtainTypedArray(R.array.photocastbandofbrothers);
                break;
            case "Black Mirror(2011-)" :
                nama = getResources().getStringArray(R.array.castblackmirror);
                photo = getResources().obtainTypedArray(R.array.photocastblackmirror);
                break;
            case "Breaking Bad(2008-2013)":
                nama = getResources().getStringArray(R.array.castbrinkingbad);
                photo = getResources().obtainTypedArray(R.array.photocastbrikingbad);
                break;
            case "Friends(1994-2004)":
                nama = getResources().getStringArray(R.array.castfriend);
                photo = getResources().obtainTypedArray(R.array.photocastfriend);
                break;
            case "Game Of Thrones(2011-2019)":
                nama = getResources().getStringArray(R.array.castgame0fthrones);
                photo = getResources().obtainTypedArray(R.array.photocastgameofthrones);
                break;
            case "How I Meet Your Mother(2005)":
                nama = getResources().getStringArray(R.array.casthowimeetyourmother);
                photo = getResources().obtainTypedArray(R.array.photocasthowimeetyourmother);
                break;
            case "Prison Break(2015-2017)":
                nama = getResources().getStringArray(R.array.castprisonbreak);
                photo = getResources().obtainTypedArray(R.array.photocastprisonbreak);
                break;
            case "Sherlock(2010-)":
                nama = getResources().getStringArray(R.array.castsherlock);
                photo = getResources().obtainTypedArray(R.array.photocastsherlock);
                break;
            case "Stranger Things(2016-)":
                nama = getResources().getStringArray(R.array.caststrangerthings);
                photo = getResources().obtainTypedArray(R.array.photocaststrangerthings);
                break;
            case "The Big Bang Theory(2007-2019)":
                nama = getResources().getStringArray(R.array.castthebigbangteori);
                photo = getResources().obtainTypedArray(R.array.photocastthebigbangteori);
                break;
            case "The 100 (2014-)":
                nama = getResources().getStringArray(R.array.castthe100);
                photo = getResources().obtainTypedArray(R.array.photocastthe100);
                break;
            case "Orange is New Black (2013-)":
                nama = getResources().getStringArray(R.array.castorangeisnewblack);
                photo = getResources().obtainTypedArray(R.array.photocastorangeisnewblack);
                break;
            case "Lost(2014-2010)":
                nama = getResources().getStringArray(R.array.castlost);
                photo = getResources().obtainTypedArray(R.array.photocastlost);
                break;
            case "Super Natural(2005-)":
                nama = getResources().getStringArray(R.array.castsupernatural);
                photo = getResources().obtainTypedArray(R.array.photocastsupernatural);
                break;
            case "Westworld(2016-)":
                nama = getResources().getStringArray(R.array.castwestworld);
                photo = getResources().obtainTypedArray(R.array.photocastwestworld);
                break;
            case "Hannibal(2013-2015)":
                nama = getResources().getStringArray(R.array.casthannibal);
                photo = getResources().obtainTypedArray(R.array.photocasthannibal);
                break;
            case "The flash(2014-)":
                nama = getResources().getStringArray(R.array.casttheflash);
                photo = getResources().obtainTypedArray(R.array.photocasttheflash);
                break;
            case "You(2018)":
                nama = getResources().getStringArray(R.array.photocastyou);
                photo = getResources().obtainTypedArray(R.array.photocastyou);
                break;
        }
    }

    void additem(){
        for (int i = 0 ; i<nama.length;i++){
            CastandCrew p =  new CastandCrew(nama[i],photo.getResourceId(i,-1));
            data.add(p);
        }
    }

    void getData(){
        prepare();
        additem();
    }

}
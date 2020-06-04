package com.example.tugasproject4;

public class Details {
    String nama,desc,genre,time,sutradara,terbit;
    int photo;

    public Details(String nama, String desc, String genre, String time, String sutradara, String terbit, int photo) {
        this.nama = nama;
        this.desc = desc;
        this.genre = genre;
        this.time = time;
        this.sutradara = sutradara;
        this.terbit = terbit;
        this.photo = photo;
    }

    public String getNama() {
        return nama;
    }

    public String getDesc() {
        return desc;
    }

    public String getGenre() {
        return genre;
    }

    public String getTime() {
        return time;
    }

    public String getSutradara() {
        return sutradara;
    }

    public String getTerbit() {
        return terbit;
    }

    public int getPhoto() {
        return photo;
    }
}

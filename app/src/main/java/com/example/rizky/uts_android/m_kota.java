package com.example.rizky.uts_android;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class m_kota {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "namaKota")
    public String namaKota;

    public m_kota(String namaKota) {
        this.namaKota = namaKota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaKota() {
        return namaKota;
    }

    public void setNamaKota(String namaKota) {
        this.namaKota = namaKota;
    }
}

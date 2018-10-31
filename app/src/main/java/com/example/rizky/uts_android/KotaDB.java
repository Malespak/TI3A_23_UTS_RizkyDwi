package com.example.rizky.uts_android;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface KotaDB {
    @Query("SELECT * FROM M_KOTA")
    List<m_kota> getAllUsers();

    @Insert
    void insertAll(m_kota...kotas);

}

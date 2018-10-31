package com.example.rizky.uts_android;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {m_kota.class}, version = 1)
public abstract class DATABASE extends RoomDatabase {
    public abstract KotaDB kotaDB();

}

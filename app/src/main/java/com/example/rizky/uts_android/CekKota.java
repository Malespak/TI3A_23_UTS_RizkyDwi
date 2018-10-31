package com.example.rizky.uts_android;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class CekKota extends AppCompatActivity {

    RecyclerView rc;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cek_kota);

        rc = findViewById(R.id.rclist);

        DATABASE db = Room.databaseBuilder(getApplicationContext(), DATABASE.class, "Production")
                .allowMainThreadQueries()
                .build();

        List<m_kota> kotalist = db.kotaDB().getAllUsers();

        rc.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RCadapter(kotalist);
        rc.setAdapter(adapter);
    }
}

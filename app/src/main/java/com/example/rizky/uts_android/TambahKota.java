package com.example.rizky.uts_android;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TambahKota extends AppCompatActivity {

    EditText inputKota;
    Button btnSimpan, btnCek;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_kota);

        inputKota = findViewById(R.id.editKota);
        btnSimpan = findViewById(R.id.simpankota);
        btnCek = findViewById(R.id.cekkota);

        final DATABASE db = Room.databaseBuilder(getApplicationContext(), DATABASE.class, "Production")
                .allowMainThreadQueries()
                .build();

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_kota kota = new m_kota(inputKota.getText().toString());
                db.kotaDB().insertAll(kota);

                inputKota.setText("");
                Toast.makeText(TambahKota.this, "Data Di Simpan", Toast.LENGTH_LONG).show();
            }
        });

        btnCek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TambahKota.this, CekKota.class);
                startActivity(i);
            }
        });
    }
}

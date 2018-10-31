package com.example.rizky.uts_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    TextView txtUser;
    Button btnDB;
    SessionManagement sm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sm = new SessionManagement(this);
        txtUser = findViewById(R.id.txtuser);
        btnDB = findViewById(R.id.DBbutton);
        if (sm.isLoggedIn()){
            HashMap<String, String> loginUser = sm.getUserInformation();
            txtUser.setText(loginUser.get(sm.KEY_EMAIL));
        }
        btnDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TambahKota.class));
            }
        });
    }
}

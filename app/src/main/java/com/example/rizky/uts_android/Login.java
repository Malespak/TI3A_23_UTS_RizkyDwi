package com.example.rizky.uts_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText edtUser,edtPass;
    Button btnLogin;
    SessionManagement sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sm = new SessionManagement(this);
        edtUser = findViewById(R.id.editUser);
        edtPass = findViewById(R.id.editPassword);
        btnLogin = findViewById(R.id.Login);

        if (sm.isLoggedIn()){
            goToActivity();
        }
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtUser.getText().toString();
                String password = edtPass.getText().toString();
                if(email.equals("") || email.trim().isEmpty() || password.equals("") || password.trim().isEmpty() ) {
                    Toast.makeText(Login.this,"Username Password harus diisi",Toast.LENGTH_LONG).show();
                }
                else
                {
                    sm.createLoginSession(email, password);
                    goToActivity();
                }
            }
        });

    }

    private void goToActivity(){
        Intent mIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(mIntent);
    }
}

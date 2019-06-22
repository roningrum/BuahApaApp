package com.uas.buahapaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserLogin extends AppCompatActivity {
    private EditText editUsername, editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        editUsername = findViewById(R.id.et_username);
        editPassword = findViewById(R.id.et_password);
        Button masuk = findViewById(R.id.btn_Login);

        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkValidasi();
            }
        });
    }

    private void checkValidasi() {
        String username = editUsername.getText().toString();
        String password = editPassword.getText().toString();

        if(TextUtils.isEmpty(username)){
            Toast.makeText(this,"HARUS DI ISI", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"PASSWORD DIBUTUHKAN", Toast.LENGTH_SHORT).show();
        }
        else{
            masuk();
        }

    }

    private void masuk() {
        Preferences.setLoginUsername(getBaseContext(), Preferences.getLoginUser(getBaseContext()));
        Preferences.setLoginPassword(getBaseContext(), Preferences.getLoginPassword(getBaseContext()));
        startActivity(new Intent(getBaseContext(),DaftarBuahActivity.class));
        finish();
    }
}

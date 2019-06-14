package com.example.mypizzaapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {



    EditText email,password;
    private static String getEmail,getPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.inputEmail);
        password = findViewById(R.id.inpuPassword);
    }

    public void getDetails(View view) {
        //getEmail = String.valueOf(email.getText());
        //getPassword = String.valueOf(password.getText());
        //Toast.makeText(getApplicationContext(),getPassword,Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this,RegActivity.class);
        startActivity(intent);

    }

    public void getList(View view) {
        Intent intent = new Intent(this,ProductList.class);
        startActivity(intent);
    }
}


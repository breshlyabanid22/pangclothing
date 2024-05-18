package com.example.pangclothing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import Backend.Entity.Account;

public class Menu extends AppCompatActivity {
    Account account;
    Intent intent;
    TextView output_firstname, output_lastname, output_address
            , output_phonenumber, output_email, output_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        account = new Account();
        intent = getIntent();
        account = intent.getParcelableExtra("account-details");
        initId();

        output_firstname.setText(account.getFirstname());
        output_lastname.setText(account.getLastname());
        output_address.setText(account.getAddress());
        output_phonenumber.setText(String.valueOf(account.getPhoneNumber()));
        output_email.setText(account.getEmail());
        output_password.setText(account.getPassword());
    }

    private void initId(){
        output_firstname = findViewById(R.id.output_firstname);
        output_lastname = findViewById(R.id.output_lastname);
        output_address = findViewById(R.id.output_address);
        output_phonenumber = findViewById(R.id.output_phonenumber);
        output_email = findViewById(R.id.output_email);
        output_password = findViewById(R.id.output_password);

    }
}
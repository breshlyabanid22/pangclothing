package com.example.pangclothing.Signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.pangclothing.Menu;
import com.example.pangclothing.R;

import android.widget.Toast;
import Backend.Database;
import Backend.Entity.Account;

public class SignUp_B extends AppCompatActivity {

    EditText input_email, input_password;
    Button btn_back, btn_done;
    Database database;
    Account account;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_b);
        database = new Database();
        intent = getIntent();
        initId();
        btn_back.setOnClickListener(e -> startActivity(new Intent(this, SignUp_A.class)));


        btn_done.setOnClickListener(e -> {
            account = intent.getParcelableExtra("account-details");
            if (account != null) {
                account.setPassword(input_password.getText().toString());
                account.setEmail(input_email.getText().toString());
                database.writeNewUser(account);
                intent = new Intent(this, Menu.class);
                intent.putExtra("account-details", account);
                startActivity(intent);
            } else {
                // Handle the case where the account is null, e.g., show an error message to the user
                Toast.makeText(this, "Account details not found.", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initId(){
        input_email = findViewById(R.id.input_email);
        input_password = findViewById(R.id.input_password);
        btn_back = findViewById(R.id.btn_back);
        btn_done = findViewById(R.id.btn_done);
    }

}
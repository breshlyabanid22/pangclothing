package com.example.pangclothing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pangclothing.Signup.SignUp_A;

import Backend.Database;
import Backend.Entity.Account;

public class Login extends AppCompatActivity {

    private Database database;
    private Button btn_signIn, btn_signUp;
    private EditText input_email, input_password;
    private TextView pw_incorrect;
    private Account account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initId();
        initListeners();
        database = new Database();
        btn_signIn.setOnClickListener(e -> {
            //check first if data is existed in db
            //else deny access
            database.isUserExist(isDataExist -> {
                if(isDataExist){
                    //if pw is correct then proceed to menu page
                    database.getUserData(data -> {
                        if(data != null && data.getPassword().equals(input_password.getText().toString())) {
                            Intent intent = new Intent(this, Menu.class);
                            intent = intent.putExtra("account-details", account);
                            startActivity(intent);
                        }
                        else{
                            pw_incorrect.setVisibility(View.VISIBLE);
                        }
                    }, input_email.getText().toString());
                }else{
                    Toast.makeText(this, "Email or Password Incorrect", Toast.LENGTH_SHORT).show();
                }
            },input_email.getText().toString());
        });


        btn_signUp.setOnClickListener(e -> startActivity(new Intent(this, SignUp_A.class)));

    }

    private void initListeners() {
        input_password.setOnClickListener(v -> {
            if (pw_incorrect.getVisibility() == View.VISIBLE && !input_password.getText().toString().isEmpty()) {
                pw_incorrect.setVisibility(View.INVISIBLE);
                input_password.setText(null);
            }
        });
    }




    private void initId(){
        btn_signIn =  findViewById(R.id.btn_signIn);
        btn_signUp =  findViewById(R.id.btn_signUp);
        input_email = findViewById(R.id.input_email);
        input_password = findViewById(R.id.input_password);
        pw_incorrect = findViewById(R.id.pw_incorrect);
    }
}
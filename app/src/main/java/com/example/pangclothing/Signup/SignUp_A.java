package com.example.pangclothing.Signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import com.example.pangclothing.Login;
import com.example.pangclothing.R;
import Backend.Entity.Account;

public class SignUp_A extends AppCompatActivity {

    Button btn_next, btn_cancel;
    EditText input_firstname, input_lastname,input_address, input_phoneNumber;
    Intent intent;
    Account account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_a);
        initId();
        account = new Account();

        btn_cancel.setOnClickListener(e -> startActivity(new Intent(this, Login.class)));


        btn_next.setOnClickListener(e -> {
            if(!isInputEmpty()){
                intent = new Intent(this, SignUp_B.class);

                account.setFirstname(input_firstname.getText().toString());
                account.setLastname(input_lastname.getText().toString());
                account.setAddress(input_address.getText().toString());
                account.setPhoneNumber(Long.parseLong(input_phoneNumber.getText().toString()));
                intent.putExtra("account-details", account);
                startActivity(intent);
            }
        });

    }

    private void initId(){
        btn_next =  findViewById(R.id.btn_next);
        btn_cancel = findViewById(R.id.btn_cancel);
        input_firstname = findViewById(R.id.input_firstname);
        input_lastname = findViewById(R.id.input_lastname);
        input_address = findViewById(R.id.input_address);
        input_phoneNumber = findViewById(R.id.input_phoneNumber);
    }


    private boolean isInputEmpty() {
        return input_firstname.getText().toString().isEmpty() &&
                input_lastname.getText().toString().isEmpty() &&
                input_address.getText().toString().isEmpty() &&
                input_phoneNumber.getText().toString().isEmpty();
    }

}
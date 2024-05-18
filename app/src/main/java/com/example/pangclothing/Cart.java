package com.example.pangclothing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Cart extends AppCompatActivity {

    private ImageView productImage;
    private TextView productName;
    private TextView description;
    private TextView price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        productImage = findViewById(R.id.productImage);
        productName = findViewById(R.id.productName);
        description = findViewById(R.id.description);
        price = findViewById(R.id.price);

    }
}


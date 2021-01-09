package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        int total = 0;
        for(int i = 0; i < Product.cart.size(); i++){
            total += (Product.cart.get(i).getProduct().getPrice() * Product.cart.get(i).getQuantity());
        }

        TextView output = findViewById(R.id.total);
        output.setText("Total price is :" + total + "₺");
    }
}
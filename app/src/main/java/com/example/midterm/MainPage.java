package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
    }

    public void btnShowProducts(View view){
        Intent intent = new Intent(this,ProductActivity.class);
        this.startActivity(intent);
    }

    public void btnShowMyCart(View view){
        Intent intent = new Intent(this,CartActivity.class);
        this.startActivity(intent);
    }

    public void btnExit(View view){
        Intent intent = new Intent(this,MainActivity.class);
        this.startActivity(intent);
    }
}
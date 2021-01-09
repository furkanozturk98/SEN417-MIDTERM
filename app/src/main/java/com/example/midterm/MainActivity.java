package com.example.midterm;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {

    static ArrayList<Product> products = new ArrayList<>();

    String defaultUsername="admin";
    String defaultPassword="password";

    TextView username;
    TextView password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Login Page");

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        products.add(new Product("Samsung galaxy a51",3500,5,R.drawable.a51, 10));
        products.add(new Product("Samsung galaxy m51",3500,4,R.drawable.m51, 10));
        products.add(new Product("Samsung galaxy m31",2500,3,R.drawable.m31, 10));
        products.add(new Product("Samsung galaxy m21",2000,3,R.drawable.m21, 10));
        products.add(new Product("Xiaomi Mi 10T",5500,3,R.drawable.m10, 0));
        products.add(new Product("Oppo Realme 7",5500,3,R.drawable.realme7, 5));
    }
    public void btnLogin(View view){
        if(defaultUsername.contentEquals(username.getText()) && defaultPassword.contentEquals(password.getText())){
            Intent intent = new Intent(this,MainPage.class);
            this.startActivity(intent);
        }
        else {
            Toast.makeText(this,"Username or password is invalid!",Toast.LENGTH_LONG).show();
        }
    }
}
package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class ProductDetailsActivity extends AppCompatActivity {

    Product product;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        setTitle("Product Details");

        Intent intent = getIntent();
        product = (Product) intent.getExtras().getSerializable("data");

        TextView name = findViewById(R.id.name);
        TextView price = findViewById(R.id.price);
        RatingBar rating = findViewById(R.id.ratingBar);
        ImageView imageView = findViewById(R.id.imageView);


        name.setText(product.getName());
        price.setText(product.getPrice() + "₺");
        rating.setRating(product.getRating());
        imageView.setImageResource(product.getImage());

    }

    public void btnAddCart(View view){
        if(product.getQuantity() == 0){
            Toast.makeText(this,"Product quantity is 0",Toast.LENGTH_LONG).show();
            return;
        }

        boolean control = false;
        for(int i = 0; i < Product.cart.size(); i++ ){
            CartItem cartItem = Product.cart.get(i);

            if(cartItem.getProduct().getName().equals(product.getName())){
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                control = true;
            }
        }

        if(!control){
            Product.cart.add(new CartItem(product,1));
        }

        for(int i = 0; i < MainActivity.products.size(); i++ ){
           Product product2 = MainActivity.products.get(i);

           if(product2.getName().equals(product.getName())){
               product2.setQuantity(product2.getQuantity() - 1);
           }
        }

        Intent intent = new Intent(this, CartActivity.class);
        startActivity(intent);

    }
}
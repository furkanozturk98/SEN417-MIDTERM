package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        setTitle("My Cart");

        ListView listView = findViewById(R.id.lvList);

        productAdapter = new ProductAdapter(Product.cart);
        listView.setAdapter(productAdapter);

    }

    public void btnPayment(View view){
        Intent intent = new Intent(this,PaymentActivity.class);
        startActivity(intent);
    }

    public class ProductAdapter extends BaseAdapter {
        public ArrayList<CartItem> cartItems;
        public ProductAdapter(ArrayList<CartItem> cartItems) {
            this.cartItems = cartItems;
        }

        @Override
        public int getCount() {
            return cartItems.size();
        }
        @Override
        public Object getItem(int position) {
            return null;
        }
        @Override
        public long getItemId(int position) {
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = getLayoutInflater();
            View myView = inflater.inflate(R.layout.productlist, null);

            CartItem cartItem = cartItems.get(position);
            final Product product = cartItem.getProduct();

            TextView name = myView.findViewById(R.id.name);
            TextView price = myView.findViewById(R.id.price);
            ImageView image = myView.findViewById(R.id.imgView);
            TextView quantity = myView.findViewById(R.id.quantity);
            Button showDetails = myView.findViewById(R.id.btnProductDetails);

            name.setText(product.getName());
            price.setText(product.getPrice() * cartItem.getQuantity() + "₺");
            image.setImageResource(product.getImage());
            quantity.setText(cartItem.getQuantity() + " product in cart");
            showDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), ProductDetailsActivity.class);
                    intent.putExtra("data", product);
                    startActivity(intent);
                }
            });
            return myView;
        }
    }
}
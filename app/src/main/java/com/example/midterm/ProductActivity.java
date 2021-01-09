package com.example.midterm;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;
public class ProductActivity extends AppCompatActivity {
    ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        setTitle("Product List");

        ListView listView = findViewById(R.id.lvList);

        productAdapter = new ProductAdapter(MainActivity.products);
        listView.setAdapter(productAdapter);

    }
    public class ProductAdapter extends BaseAdapter {
        public ArrayList<Product> products;
        public ProductAdapter(ArrayList<Product> products) {
            this.products = products;
        }
        @Override
        public int getCount() {
            return products.size();
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
            final Product product = products.get(position);

            TextView name = myView.findViewById(R.id.name);
            TextView price = myView.findViewById(R.id.price);
            ImageView image = myView.findViewById(R.id.imgView);
            TextView quantity = myView.findViewById(R.id.quantity);
            Button showDetails = myView.findViewById(R.id.btnProductDetails);

            name.setText(product.getName());
            price.setText(product.getPrice() + "₺");
            image.setImageResource(product.getImage());
            quantity.setText(product.getQuantity() + " product in stock");

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
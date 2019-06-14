package com.example.mypizzaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProductList extends AppCompatActivity {

    RecyclerView recyclerView;
    ProductAdapter adapter;

    List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        productList=new ArrayList<>();

        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        //adding some items to our list
        productList.add(
                new Product(
                        1,

                        "Mushrooms, tomatoes, onions, black olives and bell peppers with a double layer of mozzarella cheese",
                        "Starting from Rs.510",
                        4.3,
                        1000,
                        R.mipmap.veggie));

        productList.add(
                new Product(
                        1,
                        "Rich tomato sauce with a triple layer of mozzarella cheese",
                        "Starting from Rs.510",
                        4.3,
                        1200,
                        R.mipmap.cheese));

        productList.add(
                new Product(
                        1,
                        "Chicken ham & pineapple with a double layer of mozzarella cheese",
                        "Starting from Rs.510",
                        4.3,
                        1500,
                        R.mipmap.chicken));

        adapter=new ProductAdapter(this,productList);
        recyclerView.setAdapter(adapter);
    }
}

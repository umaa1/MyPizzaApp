package com.example.mypizzaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadProducts();
    }
    private void loadProducts(){
        StringRequest stringRequest=new StringRequest(Request.Method.GET,"http://192.168.137.1:8080/demo/all",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONArray products = new JSONArray(response);
                            for (int i=0; i<products.length(); i++){
                                JSONObject productobject = products.getJSONObject(i);

                                int id=productobject.getInt("productId");
                                String title=productobject.getString("title");
                                String shortdesc= productobject.getString("sortdesc");
                                double price = productobject.getDouble("price");
                                String image=productobject.getString("image");
                                Product product=new Product(id,title,shortdesc,price,image);
                                productList.add(product);
                            }
                            adapter=new ProductAdapter(ProductList.this,productList);
                            recyclerView.setAdapter(adapter);
                        }catch(JSONException e){
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),"Error: "+error,Toast.LENGTH_LONG).show();

                    }
                });
        Volley.newRequestQueue(this).add(stringRequest);
    }
}

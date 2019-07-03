package com.example.mypizzaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class CartDetails extends AppCompatActivity {

    RecyclerView recyclerView;
    CartAdapter cartAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_details);
        recyclerView = findViewById(R.id.cartRecycler);
        loadProducts();

    }
    private void loadProducts(){
        StringRequest stringRequest=new StringRequest(Request.Method.GET,"http://172.16.43.29:8080/demo/allCartData",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        List<CartClass> cartClassList = new ArrayList<>();
                        Toast.makeText(CartDetails.this,response,Toast.LENGTH_LONG).show();
                        try{
                            JSONArray products = new JSONArray(response);
                            for (int i=0; i<products.length(); i++){
                                JSONObject productobject = products.getJSONObject(i);
                                int id = productobject.getInt("cartId");
                                int quantity = productobject.getInt("quantity");
                                String title= productobject.getString("title");
                                String description = productobject.getString("description");
                                CartClass cartClass=new CartClass(id,quantity,title,description);
                                cartClassList.add(cartClass);
                            }
                            cartAdapter=new CartAdapter(CartDetails.this,cartClassList);
                            recyclerView.setAdapter(cartAdapter);
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

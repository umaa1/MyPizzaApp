package com.example.mypizzaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

public class DetailsActivity extends AppCompatActivity {
    ImageView imageView;
    TextView titleView,descriptionView,pirceView;
    Button button;
    private static String priceDetails,titleDetails;
    private static int quantity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        imageView = findViewById(R.id.imageView);
        titleView = findViewById(R.id.title);
        descriptionView = findViewById(R.id.priceView);
        pirceView = findViewById(R.id.piceView);
        button = findViewById(R.id.addToCart);
        Intent intent = getIntent();
        String image = intent.getStringExtra("image");
        String description = intent.getStringExtra("description");
        //descriptionDetails = description;
        String title = intent.getStringExtra("title");
        titleDetails = title;
        String price = intent.getStringExtra("price");
        priceDetails = price;
        pirceView.setText(price+"0 LKR");
        //Toast.makeText(this,price,Toast.LENGTH_LONG).show();
        loadImages(image);
        titleView.setText(description);
        descriptionView.setText(title);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest stringRequest=new StringRequest(Request.Method.GET,"http://172.16.43.29:8080/demo/addCartDetails?descripton="+priceDetails+"&&title=title&&quantity=1",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(DetailsActivity.this,response,Toast.LENGTH_LONG).show();
                                Intent i = new Intent(DetailsActivity.this,CartDetails.class);
                                startActivity(i);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(),"Error: "+error,Toast.LENGTH_LONG).show();

                            }
                        })
                {
                    @Override
                    protected Map<String,String>getParams() throws AuthFailureError{
                        Map<String,String> params = new HashMap<>();
                        return params;
                    }
                };
                Volley.newRequestQueue(DetailsActivity.this).add(stringRequest);
            }
        });
    }
    private void loadImages(String image){
        Picasso.with(this).load(image).placeholder(R.mipmap.logo)
                .error(R.mipmap.ic_launcher)
                .into(imageView, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {

                    }
                });
    }
}

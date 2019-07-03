package com.example.mypizzaapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{

    private Context mCtx;
    private List<Product> productList;

    public ProductAdapter(Context mCtx, List<Product> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(mCtx);
        View view=inflater.inflate(R.layout.list_layout,null);
        return new ProductViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        final Product product=productList.get(position);
        holder.textViewTitle.setText(product.getTitle());
        holder.textViewPrice.setText(String.valueOf(product.getPrice())+"0 LKR");



        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mCtx,DetailsActivity.class);
                intent.putExtra("image",product.getImage());
                intent.putExtra("description",product.getShortdesc());
                intent.putExtra("title",product.getTitle());
                intent.putExtra("price",String.valueOf(product.getPrice()));
                mCtx.startActivity(intent);
            }
        });
        Glide.with(mCtx)
                .load(product.getImage())
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder{

        RelativeLayout relativeLayout;
        ImageView imageView;
        TextView textViewTitle, textViewDesc, textViewRating, textViewPrice;


        public ProductViewHolder(View itemView) {
            super(itemView);

            relativeLayout = itemView.findViewById(R.id.LayoutItems);
            imageView=itemView.findViewById(R.id.imageView);
            textViewTitle=itemView.findViewById(R.id.textViewTitle);
            textViewDesc=itemView.findViewById(R.id.textViewShortDesc);
            textViewRating=itemView.findViewById(R.id.textViewRating);
            textViewPrice=itemView.findViewById(R.id.textViewPrice);



        }
    }

}

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

import com.bumptech.glide.Glide;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private Context mCtx;
    private List<CartClass> cartClassList;

    public CartAdapter(Context mCtx, List<CartClass> cartClassList) {
        this.mCtx = mCtx;
        this.cartClassList = cartClassList;
    }

    @Override
    public CartAdapter.CartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(mCtx);
        View view=inflater.inflate(R.layout.list_layout,null);
        return new CartAdapter.CartViewHolder(view);

    }

    @Override
    public void onBindViewHolder(CartAdapter.CartViewHolder holder, int position) {
        final CartClass cartClass=cartClassList.get(position);
        holder.textViewDesc.setText(cartClass.getTitle());
    }

    @Override
    public int getItemCount() {
        return cartClassList.size();
    }

    class CartViewHolder extends RecyclerView.ViewHolder{

        RelativeLayout relativeLayout;
        ImageView imageView;
        TextView textViewTitle, textViewDesc, textViewRating, textViewPrice;


        public CartViewHolder(View itemView) {
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

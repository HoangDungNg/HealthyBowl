package com.example.restaurant.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurant.R;
import com.example.restaurant.Restaurant_Detail;
import com.example.restaurant.model.Restaurant;

import java.util.List;

public class RestaurantItemAdapter extends RecyclerView.Adapter<RestaurantItemAdapter.RestaurantItemViewHolder> {

    private Context context;
    private List<Restaurant> restaurantItemList;

    public RestaurantItemAdapter(Context context, List<Restaurant> RestaurantItemList) {
        this.context = context;
        this.restaurantItemList = RestaurantItemList;

    }



    @NonNull
    @Override
    public RestaurantItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.restaurant_row, parent, false);
        return new RestaurantItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantItemViewHolder holder, int position) {



        holder.name.setText(restaurantItemList.get(position).getName());
        holder.introduction.setText(restaurantItemList.get(position).getIntroduction());
        holder.bg.setImageResource(restaurantItemList.get(position).getRestaurant_imageUrl());
        holder.address.setText(restaurantItemList.get(position).getAddress());
        holder.phone.setText(restaurantItemList.get(position).getPhone());
        holder.cateFood.setText(restaurantItemList.get(position).getCate_food());



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, Restaurant_Detail.class);
                i.putExtra("restaurantName",restaurantItemList.get(position).getName());
                i.putExtra("restaurantBg",restaurantItemList.get(position).getRestaurant_imageUrl());
                i.putExtra("restaurantCate", restaurantItemList.get(position).getCate_food());
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return restaurantItemList.size();

    }

    public static class RestaurantItemViewHolder extends RecyclerView.ViewHolder{

        TextView name, introduction, address, phone, cateFood;
        ImageView bg;

        public RestaurantItemViewHolder(@NonNull View itemView){


            super(itemView);

            name = itemView.findViewById(R.id.res_name);
            introduction = itemView.findViewById(R.id.res_intro);
            address = itemView.findViewById(R.id.res_add);
            phone = itemView.findViewById(R.id.res_phone);
            bg = itemView.findViewById(R.id.res_img);
            cateFood =itemView.findViewById(R.id.cateFood);
        }


    }



}

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
import com.example.restaurant.model.FoodItem;
import com.example.restaurant.model.Restaurant;

import java.util.List;

public class FoodItemAdapter extends RecyclerView.Adapter<FoodItemAdapter.FoodItemViewHolder> {

    private Context context;
    private List<FoodItem> foodItemList;

    public FoodItemAdapter(Context context, List<FoodItem> FoodItemList) {
        this.context = context;
        this.foodItemList = FoodItemList;

    }



    @NonNull
    @Override
    public FoodItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.restaurant_detail_row, parent, false);
        return new FoodItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodItemViewHolder holder, int position) {



        holder.name.setText(foodItemList.get(position).getName());
        holder.Ingredients.setText(foodItemList.get(position).getIngredient());
        holder.food_img.setImageResource(foodItemList.get(position).getFood_imageUrl());
        holder.Price.setText(foodItemList.get(position).getPrice());


    }

    @Override
    public int getItemCount() {
        return foodItemList.size();

    }

    public static class FoodItemViewHolder extends RecyclerView.ViewHolder{

        TextView name, Ingredients, Price;
        ImageView food_img;

        public FoodItemViewHolder(@NonNull View itemView){


            super(itemView);

            name = itemView.findViewById(R.id.food_name);
            Ingredients = itemView.findViewById(R.id.food_ingredients);
            Price = itemView.findViewById(R.id.food_price);
            food_img = itemView.findViewById(R.id.food_img);
        }


    }



}

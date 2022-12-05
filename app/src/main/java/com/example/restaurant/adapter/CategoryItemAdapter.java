package com.example.restaurant.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurant.Category;
import com.example.restaurant.MainActivity;
import com.example.restaurant.R;
import com.example.restaurant.model.Account;
import com.example.restaurant.model.CategoryItem;

import java.util.List;

public class CategoryItemAdapter extends RecyclerView.Adapter<CategoryItemAdapter.CategoryItemViewHolder> {

    private Context context;
    private List<CategoryItem> CategoryItemList;

    public CategoryItemAdapter(Context context, List<CategoryItem> categoryItemList) {
        this.context = context;
        this.CategoryItemList = categoryItemList;


    }


    @NonNull
    @Override
    public CategoryItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cate_row, parent, false);
        return new CategoryItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryItemViewHolder holder, int position) {


        holder.categoryImgView.setImageResource(CategoryItemList.get(position).getImageUrl());
        holder.categoryName.setText(CategoryItemList.get(position).getTxt());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(context, Category.class);
                i.putExtra("cate",CategoryItemList.get(position).getTxt());
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return CategoryItemList.size();

    }

    public static class CategoryItemViewHolder extends RecyclerView.ViewHolder{

        TextView categoryName;
        ImageView categoryImgView;
        public CategoryItemViewHolder(@NonNull View itemView){

            super(itemView);

            categoryName = itemView.findViewById(R.id.cateTxt);
            categoryImgView = itemView.findViewById(R.id.cateImg);
        }


    }



}

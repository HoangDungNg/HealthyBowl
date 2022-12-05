package com.example.restaurant.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurant.Category;
import com.example.restaurant.R;
import com.example.restaurant.model.CategoryItem;
import com.example.restaurant.model.PopList;
import com.example.restaurant.popItemDetail;

import java.util.List;

public class PopItemAdapter extends RecyclerView.Adapter<PopItemAdapter.PopItemViewHolder> {

    Context context;
    List<PopList> PopItemList;


    public PopItemAdapter(Context context, List<PopList> popItemList) {
        this.context = context;
        this.PopItemList = popItemList;
    }


    @NonNull
    @Override
    public PopItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pop_row, parent, false);
        return new PopItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopItemViewHolder holder, int position) {

        holder.popImgView.setImageResource(PopItemList.get(position).getPop_imageUrl());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, popItemDetail.class);
                i.putExtra("popItem_img", PopItemList.get(position).getPop_imageUrl());
                context.startActivity(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return PopItemList.size();

    }

    public static class PopItemViewHolder extends RecyclerView.ViewHolder{

        ImageView popImgView;
        public PopItemViewHolder(@NonNull View itemView){

            super(itemView);


            popImgView = itemView.findViewById(R.id.popImg);
        }
    }

}

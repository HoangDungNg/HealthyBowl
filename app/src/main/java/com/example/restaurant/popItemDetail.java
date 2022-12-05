package com.example.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class popItemDetail extends AppCompatActivity {

    ImageView PopItem_Detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_item_detail);

        Intent i = getIntent();
        int imgSet = i.getIntExtra("popItem_img", R.drawable.pop_img1);
        PopItem_Detail = findViewById(R.id.PopItem_Detail);
        PopItem_Detail.setImageResource(imgSet);

        PopItem_Detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(popItemDetail.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
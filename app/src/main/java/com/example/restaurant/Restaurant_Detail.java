package com.example.restaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.restaurant.adapter.FoodItemAdapter;
import com.example.restaurant.adapter.RestaurantItemAdapter;
import com.example.restaurant.model.CategoryItem;
import com.example.restaurant.model.FoodItem;
import com.example.restaurant.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class Restaurant_Detail extends AppCompatActivity {

    RecyclerView food_view;
    FoodItemAdapter foodItemAdapter;
    List<FoodItem> foodItems;
    TextView restaurantTitle;
    ImageView resImg, cate_backBtn, restaurant_img;

    SharedPreferences cate_sharedPreferences;

    private static final String PREFERENCE_CATE_NAME = "Cate_Pref";
    private static final String PREFERENCE_CATE_TITLE = "Cate_Title";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant__detail);

        cate_backBtn = findViewById(R.id.res_backBtn);

        cate_sharedPreferences = getSharedPreferences(PREFERENCE_CATE_NAME,MODE_PRIVATE);
        SharedPreferences.Editor editor = cate_sharedPreferences.edit();

        Intent intent = getIntent();
        restaurantTitle = findViewById(R.id.resTitle);
        resImg = findViewById(R.id.restaurant_img);
        restaurant_img = findViewById(R.id.restaurant_img);

        String TitleSet = intent.getStringExtra("restaurantName");
        String CateSet = intent.getStringExtra("restaurantCate");
        int imgSet = intent.getIntExtra("restaurantBg", R.drawable.chinese_cate);

        restaurantTitle.setText(TitleSet);
        resImg.setImageResource(imgSet);

        food_view = findViewById(R.id.food_view);
        foodItems = new ArrayList<>();
        setFoodRecycler(getStr(TitleSet));

        cate_backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString(PREFERENCE_CATE_TITLE, CateSet);
                editor.apply();
                Intent i = new Intent(Restaurant_Detail.this, Category.class);
                startActivity(i);
            }
        });

        //button to mapActivity
        restaurant_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Restaurant_Detail.this,MapsActivity.class);
                i.putExtra("res_name_map", TitleSet);
                startActivity(i);
            }
        });



    }

    private void setFoodRecycler(List<FoodItem> dataList) {

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 1);
        food_view.setLayoutManager(layoutManager);
        foodItemAdapter = new FoodItemAdapter(this, dataList);
        food_view.setAdapter(foodItemAdapter);
    }

    public List getStr(String title) {

        switch (title) {
            case "Ah Lin Restaurant":
                foodItems.add(new FoodItem("Tofu Soup", "Tofu, Cabbage, Carrot", "$ 5", R.drawable.al01));
                foodItems.add(new FoodItem("Tomato Soup", "Tomato, Egg, Fish", "$ 5", R.drawable.al02));
                foodItems.add(new FoodItem("Chicken Soup", "Chicken, Cabbage, Potato", "$ 7", R.drawable.al03));
                break;

            case "Wee Ban Hee":
                foodItems.add(new FoodItem("Garlic Chicken", "Chicken, Garlic, Dark Soy Sauce", "$ 5.5", R.drawable.wbh01));
                foodItems.add(new FoodItem("Fried Chicken", "Spices, soy sauce, sugar, chicken", "$ 7.5", R.drawable.wbh02));
                foodItems.add(new FoodItem("Sesame Chicken", "honey, ketchup, soy sauce, garlic, sesame oil, chicken", "$ 8.5", R.drawable.wbh03));
                break;
            case "Tim Sum Here":
                foodItems.add(new FoodItem("Vegetable Dumpling", "cabbage, chieves", "$ 4", R.drawable.tsh01));
                foodItems.add(new FoodItem("Pork Ribs", "pork ribs, dark sauce", "$ 5", R.drawable.tsh02));
                foodItems.add(new FoodItem("Xiao Long Bao", "Pork, shrimp, crab meat", "$ 6", R.drawable.tsh03));
                break;
            case "Bah Ha Lim Restaurant":
                foodItems.add(new FoodItem("Bah Kut Teh - Soup", "pork ribs, dark soy sauce, peper", "$ 6", R.drawable.bhl01));
                foodItems.add(new FoodItem("Bah Kut Teh - Dry", "pork ribs, dark soy sauce, peper", "$ 7", R.drawable.bhl02));
                break;
            case "Gem Coffee and Tea":
                foodItems.add(new FoodItem("Ice Coffee", "-", "$ 7", R.drawable.gct01));
                foodItems.add(new FoodItem("Ice Tea", "-", "$ 3", R.drawable.gct02));
                foodItems.add(new FoodItem("Hot Coffee", "-", "$ 9", R.drawable.gct03));
                break;

            case "Sushi Tori":
                foodItems.add(new FoodItem("Egg Sushi", "Egg", "$ 3", R.drawable.st01));
                foodItems.add(new FoodItem("Salmon Sushi", "Salmon", "$ 5", R.drawable.st02));
                foodItems.add(new FoodItem("Califonia Sushi", " vinegared rice, cucumber, crab, egg, avocado", "$ 7", R.drawable.st03));
                break;

            case "Ajisen ":
                foodItems.add(new FoodItem("Cha Shu Ramen", "cha shu, egg, ramen", "$ 4", R.drawable.a01));
                foodItems.add(new FoodItem("Spicy Ramen", "spicy spices, seaweed, cha shu", "$ 4", R.drawable.a02));
                foodItems.add(new FoodItem("Beef Ramen", "Beef, egg, ramen", "$ 5", R.drawable.a03));
                break;

            case "Tako Japan":
                foodItems.add(new FoodItem("Squid Tako", "-", "$ 3", R.drawable.tj01));
                foodItems.add(new FoodItem("Ham Tako", "-", "$ 6", R.drawable.tj02));
                break;

            case "Bigmama Korean Restaurant":
                foodItems.add(new FoodItem("Bhattura ", "Tofu, Cabbage, Carrot", "$ 8", R.drawable.i01f01));
                foodItems.add(new FoodItem("Chilli Mini Idli", "Tofu, Cabbage, Carrot", "$ 7", R.drawable.i01f02));
                foodItems.add(new FoodItem("Poori", "Tofu, Cabbage, Carrot", "$ 4", R.drawable.i01f03));
                foodItems.add(new FoodItem("Onion Rava Dosai", "Tofu, Cabbage, Carrot", "$ 6", R.drawable.i01f04));
                foodItems.add(new FoodItem("Pongal", "Tofu, Cabbage, Carrot", "$ 4", R.drawable.i01f05));
                foodItems.add(new FoodItem("Vegetable Biryani", "Tofu, Cabbage, Carrot", "$ 7", R.drawable.i01f06));
                break;

            case "Kim Dae Mun Korean Food":
                foodItems.add(new FoodItem("Bambaiya Dahi Puri", "Tofu, Cabbage, Carrot", "$ 6", R.drawable.i02f01));
                foodItems.add(new FoodItem("Padpi Chaat", "Tofu, Cabbage, Carrot", "$ 1", R.drawable.i02f02));
                foodItems.add(new FoodItem("Ragda Sev Puri", "Tofu, Cabbage, Carrot", "$ 7", R.drawable.i02f03));
                foodItems.add(new FoodItem("Punjabi Samosa", "Tofu, Cabbage, Carrot", "$ 8", R.drawable.i02f04));
                foodItems.add(new FoodItem("Cheese Pav Bhaji", "Tofu, Cabbage, Carrot", "$ 7", R.drawable.i02f05));
                foodItems.add(new FoodItem("Masala Pav", "Tofu, Cabbage, Carrot", "$ 4", R.drawable.i02f06));
                break;

            case "Hanwoori Korean Restaurant":
                foodItems.add(new FoodItem("Mixed Millets Chapathi", "Tofu, Cabbage, Carrot", "$ 3", R.drawable.i03f01));
                foodItems.add(new FoodItem("Black Night Shade Leaves Soup", "Tofu, Cabbage, Carrot", "$ 7", R.drawable.i03f02));
                foodItems.add(new FoodItem("Mixed Vegetable Soup", "Tofu, Cabbage, Carrot", "$ 8", R.drawable.i03f03));
                foodItems.add(new FoodItem("Basmathi Rice", "Tofu, Cabbage, Carrot", "$ 7", R.drawable.i03f04));
                foodItems.add(new FoodItem("Peas Pulao", "Tofu, Cabbage, Carrot", "$ 7", R.drawable.i03f05));
                foodItems.add(new FoodItem("Chili Tofu", "Tofu, Cabbage, Carrot", "$ 8", R.drawable.i03f06));
                break;

            case "Todamgol Restaurant":
                foodItems.add(new FoodItem("Kaveri", "Tofu, Cabbage, Carrot", "$ 7", R.drawable.i04f02));
                foodItems.add(new FoodItem("Narmadha", "Tofu, Cabbage, Carrot", "$ 5", R.drawable.i04f02));
                foodItems.add(new FoodItem("Godavari", "Tofu, Cabbage, Carrot", "$ 4", R.drawable.i04f03));
                break;

            case "Komala Vilas Restaurant":
                foodItems.add(new FoodItem("Bibimbap", "Tofu, Cabbage, Carrot", "$ 8", R.drawable.k01f01));
                foodItems.add(new FoodItem("Moksal", "Tofu, Cabbage, Carrot", "$ 9", R.drawable.k01f02));
                foodItems.add(new FoodItem("Kimchi Soup", "Tofu, Cabbage, Carrot", "$ 7", R.drawable.k01f03));
                foodItems.add(new FoodItem("Kimchi Fried Rice", "Tofu, Cabbage, Carrot", "$ 1", R.drawable.k01f04));
                foodItems.add(new FoodItem("Doganitang", "Tofu, Cabbage, Carrot", "$ 4", R.drawable.k01f05));
                foodItems.add(new FoodItem("Soybean Soup", "Tofu, Cabbage, Carrot", "$ 8", R.drawable.k01f06));
                break;

            case "Kailash Parbat Restaurant":
                foodItems.add(new FoodItem("Pan-fried Sliced Fish", "Tofu, Cabbage, Carrot", "$ 7", R.drawable.k02f01));
                foodItems.add(new FoodItem("Ramen", "Tofu, Cabbage, Carrot", "$ 9", R.drawable.k02f02));
                foodItems.add(new FoodItem("Korean Rice Cake", "Tofu, Cabbage, Carrot", "$ 7", R.drawable.k02f03));
                foodItems.add(new FoodItem("Dumpling Soup", "Tofu, Cabbage, Carrot", "$ 8", R.drawable.k02f04));
                foodItems.add(new FoodItem("Red Bean Rice", "Tofu, Cabbage, Carrot", "$ 9", R.drawable.k02f05));
                foodItems.add(new FoodItem("Beancurd Soup", "Tofu, Cabbage, Carrot", "$ 7", R.drawable.k02f06));
                break;

            case "Greenleaf":
                foodItems.add(new FoodItem("Dubu Kimchi", "Tofu, Cabbage, Carrot", "$ 8", R.drawable.k03f01));
                foodItems.add(new FoodItem("Kimchi Jjigae", "Tofu, Cabbage, Carrot", "$ 1", R.drawable.k03f02));
                foodItems.add(new FoodItem("Godeungeo Kimchi Jorim", "Tofu, Cabbage, Carrot", "$ 8", R.drawable.k03f03));
                foodItems.add(new FoodItem("Janchi Guksu", "Tofu, Cabbage, Carrot", "$ 9", R.drawable.k03f04));
                foodItems.add(new FoodItem("Bibim Guksu", "Tofu, Cabbage, Carrot", "$ 7", R.drawable.k03f05));
                foodItems.add(new FoodItem("Japchae", "Tofu, Cabbage, Carrot", "$ 8", R.drawable.k03f06));
                break;

            case "Annalakshmi Restaurant":
                foodItems.add(new FoodItem("Mung Bean Pancake", "Tofu, Cabbage, Carrot", "$ 3", R.drawable.k04f01));
                foodItems.add(new FoodItem("Pot Stickers", "Tofu, Cabbage, Carrot", "$ 4", R.drawable.k04f02));
                foodItems.add(new FoodItem("Doenjang Jigae", "Tofu, Cabbage, Carrot", "$ 9", R.drawable.k04f03));
                foodItems.add(new FoodItem("Hot Stone Bibimbap", "Tofu, Cabbage, Carrot", "$ 6", R.drawable.k04f04));
                break;
        }
        return foodItems;
    }



}
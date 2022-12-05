package com.example.restaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.restaurant.adapter.CategoryItemAdapter;
import com.example.restaurant.adapter.RestaurantItemAdapter;
import com.example.restaurant.model.Account;
import com.example.restaurant.model.CategoryItem;
import com.example.restaurant.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class Category extends AppCompatActivity {

    RecyclerView Cate_page_view;
    RestaurantItemAdapter restaurantItemAdapter;
    List<Restaurant> restaurantList;
    TextView cateTitle;
    ImageView backBtn;

    SharedPreferences cate_sharedPreferences;

    private static final String PREFERENCE_CATE_NAME = "Cate_Pref";
    private static final String PREFERENCE_CATE_TITLE = "Cate_Title";






    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        cateTitle = findViewById(R.id.cate_title);


        backBtn = findViewById(R.id.backBtn);

        cate_sharedPreferences = getSharedPreferences(PREFERENCE_CATE_NAME,MODE_PRIVATE);

        //getCate_Title();
        Cate_page_view = findViewById(R.id.cate_page_view);
        restaurantList = new ArrayList<>();


        try{
            Intent intent = getIntent();
            String TitleSet = intent.getStringExtra("cate");
            setRestaurantRecycler(getStr(TitleSet));
            cateTitle.setText(TitleSet);
        }
        catch (Exception e){
            String pre_title = cate_sharedPreferences.getString(PREFERENCE_CATE_TITLE, null);
            setRestaurantRecycler(getStr(pre_title));
            cateTitle.setText(pre_title);
        }


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Category.this, MainActivity.class);
                SharedPreferences.Editor editor = cate_sharedPreferences.edit();
                editor.clear();
                editor.commit();
                finish();
                startActivity(i);
            }
        });
    }


    public List getStr(String title){

        if (title.equals("Chinese") ){
            restaurantList.add(new Restaurant("Ah Lin Restaurant", "Ah Lin is a contemporary dining experience that cultivates togetherness around authentic Teochew soups.", "9 Bishan Pl, Singapore 579837", "9124 5678","Chinese", R.drawable.r1));
            restaurantList.add(new Restaurant("Wee Ban Hee", "Founded in 1987, Wee Bam Hee takes pride in serving one of Singapore’s favourite and iconic dish - Sesame Chicken.", "930 Yishun Ave 2, North Wing, #B1-52 Northpoint City", "91235 2134","Chinese",  R.drawable.r2));
            restaurantList.add(new Restaurant("Tim Sum Here", "Tim Sum Here is a Singapore based brand with one-MICHELIN star and more than a 100 outets accross  25 countries. ", "78 Airport Boulevard B2 - 275, 277 ", "9123 4321","Chinese",  R.drawable.r3));
            restaurantList.add(new Restaurant("Bah Ha Lim Restaurant", "Founded in 2010, Bah Ha Lim Restaurant pride itself to be the local specialist in the well-loved traditional herbal pork ribs soup.", "Plaza Singapura, 68 Orchard Rd, 238839", "9021 2315","Chinese",  R.drawable.r4));
            restaurantList.add(new Restaurant("Gem Coffee and Tea", "Established in October 2005, Gem Coffee and Tea is a Singaporean contemporary coffee chain rooted in the recreation of Nanyang coffee and toast culture popular during the 1960s and 70s. ", "18 Yishun Ave 9, Singapore 768897", "8921 4231","Chinese",  R.drawable.r5));
        }
        else if(title.equals("Jap") ){
            restaurantList.add(new Restaurant("Sushi Tori", "One of the biggest conveyor belt sushi brands in Asia.", "1 Paya Lebar Link, PLQ 2 Paya Lebar Quarter, 408533", "9176 5678","Japanese", R.drawable.r6));
            restaurantList.add(new Restaurant("Ajisen", "Enjoy the taste of delish vegetarian noodles or dress em up any way you want." ,"50 Jurong Gateway Rd, Singapore 608549","91235 2564","Japanese",  R.drawable.r7));
            restaurantList.add(new Restaurant("Tako Japan", "Tako Japan serves takoyaki, which is a type of Japanese dumpling made up of batter.  ", "391 Orchard Rd, Singapore 238872", "9123 4081","Japanese",  R.drawable.r8));
            }
        else if(title.equals("Indian") ){
            restaurantList.add(new Restaurant("Bigmama Korean Restaurant", "Bigmama Korean Restaurant in Singapore is a friendly Asian restaurant with a devoted following. ", "2 Kim Tian Rd, Singapore 169244", "9112 5678","Indian", R.drawable.r9));
            restaurantList.add(new Restaurant("Kim Dae Mun Korean Food", "Kim Dae Mun, a Korean restaurant hidden on the first floor of Concorde Shopping Mall, serves traditional hotplate dishes and soups. Despite its unassuming appearance.", "100 Orchard Rd, Singapore 238840", "9235 2134","Indian",  R.drawable.r10));
            restaurantList.add(new Restaurant("Hanwoori Korean Restaurant", "In Singapore, Hanwoori Korean Restaurant is a brilliant example of a dining establishment with a distinct culinary identity.  ", "76 Serangoon Garden Way, Singapore 555972", "9123 1321","Indian",  R.drawable.r11));
            restaurantList.add(new Restaurant("Todamgol Restaurant", "Todamgol Restaurant takes pleasure in serving top-notch, deliciously authentic Korean cuisine that has locals in Chinatown and Tanjong Pagar Road raving. ", "31 Tg Pagar Rd, Singapore 088454", "9075 2135","Indian",  R.drawable.r12));
            }
        else{
            restaurantList.add(new Restaurant("Komala Vilas Restaurant", "Komala Vilas, one of Singapore's oldest Indian vegetarian restaurants, has been a household brand when it first opened its doors in 1947.", "78 Serangoon rd, Singapore 217981", "9124 5613","Korean", R.drawable.r13));
            restaurantList.add(new Restaurant("Kailash Parbat Restaurant", "Kailash Parbat, founded by the Mulchandani brothers in the 1950s.", "3 Belilios rd, Singapore 219924", "9145 2134","Korean",  R.drawable.r14));
            restaurantList.add(new Restaurant("Greenleaf", "Green Leaf Cafe is a nourishing. ", "43 Cuff rd, Singapore 209753 ", "9123 4321","Korean",  R.drawable.r15));
            restaurantList.add(new Restaurant("Annalakshmi Restaurant", "Eat as you want, Give as you feel,' says Annalakshmi, an Indian vegetarian restaurant with a unique eating idea. ", "20 Havelock rd, Singapore 059765", "9551 2315","Korean",  R.drawable.r16));
            }
        return restaurantList;
    }



    private void setRestaurantRecycler(List<Restaurant> dataList) {

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 1);
        Cate_page_view.setLayoutManager(layoutManager);
        restaurantItemAdapter = new RestaurantItemAdapter(this, dataList);
        Cate_page_view.setAdapter(restaurantItemAdapter);

    }

    private void getCate_Title() {

    }


}
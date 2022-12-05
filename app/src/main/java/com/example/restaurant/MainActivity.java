package com.example.restaurant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.restaurant.adapter.CategoryItemAdapter;
import com.example.restaurant.adapter.PopItemAdapter;
import com.example.restaurant.model.Account;
import com.example.restaurant.model.CategoryItem;
import com.example.restaurant.model.PopList;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycleView, popRecycleView;
    CategoryItemAdapter categoryItemAdapter;
    PopItemAdapter popItemAdapter;
    List<CategoryItem> categoryItemList;
    List<PopList> popItemList;
    DrawerLayout drawerLayout;
    private TextView hello;

    SharedPreferences sharedPreferences;

    private static final String PREFERENCE_NAME = "myPref";
    private static final String PREFERENCE_EMAIL = "pre_email";
    private static final String PREFERENCE_PASS = "pre_pass";
    private static final String PREFERENCE_USERNAME = "pre_username";

    Account account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);
        String prefer_email = sharedPreferences.getString(PREFERENCE_EMAIL,null);
        String prefer_pass = sharedPreferences.getString(PREFERENCE_PASS, null);


        hello = findViewById(R.id.Hello);
        Intent intent = getIntent();
        account = (Account) intent.getSerializableExtra("account");
        getPreUsername();



        drawerLayout = findViewById(R.id.drawerLayout);

        popRecycleView = findViewById(R.id.PopListView);
        popItemList = new ArrayList<>();
        popItemList.add(new PopList(1, R.drawable.pop_img1));
        popItemList.add(new PopList(2, R.drawable.pop_img2));
        setPopRecycler(popItemList);

        categoryRecycleView = findViewById(R.id.CateView);

        categoryItemList = new ArrayList<>();
        categoryItemList.add(new CategoryItem(1, R.drawable.al01, "Chinese"));
        categoryItemList.add(new CategoryItem(2, R.drawable.st01, "Jap"));
        categoryItemList.add(new CategoryItem(3, R.drawable.k01f01, "Korean"));
        categoryItemList.add(new CategoryItem(4, R.drawable.k01f04, "Indian"));
        setCategoryRecycler(categoryItemList);


    }

    private void getPreUsername() {
        Intent intent = getIntent();
        account = (Account) intent.getSerializableExtra("account");
        try
        {
            SharedPreferences.Editor editor =sharedPreferences.edit();
            editor.putString(PREFERENCE_USERNAME, account.getUsername());
            editor.apply();
            hello.setText(getString(R.string.app_Hello)+" "+ account.getUsername());
        }
        catch (Exception e){
            String prefer_username = sharedPreferences.getString(PREFERENCE_USERNAME, null);
            hello.setText(getString(R.string.app_Hello)+" "+ prefer_username);
        }
    }


    public void ClickMenu(View view){
        openDrawer(drawerLayout);
    }

    public void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(){
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }


    public void ClickHome(View view){
        recreate();
    }

    public void ClickProfile(View view){


        redirectActivity(this, Profile.class,account);
    }

    public void ClickEdit(View view){
        redirectActivity(this, Setting.class,account);
    }

    public void ClickAbout(View view){
        redirectActivity(this, About.class,account);
    }

    public void ClickSignOut(View view){

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
        finish();
        redirectActivity(this, SignIn.class, account);

    }

    public static void redirectActivity(Activity activity, Class aClass, Account account) {
        Intent i = new Intent(activity, aClass);
        i.putExtra("account", account);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(i);


    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }

    private void setPopRecycler(List<PopList> pop_dataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        popRecycleView.setLayoutManager(layoutManager);
        popItemAdapter = new PopItemAdapter(this, pop_dataList);
        popRecycleView.setAdapter(popItemAdapter);
    }

    private void setCategoryRecycler(List<CategoryItem> dataList) {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 4);
        categoryRecycleView.setLayoutManager(layoutManager);
        categoryItemAdapter = new CategoryItemAdapter(this, dataList);
        categoryRecycleView.setAdapter(categoryItemAdapter);
    }


}

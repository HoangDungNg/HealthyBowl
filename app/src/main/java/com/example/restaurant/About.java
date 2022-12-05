package com.example.restaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.restaurant.model.Account;

public class About extends AppCompatActivity {


    DrawerLayout drawerLayout;
    Account account;
    TextView facebook, instagram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        drawerLayout = findViewById(R.id.about_drawerLayout);

        Intent intent = getIntent();
        account = (Account) intent.getSerializableExtra("account");

        facebook = findViewById(R.id.facebook_txt);
        instagram = findViewById(R.id.instagram_txt);

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.example.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.example.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
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
        redirectActivity(this,MainActivity.class,account);
    }

    public void ClickProfile(View view){
        redirectActivity(this, Profile.class,account);
    }

    public void ClickEdit(View view){
        redirectActivity(this, Setting.class,account);
    }

    public void ClickAbout(View view){
        recreate();
    }

    public void ClickSignOut(View view){
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

}
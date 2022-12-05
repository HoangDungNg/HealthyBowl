package com.example.restaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.restaurant.model.Account;

public class Profile extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Account account;
    TextView profile_name, profile_email;

    SharedPreferences sharedPreferences;

    private static final String PREFERENCE_NAME = "myPref";
    private static final String PREFERENCE_EMAIL = "pre_email";
    private static final String PREFERENCE_PASS = "pre_pass";
    private static final String PREFERENCE_USERNAME = "pre_username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        drawerLayout = findViewById(R.id.profile_drawerLayout);

        profile_name = findViewById((R.id.profileName));
        profile_email = findViewById(R.id.profileEmail);

        loadDATA();

    }

    private void loadDATA() {

        sharedPreferences =getSharedPreferences(PREFERENCE_NAME,MODE_PRIVATE);
        String prefer_username = sharedPreferences.getString(PREFERENCE_USERNAME, null);
        String prefer_email = sharedPreferences.getString(PREFERENCE_EMAIL,null);
        String prefer_pass = sharedPreferences.getString(PREFERENCE_PASS, null);

        Intent intent = getIntent();
        account = (Account) intent.getSerializableExtra("account");
        profile_name.setText(prefer_username);
        profile_email.setText(prefer_email);
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
        recreate();
    }

    public void ClickEdit(View view){
        redirectActivity(this, Setting.class,account);
    }

    public void ClickAbout(View view){
        redirectActivity(this, About.class,account);
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
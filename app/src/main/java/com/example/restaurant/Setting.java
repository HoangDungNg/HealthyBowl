package com.example.restaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.restaurant.model.Account;

import org.w3c.dom.Text;

public class Setting extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Account account;
    EditText putTextProfilePersonName,putTextProfilePassword;
    TextView putTextProfileEmail;
    Button profileBtn;

    SharedPreferences sharedPreferences;

    private static final String PREFERENCE_NAME = "myPref";
    private static final String PREFERENCE_EMAIL = "pre_email";
    private static final String PREFERENCE_PASS = "pre_pass";
    private static final String PREFERENCE_USERNAME = "pre_username";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        sharedPreferences =getSharedPreferences(PREFERENCE_NAME,MODE_PRIVATE);
        String prefer_username = sharedPreferences.getString(PREFERENCE_USERNAME, null);
        String prefer_email = sharedPreferences.getString(PREFERENCE_EMAIL,null);
        String prefer_pass = sharedPreferences.getString(PREFERENCE_PASS, null);


        putTextProfilePersonName = findViewById((R.id.editTextProfilePersonName));
        putTextProfileEmail = findViewById(R.id.editTextProfileEmail);
        putTextProfilePassword = findViewById(R.id.editTextProfilePassword);
        loadDATA();

        drawerLayout = findViewById(R.id.setting_drawerLayout);

        profileBtn = findViewById(R.id.ProfileBtn);
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBase_sql dataBase_sql =new DataBase_sql(getApplicationContext());
                Account currentAcc = dataBase_sql.getCurrentAcc(prefer_email);
                Account temp = dataBase_sql.checkUsers(putTextProfileEmail.getText().toString());

                String password = putTextProfilePassword.getText().toString();
                if(!password.isEmpty()) {
                    currentAcc.setUsername(putTextProfilePersonName.getText().toString());
                    currentAcc.setPassword(putTextProfilePassword.getText().toString());
                }
                if(dataBase_sql.update(currentAcc)){
                    Intent intent = new Intent(Setting.this, MainActivity.class);
                    intent.putExtra("account", currentAcc);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(Setting.this, "Profile Edit Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private void loadDATA() {

        sharedPreferences =getSharedPreferences(PREFERENCE_NAME,MODE_PRIVATE);
        String prefer_username = sharedPreferences.getString(PREFERENCE_USERNAME, null);
        String prefer_email = sharedPreferences.getString(PREFERENCE_EMAIL,null);
        String prefer_pass = sharedPreferences.getString(PREFERENCE_PASS, null);

        putTextProfilePersonName.setText(prefer_username);
        putTextProfileEmail.setText(prefer_email);
        putTextProfilePassword.setText(prefer_pass);

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
        recreate();
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
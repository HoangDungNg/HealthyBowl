package com.example.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.restaurant.model.Account;

public class SignIn extends AppCompatActivity {

    EditText editTextPersonEmail, editTextPersonPassword;
    Button LogInBtn, RegisterBtn;
    DataBase_sql sqLiteDatabase;
    Account account;
    DataBase_sql dataBase_sql;
    SharedPreferences sharedPreferences;

    private static final String PREFERENCE_NAME = "myPref";
    private static final String PREFERENCE_EMAIL = "pre_email";
    private static final String PREFERENCE_PASS = "pre_pass";
    private static final String PREFERENCE_USERNAME = "pre_username";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        sqLiteDatabase = new DataBase_sql(this);
        editTextPersonEmail = findViewById(R.id.editTextPersonEmail);
        editTextPersonPassword = findViewById(R.id.editTextPersonPassword);
        LogInBtn = findViewById(R.id.LogInBtn);
        RegisterBtn = findViewById(R.id.RegisterBtn);
        sharedPreferences = getSharedPreferences(PREFERENCE_NAME,MODE_PRIVATE);




        LogInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dataBase_sql = new DataBase_sql(getApplicationContext());
                account = new Account();

                String email = editTextPersonEmail.getText().toString();
                String pass = editTextPersonPassword.getText().toString();
                Account account = dataBase_sql.LoginUser(editTextPersonEmail.getText().toString(), editTextPersonPassword.getText().toString());
                Account temp = dataBase_sql.checkUsers(editTextPersonEmail.getText().toString());

                if (temp != null) {
                    if (email.equals("") || pass.equals("")) {
                        Toast.makeText(SignIn.this, "Please fill the rest", Toast.LENGTH_SHORT).show();
                    } else {
                        Boolean emailVal = sqLiteDatabase.checkPassword(email, pass);
                        if (emailVal == true) {
                            Intent i = new Intent(SignIn.this, MainActivity.class);
                            i.putExtra("account", account);
                            SharedPreferences.Editor editor =sharedPreferences.edit();
                            editor.putString(PREFERENCE_EMAIL, editTextPersonEmail.getText().toString());
                            editor.putString(PREFERENCE_PASS, editTextPersonPassword.getText().toString());
                            editor.apply();
                            startActivity(i);
                        } else {
                            Toast.makeText(SignIn.this, "Please Enter a correct email or password", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                else{
                    Toast.makeText(SignIn.this, "123Login Failed", Toast.LENGTH_SHORT).show();
                }

            }
        });

        RegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignIn.this, Register.class);
                startActivity(i);
            }
        });

    }


}
package com.example.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.restaurant.model.Account;

public class Register extends AppCompatActivity {

    EditText editTextRegisterPersonName, editTextRegEmail, editTextRegPassword, editTextRegCheckPassword;
    Button RegBtn;
    TextView ChangeLogin;
    DataBase_sql sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextRegisterPersonName = findViewById(R.id.editTextProfilePersonName);
        editTextRegEmail = findViewById(R.id.editTextProfileEmail);
        editTextRegPassword = findViewById(R.id.editTextProfilePassword);
        editTextRegCheckPassword = findViewById(R.id.editTextProfileCheckPassword);
        RegBtn = findViewById(R.id.RegBtn);
        ChangeLogin = findViewById(R.id.ChangeLogin);

        sqLiteDatabase = new DataBase_sql(this);

        RegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DataBase_sql dataBase_sql = new DataBase_sql(getApplicationContext());
                Account account = new Account();

                account.setEmail(editTextRegEmail.getText().toString());
                account.setPassword(editTextRegPassword.getText().toString());
                account.setUsername(editTextRegisterPersonName.getText().toString());

                String username = editTextRegisterPersonName.getText().toString();
                String email = editTextRegEmail.getText().toString();
                String password = editTextRegPassword.getText().toString();
                String checkPassword = editTextRegCheckPassword.getText().toString();

                if(email.equals("") || password.equals("") || checkPassword.equals("")){
                    Toast.makeText(Register.this, "Please fill the rest", Toast.LENGTH_SHORT).show();
                }
                else{
                    if (password.equals(checkPassword)){
                        Boolean emailExisted = sqLiteDatabase.checkEmail(email);
                        if (emailExisted == false){
                                    if(dataBase_sql.create(account)) {
                                        Toast.makeText(Register.this, "Register successfully!", Toast.LENGTH_SHORT).show();
                                        Intent i = new Intent(Register.this, SignIn.class);
                                        startActivity(i);
                                    }
                                    else{
                                        Toast.makeText(Register.this, "Register Failed!", Toast.LENGTH_SHORT).show();
                                    }
                        }
                        else{
                            Toast.makeText(Register.this, "Email Existed already!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(Register.this, "Password is different with the check password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        ChangeLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Register.this, SignIn.class);
                startActivity(i);
            }
        });
    }
}
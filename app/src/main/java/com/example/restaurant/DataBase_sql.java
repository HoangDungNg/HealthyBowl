package com.example.restaurant;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.example.restaurant.model.Account;

public class DataBase_sql extends SQLiteOpenHelper{

    private static String emailCol = "email";
    private static String passwordCol = "password";
    private static String usernameCol = "username";
    private static String tableName = "users";

    public DataBase_sql(Context context){

        super(context, tableName , null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table " + tableName +"("+ emailCol + " Text primary key, " + passwordCol + " Text," + usernameCol +" Text" + ") ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop Table if exists users");
    }

    public boolean create(Account account){
        boolean result = true;
        try{
            SQLiteDatabase db = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(emailCol, account.getEmail());
            contentValues.put(passwordCol, account.getPassword());
            contentValues.put(usernameCol, account.getUsername());
            result = db.insert("users",null, contentValues) >= 0;
        }catch (Exception e){
            result = false;
        }
        return result;
    }


    public Account checkUsers(String email){
        Account account = null;
        try{
            SQLiteDatabase db = getReadableDatabase();
            Cursor cursor = db.rawQuery(" select * from users where email = ?", new String[] {email});
            if(cursor.moveToFirst()){
                account = new Account();
                account.setEmail(cursor.getString(cursor.getColumnIndex("email")));
                account.setPassword(cursor.getString(cursor.getColumnIndex("password")));
                account.setUsername(cursor.getString(cursor.getColumnIndex("username")));
            }
        }catch (Exception e){
            account = null;
        }
        return account;
    }

    public Account LoginUser(String email, String password){
        Account account = null;
        try{
            SQLiteDatabase db = getReadableDatabase();
            Cursor cursor = db.rawQuery(" select * from users where email = ? and password = ?", new String[] {email, password});
            if(cursor.moveToFirst()){
                account = new Account();
                account.setEmail(cursor.getString(0));
                account.setPassword(cursor.getString(1));
                account.setUsername(cursor.getString(2));
            }
        }catch (Exception e){
            account = null;
        }
        return account;
    }


    public boolean update(Account account){

        boolean result = true;
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(emailCol, account.getEmail());
            contentValues.put(passwordCol, account.getPassword());
            contentValues.put(usernameCol, account.getUsername());
            result = db.update("users", contentValues, emailCol + " = ?", new String[]{String.valueOf(account.getEmail())}) > 0;
        }catch (Exception e){
            result = false;
        }
        return  result;
        }

    public Boolean checkEmail(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email = ?", new String[] {email});

        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }


    public Boolean checkPassword(String email, String password){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from users where email = ? and password = ?", new String[]{email, password});
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }


    public Account getCurrentAcc(String email){
        Account account =null;
        try{
            SQLiteDatabase db = getReadableDatabase();
            Cursor cursor = db.rawQuery("select * from users where email = ?", new String[]{String.valueOf(email)});
            if(cursor.moveToFirst()){
                account = new Account();
                account.setEmail(cursor.getString(0));
                account.setPassword(cursor.getString(1));
                account.setUsername(cursor.getString(2));
            }
        }catch (Exception e){
            account = null;
        }
        return account;
    }


}

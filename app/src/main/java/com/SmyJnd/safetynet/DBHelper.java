package com.SmyJnd.safetynet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Login.db";

    public DBHelper(Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("CREATE TABLE users (signup_name TEXT, signup_address TEXT, signup_email TEXT PRIMARY KEY, signup_password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("DROP TABLE IF EXISTS users");
        onCreate(MyDB);
    }

    public boolean insertData(String signup_name, String signup_address, String signup_email, String signup_password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("signup_name", signup_name);
        contentValues.put("signup_address", signup_address);
        contentValues.put("signup_email", signup_email);
        contentValues.put("signup_password", signup_password);
        long result = MyDB.insert("users", null, contentValues);
        return result != -1;
    }

    public boolean checkEmailExists(String signup_email) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT * FROM users WHERE signup_email = ?", new String[]{signup_email});
        return cursor.getCount() > 0;
    }
    public boolean checkNameAndAddressExists(String signup_name, String signup_address) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT * FROM users WHERE signup_name = ? AND signup_address = ?", new String[]{signup_name, signup_address});
        return cursor.getCount() > 0;
    }
    public boolean checkUserExists(String signup_email, String signup_password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT * FROM users WHERE signup_email = ? AND signup_password = ?", new String[]{signup_email, signup_password});
        return cursor.getCount() > 0;
    }
    public String getUserName(String signup_email) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT signup_email FROM users WHERE signup_email = ?", new String[]{signup_email});
        if (cursor.moveToFirst()) {
            return cursor.getString(0);
        } else {
            return "";
        }
    }

    public int getUserAddress(String email) {
        return 0;
    }

//    public void getLoggedinUserDetails(String signup_email2)
//    {
//        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
//
//        String query = "SELECT * FROM users WHERE signup_email= '"+signup_email2+"' ";
//        Cursor cursor = sqLiteDatabase.rawQuery("", null);
//        if(cursor.moveToFirst()){
//            String user_profile_name = cursor.getString(1);
//            String user_profile_address = cursor.getString(2);
//            String user_profile_email = cursor.getString(3);
//        }
//    }
}




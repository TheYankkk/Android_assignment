package com.example.justeat.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    static String name="Just_eat.db";
    static int dbVersion=1;
    public DatabaseHelper(Context context) {
        super(context, name, null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        String sql="create table if not exists user(id integer primary key autoincrement,username varchar(20),password varchar(20))";
        db.execSQL("create table if not exists paid(id integer primary key autoincrement,cost integer,time varchar(20))");
        db.execSQL(sql);

    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}


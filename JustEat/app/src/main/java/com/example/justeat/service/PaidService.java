package com.example.justeat.service;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.justeat.Paid;


public class PaidService {
    private DatabaseHelper dbHelper;
    public PaidService(Context context){
        dbHelper=new DatabaseHelper(context);
    }

    public boolean upload(Paid paid){
        SQLiteDatabase sdb=dbHelper.getReadableDatabase();
        String sql="insert into paid(cost,time) values(?,?)";
        Object obj[]={paid.getCost(),paid.getTime()};
        sdb.execSQL(sql, obj);
        return true;
    }


}

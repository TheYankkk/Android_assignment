package com.example.justeat;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.justeat.service.DatabaseHelper;

public class PaidActivity extends Activity {
    private TextView tt;
    private Button sb;
    private Button ob;
    private Button lb;
    private DatabaseHelper dbHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paid);
        findViews();


        dbHelper = new DatabaseHelper(this);
        SQLiteDatabase sdb = dbHelper.getWritableDatabase();;
        Cursor cursor = sdb.query("paid", null, "id=1", null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                int paid_cost = cursor.getInt(cursor.getColumnIndex("cost"));
                String paid_time = cursor.getString(cursor.getColumnIndex("time"));
                Log.d("PaidActivity", "You have spent $" + paid_cost);

            }
            while (cursor.moveToNext());
        }
            cursor.close();
        Bundle bundle = this.getIntent().getExtras();
        int receive_cost = bundle.getInt("cost");
        tt.setText("You have paid: $ " + receive_cost);
        clickButton();
        //tvp.setText("Total: $ " + paid_cost);
    }
    private void clickButton(){
        sb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(PaidActivity.this,ShopActivity.class);
                startActivity(intent);
            }
        });
        ob.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(PaidActivity.this,OrderActivity.class);
                startActivity(intent);
            }
        });
       lb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(PaidActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    private void findViews() {
        tt = (TextView) findViewById(R.id.total);
        sb = (Button) findViewById(R.id.shop_page);
        ob=(Button) findViewById(R.id.order_history);
        lb = (Button) findViewById(R.id.logout);
    }
}


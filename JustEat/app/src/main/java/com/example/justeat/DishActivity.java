package com.example.justeat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.justeat.service.DatabaseHelper;
import com.example.justeat.service.PaidService;
import com.example.justeat.service.UserService;

public class DishActivity extends Activity implements OnItemClickListener {
    //
    List<Map<String, Object>> data = new ArrayList();        //
    List<Map<String, Object>> cdata = new ArrayList();
    //
    ListView lv;
    TextView tv;
    Button bt;
    Button ib;
    int sum_price;
    private DatabaseHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish_list);
        dbHelper=new DatabaseHelper(this);
        lv = (ListView) findViewById(R.id.listView1);
        tv = (TextView) findViewById(R.id.totalPrice);
        bt = (Button) findViewById(R.id.payBt);
        ib=(Button) findViewById(R.id.dish_information);

        final String time = getSysNowTime();
        initData();
        initLv();
        ib.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(DishActivity.this,DishFragmentActivity.class);
                startActivity(intent);
            }
        });
        bt.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View v){
                {
                    PaidService uService = new PaidService(DishActivity.this);

                    Paid paid = new Paid(); int cost = sum_price;
                    paid.setCost(cost);
                    paid.setTime(time);
                    uService.upload(paid);
                    Toast.makeText(DishActivity.this, "支付成功", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(DishActivity.this, PaidActivity.class);
                    Bundle bundleSimple = new Bundle();
                    bundleSimple.putInt("cost",cost);
                    intent.putExtras(bundleSimple);
                    startActivity(intent);
                 }
           }
        });
    }




    private void initLv() {
        DishAdapter sa = new DishAdapter(this, data, R.layout.dishdetail);
        lv.setAdapter(sa);
        lv.setOnItemClickListener(this);
    }
    
    

    private void initData() {
        for (int i = 0; i < 6; i++) {
            Map<String, Object> item = new HashMap();
            item.put("id", i);
            item.put("img", R.drawable.item1 + i);
            item.put("name", "Dish" + i);
            item.put("price", 10f + 2 * i);
            item.put("count", 0);
            data.add(item);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        Map item = data.get(arg2);
        Log.i("Msg", "arg0=" + arg0.getClass() + "  ,arg1=" + arg1.getClass());
        CheckBox box = (CheckBox) arg1.findViewById(R.id.lv_item_check);
        if (cdata.contains(item)) {
            cdata.remove(item);
            box.setChecked(false);
        } else {
            cdata.add(item);
            box.setChecked(true);
        }
        sumPrice();

    }


    public void upload(){
        SQLiteDatabase sdb=dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("cost",sum_price);
        values.put("time",getSysNowTime());
        sdb.insert("paid",null,values);
    }
    public String getSysNowTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public void sumPrice() {
        float sum = 0;
        for (Map<String, Object> item : cdata) {
            sum += (Float) item.get("price") * (Integer) item.get("count");
        }
        tv.setText("Total: $ " + sum);
        sum_price=(int)sum;
    }


}


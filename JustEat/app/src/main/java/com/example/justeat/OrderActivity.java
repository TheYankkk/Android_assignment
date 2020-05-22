package com.example.justeat;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.justeat.service.DatabaseHelper;
import com.example.justeat.order_info;
import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends Activity {
    List<order_info> orderList;
    DatabaseHelper mOpenHelper;
    SQLiteDatabase db;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        ListView lv = (ListView) findViewById(R.id.order_lv);
        orderList=new ArrayList<order_info>();
        mOpenHelper=new DatabaseHelper(this);
        db = mOpenHelper.getWritableDatabase();
        Query();
        myAdapter = new MyAdapter(this);
        // 向listview中添加Adapter
        lv.setAdapter(myAdapter);
    }
    class MyAdapter extends BaseAdapter {
        private Context context;
        private LayoutInflater inflater;

        public MyAdapter(Context context) {
            this.context = context;
            inflater = LayoutInflater.from(context);
        }
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return orderList.size();
        }
        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return null;
        }
        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // 从personList取出Person
            order_info p = orderList.get(position);
            ViewHolder viewHolder = null;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = inflater.inflate(R.layout.orderdetail, null);
                viewHolder.txt_id = (TextView) convertView
                        .findViewById(R.id.order_id);
                viewHolder.txt_cost = (TextView) convertView
                        .findViewById(R.id.order_cost);
                viewHolder.txt_time = (TextView) convertView
                        .findViewById(R.id.order_time);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            //向TextView中插入数据
            viewHolder.txt_id.setText(p.getId());
            viewHolder.txt_cost.setText(p.getCost());
            viewHolder.txt_time.setText(p.getTime());

            return convertView;
        }
    }

    class ViewHolder {
        private TextView txt_id;
        private TextView txt_cost;
        private TextView txt_time;
    }

    // 插入数据


    // 查询数据
    public void Query() {
        Cursor cursor = db.query("paid", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            String id = cursor.getString(0);
            String cost = cursor.getString(1);
            String time = cursor.getString(2);
            order_info order = new order_info(id, cost,time);
            orderList.add(order);
        }
    }

 }
package com.example.justeat;
import java.util.List;
import java.util.Map;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class DishAdapter extends BaseAdapter {
    private DishActivity activity;
    private List<Map<String,Object>>data;
    private int layout;

    public DishAdapter(DishActivity activity, List<Map<String, Object>> data,
                       int layout) {
        super();
        this.activity = activity;
        this.data = data;
        this.layout = layout;
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return data.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }

    @Override
    public View getView(int arg0, View arg1, ViewGroup arg2) {
        final Map<String,Object> item = data.get(arg0);
        View v =LayoutInflater.from(activity).inflate(layout, null);

        ImageView iv=(ImageView) v.findViewById(R.id.lv_item_img);
        iv.setImageResource((Integer) item.get("img"));

        TextView name =(TextView) v.findViewById(R.id.lv_item_name);
        name.setText(item.get("name").toString());
        TextView price =(TextView) v.findViewById(R.id.lv_item_price);
        price.setText("$ "+item.get("price").toString());

        Button addBt= (Button) v.findViewById(R.id.lv_item_add);
        Button minBt= (Button) v.findViewById(R.id.lv_item_min);
        final EditText et =(EditText) v.findViewById(R.id.lv_item_txt);
        et.setText(item.get("count").toString());

        addBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                item.put("count", (Integer)item.get("count")+1);
                et.setText(item.get("count").toString());
                activity.sumPrice();
            }
        });
        minBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Integer ct = (Integer)item.get("count")-1;
                if(ct<=0)ct=0;
                item.put("count", ct);
                et.setText(ct.toString());
                activity.sumPrice();
            }
        });

        return v;
    }

}
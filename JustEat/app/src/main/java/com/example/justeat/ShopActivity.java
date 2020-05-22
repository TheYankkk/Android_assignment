package com.example.justeat;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class ShopActivity extends Activity {
    LinearLayout shopview0;
    LinearLayout shopview1;
    LinearLayout shopview2;
    private TextView tt;

    private Button ob;
    private Button lb;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        findViews();
        shopview0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(ShopActivity.this,DishActivity.class);
                startActivity(intent);
            }
        });
        shopview1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(ShopActivity.this,DishActivity.class);
                startActivity(intent);
            }
        });
        shopview2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(ShopActivity.this,DishActivity.class);
                startActivity(intent);
            }
        });

        ob.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(ShopActivity.this,OrderActivity.class);
                startActivity(intent);
            }
        });
        lb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(ShopActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        }


    private void findViews() {
        shopview0 = (LinearLayout) findViewById(R.id.shop0_view);
        shopview1 = (LinearLayout) findViewById(R.id.shop1_view);
        shopview2 = (LinearLayout) findViewById(R.id.shop2_view);
        tt = (TextView) findViewById(R.id.total);

        ob=(Button) findViewById(R.id.order_history);
        lb = (Button) findViewById(R.id.logout);

    }
}


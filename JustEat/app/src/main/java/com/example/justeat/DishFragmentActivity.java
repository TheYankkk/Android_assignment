package com.example.justeat;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.justeat.SelectFragment;
import com.example.justeat.ResultFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


public class DishFragmentActivity extends AppCompatActivity implements SelectFragment.Callback {
    private Button fsb;
    private Button fob;
    private Button flb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dishfragment);
        findViews();
        clickButton();
    }

    @Override
    public void onItemSelected(int id) {
        ResultFragment resultFragment = (ResultFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_result);
        resultFragment.showResult(id);
    }
    private void findViews() {
        fsb = (Button) findViewById(R.id.f_shop_page);
        fob = (Button) findViewById(R.id.f_order_history);
        flb = (Button) findViewById(R.id.f_logout);
    }
    private void clickButton(){
        fsb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(DishFragmentActivity.this,ShopActivity.class);
                startActivity(intent);
            }
        });
        fob.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(DishFragmentActivity.this,OrderActivity.class);
                startActivity(intent);
            }
        });
        flb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(DishFragmentActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}

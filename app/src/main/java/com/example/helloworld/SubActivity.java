package com.example.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
    }

    @Override
    public void onBackPressed() {
        /*响应返回键*/
        Intent ret_intent = new Intent();
        setResult(RESULT_CANCELED, ret_intent);
        finish();
    }

    public void calculate(View v)
    {
        /*计算*/

        // 获取Intent数据
        Intent get_intent = getIntent();
        if(get_intent.hasExtra("num1") && get_intent.hasExtra("num2"))
        {
            // 若数据存在则处理

            double num1 = get_intent.getDoubleExtra("num1", 0);
            double num2 = get_intent.getDoubleExtra("num2", 0);

            // 设置返回数据
            Intent ret_intent = new Intent();
            ret_intent.putExtra("num1", num1);
            ret_intent.putExtra("num2", num2);
            ret_intent.putExtra("result", num1 + num2);

            setResult(RESULT_OK, ret_intent);

            finish();
        }
        else
        {
            // 数据不存在则直接返回
            onBackPressed();
        }
    }
}

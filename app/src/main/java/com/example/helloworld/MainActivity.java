package com.example.helloworld;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*活动创建*/
        Log.d("DEMO", actName + " onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startDialog(View v)
    {
        /*启动对话式的活动*/
        Log.d("DEMO", actName + " onSwitch");
        Intent intent = new Intent("com.example.helloworld.DIALOG");
        startActivity(intent);
    }

    public static void actionStart(Context context)
    {
        /*显式的启动方法*/
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
}

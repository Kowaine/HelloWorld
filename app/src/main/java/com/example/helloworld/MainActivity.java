package com.example.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*活动创建*/
        Log.d("DEMO", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        /*活动启动*/
        Log.d("DEMO", "onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        /*活动准备完毕，开始与用户交互*/
        Log.d("DEMO", "onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        /*活动暂停*/
        Log.d("DEMO", "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        /*活动停止*/
        Log.d("DEMO", "onStop");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        /*活动重启(回到栈顶)*/
        Log.d("DEMO", "onRestart");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        /*活动销毁*/
        Log.d("DEMO", "onDestroy");
        super.onDestroy();
    }
}

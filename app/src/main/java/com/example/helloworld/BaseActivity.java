package com.example.helloworld;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends AppCompatActivity {

    protected String actName = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*活动创建*/
        Log.d("DEMO", actName + " onCreate");
        super.onCreate(savedInstanceState);
        ActCollector.addAct(this);
    }

    @Override
    protected void onStart() {
        /*活动启动*/
        super.onStart();
    }

    @Override
    protected void onResume() {
        /*活动准备完毕，开始与用户交互*/
        Log.d("DEMO", actName + " onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        /*活动暂停*/
        Log.d("DEMO", actName + " onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        /*活动停止*/
        Log.d("DEMO", actName + " onStop");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        /*活动重启(回到栈顶)*/
        Log.d("DEMO", actName + " onRestart");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        /*活动销毁*/
        Log.d("DEMO", actName + " onDestroy");
        super.onDestroy();
        ActCollector.removeAct(this);
    }

    public void exit(View v)
    {
        /*完全退出应用*/
        Log.d("DEMO", actName + " onExit");
        ActCollector.finishAll();
    }

    @Override
    public void finish() {
        /*结束活动*/
        Log.d("DEMO", actName + " finish");
        super.finish();
    }
}

class ActCollector
{
    private static List<Activity> activities = new ArrayList<>();

    public static void addAct(Activity act)
    {
        Log.d("DEMO", "addAct " + act.getClass().getSimpleName());
        activities.add(act);
    }

    public static void removeAct(Activity act)
    {
        Log.d("DEMO", "removeAct " + act.getClass().getSimpleName());
        activities.remove(act);
    }

    public static void finishAll()
    {
        Log.d("DEMO", "finishAll");
        for(Activity act: activities)
        {
            if(!act.isFinishing())
            {
                act.finish();
            }
        }
    }
}

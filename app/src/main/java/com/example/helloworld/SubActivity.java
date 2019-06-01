package com.example.helloworld;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class SubActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*活动创建*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        // 获取保存的字符串并恢复
        if(savedInstanceState!=null)
        {
            String savedString = savedInstanceState.getString("input_text");
            EditText inputTextView = findViewById(R.id.input_text);
            inputTextView.setText(savedString);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d("DEMO", actName + " onSaveInstanceState");
        super.onSaveInstanceState(outState);

        // 活动销毁前保存字符串
        String inputText = ((EditText)findViewById(R.id.input_text)).getText().toString();
        outState.putString("input_text", inputText);
    }

    public static void actionStart(Context context)
    {
        /*显式的启动方法*/
        Intent intent = new Intent(context, SubActivity.class);
        context.startActivity(intent);
    }
}

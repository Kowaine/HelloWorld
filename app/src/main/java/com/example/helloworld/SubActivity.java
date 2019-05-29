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
        Log.d("run", "enter SubActivity");
    }

    @Override
    public void onBackPressed() {
        Log.d("run", "enter onBackPressed");
        Intent get_intent = getIntent();
        int num1 = get_intent.getIntExtra("num1", 0);
        int num2 = get_intent.getIntExtra("num2", 0);
        Intent ret_intent = new Intent();
        ret_intent.putExtra("num1", num1);
        ret_intent.putExtra("num2", num2);
        ret_intent.putExtra("result", num1+num2);
        setResult(RESULT_OK, ret_intent);
        finish();
    }

    public void calculate(View v)
    {
        Log.d("run", "enter calculate");
        Intent get_intent = getIntent();
        int num1 = get_intent.getIntExtra("num1", 0);
        int num2 = get_intent.getIntExtra("num2", 0);
        Intent ret_intent = new Intent();
        ret_intent.putExtra("num1", num1);
        ret_intent.putExtra("num2", num2);
        ret_intent.putExtra("result", num1+num2);
        setResult(RESULT_OK, ret_intent);
        finish();
    }
}

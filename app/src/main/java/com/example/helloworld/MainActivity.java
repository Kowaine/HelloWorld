package com.example.helloworld;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.hello_world_text);

        String content =
                "屏幕宽度为：" + getScreenWidth() + "px\n" +
                "屏幕高度为：" + getScreenHeight() + "px\n" +
                "屏幕像素密度为(px/dp)：" + getScreenDensity();
        // 测试是否能正常滚动
        for(int i=0; i<100; ++i)
        {
            content += i+"\n";
        }
        textView.setText(content);
        setMarquee(textView);
        //textView.setGravity(Gravity.TOP); //对constraint布局无效
    }
    public DisplayMetrics getDisplayMetrics(Context context)
    {
        // 从系统服务获取窗口管理器
        WindowManager windowManager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);

        // 获取显示参数
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);

        return displayMetrics;
    }

    public int getScreenWidth()
    {
        return getDisplayMetrics(MainActivity.this).widthPixels;
    }

    public int getScreenHeight()
    {
        return getDisplayMetrics(MainActivity.this).heightPixels;
    }

    public float getScreenDensity()
    {
        return getDisplayMetrics(MainActivity.this).density;
    }

    public void setMarquee(TextView textView)
    {
        /*设置跑马灯效果*/
        textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textView.setSingleLine(true);
        textView.setSelected(true);
        textView.setFocusable(true);
        textView.setFocusableInTouchMode(true);
    }
}

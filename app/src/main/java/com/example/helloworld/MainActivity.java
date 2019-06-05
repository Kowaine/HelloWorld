package com.example.helloworld;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

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
        setMarquee(textView);
        for(int i=0; i<100; ++i)
        {
            content += i+"\n";
        }
        textView.setText(content);

        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("警告");
                dialog.setMessage("说出来你可能不信，这是一条严重警告");
                dialog.setCancelable(false);
                dialog.setPositiveButton("知道了知道了", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "知道就好", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setNegativeButton("guna", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "你吼辣么大声干什么", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();
            }
        });



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

    public void setProgress(ProgressBar progressBar, int progress)
    {
        progressBar.setProgress(progress);
    }

    public void addProgress(ProgressBar progressBar, int increase)
    {
        int progress = progressBar.getProgress();
        progress += increase;
        progressBar.setProgress(progress);
    }
}

package com.example.helloworld;

import android.content.ClipData;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HelloWorldActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_world);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 装载菜单项
        getMenuInflater().inflate(R.menu.main, menu);

        // 只能通过menu间接获取item
        MenuItem item = menu.findItem(R.id.version);

        // 获取版本号
        PackageManager packageManager = getPackageManager();
        String packageName = getPackageName();
        String version = null;
        try {// try catch 语句是必需的
            version = packageManager.getPackageInfo(packageName, PackageManager.GET_CONFIGURATIONS).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        version = "版本号：" + version;

        item.setTitle(version);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /*响应菜单的点击*/

        // 判断选择项并响应
        switch(item.getItemId())
        {
            case R.id.github_item:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(getResources().getString(R.string.github_project)));
                startActivity(intent);
                break;
            case R.id.exit_item:
                finish();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        /*响应返回Intent*/

        // 判断返回来源
        switch(requestCode)
        {
            case 0:
                // 判断返回结果
                if(resultCode == RESULT_OK)
                {
                    Toast.makeText(HelloWorldActivity.this,data.getDoubleExtra("num1", 0)+"+"
                            +data.getDoubleExtra("num2", 0)+"="
                            +data.getDoubleExtra("result", 0), Toast.LENGTH_SHORT ).show();
                }
                else if(resultCode == RESULT_CANCELED)
                {
                    Toast.makeText(HelloWorldActivity.this, R.string.cal_canceled, Toast.LENGTH_SHORT);
                }
                break;
            default:
                break;
        }
    }


    public void changeString(View v)
    {
        /*按动按键更换字符串*/

        TextView text = findViewById(R.id.hello_world_text);
        Toast info;

        // 判断文字并切换到另一个
        if(text.getText() == getResources().getString(R.string.hello_string))
        {
            text.setText(R.string.goodbye_string);
            info = Toast.makeText(HelloWorldActivity.this, R.string.goodbye_string, Toast.LENGTH_SHORT);
        }
        else
        {
            text.setText(R.string.hello_string);
            info = Toast.makeText(HelloWorldActivity.this, R.string.hello_string, Toast.LENGTH_SHORT);
        }
        info.show();
    }

    public void openGithubHome(View v)
    {
        // 隐式Intent打开浏览器访问github主页
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getResources().getString(R.string.github_home)));
        startActivity(intent);
    }

    public void startCalculateActivity(View v)
    {
        /*将两个数字隐式Intent传送*/

        // 获取输入栏内两个数字，为空则提示用户输入
        String num_string1 = ((EditText)findViewById(R.id.num1)).getText().toString();
        String num_string2 = ((EditText)findViewById(R.id.num2)).getText().toString();
        if(num_string1.equals("") || num_string2.equals(""))
        {
            // 提示用户输入
            Toast.makeText(HelloWorldActivity.this, R.string.null_input, Toast.LENGTH_SHORT);
        }
        else
        {
            // 正常传输数据

            double num1 = Double.parseDouble(num_string1);
            double num2 = Double.parseDouble(num_string2);

            // 设置Intent参数
            Intent intent = new Intent("com.example.helloworld.CALCULATE");
            intent.putExtra("num1", num1);
            intent.putExtra("num2", num2);

            startActivityForResult(intent, 0);
        }
    }
}

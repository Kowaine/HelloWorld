package com.example.helloworld;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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
        Log.d("run", "enter onActivityResult");
        switch(requestCode)
        {
            case 0:
                if(resultCode == RESULT_OK)
                {
                    Toast.makeText(HelloWorldActivity.this,data.getIntExtra("num1", 0)+"+"
                            +data.getIntExtra("num2", 0)+"="
                            +data.getIntExtra("result", 0), Toast.LENGTH_SHORT ).show();
                }
                break;
            default:
                break;
        }
    }

    //按动按键更换字符串
    public void changeString(View v)
    {
        TextView text = (TextView) findViewById(R.id.hello_world_text);
        Toast info;
        if(text.getText() == getResources().getString(R.string.hello_string))
        {
            text.setText(R.string.changed_string);
            info = Toast.makeText(HelloWorldActivity.this, R.string.changed_string, Toast.LENGTH_SHORT);
        }
        else
        {
            text.setText(R.string.hello_string);
            info = Toast.makeText(HelloWorldActivity.this, R.string.hello_string, Toast.LENGTH_SHORT);
        }
        info.show();
    }

    public void openBrowser(View v)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getResources().getString(R.string.github_home)));
        startActivity(intent);
    }

    public void changeActivity(View v)
    {
        Log.d("run", "enter changeActivity");
        int num1 = ((EditText)findViewById(R.id.num1)).getText().toString().equals("")?0:Integer.parseInt(((EditText)findViewById(R.id.num1)).getText().toString());
        int num2 = ((EditText)findViewById(R.id.num2)).getText().toString().equals("")?0:Integer.parseInt(((EditText)findViewById(R.id.num2)).getText().toString());;
        Intent intent = new Intent("com.example.hellowold.CALCULATE");
        intent.putExtra("num1", num1);
        intent.putExtra("num2", num2);
        startActivityForResult(intent, 0);
        Log.d("run", "quit changeActivity");
    }
}

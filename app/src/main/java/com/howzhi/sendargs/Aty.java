package com.howzhi.sendargs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.howzhi.sendargs.domain.User;

public class Aty extends AppCompatActivity {

    private TextView tview;
    private EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aty);
        edit = (EditText) findViewById(R.id.editText);
        Intent it = getIntent();
        TextView tv = (TextView) findViewById(R.id.tv);
       // tv.setText(it.getStringExtra("data")); //普通对象
        //Bundle data = it.getExtras(); //不指定key
       // Bundle data = it.getBundleExtra("data"); //指定key
       // tv.setText(String.format("name=%s,age=%d, addr=%s", data.getString("name"), data.getInt("age"),data.getString("addr", "zhejiang-hangzhou")));


       // User user = (User) it.getSerializableExtra("user");
            User user = it.getParcelableExtra("user");
        tv.setText(String.format("name=%s,age=%d", user.getUserName(), user.getAge()));


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                setResult(1, i.putExtra("data",edit.getText().toString()));
                finish(); //结束当前atciviy
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_aty, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

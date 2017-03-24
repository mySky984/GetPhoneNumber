package com.lfq.zzuli.getphonenumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.lfq.zzuli.getphonenumber.adapter.MyAdapter;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Getmyphonenumber.getPhoneNumber(this);
        //获得ListView的实例
        listView = (ListView) findViewById(R.id.lv);
        myAdapter = new MyAdapter(Getmyphonenumber.lists,getApplicationContext());
        //加载适配器
        listView.setAdapter(myAdapter);
    }
}

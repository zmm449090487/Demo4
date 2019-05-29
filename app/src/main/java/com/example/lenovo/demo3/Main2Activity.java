package com.example.lenovo.demo3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.util.ArrayList;

import adapter.MyPagerAdapter;
import bean.ResultsBean;

public class Main2Activity extends AppCompatActivity {

    private ViewPager mVp;
    private ArrayList<View> list;
    private MyPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
//

        mVp = (ViewPager) findViewById(R.id.vp);
//
//        Intent intent = getIntent();
//        for (int i = 0; i < 10; i++) {
//            String url = intent.getStringExtra("url");
//            list.add()
//        }
//
//        list = new ArrayList<>();
//        adapter = new MyPagerAdapter(list);
//        mVp.setAdapter(adapter);


    }
}

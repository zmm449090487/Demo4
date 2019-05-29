package com.example.lenovo.demo3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import adapter.MyAdapter;
import adapter.MyPagerAdapter;
import bean.ResultsBean;
import presenter.PresenterImpl;
import view.IView;

public class MainActivity extends AppCompatActivity implements IView, View.OnClickListener {

    private RecyclerView mRec;
    private MyAdapter adapter;
//    private ViewPager mVp;
//    private TextView mTv;
    private ArrayList<ResultsBean> list;
    private ImageView img;
//    private ArrayList<View> pagerList;
//    private MyPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//张苗苗
        initView();
        initMvp();
    }

    private void initMvp() {
        PresenterImpl presenter = new PresenterImpl(this);
        presenter.updataData();
    }

    private void initView() {
        mRec = (RecyclerView) findViewById(R.id.rec);

        list = new ArrayList<>();
        mRec.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(this,list);
        mRec.setAdapter(adapter);


//        adapter.setOnClick(new MyAdapter.OnClick() {
//            @Override
//            public void OnClick(ResultsBean resultsBean, int position) {
//                String url = resultsBean.getUrl();
//                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
//                for (int i = 0; i < list.size(); i++) {
//                    intent.putExtra("url",url);
//                }
//                startActivity(intent);
//            }
//        });

//        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
//        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);//不设置的话，图片闪烁错位，有可能有整列错位的情况。
//        mRec.setLayoutManager(layoutManager);

//        pagerList = new ArrayList<View>();
//
//        pagerAdapter = new MyPagerAdapter(pagerList);
//        mVp.setAdapter(pagerAdapter);

//        adapter.setOnClick(new MyAdapter.OnClick() {
//            @Override
//            public void OnClick(ResultsBean resultsBean, int position) {
//                mRec.setVisibility(View.GONE);
//                mVp.setVisibility(View.VISIBLE);
//                mTv.setVisibility(View.VISIBLE);
//
//                for (int i = 0; i < list.size(); i++) {
//                    View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.img_item_layout,null);
//                    img = view.findViewById(R.id.img);
//                    img.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            //当点击图片的时候让RecyclerView显示,vp和txt隐藏
//                            mRec.setVisibility(View.VISIBLE);
//                            mVp.setVisibility(View.GONE);
//                            mTv.setVisibility(View.GONE);
//                        }
//                    });
//
//                    //点击哪个图片显示哪个图片
//                    mVp.setCurrentItem(position);
//                    Glide.with(MainActivity.this).load(list.get(i).getUrl()).into(img);
//                    pagerList.add(view);
//                }
//                pagerAdapter.notifyDataSetChanged();
//            }
//
//
//        });
        //pager监听
//        mVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int i, float v, int i1) {
//
//            }
//
//            @Override
//            public void onPageSelected(int i) {
//                mTv.setText(i+"1"+"/"+20);
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int i) {
//
//            }
//        });

        mRec.setOnClickListener(this);
//        mVp = (ViewPager) findViewById(R.id.vp);
//        mTv = (TextView) findViewById(R.id.tv);
    }

    private static final String TAG = "MainActivity";

    @Override
    public void updataSuccess(List<ResultsBean> resultsBeans) {
        adapter.addData(resultsBeans);
    }

    @Override
    public void updataError(String error) {
        Log.d(TAG, "updataError: " + error);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.rec:
                break;
        }
    }
}

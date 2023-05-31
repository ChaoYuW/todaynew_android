package com.wdit.today_new_android.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.wdit.today_new_android.R;
import com.wdit.today_new_android.adapter.MyPagerAdapter;
import com.wdit.today_new_android.entity.TabEntity;
import com.wdit.today_new_android.fragment.HomeFragment;

import java.util.ArrayList;

public class HomeActivity extends BaseActivity {

    private String selectedColor = "#6200EE";
    private String unSelectedColor = "#888888";
    private String[] mTitles = {"首页", "资讯","","消息", "我的"};
    private int[] mIconUnselectIds = {
            R.mipmap.home_unselect,
            R.mipmap.collect_unselect,
            R.mipmap.collect_unselect,
            R.mipmap.collect_unselect,
            R.mipmap.my_unselect};
    private int[] mIconSelectIds = {
            R.mipmap.home_selected,
            R.mipmap.collect_selected,
            R.mipmap.collect_selected,
            R.mipmap.collect_selected,
            R.mipmap.my_selected};

    private LinearLayout l_tab;
    // 底部Tab Fragment
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    // 底部Tab 每一项的数据配置
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    // ViewPager 容器
    private ViewPager viewPager;
    // Tab 容器
    private CommonTabLayout commonTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int initLayout() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
        viewPager = findViewById(R.id.viewpager);
        l_tab = findViewById(R.id.l_tab);
        initTabBar();
    }
    private void clickMTab(int i) {;
        Log.e("hhh", String.valueOf(i));
        for (int p = 0; p < l_tab.getChildCount(); p++) {
            if (p != 2) {
                LinearLayout l = (LinearLayout)l_tab.getChildAt(p);
                ImageView imageView = (ImageView)l.getChildAt(0);
                TextView textView = (TextView)l.getChildAt(1);
                textView.setTextColor(Color.parseColor(unSelectedColor));
                imageView.setImageResource(mIconUnselectIds[p]);
                imageView.setColorFilter(Color.parseColor(unSelectedColor));
                Log.e("text" + String.valueOf(p), textView.getText().toString());
            }
        }
        if (i != 2) {
            LinearLayout l = (LinearLayout)l_tab.getChildAt(i);
            ImageView imageView = (ImageView)l.getChildAt(0);
            TextView textView = (TextView)l.getChildAt(1);
            imageView.setImageResource(mIconSelectIds[i]);
            textView.setTextColor(Color.parseColor(selectedColor));
            imageView.setColorFilter(Color.parseColor(selectedColor));
            Log.e("text" + String.valueOf(i), textView.getText().toString());
        }
    }

    private void initTabBar() {
        clickMTab(0);
        for (int i = 0; i < l_tab.getChildCount(); i++) {
            if (i != 2) {
                LinearLayout l = (LinearLayout)l_tab.getChildAt(i);
                l.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int i = l_tab.indexOfChild(view);
                        clickMTab(i);
                        viewPager.setCurrentItem(i);
                    }
                });
            } else {
                LinearLayout l = (LinearLayout)l_tab.getChildAt(i);
//                ImageView imageView = (ImageView)l.getChildAt(0);
//                imageView.setColorFilter(R.color.colorPink);
                l.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        Intent in = new Intent(mContext, PublishActivity.class);
//                        startActivity(in);
                    }
                });
            }
        }
    }


    @Override
    protected void initData() {

        mFragments.add(HomeFragment.newInstance());
        mFragments.add(HomeFragment.newInstance());
        mFragments.add(HomeFragment.newInstance());
        mFragments.add(HomeFragment.newInstance());
        mFragments.add(HomeFragment.newInstance());

        // mTabEntities 初始化
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        // 设置预先加载 Fragment，防止快速切换BUG
        viewPager.setOffscreenPageLimit(mFragments.size());

        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), mTitles, mFragments));
    }
}
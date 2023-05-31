package com.wdit.today_new_android.activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.wdit.today_new_android.R;
import com.wdit.today_new_android.adapter.MyPagerAdapter;

import java.util.ArrayList;

public class HomeActivity extends BaseActivity {

    private String[] mTitles = {"首页", "资讯", "我的"};
    private int[] mIconUnselectIds = {
            R.mipmap.home_unselect,
            R.mipmap.collect_unselect,
            R.mipmap.my_unselect};
    private int[] mIconSelectIds = {
            R.mipmap.home_selected,
            R.mipmap.collect_selected,
            R.mipmap.my_selected};
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
        commonTabLayout = findViewById(R.id.commonTabLayout);
    }

    @Override
    protected void initData() {

        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), mTitles, mFragments));
    }
}
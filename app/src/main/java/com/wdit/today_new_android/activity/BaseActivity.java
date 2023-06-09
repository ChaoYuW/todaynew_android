package com.wdit.today_new_android.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public abstract class BaseActivity extends AppCompatActivity {
    public Context mContext;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(initLayout());
        initView();
        initData();
    }

    protected abstract int initLayout();

    protected abstract void initView();

    protected abstract void initData();
    /**
     * @desc Toast 提示
     * @param msg
     */
    public void showToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }
    /**
     * @desc 同步 Toast 提示
     * @param msg
     */
    public void showToastSync(String msg) {
        Looper.prepare();
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
        Looper.loop();
    }

    /**
     * @desc 插入新的值
     * @param key
     * @param val
     */
    protected void insertVal(String key, String val) {
        SharedPreferences sp = getSharedPreferences("sp_ttit", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, val);
        editor.commit();
    }
    /**
     * @desc 获取值
     * @param key
     * @return
     */
    protected String findByKey(String key) {
        SharedPreferences sp = getSharedPreferences("sp_ttit", MODE_PRIVATE);
        return sp.getString(key, "");
    }
    /**
     * @desc 打开新页面
     * @param cls 新页面
     */
    public void navigateTo(Class cls) {
        Intent in = new Intent(mContext, cls);
        startActivity(in);
    }
    /**
     * @desc 打开新页面，并且指定类型
     * @param cls
     * @param flags
     */
    public void navigateToWithFlag(Class cls, int flags) {
        Intent in = new Intent(mContext, cls);
        in.setFlags(flags);
        startActivity(in);
    }

//    protected VideoViewManager getVideoViewManager() {
//        return VideoViewManager.instance();
//    }
//
//    @NonNull
//    @Override
//    public AppCompatDelegate getDelegate() {
//        return SkinAppCompatDelegateImpl.get(this, this);
//    }
}

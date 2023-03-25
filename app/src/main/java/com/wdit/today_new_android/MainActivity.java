package com.wdit.today_new_android;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wdit.today_new_android.activity.BaseActivity;
import com.wdit.today_new_android.activity.LoginActivity;
import com.wdit.today_new_android.activity.RegisterActivity;

public class MainActivity extends BaseActivity {

    private Button btnLogin;
    private Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        btnLogin = findViewById(R.id.btn_login);

        btnRegister = findViewById(R.id.btn_register);

    }

    @Override
    protected void initData() {
        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
//                Intent in = new Intent(MainActivity.this, LoginActivity.class);
//                startActivity(in);
                navigateTo(LoginActivity.class);
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent in = new Intent(MainActivity.this, RegisterActivity.class);
//                startActivity(in);
                navigateTo(RegisterActivity.class);
            }
        });
    }
}
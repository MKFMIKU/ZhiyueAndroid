package com.kffuck.mikum.zhiyue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.kffuck.mikum.zhiyue.init.Guide;
import com.kffuck.mikum.zhiyue.model.AccountObj;
import com.kffuck.mikum.zhiyue.model.UserObj;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MAL";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //App启动初始化
        CheckLogin();
    }


    //检查是否登陆，没登陆跳转到init块
    private void CheckLogin() {
        if (!AccountObj.isLogin(this)) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, Guide.class);
            startActivity(intent);
        }
    }
}

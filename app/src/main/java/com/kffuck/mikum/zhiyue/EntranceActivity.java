package com.kffuck.mikum.zhiyue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kffuck.mikum.zhiyue.init.Guide;
import com.kffuck.mikum.zhiyue.model.AccountObj;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class EntranceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Init();
        CheckLogin();

    }

    private void Init() {
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(this);
        ImageLoader.getInstance().init(configuration);
    }

    private void CheckLogin() {
        if (!AccountObj.isLogin(getApplicationContext())) {
            startActivity(new Intent(EntranceActivity.this, Guide.class));
        } else {
            startActivity(new Intent(EntranceActivity.this, MainActivity.class));
        }
    }
}

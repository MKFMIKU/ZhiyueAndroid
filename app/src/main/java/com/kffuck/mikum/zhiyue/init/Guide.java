package com.kffuck.mikum.zhiyue.init;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.kffuck.mikum.zhiyue.R;
import com.nostra13.universalimageloader.core.ImageLoader;

public class Guide extends AppCompatActivity {

    private ImageView background_img;
    private Button loginButton, signButton, qqButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();

        background_img = (ImageView) findViewById(R.id.background_img);
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage("drawable://"+R.drawable.big_bg, background_img);


        loginButton = (Button) findViewById(R.id.loginButton);
        signButton = (Button) findViewById(R.id.signButton);
        qqButton = (Button) findViewById(R.id.qqButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent().setClass(Guide.this, login.class));
            }
        });

        signButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent().setClass(Guide.this, sign.class));
            }
        });

        qqButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "QQ Login", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

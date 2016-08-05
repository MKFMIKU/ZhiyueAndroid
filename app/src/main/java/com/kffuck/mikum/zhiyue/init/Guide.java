package com.kffuck.mikum.zhiyue.init;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.kffuck.mikum.zhiyue.R;

public class Guide extends AppCompatActivity {

    private Button loginButton, signButton, qqButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

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

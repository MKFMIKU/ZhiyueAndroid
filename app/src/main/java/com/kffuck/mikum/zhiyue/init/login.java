package com.kffuck.mikum.zhiyue.init;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.kffuck.mikum.zhiyue.R;

public class login extends AppCompatActivity {

    private Button loginAction;
    private EditText idInput, passwdInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init_login);

        loginAction = (Button) findViewById(R.id.loginAction);

        idInput = (EditText) findViewById(R.id.idInput);
        passwdInput = (EditText) findViewById(R.id.passwdInput);

        loginAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}

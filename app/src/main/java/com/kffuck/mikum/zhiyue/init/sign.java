package com.kffuck.mikum.zhiyue.init;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kffuck.mikum.zhiyue.MainActivity;
import com.kffuck.mikum.zhiyue.R;
import com.kffuck.mikum.zhiyue.commn.Global;
import com.kffuck.mikum.zhiyue.model.AccountObj;
import com.kffuck.mikum.zhiyue.network.AccountHttp;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class sign extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init_sign);

        final EditText email,nickname,realname,phone,school,password;
        email = (EditText) findViewById(R.id.sign_email);
        nickname = (EditText) findViewById(R.id.sign_nickname);
        realname = (EditText) findViewById(R.id.sign_realname);
        phone = (EditText) findViewById(R.id.sign_phone);
        school = (EditText) findViewById(R.id.sign_school);
        password = (EditText) findViewById(R.id.sign_password);

        final Button sign = (Button) findViewById(R.id.sign_sign);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestParams params = new RequestParams();
                params.put("email", email.getText().toString());
                params.put("nickname", nickname.getText().toString());
                params.put("phone", phone.getText().toString());
                params.put("name", realname.getText().toString());
                params.put("school", school.getText().toString());
                params.put("password", password.getText().toString());

                AccountHttp.post("/sign", params, new JsonHttpResponseHandler(){
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        try {
                            int code = response.getInt("code");
                            String msg = response.getString("msg");
                            if (code == 200) {
                                if (msg.equals("ok")) {
                                    Toast.makeText(getApplicationContext(), "注册成功", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent().setClass(sign.this, login.class));
                                }
                            }

                        }catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                        Log.w("NetWork", throwable);
                        Toast.makeText(getApplicationContext(), "NetWork Error", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}

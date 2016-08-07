package com.kffuck.mikum.zhiyue.init;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kffuck.mikum.zhiyue.MainActivity;
import com.kffuck.mikum.zhiyue.R;
import com.kffuck.mikum.zhiyue.model.AccountObj;
import com.kffuck.mikum.zhiyue.model.UserObj;
import com.kffuck.mikum.zhiyue.network.AccountHttp;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;


import org.json.JSONObject;


import cz.msebera.android.httpclient.Header;

public class login extends AppCompatActivity {

    private Button loginAction;
    private EditText emailInput, passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init_login);

        loginAction = (Button) findViewById(R.id.loginAction);

        emailInput = (EditText) findViewById(R.id.emailInput);
        passwordInput = (EditText) findViewById(R.id.passwdInput);

        loginAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailData = emailInput.getText().toString();
                String passwordData = passwordInput.getText().toString();
                loginCheck(emailData, passwordData);
            }
        });
    }

    private boolean loginCheck(String email, String password) {
        if (email.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Email is empty", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (password.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Password is empty", Toast.LENGTH_SHORT).show();
            return false;
        }

        final RequestParams requestParams = new RequestParams();
        requestParams.put("email", email);
        requestParams.put("password", password);


        AccountHttp.post("/login", requestParams, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    int code = response.getInt("code");
                    String msg = response.getString("msg");
                    if (code == 200) {
                        if (msg.equals("ok")) {
                            JSONObject data = response.getJSONObject("result");
                            UserObj myUser = new UserObj(data);
                            Toast.makeText(getApplicationContext(), "Welcome " + myUser.nickname, Toast.LENGTH_SHORT).show();
                            AccountObj.saveAccount(getApplicationContext(), myUser);
                            startActivity(new Intent().setClass(login.this, MainActivity.class));
                        }
                    } else
                        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Log.w("NetWork", throwable);
                Toast.makeText(getApplicationContext(), "NetWork Error", Toast.LENGTH_SHORT).show();
            }
        });
        return false;
    }

}

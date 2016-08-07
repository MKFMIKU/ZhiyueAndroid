package com.kffuck.mikum.zhiyue.square;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.kffuck.mikum.zhiyue.MainActivity;
import com.kffuck.mikum.zhiyue.init.login;
import com.kffuck.mikum.zhiyue.model.AccountObj;
import com.kffuck.mikum.zhiyue.model.UserObj;
import com.kffuck.mikum.zhiyue.network.SquareHttp;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.rey.material.widget.Button;

import com.kffuck.mikum.zhiyue.R;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class EditTweet extends AppCompatActivity {
    private UserObj myUser;
    private EditText contentEdit;
    private Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);

        myUser = AccountObj.loadAccount(this);
        contentEdit = (EditText) findViewById(R.id.SquareContent);
        buttonSend = (Button) findViewById(R.id.TweetSub);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String content = contentEdit.getText().toString();
                RequestParams params = new RequestParams();
                params.put("userId", myUser.nickname);
                params.put("content", content);

                SquareHttp.post("/post", params, new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        try {
                            int code = response.getInt("code");
                            String msg = response.getString("msg");
                            if (code == 200) {
                                if (msg.equals("ok")) {
                                    Toast.makeText(getApplicationContext(), "Send OK", Toast.LENGTH_SHORT).show();
                                }
                            } else
                                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
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

package com.kffuck.mikum.zhiyue.init;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.kffuck.mikum.zhiyue.R;
import com.kffuck.mikum.zhiyue.commn.Global;

public class sign extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init_sign);

        WebView SignWeb = (WebView) findViewById(R.id.SignWeb);

        WebSettings webSettings = SignWeb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        SignWeb.loadUrl(Global.HOST + "/sign.html");
    }
}

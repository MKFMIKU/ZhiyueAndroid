package com.kffuck.mikum.zhiyue.square;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.kffuck.mikum.zhiyue.R;
import com.kffuck.mikum.zhiyue.commn.Global;
import com.rey.material.widget.FloatingActionButton;

public class SquareFragment extends Fragment {
    private WebView SquareWeb;
    private FloatingActionButton squareButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pager_public, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        InitWeb();

        squareButton = (FloatingActionButton) getActivity().findViewById(R.id.SquareButton);
        squareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), EditTweet.class));
            }
        });
    }

    private void InitWeb() {
        SquareWeb = (WebView) getActivity().findViewById(R.id.SquareWeb);
        WebSettings webSettings = SquareWeb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        SquareWeb.loadUrl(Global.HOST + "/square.html");
    }
}

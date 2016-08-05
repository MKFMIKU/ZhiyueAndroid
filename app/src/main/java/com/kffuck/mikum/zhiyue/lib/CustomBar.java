package com.kffuck.mikum.zhiyue.lib;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CustomBar extends Activity {
    private ViewGroup bars = null;
    private int atIndex = 0;

    public CustomBar(ViewGroup view) {
        this.bars = view;
    }

    private void hideBar(Integer index) {
        ViewGroup focusBarNow = (ViewGroup) bars.getChildAt(index);
        TextView textView = (TextView) focusBarNow.getChildAt(1);
        textView.setVisibility(View.GONE);
    }

    private void showBar(Integer index) {
        ViewGroup focusBarNow = (ViewGroup) bars.getChildAt(index);
        TextView textView = (TextView) focusBarNow.getChildAt(1);
        textView.setVisibility(View.VISIBLE);
    }

    public void focusbar(Integer index) {
        hideBar(atIndex);
        showBar(index);
        atIndex = index;
    }
}

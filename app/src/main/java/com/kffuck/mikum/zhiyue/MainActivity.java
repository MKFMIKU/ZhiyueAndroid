package com.kffuck.mikum.zhiyue;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kffuck.mikum.zhiyue.init.Guide;
import com.kffuck.mikum.zhiyue.lib.CustomBar;
import com.kffuck.mikum.zhiyue.model.AccountObj;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<View> viewList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //App启动初始化
        CheckLogin();
        InitPager();
    }


    //检查是否登陆，没登陆跳转到init块
    private void CheckLogin() {
        if (!AccountObj.isLogin(this)) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, Guide.class);
            startActivity(intent);
        }
    }

    private void InitPager() {
        final ViewGroup custom_bar = (ViewGroup) getLayoutInflater().inflate(R.layout.custom_actionbar, null);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(custom_bar);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

        final CustomBar customBar = new CustomBar(custom_bar);

        LayoutInflater layoutInflater = getLayoutInflater();
        View publicView = layoutInflater.inflate(R.layout.pager_public, null);
        View recommnView = layoutInflater.inflate(R.layout.pager_recommn, null);
        View gridView = layoutInflater.inflate(R.layout.pager_grid, null);
        View userView = layoutInflater.inflate(R.layout.pager_user, null);

        viewList = new ArrayList<View>();
        viewList.add(publicView);
        viewList.add(recommnView);
        viewList.add(gridView);
        viewList.add(userView);

        PagerAdapter pagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return viewList.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(viewList.get(position));
                return viewList.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(viewList.get(position));
            }

            @Override
            public void setPrimaryItem(ViewGroup container, int position, Object object) {
                customBar.focusbar(position);
            }
        };
        assert viewPager != null;
        viewPager.setAdapter(pagerAdapter);
    }
}

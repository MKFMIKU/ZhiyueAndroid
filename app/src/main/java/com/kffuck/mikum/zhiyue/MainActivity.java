package com.kffuck.mikum.zhiyue;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.kffuck.mikum.zhiyue.grid.GridFragment;
import com.kffuck.mikum.zhiyue.recommn.RecommnFragment;
import com.kffuck.mikum.zhiyue.square.SquareFragment;
import com.kffuck.mikum.zhiyue.user.UserFragment;


public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager = getFragmentManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitUI();

    }

    private void InitUI() {

        AHBottomNavigation bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);
        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.bar_public, R.drawable.icon_public, R.color.colorPrimaryDark);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.bar_recommn, R.drawable.icon_recommn, R.color.colorPrimaryDark);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.bar_grid, R.drawable.icon_grid, R.color.colorPrimaryDark);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem(R.string.bar_user, R.drawable.icon_user, R.color.colorPrimaryDark);

        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);
        bottomNavigation.addItem(item4);

        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#00bcd4"));
        bottomNavigation.setAccentColor(Color.parseColor("#ffffff"));
        bottomNavigation.setForceTint(true);

        bottomNavigation.setInactiveColor(Color.parseColor("#b2d7d2"));

        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                Fragment fragment = null;
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                switch (position) {
                    case 0:
                        fragment = new SquareFragment();
                        break;
                    case 1:
                        fragment = new RecommnFragment();
                        break;
                    case 2:
                        fragment = new GridFragment();
                        break;
                    case 3:
                        fragment = new UserFragment();
                        break;
                }
                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                return true;
            }
        });
    }

}

package com.kffuck.mikum.zhiyue;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.kffuck.mikum.zhiyue.lib.UserCard;

public class RecommnActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pager_recommn);

        UserCard userCard = (UserCard) findViewById(R.id.UserCard);

        userCard.setOnClickListener(new UserCard.UserCardClickListener() {
            @Override
            public void leftClick() {
                Toast.makeText(getApplicationContext(), "CLEAR", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightClick() {
                Toast.makeText(getApplicationContext(), "DONE", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

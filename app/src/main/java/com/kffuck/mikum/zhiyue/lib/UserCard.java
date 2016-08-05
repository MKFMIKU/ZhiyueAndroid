package com.kffuck.mikum.zhiyue.lib;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.kffuck.mikum.zhiyue.R;
import com.kffuck.mikum.zhiyue.model.UserCardObj;
import com.nostra13.universalimageloader.core.ImageLoader;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserCard extends CardView {

    private CircleImageView avatarCard;
    private TextView nameCard;
    private TextView nicknameCard;
    private TextView schoolCard;

    public UserCard(Context context) {
        this(context, null);
    }

    public UserCard(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public UserCard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.custom_usercard, this, true);

        avatarCard = (CircleImageView) findViewById(R.id.avatarCard);
        nameCard = (TextView) findViewById(R.id.nameCard);
        nicknameCard = (TextView) findViewById(R.id.nicknameCard);
        schoolCard = (TextView) findViewById(R.id.schoolCard);

        try {
            setPadding(0, 0, 0, 0);
            setCardBackgroundColor(Color.WHITE);
            setCardElevation(20);
            if (Build.VERSION.SDK_INT >= 21) {
                setClipToOutline(false);
            }
        } catch (Exception e) {
            Log.w("CustomCard", e);
        }

    }

    public void fillData(UserCardObj usercard) {
        ImageLoader.getInstance().displayImage(usercard.avatar, avatarCard);
        nameCard.setText(usercard.name);
        nicknameCard.setText(usercard.nickname);
        schoolCard.setText(usercard.school);
    }


}
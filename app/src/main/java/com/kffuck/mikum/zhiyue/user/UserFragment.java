package com.kffuck.mikum.zhiyue.user;


import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.kffuck.mikum.zhiyue.R;
import com.kffuck.mikum.zhiyue.init.Guide;
import com.kffuck.mikum.zhiyue.model.AccountObj;
import com.kffuck.mikum.zhiyue.model.UserObj;
import com.nostra13.universalimageloader.core.ImageLoader;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserFragment extends Fragment {
    private UserObj myUser;
    private CircleImageView avatarImage;
    private Button loginOutButton;
    private TextView nickNameText, schoolText;
    private ImageLoader imageLoader = ImageLoader.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pager_user, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        myUser = AccountObj.loadAccount(getActivity());

        //Get the view id
        avatarImage = (CircleImageView) getActivity().findViewById(R.id.avatar);
        nickNameText = (TextView) getActivity().findViewById(R.id.nickNameText);
        schoolText = (TextView) getActivity().findViewById(R.id.schoolText);

        imageLoader.displayImage(myUser.avatar, avatarImage);
        nickNameText.setText(myUser.nickname);
        schoolText.setText(myUser.school);

        loginOutButton = (Button) getActivity().findViewById(R.id.loginOutButton);
        loginOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccountObj.loginOut(getActivity());
                startActivity(new Intent(getActivity(), Guide.class));
            }
        });
    }

}

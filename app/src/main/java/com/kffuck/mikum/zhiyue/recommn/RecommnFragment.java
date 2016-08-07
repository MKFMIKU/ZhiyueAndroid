package com.kffuck.mikum.zhiyue.recommn;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kffuck.mikum.zhiyue.R;

import at.markushi.ui.CircleButton;
import de.hdodenhof.circleimageview.CircleImageView;


public class RecommnFragment extends Fragment {
    private CircleImageView avatarCard;
    private CircleButton clearButton, doneButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pager_recommn, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Init U id
        clearButton = (CircleButton) getActivity().findViewById(R.id.clearButton);
        doneButton = (CircleButton) getActivity().findViewById(R.id.doneButton);
        avatarCard = (CircleImageView) getActivity().findViewById(R.id.avatarCard);


    }
}

package com.kffuck.mikum.zhiyue.square;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Toast;

import com.kffuck.mikum.zhiyue.R;
import com.kffuck.mikum.zhiyue.model.TweetObj;
import com.kffuck.mikum.zhiyue.network.SquareHttp;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.rey.material.widget.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;


public class SquareFragment extends Fragment {
    private FloatingActionButton squareButton;
    private RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pager_public, container, false);


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView = (RecyclerView) getActivity().findViewById(R.id.square_tweets);

        initSquare();

        squareButton = (FloatingActionButton) getActivity().findViewById(R.id.SquareButton);
        squareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), NewTweet.class));
            }
        });

    }

    private void initSquare(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        getTweets();
    }

    private void getTweets(){
        SquareHttp.get("/get",null,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    int code = response.getInt("code");
                    String msg = response.getString("msg");
                    if (code == 200) {
                        if (msg.equals("ok")) {

                            List<TweetObj> tweetObjs = new ArrayList<TweetObj>();

                            JSONArray tweets = response.getJSONArray("result");

                            for(int i=0;i<tweets.length();i++){
                                Log.d("Tweets","INDEX = "+i);
                                JSONObject tweet = (JSONObject) tweets.get(i);
                                Log.d("Tweets","TweetObj = "+String.valueOf(tweet));
                                TweetObj tweetObj = new TweetObj(tweet);
                                Log.d("Tweets","tweet = "+String.valueOf(tweetObj));
                                tweetObjs.add(tweetObj);
                            }
                            Log.d("Tweets", "TweetOBJS = "+String.valueOf(tweetObjs));
                            TweetAdapter tweetAdapter = new TweetAdapter(getActivity(), tweetObjs);
                            recyclerView.setAdapter(tweetAdapter);
                        }
                    } else
                        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

package com.kffuck.mikum.zhiyue.model;


import org.json.JSONObject;

public class TweetObj {
    public String _id;
    public String nickname;
    public String time;
    public String content;
    public String avatar;

    public TweetObj(JSONObject data){
        this._id = data.optString("_id","");
        this.nickname = data.optString("nickname", "");
        this.time = data.optString("createTime","");
        this.avatar = data.optString("avatar", "");
        this.content = data.optString("content", "");
    }
}

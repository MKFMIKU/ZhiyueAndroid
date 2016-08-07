package com.kffuck.mikum.zhiyue.model;

import org.json.JSONObject;

import java.io.Serializable;

public class UserObj implements Serializable {
    public String _id = "";
    public String avatar = "";
    public String nickname = "";
    public String name = "";
    public String phone = "";
    public String email = "";
    public String school = "";

    public UserObj(JSONObject json) {
        _id = json.optString("_id", "");
        avatar = json.optString("avatar", "");
        nickname = json.optString("nickname", "");
        name = json.optString("name", "");
        phone = json.optString("phone", "");
        email = json.optString("email", "");
        school = json.optString("school", "");
    }
}

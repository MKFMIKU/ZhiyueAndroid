package com.kffuck.mikum.zhiyue.model;

import org.json.JSONObject;

import java.io.Serializable;

public class UserObj implements Serializable {
    public String avatar = "";
    public int id;
    public String nickname = "";
    public String name = "";
    public String phone = "";
    public String email = "";
    public String school = "";

    public UserObj() {

    }

    public UserObj(JSONObject json) {
        avatar = json.optString("avatar", "");
        id = json.optInt("id");
        nickname = json.optString("nickname", "");
        name = json.optString("name", "");
        phone = json.optString("phone", "");
        email = json.optString("email", "");
        school = json.optString("school", "");
    }
}

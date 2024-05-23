//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.farzine.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Model_User_Account {
    private int userID;
    private String userName;
    private String gender;
    private String image;
    private boolean status;

    public int getUserID() {
        return this.userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Model_User_Account(int userID, String userName, String gender, String image, boolean status) {
        this.userID = userID;
        this.userName = userName;
        this.gender = gender;
        this.image = image;
        this.status = status;
    }

    public Model_User_Account(Object json) {
        JSONObject obj = (JSONObject)json;

        try {
            this.userID = obj.getInt("userID");
            this.userName = obj.getString("userName");
            this.gender = obj.getString("gender");
            this.image = obj.getString("image");
            this.status = obj.getBoolean("status");
        } catch (JSONException var4) {
            JSONException e = var4;
            System.err.println(e);
        }

    }
}

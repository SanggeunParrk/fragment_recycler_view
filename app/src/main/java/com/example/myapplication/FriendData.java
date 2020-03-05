package com.example.myapplication;

public class FriendData {
    private String NickName;
    private String Msg;

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }
    public FriendData(String NickName, String Msg){
        this.NickName = NickName;
        this.Msg = Msg;
    }
    public FriendData(){
        this("default","default");
    }



}

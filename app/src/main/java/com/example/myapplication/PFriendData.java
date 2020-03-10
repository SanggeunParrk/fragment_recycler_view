package com.example.myapplication;

public class PFriendData {
    private String pNickName;
    private String pMsg;

    public String getNickName() {
        return pNickName;
    }

    public void setNickName(String nickName) {
        pNickName = nickName;
    }

    public String getMsg() {
        return pMsg;
    }

    public void setMsg(String msg) {
        pMsg = msg;
    }
    public PFriendData(String NickName, String Msg){
        this.pNickName = NickName;
        this.pMsg = Msg;
    }
    public PFriendData(){
        this("default","default");
    }



}

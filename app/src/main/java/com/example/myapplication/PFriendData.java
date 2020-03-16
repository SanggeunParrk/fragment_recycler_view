package com.example.myapplication;

public class PFriendData {
    private String  pNickName;
    private String  pMsg;
    private String  pBarText;
    private int     pBirthday;
    private int     pType; // 0 - 기본, 1 - FriendBar, 2 - RecyclerView
    private int     pChildViewType; // 0 - 생일, 1 - 즐겨찾기, 2 - 추천 친구, 3 - 즐겨찾기, 4 - 친구

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
    public PFriendData(int pNumber) {
        this.pType=0;
        this.pNickName = (String) "Nick"+pNumber;
        this.pMsg = (String) "Msg"+pNumber;
        this.pBirthday = (int) pNumber;
    }
    public PFriendData(String tag){
        this.pType=1;
        if(tag == "Birthday")           pBarText = "생일인 친구";
        else if (tag.equals("Recommended"))  pBarText = "추천친구";
        else if (tag.equals("Channel") )      pBarText = "채널";
        else if (tag.equals("Favorites"))    pBarText = "즐겨찾기";
        else if (tag.equals("Friends"))      pBarText = "친구";
        else if (tag.equals("Me")) {this.pNickName="My name"; this.pMsg="My Msg";this.pType=0;}
    }
    public PFriendData(String tag1, int tag2){
        this.pType=2;
        if(tag1.equals("Child View")){
            this.pChildViewType = tag2;
        }
    }
    public int getpBirthday() {return pBirthday;}
    public int getType(){ return pType; }
    public String getpBarText() {return pBarText;}
    public int getpChildViewType(){return pChildViewType;}
}

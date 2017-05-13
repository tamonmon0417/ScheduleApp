package com.lifeistech.android.scheduleapp;

import java.io.Serializable;

/**
 * Created by tamon okamoto on 2017/05/10.
 */

public class Card implements Serializable {
    public int imageId;
    public String title;
    public String content;
    public int likeNum = 0;
    public String detail;


    public Card(){

    }

    public Card(int imageId, String title, String content, String detail){
        this.imageId = imageId;
        this.title = title;
        this.content = content;
        this.detail = detail;

//       コンストラクタ

    }
}



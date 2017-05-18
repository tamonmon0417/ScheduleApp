package com.lifeistech.android.scheduleapp;

import java.io.Serializable;

/**
 * Created by tamon okamoto on 2017/05/10.
 */

public class Card implements Serializable {
    public int imageId;
    public String title;
    public String content;
    public String detail;
    public String date;


    public Card(String title, String content, String detail, String date){

    }

//    Card card = new Card(String title, String content, String detail, String date);
//    MainActivity.mCards.add(card);
//
//    MainActivity.init();
//    MainActivity.mCardAdapter.notifyDataSetChanged();
//    finish();

    public Card(int imageId, String title, String content, String detail, String date) {
        this.imageId = imageId;
        this.title = title;
        this.content = content;
        this.detail = detail;
        this.date = date;
    }


}



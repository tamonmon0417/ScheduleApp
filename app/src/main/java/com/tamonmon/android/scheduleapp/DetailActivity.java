package com.tamonmon.android.scheduleapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    ImageView iconImageView;
    TextView titleTextView;
    TextView likeTextView;
    TextView contentTextView;
    TextView detailTextView;
    ImageView likeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);






        iconImageView = (ImageView) findViewById(R.id.icon);
        titleTextView = (TextView) findViewById(R.id.titele_textview);
//        likeTextView = (TextView) findViewById(R.id.like_textview);
        contentTextView = (TextView) findViewById(R.id.content);
        detailTextView = (TextView) findViewById(R.id.detail);
//        likeButton = (ImageView) findViewById(R.id.like_button);

        Intent intent = getIntent();
        Card card = (Card) intent.getSerializableExtra("key");
//        Log.d("TAG", card.detail);
        iconImageView.setImageResource(card.imageId);
        titleTextView.setText(card.title);
        contentTextView.setText(card.content);
        detailTextView.setText(card.detail);



    }


}

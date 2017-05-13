package com.lifeistech.android.scheduleapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Card> mCards;
    ArrayList<Card> mCards0;
    ArrayList<Card> mCards2;
    CardAdapter mCardAdapter;
    ListView mListView;
    ArrayList<Card> showArray;
    ArrayList<ArrayList<Card>> eventArray;
    int position = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.listView);

        mCards = new ArrayList<Card>();

        mCards.add(new Card(R.drawable.image1, getString(R.string.sing_title),
                getString(R.string.sing_content), getString(R.string.sing_detail)));
        mCards.add(new Card(R.drawable.image1, getString(R.string.voice_title),
                getString(R.string.voice_content),getString(R.string.voice_detail)));


        mCards0 = new ArrayList<Card>();

        mCards0.add(new Card(R.drawable.image1, getString(R.string.sing_title0),
                getString(R.string.sing_content0), getString(R.string.sing_detail0)));
        mCards0.add(new Card(R.drawable.image1, getString(R.string.voice_title0),
                getString(R.string.voice_content0),getString(R.string.voice_detail0)));


        mCards2 = new ArrayList<Card>();

        mCards2.add(new Card(R.drawable.image1, getString(R.string.sing_title2),
                getString(R.string.sing_content), getString(R.string.sing_detail2)));
        mCards2.add(new Card(R.drawable.image1, getString(R.string.voice_title2),
                getString(R.string.voice_content2),getString(R.string.voice_detail2)));

        eventArray = new ArrayList<>();

        eventArray.add(mCards0);
        eventArray.add(mCards);
        eventArray.add(mCards2);

        showArray = new ArrayList<>();//showArrayを宣言

        showArray.addAll(eventArray.get(position));

        mCardAdapter = new CardAdapter(this, R.layout.card, showArray);
        mListView.setAdapter(mCardAdapter);

        Button before = (Button)findViewById(R.id.before);
        before.setText("before");
        before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position != 0) {
                    position--;
                    showArray.clear();
                    showArray.addAll(eventArray.get(position));
                    mCardAdapter.notifyDataSetChanged();
                }
            }
        });

        Button next = (Button)findViewById(R.id.next);
        next.setText("next");
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position != 2){
                position ++;
                showArray.clear();
                showArray.addAll(eventArray.get(position));
                mCardAdapter.notifyDataSetChanged();}

            }
        });



        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("key",showArray.get(position));
                startActivity(intent);

            }
        });
    }



}

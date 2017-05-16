package com.lifeistech.android.scheduleapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;

import android.app.Activity;
import android.widget.TextView;
import android.widget.Toolbar;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    ArrayList<Card> mCards;
    ArrayList<Card> mCards0;
    ArrayList<Card> mCards2;
    CardAdapter mCardAdapter;
    ListView mListView;
    ArrayList<Card> showArray;
    ArrayList<ArrayList<Card>> eventArray;
    int position = 1;







//以下　リストビュー
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.listView);

        mCards = new ArrayList<Card>();

        mCards.add(new Card(R.drawable.image1, getString(R.string.data1_title0),
                getString(R.string.data1_content0), getString(R.string.data1_detail0)));
        mCards.add(new Card(R.drawable.image1, getString(R.string.data1_title1),
                getString(R.string.data1_content1),getString(R.string.data1_detail1)));
        mCards.add(new Card(R.drawable.image1, getString(R.string.data1_title2),
                getString(R.string.data1_content2), getString(R.string.data1_detail2)));
        mCards.add(new Card(R.drawable.image1, getString(R.string.data1_title3),
                getString(R.string.data1_content3),getString(R.string.data1_detail3)));
        mCards.add(new Card(R.drawable.image1, getString(R.string.data1_title4),
                getString(R.string.data1_content4), getString(R.string.data1_detail4)));
        mCards.add(new Card(R.drawable.image1, getString(R.string.data1_title5),
                getString(R.string.data1_content5),getString(R.string.data1_detail5)));


        mCards0 = new ArrayList<Card>();

        mCards0.add(new Card(R.drawable.image1, getString(R.string.data0_title0),
                getString(R.string.data0_content0), getString(R.string.data0_detail0)));
        mCards0.add(new Card(R.drawable.image1, getString(R.string.data0_title1),
                getString(R.string.data0_content1),getString(R.string.data0_detail1)));
        mCards0.add(new Card(R.drawable.image1, getString(R.string.data0_title2),
                getString(R.string.data0_content2), getString(R.string.data0_detail2)));
        mCards0.add(new Card(R.drawable.image1, getString(R.string.data0_title3),
                getString(R.string.data0_content3),getString(R.string.data0_detail3)));
        mCards0.add(new Card(R.drawable.image1, getString(R.string.data0_title4),
                getString(R.string.data0_content4), getString(R.string.data0_detail4)));
        mCards0.add(new Card(R.drawable.image1, getString(R.string.data0_title5),
                getString(R.string.data0_content5),getString(R.string.data0_detail5)));

        mCards2 = new ArrayList<Card>();


        mCards2.add(new Card(R.drawable.image1, getString(R.string.data2_title0),
                getString(R.string.data2_content0), getString(R.string.data2_detail0)));
        mCards2.add(new Card(R.drawable.image1, getString(R.string.data2_title1),
                getString(R.string.data2_content1),getString(R.string.data2_detail1)));
        mCards2.add(new Card(R.drawable.image1, getString(R.string.data2_title2),
                getString(R.string.data2_content2), getString(R.string.data2_detail2)));
        mCards2.add(new Card(R.drawable.image1, getString(R.string.data2_title3),
                getString(R.string.data2_content3),getString(R.string.data2_detail3)));
        mCards2.add(new Card(R.drawable.image1, getString(R.string.data2_title4),
                getString(R.string.data2_content4), getString(R.string.data2_detail4)));
        mCards2.add(new Card(R.drawable.image1, getString(R.string.data2_title5),
                getString(R.string.data2_content5),getString(R.string.data2_detail5)));


        eventArray = new ArrayList<>();

        eventArray.add(mCards0);
        eventArray.add(mCards);
        eventArray.add(mCards2);

        showArray = new ArrayList<>();//showArrayを宣言

        showArray.addAll(eventArray.get(position));

        mCardAdapter = new CardAdapter(this, R.layout.card, showArray);
        mListView.setAdapter(mCardAdapter);

        final Date nowDate = new Date();




        Button before = (Button)findViewById(R.id.before);
//        before.setText("before");
        before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position != 0) {
                position--;
                showArray.clear();
                showArray.addAll(eventArray.get(position));
                mCardAdapter.notifyDataSetChanged();

                Calendar cal = Calendar.getInstance();
                cal.setTime(nowDate);
                cal.add(Calendar.DAY_OF_MONTH, -1);

                }
            }
        });

        Button next = (Button)findViewById(R.id.next);
//        next.setText("next");
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position != 2){
                position ++;
                showArray.clear();
                showArray.addAll(eventArray.get(position));
                mCardAdapter.notifyDataSetChanged();

                Calendar cal = Calendar.getInstance();
                cal.setTime(nowDate);
                cal.add(Calendar.DAY_OF_MONTH, 1);
                }

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


//        日付表示

        // yyyy-MM-dd形式へ
        String strDate = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(nowDate);
//        Calendar cal = Calendar.getInstance();
        // 翌日


        TextView textView = (TextView)findViewById(R.id.date);
        textView.setText(strDate);


    }



}


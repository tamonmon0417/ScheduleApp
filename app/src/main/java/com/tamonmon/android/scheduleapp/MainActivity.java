package com.tamonmon.android.scheduleapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    static ArrayList<Card> mCards;
    static ArrayList<Card> yesterDayArray;
    static ArrayList<Card> todayArray;
    static ArrayList<Card> tommorowArray;
    static CardAdapter mCardAdapter;
    ListView mListView;
    static ArrayList<Card> showArray;
    static ArrayList<ArrayList<Card>> eventArray;
    static int position = 1;

    static Date nowDate = new Date();


    //以下　リストビュー
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.listView);

        mCards = new ArrayList<Card>();
        yesterDayArray = new ArrayList<Card>();
        todayArray = new ArrayList<Card>();
        tommorowArray = new ArrayList<Card>();

        eventArray = new ArrayList<>();

        mCards.add(new Card(R.drawable.image1, getString(R.string.data1_title0),
                getString(R.string.data1_content0), getString(R.string.data1_detail0), "2017/05/19"));
        mCards.add(new Card(R.drawable.image2, getString(R.string.data1_title1),
                getString(R.string.data1_content1), getString(R.string.data1_detail1), "2017/05/19"));
        mCards.add(new Card(R.drawable.image3, getString(R.string.data1_title2),
                getString(R.string.data1_content2), getString(R.string.data1_detail2), "2017/05/19"));
        mCards.add(new Card(R.drawable.image4, getString(R.string.data1_title3),
                getString(R.string.data1_content3), getString(R.string.data1_detail3), "2017/05/19"));
        mCards.add(new Card(R.drawable.image5, getString(R.string.data1_title4),
                getString(R.string.data1_content4), getString(R.string.data1_detail4, "2017/05/19"), "2017/05/20"));
        mCards.add(new Card(R.drawable.image6, getString(R.string.data1_title5),
                getString(R.string.data1_content5), getString(R.string.data1_detail5), "2017/05/20"));


        mCards.add(new Card(R.drawable.image1, getString(R.string.data0_title0),
                getString(R.string.data0_content0), getString(R.string.data0_detail0), "2017/05/18"));
        mCards.add(new Card(R.drawable.image2, getString(R.string.data0_title1),
                getString(R.string.data0_content1), getString(R.string.data0_detail1, "2017/05/17", "2017/05/17"), "2017/05/18"));
        mCards.add(new Card(R.drawable.image3, getString(R.string.data0_title2),
                getString(R.string.data0_content2), getString(R.string.data0_detail2, "2017/05/17"), "2017/05/18"));
        mCards.add(new Card(R.drawable.image4, getString(R.string.data0_title3),
                getString(R.string.data0_content3), getString(R.string.data0_detail3, "2017/05/17"), "2017/05/18"));
        mCards.add(new Card(R.drawable.image5, getString(R.string.data0_title4),
                getString(R.string.data0_content4), getString(R.string.data0_detail4, "2017/05/17"), "2017/05/18"));
        mCards.add(new Card(R.drawable.image6, getString(R.string.data0_title5),
                getString(R.string.data0_content5), getString(R.string.data0_detail5), "2017/05/18"));

        mCards.add(new Card(R.drawable.image1, getString(R.string.data2_title0),
                getString(R.string.data2_content0), getString(R.string.data2_detail0), "2017/05/20"));
        mCards.add(new Card(R.drawable.image2, getString(R.string.data2_title1),
                getString(R.string.data2_content1), getString(R.string.data2_detail1), "2017/05/20"));
        mCards.add(new Card(R.drawable.image3, getString(R.string.data2_title2),
                getString(R.string.data2_content2), getString(R.string.data2_detail2), "2017/05/20"));
        mCards.add(new Card(R.drawable.image4, getString(R.string.data2_title3),
                getString(R.string.data2_content3), getString(R.string.data2_detail3), "2017/05/20"));
        mCards.add(new Card(R.drawable.image5, getString(R.string.data2_title4),
                getString(R.string.data2_content4), getString(R.string.data2_detail4), "2017/05/20"));
        mCards.add(new Card(R.drawable.image6, getString(R.string.data2_title5),
                getString(R.string.data2_content5), getString(R.string.data2_detail5), "2017/05/20"));


        showArray = new ArrayList<>();//showArrayを宣言
        mCardAdapter = new CardAdapter(this, R.layout.card, showArray);

        mListView.setAdapter(mCardAdapter);
        init();

        Button before = (Button) findViewById(R.id.before);
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
                    nowDate = cal.getTime();

                    String strDate = new SimpleDateFormat("yyyy-MM-dd", Locale.JAPAN).format(cal.getTime());
                    Log.e("TAG", strDate);

                    TextView textView = (TextView) findViewById(R.id.date);
                    textView.setText(strDate);

                }
            }
        });

        Button next = (Button) findViewById(R.id.next);
//        next.setText("next");
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position != 2) {
                    position++;
                    showArray.clear();
                    showArray.addAll(eventArray.get(position));
                    mCardAdapter.notifyDataSetChanged();

                    Calendar cal = Calendar.getInstance();
                    cal.setTime(nowDate);
                    cal.add(Calendar.DAY_OF_MONTH, 1);

                    nowDate = cal.getTime();//基準を更新


                    String strDate = new SimpleDateFormat("yyyy-MM-dd", Locale.JAPAN).format(cal.getTime());
                    Log.e("TAG", strDate);

                    TextView textView = (TextView) findViewById(R.id.date);
                    textView.setText(strDate);

                }

            }
        });

        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("key", showArray.get(position));
                startActivity(intent);

            }
        });


//        日付表示

        // yyyy-MM-dd形式へ
        String strDate = new SimpleDateFormat("yyyy-MM-dd", Locale.JAPAN).format(nowDate);
//        Calendar cal = Calendar.getInstance();
        // 翌日


        TextView textView = (TextView) findViewById(R.id.date);
        textView.setText(strDate);

//        コンテンツ追加
        Button input = (Button) findViewById(R.id.inputButton);
        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InputActivity.class);
                startActivity(intent);


            }
        });
    }


    static public void init() {


        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        String yesteerdayDate = new SimpleDateFormat("yyyy/MM/dd", Locale.JAPAN).format(cal.getTime());

        String todayDate = new SimpleDateFormat("yyyy/MM/dd", Locale.JAPAN).format(date);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date);
        cal2.add(Calendar.DAY_OF_MONTH, 1);
        String tomorowDate = new SimpleDateFormat("yyyy/MM/dd", Locale.JAPAN).format(cal2.getTime());


        Log.e("TAG1", yesteerdayDate);
        Log.e("TAG2", todayDate);
        Log.e("TAG3", tomorowDate);

        todayArray.clear();
        yesterDayArray.clear();
        tommorowArray.clear();
        eventArray.clear();

        for (int i = 0; i < mCards.size(); i++) {

            Log.e("TAG@", mCards.get(i).date);

            if (mCards.get(i).date.equals(todayDate)) {
                todayArray.add(mCards.get(i));
                Log.e("TAG", "today");
                Log.e("TAG", todayDate);
                Log.e("TAG", mCards.get(i).title);
                Log.e("TAG", mCards.get(i).date);
            } else if (mCards.get(i).date.equals(yesteerdayDate)) {
                yesterDayArray.add(mCards.get(i));
                Log.e("TAG", "yos");
            } else if (mCards.get(i).date.equals(tomorowDate)) {
                tommorowArray.add(mCards.get(i));
                Log.e("TAG", "tomo");
            }

        }


        eventArray.add(yesterDayArray);
        eventArray.add(todayArray);
        eventArray.add(tommorowArray);

        showArray.clear();
        showArray.addAll(eventArray.get(position));
        mCardAdapter.notifyDataSetChanged();


    }

}


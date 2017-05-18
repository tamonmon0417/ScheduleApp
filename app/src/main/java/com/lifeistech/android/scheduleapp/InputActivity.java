package com.lifeistech.android.scheduleapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity {
    public String title;
    public String content;
    public String detail;
    public String date;

    EditText titleEditText;
    EditText contentEditText;
    EditText detailEditText;
    EditText dateEditText;
//    SharedPreferences pref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        titleEditText = (EditText) findViewById(R.id.title);
        contentEditText = (EditText) findViewById(R.id.content);
        detailEditText = (EditText) findViewById(R.id.detail);
        dateEditText = (EditText) findViewById(R.id.date);

        titleEditText.selectAll();
        contentEditText.selectAll();
        detailEditText.selectAll();
        dateEditText.selectAll();

        final String titele_textview = titleEditText.getText() .toString();
        final String content = contentEditText.getText() .toString();
        final String detail = detailEditText.getText() .toString();
        final String date = titleEditText.getText() .toString();


        Button input = (Button) findViewById(R.id.inputButton);
        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Card card = new Card(titele_textview, content, detail, date);
                MainActivity.mCards.add(card);

                MainActivity.init();
                MainActivity.mCardAdapter.notifyDataSetChanged();
                finish();



            }



        });
    }
}



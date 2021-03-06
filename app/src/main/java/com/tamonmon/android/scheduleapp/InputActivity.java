package com.tamonmon.android.scheduleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity {
    public String title;
    public String content;
    public String detail;
    public String date;
    public int imageId;

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


//        titleEditText.selectAll();
//        contentEditText.selectAll();
//        detailEditText.selectAll();
//        dateEditText.selectAll();


        final int imageId = R.drawable.image1;


        Button input = (Button) findViewById(R.id.inputButton);
        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                title = titleEditText.getText().toString();
                content = contentEditText.getText().toString();
                detail = detailEditText.getText().toString();
                date = dateEditText.getText().toString();

                Card card = new Card(imageId, title, content, detail, date);
                MainActivity.mCards.add(card);

                MainActivity.init();
                MainActivity.mCardAdapter.notifyDataSetChanged();
                finish();
                Log.e("TAG",date);
                Log.e("TAG",detail);
                Log.e("TAG",content);
                Log.e("TAG",title);
//                Log.e("TAG",imageId);



            }



        });
    }
}



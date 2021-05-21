package com.example.android.nitpatna;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class NumberActivity extends AppCompatActivity {
//    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        ArrayList<String> words = new ArrayList<String>();
        words.add("One");
        words.add("Two");
        words.add("Three");
        words.add("Four");
        words.add("Five");
        words.add("Six");
        words.add("Seven");
        words.add("Eight");
        words.add("Nine");
        words.add("Ten");



//        int index;
//        for(index = 0;index < 10;index++)

        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);


        int i;
        for(i=0;i<words.size();i++)
        {
        TextView wordView = new TextView(this);
        wordView.setText(words.get(i));
//        setContentView(wordView);
                    rootView.addView(wordView);

        }
//        rootView.addView(wordView);

//        int j;
//        for(j=0;i<words.size();j++) {
//        Log.v("NumberActivity","hello" + words.get(j));
//        }
//
//        TextView wordView2 = new TextView(this);
//        wordView.setText(words[1]);
//        rootView.addView(wordView2);

    }


}
package com.hafizhmo.beritaindojava.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.hafizhmo.beritaindojava.R;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        //TO-DO 1: create recyclerview on activity_main.xml
        //TO-DO 2: initial recyclerview by the 'id'

        //TO-DO 3: initial ApiClient
        //TO-DO 4: call method 'getNews'

        //TO-DO 6: (onResponse of getNews) create adapter on adapter/NewsAdapter
        //TO-DO 7: (onResponse of getNews) initial MainAdapter with 'context' and 'list'
        //TO-DO 7: (onResponse of getNews) setup layoutmanager to recyclerview
        //TO-DO 8: (onResponse of getNews) setup adapter to recyclerview
    }
}
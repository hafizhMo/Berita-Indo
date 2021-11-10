package com.hafizhmo.beritaindojava.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.hafizhmo.beritaindojava.R;
import com.hafizhmo.beritaindojava.adapter.MainAdapter;
import com.hafizhmo.beritaindojava.data.Source;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TO-DO 1: create recyclerview on activity_main.xml
        //TO-DO 2: initial recyclerview by the 'id'
        RecyclerView recyclerView = findViewById(R.id.recycler_main);

        //TO-DO 3: create model on data/Source
        //TO-DO 4: initial arraylist of 'Source'
        ArrayList<Source> arrayList = new ArrayList<>();

        //TO-DO 5: add data to arraylist
        arrayList.add(new Source("antara", "antara.com"));
        arrayList.add(new Source("antara", "antara.com"));
        arrayList.add(new Source("antara", "antara.com"));

        //TO-DO 6: create adapter on adapter/MainAdapter
        //TO-DO 7: initial MainAdapter with 'context' and 'arraylist'
        MainAdapter adapter = new MainAdapter(this, arrayList);

        //TO-DO 7: setup layoutmanager to recyclerview
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //TO-DO 8: setup adapter to recyclerview
        recyclerView.setAdapter(adapter);
    }
}
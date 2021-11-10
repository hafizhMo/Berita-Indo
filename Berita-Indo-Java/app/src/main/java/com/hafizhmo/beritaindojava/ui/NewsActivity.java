package com.hafizhmo.beritaindojava.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.hafizhmo.beritaindojava.R;
import com.hafizhmo.beritaindojava.adapter.NewsAdapter;
import com.hafizhmo.beritaindojava.data.News;
import com.hafizhmo.beritaindojava.network.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        String key = getIntent().getStringExtra("KEY");

        //TO-DO 1: create recyclerview on activity_main.xml
        //TO-DO 2: initial recyclerview by the 'id'
        RecyclerView recyclerNews = findViewById(R.id.recycler_news);

        //TO-DO 3: initial ApiClient
        //TO-DO 4: call method 'getNews'
        ApiClient apiClient = new ApiClient();

        //TO-DO 6: (onResponse of getNews) create adapter on adapter/NewsAdapter
        //TO-DO 7: (onResponse of getNews) initial MainAdapter with 'context' and 'list'
        //TO-DO 7: (onResponse of getNews) setup layoutmanager to recyclerview
        //TO-DO 8: (onResponse of getNews) setup adapter to recyclerview
        apiClient.getApi().getNews(key).enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                News news = response.body();

                NewsAdapter adapter = new NewsAdapter(NewsActivity.this, news.data.posts);
                recyclerNews.setLayoutManager(new LinearLayoutManager(NewsActivity.this));
                recyclerNews.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                Toast.makeText(NewsActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
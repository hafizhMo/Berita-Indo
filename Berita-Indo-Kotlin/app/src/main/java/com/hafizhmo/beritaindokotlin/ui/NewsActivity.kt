package com.hafizhmo.beritaindokotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.hafizhmo.beritaindokotlin.adapter.NewsAdapter
import com.hafizhmo.beritaindokotlin.data.News
import com.hafizhmo.beritaindokotlin.databinding.ActivityNewsBinding
import com.hafizhmo.beritaindokotlin.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsBinding
    private var source: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityNewsBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        source = intent.getStringExtra("SOURCE_KEY").toString()
        binding.recyclerNews.layoutManager = LinearLayoutManager(this)
        load { post: List<News.Data.Post> ->
            binding.recyclerNews.adapter = NewsAdapter(post)
        }
    }

    private fun load(callback: (List<News.Data.Post>) -> Unit) {
        val apiClient = ApiClient.builder()
        apiClient!!.getNews(source).enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                return callback(response.body()!!.datas.posts)
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Toast.makeText(this@NewsActivity, t.toString(), Toast.LENGTH_SHORT).show()
            }

        })
    }
}
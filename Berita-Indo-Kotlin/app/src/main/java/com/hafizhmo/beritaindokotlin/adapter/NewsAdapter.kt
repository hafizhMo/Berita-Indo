package com.hafizhmo.beritaindokotlin.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hafizhmo.beritaindokotlin.data.News
import com.hafizhmo.beritaindokotlin.databinding.ItemNewsBinding
import com.squareup.picasso.Picasso

class NewsAdapter(
    private val arrNews: List<News.Data.Post>
) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private lateinit var context: Context

    class ViewHolder(val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            binding.textTitle.text = arrNews[position].title
            binding.textPubdate.text = arrNews[position].pubDate?.substring(0, 16)

            Picasso.with(context)
                .load(arrNews[position].thumbnail)
                .into(binding.imageThumbnail)

            holder.itemView.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(arrNews[position].link)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int = arrNews.size

}
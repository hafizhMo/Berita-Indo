package com.hafizhmo.beritaindokotlin.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hafizhmo.beritaindokotlin.data.Main
import com.hafizhmo.beritaindokotlin.databinding.ItemMainBinding
import com.hafizhmo.beritaindokotlin.ui.NewsActivity

class MainAdapter(
    private val arrMain: ArrayList<Main>
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private lateinit var context: Context

    class ViewHolder(val binding: ItemMainBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val binding = ItemMainBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            binding.textName.text = arrMain[position].name
            binding.textWebsite.text = arrMain[position].website

            holder.itemView.setOnClickListener {
                val i = Intent(context, NewsActivity::class.java)
                i.putExtra("SOURCE_KEY", arrMain[position].name)
                context.startActivity(i)
            }
        }
    }

    override fun getItemCount(): Int = arrMain.size

}
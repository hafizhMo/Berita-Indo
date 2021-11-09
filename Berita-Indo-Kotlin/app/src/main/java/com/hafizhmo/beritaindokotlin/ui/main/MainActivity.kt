package com.hafizhmo.beritaindokotlin.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.hafizhmo.beritaindokotlin.data.Main
import com.hafizhmo.beritaindokotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val arrMain: ArrayList<Main> = ArrayList()
        arrMain.add(Main("Antara", "https://www.antaranews.com/"))
        arrMain.add(Main("CNBC", "https://www.cnbcindonesia.com/"))
        arrMain.add(Main("CNN", "https://www.cnnindonesia.com/"))
        arrMain.add(Main("JPNN", "https://www.jpnn.com/"))
        arrMain.add(Main("Kumparan", "https://kumparan.com/"))

        binding.recyclerMain.layoutManager = LinearLayoutManager(this)
        binding.recyclerMain.adapter = MainAdapter(arrMain)
    }
}
package com.ravankhidirov.movieapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ravankhidirov.movieapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var prompt:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchButton.setOnClickListener {
            prompt = binding.searchMovie.text.toString()
            val intent = Intent(this,MoviesActivity::class.java)
            intent.putExtra("prompt",prompt)
            startActivity(intent)
        }
    }
}
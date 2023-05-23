package com.ravankhidirov.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ravankhidirov.movieapp.adapter.Adapter
import com.ravankhidirov.movieapp.databinding.ActivityMoviesBinding
import com.ravankhidirov.movieapp.model.Results
import com.ravankhidirov.movieapp.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesActivity : AppCompatActivity() {
    lateinit var binding: ActivityMoviesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoviesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val prompt:String = intent.getStringExtra("prompt").toString()

        getMovies(prompt)
    }


    fun getMovies(prompt:String)
    {
        val call: Call<Results?>? = RetrofitClient.getRetrofitInstance()?.getApi()?.getMovies(Constants.API_KEY,prompt)

        call?.enqueue(object : Callback<Results?> {
            override fun onResponse(call: Call<Results?>?, response: Response<Results?>?) {
                val movieList: Results = response?.body() as Results
                binding.rV.adapter = Adapter(movieList.results)
            }
            override fun onFailure(call: Call<Results?>?, t: Throwable?) {
                Toast.makeText(applicationContext, "An error has occured", Toast.LENGTH_LONG).show()
            }
        })

    }


}
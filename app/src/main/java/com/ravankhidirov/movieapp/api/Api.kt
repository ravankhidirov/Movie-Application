package com.ravankhidirov.movieapp.api

import com.ravankhidirov.movieapp.model.Results
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("movie")
    fun getMovies(@Query("api_key")api_key : String,@Query("query")query:String): Call<Results?>?

}
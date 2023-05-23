package com.ravankhidirov.movieapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ravankhidirov.movieapp.R
import com.ravankhidirov.movieapp.model.Movie

class Adapter (var list1:List<Movie>): RecyclerView.Adapter<Adapter.ViewHolder>(){
    var list : List<Movie>
    init {
        this.list=list1
    }
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var title = itemView.findViewById<TextView>(R.id.movieTitle)
        var language = itemView.findViewById<TextView>(R.id.movieLanguage)
        var overview = itemView.findViewById<TextView>(R.id.movieOverview)
        var imdb = itemView.findViewById<TextView>(R.id.movieIMDB)
        var date = itemView.findViewById<TextView>(R.id.movieReleaseDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.one_movie,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = (list.get(position).title)
        holder.language.text = list.get(position).original_language
        holder.date.text = list.get(position).release_date
        holder.overview.text = list.get(position).overview
        holder.imdb.text = list.get(position).vote_average.toString()
    }
}
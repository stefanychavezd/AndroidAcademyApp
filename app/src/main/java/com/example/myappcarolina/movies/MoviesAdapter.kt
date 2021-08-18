package com.example.myappcarolina.movies

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myappcarolina.R
import com.example.myappcarolina.movies.model.MovieModel

class MoviesAdapter(private var movieList: List<MovieModel>, var context: Context):
    RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    fun setData(list: List<MovieModel>){
        movieList = list
        notifyDataSetChanged()
    }

    class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var poster: ImageView = itemView.findViewById(R.id.movie_poster)
        var title: TextView = itemView.findViewById(R.id.movie_title)
        var ratingBar: RatingBar = itemView.findViewById(R.id.movie_ratingBar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val element = movieList[position]
        holder.title.text = element.title
        holder.ratingBar.rating = element.rating.toFloat()
        Glide.with(context)
            .load(movieList[position].poster)
            .fitCenter()
            .into(holder.poster)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}
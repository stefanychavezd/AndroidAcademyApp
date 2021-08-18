package com.example.myappcarolina.ui.series

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.RatingBar
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.myappcarolina.R

class SeriesAdapter(var context: Context?  = null, var serieList : List<SeriesModel> = listOf())
    : BaseAdapter() {
    // var serieList : List<SerieModel>
    //var context : Context?

    fun setData(list: List<SeriesModel>){
        serieList = list
        notifyDataSetChanged()
    }

    /** constructor(context: Context, serieList : List<SerieModel>):super() {
    this.context = context
    this.serieList = serieList
    }**/
    override fun getCount(): Int = serieList.size

    override fun getItem(position: Int): Any  = serieList[position]

    override fun getItemId(position: Int): Long = position.toLong()


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val serie = this.serieList[position]

        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var gridView =  inflator.inflate(R.layout.item_card, null)
        Glide.with(context!!)
            .load(serie.poster)
            .fitCenter()
            .into(gridView.findViewById(R.id.movie_poster))
        gridView.findViewById<TextView>(R.id.movie_title).text = serie.title
        gridView.findViewById<RatingBar>(R.id.movie_ratingBar).rating = serie.rating.toFloat()

        return gridView

    }
}
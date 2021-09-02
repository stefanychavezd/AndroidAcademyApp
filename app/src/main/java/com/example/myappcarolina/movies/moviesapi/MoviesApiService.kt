package com.example.myappcarolina.movies.moviesapi

import com.example.myappcarolina.movies.model.MovieModel
import retrofit2.http.GET

interface MovieApiServices {
    @GET("movies/")
    fun getMovieList(): retrofit2.Call<List<MovieModel>>
}
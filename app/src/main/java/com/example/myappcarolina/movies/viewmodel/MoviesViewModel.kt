package com.example.myappcarolina.movies.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.myappcarolina.movies.data.MoviesRepository
import com.example.myappcarolina.movies.model.MovieModel

class MoviesViewModel() : ViewModel() {

    var moviesRepository: MoviesRepository = MoviesRepository()

    fun getAllMoviesList(context: Context): LiveData<List<MovieModel>> {
        return moviesRepository.getMovies(context)
    }

    fun getMoviesFromApi(context: Context){
        moviesRepository.apiCallPutInBd(context)
    }

}
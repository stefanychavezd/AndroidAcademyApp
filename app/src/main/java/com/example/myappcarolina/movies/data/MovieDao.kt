package com.example.myappcarolina.movies.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myappcarolina.movies.model.MovieModel

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addMovie(movieEntity: List<MovieModel>)

    @Query("SELECT * FROM Movies")
    fun readAllMovies() : LiveData<List<MovieModel>>
}
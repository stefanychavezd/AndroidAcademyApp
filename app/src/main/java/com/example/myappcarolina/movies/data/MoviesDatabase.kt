package com.example.myappcarolina.movies.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myappcarolina.movies.model.MovieModel

@Database(entities = [MovieModel::class], version = 1, exportSchema = true)
abstract class MoviesDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}
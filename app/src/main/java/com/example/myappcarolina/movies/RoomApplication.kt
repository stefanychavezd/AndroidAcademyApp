package com.example.myappcarolina.movies

import android.content.Context
import androidx.room.Room
import com.example.myappcarolina.movies.data.MoviesDatabase

class RoomApplication {

    var databaseMovies: MoviesDatabase? = null

/*
    fun create(context: Context): MoviesDatabase {
        return Room.databaseBuilder(context, MoviesDatabase::class.java,
            "MoviesDb").build()
    }*/

    fun getMoviesDatabase(context: Context): MoviesDatabase {
        var dbmovies = databaseMovies
        if(dbmovies==null){
            dbmovies = Room.databaseBuilder(context, MoviesDatabase::class.java,
                "MoviesDb").build()
        }
        return dbmovies
    }

    /*companion object{
        var databaseMovies: MoviesDatabase? = null
    }

    override fun onCreate() {
        Log.e("OnCrete!!!", "creando room")
        super.onCreate()
         databaseMovies = Room.databaseBuilder(applicationContext, MoviesDatabase::class.java,
        "MoviesDb").build()
    }*/
}
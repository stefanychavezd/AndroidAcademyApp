package com.example.myappcarolina.movies.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Movies")
data class MovieModel (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")val id:Int,
    @ColumnInfo(name = "poster")val poster: String,
    @ColumnInfo(name = "rating")val rating: Double,
    @ColumnInfo(name = "title")val title: String
    )
package com.example.myappcarolina.ui.series.seriesapi

import com.example.myappcarolina.ui.series.SeriesModel
import retrofit2.http.GET

interface SeriesApiService {
    @GET("series/")
    fun getSerieList(): retrofit2.Call<List<SeriesModel>>
}
package com.example.myappcarolina.ui.series

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myappcarolina.ui.series.data.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SeriesViewModel : ViewModel() {

    var mutableLiveDataSeries = MutableLiveData<List<SeriesModel>>()
    var apiServiceSeries = ApiService()

    fun getSeriesList(){
        var call: Call<List<SeriesModel>> = apiServiceSeries.seriesService.getSerieList()
        call.enqueue(object : Callback<List<SeriesModel>> {
            override fun onResponse(
                call: Call<List<SeriesModel>>?,
                response: Response<List<SeriesModel>>?
            ) {
                if (response != null) {
                    mutableLiveDataSeries.postValue(response.body())
                }
            }
            override fun onFailure(call: Call<List<SeriesModel>>?, t: Throwable?) {
                call?.cancel()
            }

        })
    }
}
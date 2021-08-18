package com.example.myappcarolina.movies.data

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.myappcarolina.movies.RoomApplication
import com.example.myappcarolina.movies.model.MovieModel
import com.example.myappcarolina.movies.moviesapi.MovieApiServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MoviesRepository {

    var roomApplication = RoomApplication()

    fun getMovies(context: Context): LiveData<List<MovieModel>> {
        //Log.e("Caro", roomApplication.getMoviesDatabase(context).toString())
        //Log.e("movieDao", roomApplication.getMoviesDatabase(context).movieDao().toString())
       // Log.e("all", roomApplication.getMoviesDatabase(context).movieDao().readAllMovies().toString())
        return roomApplication.getMoviesDatabase(context).movieDao().readAllMovies()
    }

    fun apiCallPutInBd(context: Context){

        val movieAPI = "https://api-movie-carolina.herokuapp.com/api/"
        val TAG= "My fav movies"

        val retrofit = Retrofit.Builder()
            .baseUrl(movieAPI)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service: MovieApiServices = retrofit.create(MovieApiServices :: class.java)

        service.getMovieList().enqueue(object : Callback<List<MovieModel>> {
            override fun onResponse(call: Call<List<MovieModel>>?, response: Response<List<MovieModel>>?) {
                Log.e(TAG,response!!.body().toString())
                if(response != null){
                    Thread(Runnable {
                        roomApplication.getMoviesDatabase(context).movieDao().addMovie(response.body()!!)
                    }).start()
                }
            }

            override fun onFailure(call: Call<List<MovieModel>>?, t: Throwable?) {
                Log.e(TAG,"OOPS!! something went wrong..")
            }
        })

    }





       /** call.enqueue(object : Callback<List<MovieModel>> {
            override fun onResponse(
                call: Call<List<MovieModel>>?,
                response: Response<List<MovieModel>>?) {
                if (response != null) {
                    Thread(Runnable {
                        RoomApplication.databaseMovies!!.movieDao().addMovie(response.body()!!)
                    }).start()

                }
            }
            override fun onFailure(call: Call<List<MovieModel>>?, t: Throwable?) {
                call?.cancel()
            }
        })
        return liveDataMovie
    }*/
}
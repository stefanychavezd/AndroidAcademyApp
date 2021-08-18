package com.example.myappcarolina.movies

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myappcarolina.NetworkMonitor
import com.example.myappcarolina.databinding.FragmentMoviesBinding
import com.example.myappcarolina.movies.model.MovieModel
import com.example.myappcarolina.movies.viewmodel.MoviesViewModel

class MoviesFragment : Fragment() {

    lateinit var rvMovies: RecyclerView
    lateinit var movieAdapter : MoviesAdapter
    private var movieList = listOf<MovieModel>()
    private lateinit var moviesViewModel: MoviesViewModel
    private var _binding: FragmentMoviesBinding? = null
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    var networkMonitor = NetworkMonitor()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
        : View? {
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        var context = context
        moviesViewModel = ViewModelProvider(this).get(MoviesViewModel::class.java)


        if(networkMonitor.isNetworkAvailable(context!!)){
            moviesViewModel.getMoviesFromApi(context)
        }else{
            Toast.makeText(context,"No internet found. Showing cached list in the view",Toast.LENGTH_LONG).show()
        }

        moviesViewModel.getAllMoviesList(context).observe(viewLifecycleOwner, Observer { list ->
            movieAdapter.setData(list)
        })
        initRecyclerView(context!!)

        return binding.root
    }

    private fun initRecyclerView(context: Context){
        rvMovies = binding.rvMovies
        movieAdapter  = MoviesAdapter(movieList, context)
        rvMovies.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = movieAdapter
            setHasFixedSize(true)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
package com.example.myappcarolina.ui.series

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myappcarolina.databinding.FragmentSeriesBinding

class SeriesFragment : Fragment() {

    private lateinit var notificationsViewModel: SeriesViewModel
    private var _binding: FragmentSeriesBinding? = null
    lateinit var seriesViewModel: SeriesViewModel
    lateinit var gridView : GridView
    lateinit var seriesAdapter: SeriesAdapter
    private  var  seriesList = listOf<SeriesModel>()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProvider(this).get(SeriesViewModel::class.java)

        _binding = FragmentSeriesBinding.inflate(inflater, container, false)
        var context = context
        initGridView(context!!)
        return binding.root
    }

    private fun initGridView(context: Context){
        seriesViewModel = ViewModelProvider(this).get(SeriesViewModel :: class.java)
        seriesViewModel.getSeriesList()
        seriesViewModel.mutableLiveDataSeries.observe(viewLifecycleOwner, Observer { list ->
            seriesAdapter.setData(list)
        })
        gridView = binding.gridSerie
        seriesAdapter = SeriesAdapter(context, seriesList)
        gridView.adapter = seriesAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
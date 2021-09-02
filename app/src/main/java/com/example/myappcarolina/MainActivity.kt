package com.example.myappcarolina

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.myappcarolina.databinding.ActivityMainBinding
import com.example.myappcarolina.movies.MoviesFragment
import com.example.myappcarolina.ui.ViewPagerAdapter
import com.example.myappcarolina.ui.home.HomeFragment
import com.example.myappcarolina.ui.series.SeriesFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        val viewPager = binding.viewPager
        val adapterViewPager = ViewPagerAdapter(this)


        navView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    viewPager.currentItem = 0
                    true
                }
                R.id.navigation_movies -> {
                    viewPager.currentItem = 1
                    true
                }
                R.id.navigation_series -> {
                    viewPager.currentItem = 2
                    true
                }
                else -> false
            }
        }
        adapterViewPager.addFragment(HomeFragment())
        adapterViewPager.addFragment(MoviesFragment())
        adapterViewPager.addFragment(SeriesFragment())
        viewPager.adapter = adapterViewPager

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                when(position){
                    0 -> navView.menu.findItem(R.id.navigation_home).isChecked = true
                    1 -> navView.menu.findItem(R.id.navigation_movies).isChecked = true
                    2 -> navView.menu.findItem(R.id.navigation_series).isChecked = true
                }
            }
        })
    }


}



/**viewPager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float,
                positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                when(position){
                    0 -> navView.menu.findItem(R.id.navigation_home).isChecked = true
                    1 -> navView.menu.findItem(R.id.navigation_movies).isChecked = true
                    2 -> navView.menu.findItem(R.id.navigation_series).isChecked = true
                }
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })

    }*/



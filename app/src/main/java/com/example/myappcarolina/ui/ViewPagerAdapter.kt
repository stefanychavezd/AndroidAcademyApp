package com.example.myappcarolina.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


class ViewPagerAdapter(fm: FragmentActivity): FragmentStateAdapter(fm) {

    private  val listFragment : MutableList<Fragment> =  ArrayList()

    fun addFragment(fragment: Fragment){
        listFragment.add(fragment)
    }

    override fun getItemCount(): Int {
        return listFragment.size
    }

    override fun createFragment(position: Int): Fragment {
        return listFragment[position]
    }

}
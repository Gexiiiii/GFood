package com.gexiiiii.gfood.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * author : Gexiiiii
 * date : 2019/12/5 16:34
 * description :
 */
class ViewPagerAdapter(fm: FragmentManager, private val mData: List<Fragment>) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return mData[position]
    }

    override fun getCount(): Int {
        return mData.size
    }
}
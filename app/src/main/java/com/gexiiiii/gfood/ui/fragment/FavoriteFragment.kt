package com.gexiiiii.gfood.ui.fragment

import com.gexiiiii.gfood.R
import com.gexiiiii.gfood.ui.GBaseFragment
import com.gexiiiii.gfood.ui.activity.MainActivity
import com.gexiiiii.gfood.ui.adapter.ViewPagerAdapter
import com.gexiiiii.gfood.ui.fragment.favorite.FavoriteMenuFragment
import com.gexiiiii.gfood.ui.fragment.favorite.FavoriteNewsFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_favorite.*

/**
 * author : Gexiiiii
 * date : 2019/12/6 10:22
 * description :
 */
class FavoriteFragment : GBaseFragment() {

    override fun initVariable() {
    }

    override fun initViews() {
        initViewPager()
        initTabLayout()
    }

    override fun layoutResId(): Int {
        return R.layout.fragment_favorite
    }

    override fun onLazyLoad() {
    }

    override fun setListeners() {
    }

    /**
     * 初始化 viewpager
     */
    private fun initViewPager() {
        val fragments = arrayListOf(
            FavoriteMenuFragment(), FavoriteNewsFragment()
        )
        favoriteViewPager.adapter = ViewPagerAdapter(childFragmentManager, fragments)
        favoriteViewPager.setNoScroll(true)
        favoriteViewPager.offscreenPageLimit = 2
    }

    /**
     * 初始化 tablayout
     */
    private fun initTabLayout() {
        val mainActivity: MainActivity = activity as MainActivity
        mainActivity.mainTitleBar.centerTabLayout?.apply {
            setViewPager(favoriteViewPager)
        }
    }
}

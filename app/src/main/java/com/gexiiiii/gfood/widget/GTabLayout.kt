package com.gexiiiii.gfood.widget

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.gexiiiii.base.utils.XDensityUtil
import com.gexiiiii.gfood.R
import com.google.android.material.tabs.TabLayout

/**
 * author : Gexiiiii
 * date : 2019/12/4 17:06
 * description :
 */
class GTabLayout : RelativeLayout {

    var mTabLayout: TabLayout = TabLayout(context)
    private var mViewPager: ViewPager? = null

    constructor(ctx: Context) : this(ctx, null)

    constructor(ctx: Context, attr: AttributeSet?) : super(ctx, attr) {
        initView()
    }

    private fun initView() {
        mTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                var position = tab!!.position
                mViewPager?.setCurrentItem(position, true)
            }
        })
        mTabLayout.setSelectedTabIndicatorColor(resources.getColor(R.color.colorAccent))
        mTabLayout.setSelectedTabIndicatorHeight(0)
        mTabLayout.setBackgroundColor(Color.WHITE)
        mTabLayout.setUnboundedRipple(true)
        mTabLayout.tabRippleColor = ColorStateList.valueOf(resources.getColor(R.color.colorAccent))
        val params = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        params.addRule(ALIGN_PARENT_BOTTOM)
        addView(mTabLayout, params)
    }


    fun addTabItem(items: ArrayList<TabItem>) {
        for (item in items) {
            val tab = mTabLayout.newTab()
            tab.customView = createItemView(item)
            mTabLayout.addTab(tab)
        }
    }

    fun setViewPager(viewPager: ViewPager) {
        mViewPager = viewPager
        mViewPager?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                var positionOffset = 0f
                if (position > 1) {
                    positionOffset = 1f
                }
                if (pageSelectedListener != null) {
                    pageSelectedListener!!(position)
                }
                mTabLayout.setScrollPosition(position, positionOffset, true)
            }
        })
    }

    /**
     * 创建item视图
     * 1、目前包括图片和文字，图片在上，文字在下。
     * 2、照相机只包含图片
     */
    private fun createItemView(item: TabItem): View {
        val view = LinearLayout(context)
        view.orientation = LinearLayout.VERTICAL
        view.gravity = Gravity.CENTER

        if (textStyle == 0) {
            textStyle = R.style.BottomTabText
        }

        //添加图标
        if (item.resId > 0) {
            val imageView = ImageView(context)
            if (item.tabTxt.isNotEmpty()) {
                imageView.adjustViewBounds = true
                imageView.maxWidth = XDensityUtil.dip2px(context, 25f)
                imageView.maxHeight = XDensityUtil.dip2px(context, 25f)
                imageView.setPadding(5, 15, 5, 5)
            } else {
                imageView.setPadding(5, 5, 5, 10)
            }
            imageView.setImageResource(item.resId)
            view.addView(imageView)
        }
        //添加文字
        if (item.tabTxt.isNotEmpty()) {
            val textView = TextView(context)
            textView.text = item.tabTxt
            textView.setTextAppearance(context, textStyle)
            textView.setPadding(5, 5, 5, 10)
            textView.gravity = Gravity.CENTER
            view.addView(textView)
        }
        return view
    }

    private var textStyle = 0

    fun setTextStyle(resId: Int) {
        textStyle = resId
    }

    class TabItem(var tabTxt: String, var resId: Int)

    private var pageSelectedListener: ((Int) -> Unit)? = null

    fun setPageSelectedListener(listener: (Int) -> Unit) {
        this.pageSelectedListener = listener
    }
}
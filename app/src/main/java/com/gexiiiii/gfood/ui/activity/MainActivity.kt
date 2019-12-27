package com.gexiiiii.gfood.ui.activity

import android.app.Dialog
import android.app.ProgressDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.drawerlayout.widget.DrawerLayout
import com.gexiiiii.base.utils.XGlideUtil
import com.gexiiiii.gfood.R
import com.gexiiiii.gfood.bean.http.CategoryBean
import com.gexiiiii.gfood.bean.http.SimpleWeatherBean
import com.gexiiiii.gfood.contract.MainContract
import com.gexiiiii.gfood.manager.DialogManager
import com.gexiiiii.gfood.presenter.MainPresenter
import com.gexiiiii.gfood.ui.ImmersionActivity
import com.gexiiiii.gfood.ui.adapter.ViewPagerAdapter
import com.gexiiiii.gfood.ui.fragment.CategoryFragment
import com.gexiiiii.gfood.ui.fragment.FavoriteFragment
import com.gexiiiii.gfood.ui.fragment.HomeFragment
import com.gexiiiii.gfood.ui.fragment.OtherFragment
import com.gexiiiii.gfood.widget.GTabLayout
import com.gexiiiii.gfood.widget.TitleBar
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_other.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.system.exitProcess

/**
 * author : Gexiiiii
 * date : 2019/12/5 15:03
 * description :
 */
class MainActivity : ImmersionActivity(), MainContract.View {

    private val mPresenter = MainPresenter()
    private val homeFragment = HomeFragment()
    private val favoriteFragment = FavoriteFragment()
    private val categoryFragment = CategoryFragment()

    private var onSearch = false

    override fun initVariable() {
        mPresenter.getCity()
    }

    override fun initViews() {
        super.initViews()
        mPresenter.takeView(this)
        initViewPager()
        initTabLayout()

        //禁止手势滑动
        dlMain.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)

        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.flMainDrawer, OtherFragment())
        ft.commit()
    }

    override fun titleBar(): TitleBar {
        return mainTitleBar
    }

    override fun layoutResId(): Int {
        return R.layout.activity_main
    }

    override fun onLazyLoad() {
    }

    override fun setListeners() {
        mainTitleBar.setTitleBarClickListener(object : TitleBar.TitleBarClickListener {
            override fun leftClick() {
                dlMain.openDrawer(flMainDrawer)
            }

            override fun rightClick() {
                onSearch = if (onSearch) {
                    mainTitleBar.setRightIcon(R.mipmap.ic_search_white)
                    homeFragment.showSearchView(false)
                    false
                } else {
                    mainTitleBar.setRightIcon(R.mipmap.ic_close)
                    homeFragment.showSearchView(true)
                    true
                }
            }
        })

        mainTabLayout.setPageSelectedListener {
            when (it) {
                0 -> {
                    mainTitleBar.setCenterText(resources.getString(R.string.app_name))
                    mainTitleBar.showTab(false)
                    mainTitleBar.setRightIcon(R.mipmap.ic_search_white)
                }
                1 -> {
                    mainTitleBar.setCenterText(resources.getString(R.string.bottom_category))
                    mainTitleBar.showTab(false)
                }
                2 -> {
                    mainTitleBar.setCenterText(resources.getString(R.string.bottom_favorite))
                    mainTitleBar.showTab(true)
                }
            }
        }

        mainTitleBar.centerTabLayout!!.mTabLayout.addOnTabSelectedListener(object :
            TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
            }
        })
    }

    override fun getCitySuccess(city: String, time: Long) {
        tvCityAndTime.visibility = View.VISIBLE
        tvCityAndTime.text = "$city  ${SimpleDateFormat("yyyy年MM月dd日").format(Date(time))}"
//        mPresenter.getWeather(city.replace("市", ""))
    }

    override fun getWeatherSuccess(simpleWeatherBean: SimpleWeatherBean) {
        ivWeather.drawable.level = simpleWeatherBean.result.future[0].wid.day.toInt()
        tvWeather.text =
            "${simpleWeatherBean.result.future[0].weather}  ${simpleWeatherBean.result.future[0].temperature}"
    }

    override fun getCategorySuccess(categoryBean: CategoryBean) {
        categoryFragment.setCategory(categoryBean)
    }

    fun getCategory() {
        mPresenter.getCategory()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.dropView()
    }

    /**
     * 初始化 tablayout
     */
    private fun initTabLayout() {
        val items = arrayListOf(
            GTabLayout.TabItem(
                resources.getString(R.string.bottom_home),
                R.drawable.selector_tab_home
            ),
            GTabLayout.TabItem(
                resources.getString(R.string.bottom_category),
                R.drawable.selector_tab_category
            ),
            GTabLayout.TabItem(
                resources.getString(R.string.bottom_favorite),
                R.drawable.selector_tab_favorite
            )
        )
        val favoriteItems = arrayListOf(
            GTabLayout.TabItem(resources.getString(R.string.title_tab_menu), 0),
            GTabLayout.TabItem(resources.getString(R.string.title_tab_news), 0)
        )
        mainTabLayout.apply {
            setViewPager(mainViewPager)
            addTabItem(items)
        }
        mainTitleBar.centerTabLayout!!.apply {
            setTextStyle(R.style.FavoriteTabText)
            addTabItem(favoriteItems)
            mTabLayout.setSelectedTabIndicatorColor(resources.getColor(R.color.colorWhite))
            mTabLayout.setBackgroundColor(resources.getColor(R.color.colorPrimary))
            mTabLayout.setSelectedTabIndicatorHeight(5)
            mTabLayout.setTabRippleColorResource(R.color.colorPrimary)
        }
    }

    /**
     * 初始化 viewpager
     */
    private fun initViewPager() {
        val fragments = arrayListOf(
            homeFragment, categoryFragment, favoriteFragment
        )
        mainViewPager.adapter = ViewPagerAdapter(supportFragmentManager, fragments)
        mainViewPager.setNoScroll(true)
        mainViewPager.offscreenPageLimit = 3
    }

    override fun onBackPressed() {
        if (dlMain.isDrawerOpen(flMainDrawer)) {
            dlMain.closeDrawer(flMainDrawer)
        } else {
            //显示确认退出程序的对话框
            DialogManager.showMsgDialog(this, "退出程序", "是否确定退出程序?",
                DialogInterface.OnClickListener { _, which ->
                    if (which == Dialog.BUTTON_POSITIVE) {
                        //退出程序
                        val pd = ProgressDialog(this)
                        pd.setMessage("正在退出...")
                        pd.show()
                        mHandler.postDelayed({
                            pd.hide()
                            exitProcess(0)
                        }, 1000)
                    }
                })
        }
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }
}

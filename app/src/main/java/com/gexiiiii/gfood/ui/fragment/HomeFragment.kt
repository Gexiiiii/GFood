package com.gexiiiii.gfood.ui.fragment


import android.text.TextUtils
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.gexiiiii.gfood.R
import com.gexiiiii.gfood.bean.db.LookHistoryBean
import com.gexiiiii.gfood.bean.http.CategoryBean
import com.gexiiiii.gfood.ui.GBaseFragment
import com.gexiiiii.gfood.ui.activity.MenuListActivity
import com.gexiiiii.gfood.ui.adapter.CategoryAdapter
import com.gexiiiii.gfood.ui.adapter.LookHistoryAdapter
import com.gexiiiii.gfood.widget.EmptyView
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.widget_edittext.*

/**
 * author : Gexiiiii
 * date : 2019/12/6 10:21
 * description :
 */
class HomeFragment : GBaseFragment() {

    private var mData = arrayListOf<LookHistoryBean>()
    private val adapter = LookHistoryAdapter(activity, mData)

    override fun initVariable() {
    }

    override fun initViews() {
        rvLookHistory.layoutManager = LinearLayoutManager(activity)
        rvLookHistory.adapter = adapter
        adapter.emptyView = EmptyView(activity)
    }

    override fun layoutResId(): Int {
        return R.layout.fragment_home
    }

    override fun onLazyLoad() {
    }

    override fun setListeners() {
        ivSearchHistory.setOnClickListener {

        }

        ivCleanLookHistory.setOnClickListener {

        }
        btnSearch.setOnClickListener {
            val keywords = getSearch.text
            if (TextUtils.isEmpty(keywords)) {
                showToast("关键字不能为空")
            } else {
                MenuListActivity.start(activity!!, keywords, -1)
            }
        }
    }

    fun showSearchView(isShow: Boolean) {
        if (isShow) {
            llSearch.visibility = View.VISIBLE
        } else {
            llSearch.visibility = View.GONE
            getSearch.text = ""
        }
    }
}

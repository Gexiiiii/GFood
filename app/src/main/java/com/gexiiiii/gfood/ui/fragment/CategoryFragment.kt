package com.gexiiiii.gfood.ui.fragment

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.gexiiiii.gfood.R
import com.gexiiiii.gfood.bean.http.CategoryBean
import com.gexiiiii.gfood.ui.GBaseFragment
import com.gexiiiii.gfood.ui.activity.MainActivity
import com.gexiiiii.gfood.ui.activity.MenuListActivity
import com.gexiiiii.gfood.ui.adapter.CategoryAdapter
import com.gexiiiii.gfood.widget.EmptyView
import kotlinx.android.synthetic.main.fragment_category.*

/**
 * author : Gexiiiii
 * date : 2019/12/6 10:21
 * description :
 */
class CategoryFragment : GBaseFragment() {

    private var mData = arrayListOf<CategoryBean.ResultBean>()
    private val adapter = CategoryAdapter(activity, mData)

    override fun initVariable() {
        val mainActivity: MainActivity = activity as MainActivity
//        mainActivity.getCategory()
    }

    override fun initViews() {
        rvCategory.layoutManager = LinearLayoutManager(activity)
        rvCategory.adapter = adapter
        adapter.emptyView = EmptyView(activity)
    }

    override fun layoutResId(): Int {
        return R.layout.fragment_category
    }

    override fun onLazyLoad() {
    }

    override fun setListeners() {
        adapter.setOnTagClickListener {
            MenuListActivity.start(activity!!, "", it.id.toInt())
        }
    }

    fun setCategory(categoryBean: CategoryBean) {
        mData.clear()
        mData.addAll(categoryBean.result)
        adapter.notifyDataSetChanged()
    }
}

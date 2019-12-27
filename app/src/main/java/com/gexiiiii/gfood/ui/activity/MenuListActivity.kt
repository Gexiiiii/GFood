package com.gexiiiii.gfood.ui.activity

import android.content.Context
import android.content.Intent
import android.text.TextUtils
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.gexiiiii.gfood.R
import com.gexiiiii.gfood.bean.http.MenuBean
import com.gexiiiii.gfood.contract.MenuListContract
import com.gexiiiii.gfood.presenter.MenuListPresenter
import com.gexiiiii.gfood.ui.ImmersionActivity
import com.gexiiiii.gfood.ui.adapter.MenuListAdapter
import com.gexiiiii.gfood.widget.EmptyView
import com.gexiiiii.gfood.widget.TitleBar
import kotlinx.android.synthetic.main.activity_menu_list.*


/**
 * author : Gexiiiii
 * date : 2019/12/13 15:27
 * description :
 */
class MenuListActivity : ImmersionActivity(), MenuListContract.View,
    BaseQuickAdapter.RequestLoadMoreListener {

    private var keywords: String? = null
    private var categoryId: Int? = -1
    private var num = 0
    private var pn = 0
    private var rn = 0
    private val mPresenter = MenuListPresenter()

    private var mData = arrayListOf<MenuBean.ResultBean.DataBean>()
    private val adapter = MenuListAdapter(this, mData)

    override fun initVariable() {
        keywords = intent.getStringExtra("keywords")
        categoryId = intent.getIntExtra("categoryId", -1)
    }

    override fun initViews() {
        super.initViews()
        mPresenter.takeView(this)

        adapter.emptyView = EmptyView(this)
        adapter.setOnLoadMoreListener(this, rvMenuList)
        adapter.setOnClickListener {
            MenuInfoActivity.start(this, it)
        }

        rvMenuList.layoutManager = LinearLayoutManager(this)
        rvMenuList.adapter = adapter

        if (!TextUtils.isEmpty(keywords)) {
            mPresenter.getMenuList(keywords!!, pn)
        }
        if (categoryId != -1) {
            mPresenter.getMenuList(categoryId!!, pn)
        }
    }

    override fun layoutResId(): Int {
        return R.layout.activity_menu_list
    }

    override fun onLazyLoad() {
    }

    override fun setListeners() {
        tbMenuList.setTitleBarClickListener(object : TitleBar.TitleBarClickListener {
            override fun leftClick() {
                finish()
            }

            override fun rightClick() {
            }
        })
    }

    override fun titleBar(): TitleBar {
        return tbMenuList
    }

    override fun getMenuListSuccess(data: MenuBean) {
        num = data.result.totalNum
        rn = data.result.rn
        pn += data.result.data.size
        if (pn >= num) {
            adapter.loadMoreEnd()
        } else {
            adapter.loadMoreComplete()
        }
        mData.addAll(data.result.data)
        adapter.notifyDataSetChanged()
    }

    override fun onLoadMoreRequested() {
        if (pn < num) {
            if (!TextUtils.isEmpty(keywords)) {
                mPresenter.getMenuList(keywords!!, pn)
            }
            if (categoryId != -1) {
                mPresenter.getMenuList(categoryId!!, pn)
            }
        } else {
            adapter.loadMoreEnd()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.dropView()
    }

    companion object {
        fun start(context: Context, keywords: String, categoryId: Int) {
            val i = Intent(context, MenuListActivity::class.java)
            if (!TextUtils.isEmpty(keywords)) {
                i.putExtra("keywords", keywords)
            }
            if (categoryId != -1) {
                i.putExtra("categoryId", categoryId)
            }
            context.startActivity(i)
        }
    }
}

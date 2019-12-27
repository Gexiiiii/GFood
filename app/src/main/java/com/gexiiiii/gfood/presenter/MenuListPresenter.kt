package com.gexiiiii.gfood.presenter

import com.gexiiiii.gfood.contract.MainContract
import com.gexiiiii.gfood.contract.MenuListContract
import com.gexiiiii.gfood.manager.HttpManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * author : Gexiiiii
 * date : 2019/12/13 15:37
 * description :
 */
class MenuListPresenter : MenuListContract.Presenter {
    override fun getMenuList(keywords: String, pn: Int) {
        HttpManager.api()
            .searchMenu(keywords, pn.toString())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                mView!!.getMenuListSuccess(it)
                mView!!.showToast(it.reason)
            }
    }

    override fun getMenuList(categoryId: Int, pn: Int) {
        HttpManager.api()
            .getMenuListFromCategoryId(categoryId, pn.toString())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                mView!!.getMenuListSuccess(it)
                mView!!.showToast(it.reason)
            }
    }

    private var mView: MenuListContract.View? = null

    override fun dropView() {
        mView = null
    }

    override fun takeView(view: MenuListContract.View) {
        mView = view
    }
}
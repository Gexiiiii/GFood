package com.gexiiiii.gfood.contract

import com.gexiiiii.base.XPresenter
import com.gexiiiii.base.XView
import com.gexiiiii.gfood.bean.http.CategoryBean
import com.gexiiiii.gfood.bean.http.MenuBean
import com.gexiiiii.gfood.bean.http.SimpleWeatherBean

/**
 * author : Gexiiiii
 * date : 2019/12/13 15:37
 * description :
 */
class MenuListContract {
    interface View : XView {
        fun getMenuListSuccess(data: MenuBean)
    }

    interface Presenter : XPresenter<View> {
        fun getMenuList(keywords: String, pn: Int)
        fun getMenuList(categoryId: Int, pn: Int)
    }
}
package com.gexiiiii.gfood.contract

import android.view.View
import com.gexiiiii.base.XPresenter
import com.gexiiiii.base.XView
import com.gexiiiii.gfood.bean.http.CategoryBean
import com.gexiiiii.gfood.bean.http.SimpleWeatherBean

/**
 * author : Gexiiiii
 * date : 2019/12/6 16:11
 * description :
 */
class MainContract {
    interface View : XView {
        fun getCitySuccess(city: String, time: Long)
        fun getWeatherSuccess(simpleWeatherBean: SimpleWeatherBean)
        fun getCategorySuccess(categoryBean: CategoryBean)
    }

    interface Presenter : XPresenter<View> {
        fun getCity()
        fun getWeather(city: String)
        fun getCategory()
    }
}